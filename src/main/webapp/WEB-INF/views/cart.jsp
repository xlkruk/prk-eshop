<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">

		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Koszyk</h1>
					<p>Wybrane produkty:</p>
				</div>
			</div>
		</section>

		<section class="container" ng-app="cartApp">
			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
				<div>
					<a class="btn btn-warning pull-left" ng-click="clearCart()"><span
						class="glyphicon glyphicon-remove-sign"></span>Wyczyść koszyk</a>
				</div>
                <a href="<spring:url value="/order/${cartId}"/>"
                   class="btn btn-default pull-right"><span class="glyphicon-shopping-cart glyphicon"></span> Złóż zamówienie
                </a>

				<table class="table table-hover">
					<tr>
						<th>Przedmiot</th>
						<th>Cena jednostkowa</th>
						<th>Rabat</th>
						<th>Ilość (szt.)</th>
						<th>Cena PLN</th>
						<th></th>
					</tr>
					<tr ng-repeat="item in cart.cartItems">
						<td>{{item.product.name}}</td>
						<td>{{item.product.price}}</td>
						<td>{{item.product.discount}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice| number : 2}}</td>
						<td><a href="#" class="label label-warning"
							ng-click="removeFromCart(item.product.id)"><span
								class="glyphicon glyphicon-remove"></span>Usuń</a></td>
					</tr>
					<tr>
						<th></th>
						<th></th>
						<th></th>
						<th>Cena brutto</th>
						<th>{{calculateGrandTotal()| number : 2}}</th>
						<th></th>
					</tr>
				</table>

				<a href="<spring:url value="/product/productList"/>" class="btn btn-info">Kontynuuj
					zakupy</a>
			</div>
		</section>
	</div>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"/>"></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>