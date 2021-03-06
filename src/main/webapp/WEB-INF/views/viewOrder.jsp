﻿<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Zamówienie ${order.orderId}</h1>
			<h1>Status: ${order.status}</h1>
			<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
				<form
					action="${pageContext.request.contextPath}/admin/order/changeStatus"
					method="post">
					<div class="form-group">
						<label for="status">Zmiana statusu:</label> <label class="checkbox-inline"><form:radiobutton
								path="order.status" id="status" value="NEW" />NOWY</label> <label
							class="checkbox-inline"><form:radiobutton
								path="order.status" id="status" value="PAYED" />ZAPŁACONE</label> <label
							class="checkbox-inline"><form:radiobutton
								path="order.status" id="status" value="SENT" />WYSŁANE</label> <label
							class="checkbox-inline"><form:radiobutton
								path="order.status" id="status" value="COMPLETED" />ZAKOŃCZONE</label>

						<input type="hidden" name="orderId" value="${order.orderId}">
						<input class="btn btn-warning" type="submit" value="Zmień status" />
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</c:if>


			<p class="lead">poniżej szczegółowe informacje o zamówieniu:</p>
		</div>

		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6">
				<address>
				<h3>${order.customer.customerFirstName} ${order.customer.customerLastName}</h3><br>
					<strong>Adres dostawy</strong><br>
					${order.shippingAddress.street} 
					${order.shippingAddress.apartmentNumber} <br>
					${order.shippingAddress.city},
					${order.shippingAddress.zipCode} <br>
				</address>
			</div>
			<div class="col-xs-6 col-sm-6 col-md-6 text-right">
				<p>
					Data złożenia zamówienia:
					<fmt:formatDate type="date" value="${order.creationDate}" />
				</p>
			</div>
		</div>

		<div class="row">
			<div class="col-xs-6 col-sm-6 col-md-6">
				<address>
					<strong>Adres do faktury</strong><br>
					${order.billingAddress.street} 
					${order.billingAddress.apartmentNumber} <br>
					${order.billingAddress.city},
					${order.billingAddress.zipCode} <br>
				</address>
			</div>
		</div>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Produkty</th>
						<th>#</th>
						<th class="text-center">Cena jednostkowa</th>
						<th class="text-center">Cena po naliczeniu rabatu</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="orderItem" items="${order.orderItems}">
						<tr>
							<td class="col-md-9"><em>${orderItem.productName}</em></td>
							<td class="col-md-1" style="text-align: center">${orderItem.quantity}</td>
							<td class="col-md-1" style="text-align: center"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${orderItem.price}" /> PLN</td>
							<td class="col-md-1" style="text-align: center"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${orderItem.totalPrice}" /> PLN</td>
						</tr>
					</c:forEach>

					<tr>
						<td></td>
						<td></td>
						<td class="text-right">
							<h4>
								<strong>Cena Brutto: </strong>
							</h4>
						</td>
						<td class="text-center text-danger">
							<h4>
								<strong><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${order.cart.grantTotal}" /> PLN</strong>
							</h4>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
			<a
				href="<c:url value="/customer/orderList/${order.cart.customer.customerId}"/>"
				class="btn btn-default">Zamknij</a>
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
			<a href="<c:url value="/admin/orderList"/>" class="btn btn-warning">Zamknij</a>
		</c:if>

	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>