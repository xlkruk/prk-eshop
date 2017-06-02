<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Zamówienie</h1>

			<p class="lead">Dane potrzebne do złożenia zamówienia:</p>
		</div>
		<form:form commandName="order" class="form-horizontal">

			<h2>Adres dostawy</h2>
			<section>
				<div class="jumbotron">
					<div class="container">
						<div class="form-group">
							<label for="shippingStreet">Ulica:</label>
							<form:errors path="cart.customer.shippingAddress.street"
								cssStyle="color: red;" />
							<form:input path="cart.customer.shippingAddress.street"
								id="shippingStreet" class="form-control" />
						</div>

						<div class="form-group">
							<label for="shipingApartamentNumber">Numer domu:</label>
							<form:errors path="cart.customer.shippingAddress.apartmentNumber"
								cssStyle="color: red;" />
							<form:input path="cart.customer.shippingAddress.apartmentNumber"
								id="shippingApartamentNumber" class="form-control" />
						</div>

						<div class="form-group">
							<label for="shippingCity">Miasto:</label>
							<form:errors path="cart.customer.shippingAddress.city"
								cssStyle="color: red;" />
							<form:input path="cart.customer.shippingAddress.city"
								id="shippingCity" class="form-control" />
						</div>

						<div class="form-group">
							<label for="shippingZipCode">Kod pocztowy:</label>
							<form:errors path="cart.customer.shippingAddress.zipCode"
								cssStyle="color: red;" />
							<form:input path="cart.customer.shippingAddress.zipCode"
								id="shippingZipCode" class="form-control" />
						</div>

						<input type="hidden" name="_flowExecutionKey" />
					</div>
				</div>
			</section>

			<br>
			<br>
			<button class="btn btn-default"
				name="_eventId_backToCollectCustomerInfo">Powrót</button>
			<input type="submit" value="Dalej" class="btn btn-default"
				name="_eventId_shippingDetailCollected" />
			<button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token }">
		</form:form>




		<%@include file="/WEB-INF/views/template/footer.jsp"%>