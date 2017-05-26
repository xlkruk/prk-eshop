<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Nasze produkty</h1>
			<h3>Kategorie:</h3>
			<a href="<spring:url value="/product/productList" />">Wszystkie</a>
			| <a href="<spring:url value="/product/productListByCategory/JEWELLERY" />">Biżuteria</a>
			| <a href="<spring:url value="/product/productListByCategory/CERAMICS" />">Ceramika</a>
			| <a href="<spring:url value="/product/productListByCategory/CARDS" />">Kartki i zaproszenia</a>
			| <a href="<spring:url value="/product/productListByCategory/FERNITURES" />">Meble</a>
			| <a href="<spring:url value="/product/productListByCategory/PAINTINGS" />">Obrazy i ramki</a>
			| <a href="<spring:url value="/product/productListByCategory/BAGS" />">Torby</a>

			<p class="lead">Sprawdź nasze wspaniałe produkty</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-info">
					<th>Miniaturka</th>
					<th>Nazwa produktu</th>
					<th>Kategoria</th>
					<th>Rabat %</th>
					<th>Cena PLN</th>
					<th></th>
				</tr>
			</thead>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><img src="${pageContext.request.contextPath}/productImage?id=${product.id}"  alt="image" style="width: 100%;" /></td>
					<td>${product.name}</td>
					<td>${product.category}</td>
				 	<td>${product.discount}</td>
					<td><h2><strong><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.price}" /></strong></h2></td>
					<td><a
						href="<spring:url value="/product/viewProduct/${product.id }" />"><span
							class="glyphicon glyphicon-info-sign btn btn-info"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>