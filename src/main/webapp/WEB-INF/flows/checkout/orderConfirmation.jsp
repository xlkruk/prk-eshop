<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>
<jsp:useBean id="now" class="java.util.Date" />

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Zamówienie</h1>

			<p class="lead">Potwierdzenie zamówienia</p>
		</div>
		<div class="container">
			<div class="row">

				<form:form commandName="order" class="form-horizontal">
					<div
						class="well col-xs-10 col-sm-10 col-md-10 col-xs-offset-1 col-sm-offset-1 col-md-offset-1">

						<div class="text-center">
							<h1>Zamówienie</h1>
						</div>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Adres dostawy</strong><br>
									${order.cart.customer.shippingAddress.street} ${order.cart.customer.shippingAddress.apartmentNumber} <br>
									
									${order.cart.customer.shippingAddress.zipCode} ${order.cart.customer.shippingAddress.city} <br>
								</address>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6 text-right">
								<p>
									Data złożenia zamówienia:
									<fmt:formatDate type="date" value="${now}" />
								</p>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<address>
									<strong>Adres do faktury</strong><br>
									${order.cart.customer.billingAddress.street} ${order.cart.customer.billingAddress.apartmentNumber} <br>
									${order.cart.customer.billingAddress.zipCode} ${order.cart.customer.billingAddress.city} <br>
								</address>
							</div>
						</div>
						<div class="row">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Produkty</th>
										<th>#</th>
										<th class="text-center">Rabat</th>
										<th class="text-center">Cena jednostkowa</th>
										<th class="text-center">Łącznie</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="cartItem" items="${order.cart.cartItems}">
										<tr>
											<td class="col-md-9"><em>${cartItem.product.name}</em></td>
											<td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
											<td class="col-md-1" style="text-align: center">${cartItem.product.discount}%</td>
											<td class="col-md-1" style="text-align: center"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.product.price}" /> PLN</td>
											<td class="col-md-1" style="text-align: center"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${cartItem.totalPrice}" /> PLN</td>
										</tr>
									</c:forEach>

									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td class="text-right">
											<h4>
												<strong>Cena Brutto: </strong>
											</h4>
										</td>
										<td class="text-center text-danger">
											<h4>
												<strong><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${order.cart.grantTotal}" />PLN</strong>
											</h4>
										</td>
									</tr>
								</tbody>
							</table>
						</div>

						<input type="hidden" name="_flowExecutionKey" /> <br> <br>
						<button class="btn btn-default"
							name="_eventId_backToCollectShippingDetail">Powrót</button>
						<input type="submit" value="Złóż zamówienie"
							class="btn btn-default" name="_eventId_orderConfirmed" />
						<button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token }">

					</div>
				</form:form>

			</div>
		</div>

		<%@include file="/WEB-INF/views/template/footer.jsp"%>