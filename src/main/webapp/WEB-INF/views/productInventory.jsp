<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Lista produktów</h1>

			<p class="lead">Tu można zarządzać produktami</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-warning">
					<th>Miniaturka</th>
					<th>Nazwa produktu</th>
					<th>Kategoria</th>
					<th>Dostępność (szt.)</th>
					<th>Cena</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><img src="#" alt="image" /></td>
					<td>${product.name}</td>
					<td>${product.category}</td>
					<td>${product.stock}</td>
					<td>${product.price}PLN</td>
					<td><a
						href="<spring:url value="/productList/viewProduct/${product.id }" />"><span
							class="glyphicon glyphicon-info-sign"></span></a>
							<a
						href="<spring:url value="/admin/productInventory/deleteProduct/${product.id }" />"><span
							class="glyphicon glyphicon-remove danger"></span></a>
							</td>
				</tr>
			</c:forEach>
		</table>
		<a class="btn btn-default" href="<spring:url value="/admin/productInventory/addProduct"/>">Dodaj produkt</a>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>