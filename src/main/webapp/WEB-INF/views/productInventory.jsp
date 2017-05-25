<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<!-- <th>Dostępność (szt.)</th> -->
					<th>Cena</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">

					<tr>
						<td><img
							src="${pageContext.request.contextPath}/productImage?id=${product.id}"
							alt="image" style="width: 100%;" /></td>
						<td>${product.name}</td>
						<td>${product.category}</td>
						<!-- <td>${product.stock}</td>-->
						<td><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.price}" /> PLN</td>
						<td><a
							href="<spring:url value="/product/viewProduct/${product.id }" />"><span
								class="glyphicon glyphicon-info-sign btn btn-info"></span></a> <a
							href="<spring:url value="/admin/product/editProduct/${product.id }" />"><span
								class="glyphicon glyphicon-edit btn btn-warning"></span></a> <a
							href="<spring:url value="/admin/product/deleteProduct/${product.id }" />"><span
								class="glyphicon glyphicon-remove btn btn-danger"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="btn btn-default"
			href="<spring:url value="/admin/product/addProduct"/>">Dodaj
			produkt</a>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>