<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Klienci</h1>

			<p class="lead">Informacje o klientach</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-info">
					<th>Imie</th>
					<th>Nazwisko</th>
					<th>Email</th>
					<th>Telefon</th>
					<th>login</th>
					

				</tr>
			</thead>
			<c:forEach items="${customers}" var="customer">
				<tr>

					<td>${customer.customerFirstName}</td>
					<td>${customer.customerLastName}</td>
					<td>${customer.customerEmail}</td>
					<td>${customer.customerPhone}</td>
					<td>${customer.username}</td>

				</tr>
			</c:forEach>
		</table>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>