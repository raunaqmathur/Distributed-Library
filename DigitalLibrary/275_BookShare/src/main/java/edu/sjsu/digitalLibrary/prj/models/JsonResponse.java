package edu.sjsu.digitalLibrary.prj.models;

import com.fasterxml.jackson.annotation.JsonView;

import edu.sjsu.digitalLibrary.prj.jsonview.Views;

public class JsonResponse {

	@JsonView(Views.Public.class)
	String status;
	
	@JsonView(Views.Public.class)
	String successFlag;
	
	@JsonView(Views.Public.class)
	String errorMessage;
	
	@JsonView(Views.Public.class)
	String successMessage;

	public String getSuccessFlag() {
		return successFlag;
	}

	public void setSuccessFlag(String successFlag) {
		this.successFlag = successFlag;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}
