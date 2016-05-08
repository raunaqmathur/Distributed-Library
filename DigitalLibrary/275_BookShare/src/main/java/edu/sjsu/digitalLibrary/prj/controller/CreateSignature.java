package edu.sjsu.digitalLibrary.prj.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class CreateSignature {
  private static final String UTF8_CHARSET = "UTF-8";
  private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
  private static final String REQUEST_URI = "/onca/xml";
  private static final String REQUEST_METHOD = "GET";

  private static String endpoint = "webservices.amazon.com"; // must be lowercase
  private static String awsAccessKeyId = "AKIAJB4D7BCA7KQDR4UA";
  private static String awsSecretKey = "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";

  private SecretKeySpec secretKeySpec = null;
  private static Mac mac = null;

  public CreateSignature() throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
    byte[] secretyKeyBytes = awsSecretKey.getBytes(UTF8_CHARSET);
    secretKeySpec =
      new SecretKeySpec(secretyKeyBytes, HMAC_SHA256_ALGORITHM);
    mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
    mac.init(secretKeySpec);
  }

  public String signURL(String isbn) {
	  Map<String, String> params = new HashMap<String,String>();
    params.put("AWSAccessKeyId", awsAccessKeyId);
    params.put("Operation", "ItemLookup");
    params.put("ResponseGroup", "Large");
    params.put("SearchIndex", "All");
    params.put("IdType", "ISBN");
    params.put("ItemId",isbn);
    params.put("AssociateTag", "demobookshare-20");
    params.put("Timestamp", timestamp());
    SortedMap<String, String> sortedParamMap =
      new TreeMap<String, String>(params);
    String canonicalQS = canonicalize(sortedParamMap);
    String toSign =
      REQUEST_METHOD + "\n"
      + endpoint + "\n"
      + REQUEST_URI + "\n"
      + canonicalQS;
    //System.out.println(toSign);
    String hmac = hmac(toSign);
    //System.out.println(hmac);
    String sig = percentEncodeRfc3986(hmac);
    String url = "http://" + endpoint + REQUEST_URI + "?" +
    canonicalQS + "&Signature=" + sig;
System.out.println(url);
    return url;
  }

  private static String hmac(String stringToSign) {
    String signature = null;
    byte[] data;
    byte[] rawHmac;
    try {
      data = stringToSign.getBytes(UTF8_CHARSET);
      System.out.println(data);
      rawHmac = mac.doFinal(data);
      Base64 encoder = new Base64();
      signature = new String(encoder.encode(rawHmac));
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(UTF8_CHARSET + " is unsupported!", e);
    }
    return signature;
  }

  private static String timestamp() {
    String timestamp = null;
    Calendar cal = Calendar.getInstance();
    DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
    timestamp = dfm.format(cal.getTime());
    return timestamp;
  }

  private static String canonicalize(SortedMap<String, String> sortedParamMap)
{
    if (sortedParamMap.isEmpty()) {
      return "";
    }

    StringBuffer buffer = new StringBuffer();
    Iterator<Map.Entry<String, String>> iter =
      sortedParamMap.entrySet().iterator();

    while (iter.hasNext()) {
      Map.Entry<String, String> kvpair = iter.next();
      buffer.append(percentEncodeRfc3986(kvpair.getKey()));
      buffer.append("=");
      buffer.append(percentEncodeRfc3986(kvpair.getValue()));
      if (iter.hasNext()) {
        buffer.append("&");
      }
    }
    String canonical = buffer.toString();
    return canonical;
  }

  private static String percentEncodeRfc3986(String s) {
    String out;
    try {
      out = URLEncoder.encode(s, UTF8_CHARSET)
      .replace("+", "%20")
      .replace("*", "%2A")
      .replace("%7E", "~");
    } catch (UnsupportedEncodingException e) {
      out = s;
    }
    return out;
  }

}