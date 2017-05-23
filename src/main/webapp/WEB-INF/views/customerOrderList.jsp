<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Twoje zamówienia</h1>

			<p class="lead">Zarządzanie zamówieniami</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-info">
					<th>Nr zamówienia</th>
					<th>Data złożenia zamówienia</th>
					<!-- <th>Dostępność (szt.)</th> -->
					<th>Status</th>
					<th></th>

				</tr>
			</thead>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td>${order.orderId}</td>
					<td>${order.creationDate}</td>
					<!-- 	<td>${product.stock}</td> -->
					<td>${order.status}</td>
					<td><a
						href="<spring:url value="/order/viewOrder/${order.orderId }" />"><span
							class="glyphicon glyphicon-info-sign btn btn-info"></span></a> <c:if
							test="${order.status=='NOWY'}">
							<a
								href="<spring:url value="/customer/pay/${order.orderId }" />"><span
								class="btn btn-info">zapłać</span></a>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>