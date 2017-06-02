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

			<h2>Informacje podstawowe</h2>
			<section>
				<div class="jumbotron">
					<div class="container">
						<div class="form-group">
							<h3>${order.cart.customer.customerFirstName}
								${order.cart.customer.customerLastName}<br>
								<h3>Email: ${order.cart.customer.customerEmail}</h3>
								<h3>Telefon: ${order.cart.customer.customerPhone}</h3>
						</div>
					</div>
				</div>
			</section>



			<h2>Adres do faktury</h2>
			<section>
				<div class="jumbotron">
					<div class="container">
						<div class="form-group">
							<label for="billingStreet">Ulica:</label>
							<form:errors path="cart.customer.billingAddress.street"
								cssStyle="color: red;" />
							<form:input path="cart.customer.billingAddress.street"
								id="billingStreet" class="form-control" />
						</div>

						<div class="form-group">
							<label for="billingApartamentNumber">Numer domu:</label>
							<form:errors path="cart.customer.billingAddress.apartmentNumber"
								cssStyle="color: red;" />
							<form:input path="cart.customer.billingAddress.apartmentNumber"
								id="billingApartamentNumber" class="form-control" />
						</div>

						<div class="form-group">
							<label for="billingCity">Miasto:</label>
							<form:errors path="cart.customer.billingAddress.city"
								cssStyle="color: red;" />
							<form:input path="cart.customer.billingAddress.city"
								id="billingCity" class="form-control" />
						</div>

						<div class="form-group">
							<label for="billingZipCode">Kod pocztowy:</label>
							<form:errors path="cart.customer.billingAddress.zipCode"
								cssStyle="color: red;" />
							<form:input path="cart.customer.billingAddress.zipCode"
								id="billingZipCode" class="form-control" />
						</div>

						<input type="hidden" name="_flowExecutionKey" />
					</div>
				</div>
			</section>
			<br>
			<br>
			<input type="submit" value="Dalej" class="btn btn-default"
				name="_eventId_customerInfoCollected" />
			<button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token }">
		</form:form>




		<%@include file="/WEB-INF/views/template/footer.jsp"%>