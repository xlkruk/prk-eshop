<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Szczegóły:</h1>

			<p class="lead">poniżej szczegółowe informacje o produkcie:</p>
		</div>

		<div class="container" ng-app="cartApp">
			<div class="row">
				<div class="col-md-6">
					<img
						src="${pageContext.request.contextPath}/productImage?id=${product.id}"
						alt="image" style="width: 100%; height: 300px;" />
				</div>

				<div class="col-md-6">
					<h3>${product.name}</h3>
					<p>
						<strong>Producent:</strong>${product.manufacturer}</p>
					<p>
						<strong>Kategoria:</strong>${product.category}</p>

					<h4>${product.price}PLN</h4>
				</div>
			</div>
			<br />
			<c:set var="role" scope="page" value="${param.role}" />
			<c:set var="url" scope="page" value="/product/productList" />
			<c:if test="${role='admin'}">
				<c:set var="url" scope="page" value="/admin/productInventory" />
			</c:if>

			<p ng-controller="cartCtrl">
				<a href="<c:url value="${url}" />" class="btn btn-default">Powrót</a>
				<a href="#" class="btn btn-warning btn-large"
					ng-click="addToCart('${product.id}')"><span
					class="glyphicon glyphicon-shopping-cart"></span>Dodaj do koszyka</a> <a
					href="<spring:url value="/cart" />" class="btn btn-default"><span
					class="glyphicon glyphicon-hand-right"></span>Pokaż koszyk</a>
			</p>
			<br />
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong>Opis:</strong>
					</div>
					<div class="panel-body">${product.description}</div>
				</div>

			</div>

		</div>
	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>