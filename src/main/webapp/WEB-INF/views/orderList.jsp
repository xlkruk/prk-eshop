<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Zamówienia</h1>
			<a href="<spring:url value="/admin/orderList" />">Wszystkie</a>
			| <a href="<spring:url value="/admin/orderListByStatus/NEW" />">Nowe</a>
			| <a href="<spring:url value="/admin/orderListByStatus/PAYMENT_RECEIVED" />">Opłacone</a>
			| <a href="<spring:url value="/admin/orderListByStatus/SENT" />">Wysłane</a>
			| <a href="<spring:url value="/admin/orderListByStatus/COMPLETED" />">Zakończone</a>
			<p class="lead">Zarządzanie zamówieniami</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-info">
					<th>Nr zamówienia</th>
					<th>Data złożenia</th>
					<th>Data zmiany statusu</th>
					<!-- <th>Dostępność (szt.)</th> -->
					<th>Status</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.orderId}</td>
					<td>${order.creationDate}</td>
					<td>${order.statusChangeDate}</td>
					<!-- 	<td>${product.stock}</td> -->
					<td>${order.status}</td>
					<td><a
						href="<spring:url value="/order/viewOrder/${order.orderId }" />"><span
							class="glyphicon glyphicon-info-sign btn btn-info"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>