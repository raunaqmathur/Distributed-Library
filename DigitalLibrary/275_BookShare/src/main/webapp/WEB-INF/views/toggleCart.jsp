<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    

<!-- ============================================== TOGGLE RIGHT CONTENT ============================================== -->

<div id="cart-dropdown-wrapper">
			<nav id="menu1" class="cart-dropdown">
			<h2 class="shopping-cart-heading">Shopping cart</h2>
			<div class="cart-items">
				<div class="cart-items-list">
					<ul>
						<li class="media">

							<div class="clearfix book cart-book">
								<a href="single-book.html" class="media-left">
									<div class="book-cover">
										<img width="140" height="212" alt=""
											src="<c:url value="/resources/images/blank.gif" />"
											data-echo="/resources/images/book-covers/01.jpg">
									</div>
								</a>
								<div class="media-body book-details">
									<div class="book-description">
										<h3 class="book-title">
											<a href="single-book.html">The Brief Wondrous Life of
												Oscar Wao</a>
										</h3>
										<p class="book-subtitle">
											by <a href="single-book.html">Cormac McCarthy</a>
										</p>
										<p class="price m-t-20">$1,401.75</p>
									</div>
								</div>
							</div>


						</li>
						<li class="media">

							<div class="clearfix book cart-book">
								<a href="single-book.html" class="media-left">
									<div class="book-cover">
										<img width="140" height="212" alt=""
											src="<c:url value="/resources/images/blank.gif" />"
											data-echo="/resources/images/book-covers/02.jpg">
									</div>
								</a>
								<div class="media-body book-details">
									<div class="book-description">
										<h3 class="book-title">
											<a href="single-book.html">The Brief Wondrous Life of
												Oscar Wao</a>
										</h3>
										<p class="book-subtitle">
											by <a href="single-book.html">Cormac McCarthy</a>
										</p>
										<p class="price m-t-20">$14.45</p>
									</div>
								</div>
							</div>


						</li>

					</ul>
				</div>
				<div class="cart-item-footer">
					<h3 class='total text-center'>
						Total:<span>$1,416.00</span>
					</h3>
					<div class="proceed-to-checkout text-center">
						<button type="button" class="btn btn-primary btn-uppercase">Proceed
							to Checkout</button>
					</div>
				</div>

			</div>

			</nav>
		</div>

<!-- ============================================== TOGGLE RIGHT CONTENT : END ============================================== -->
