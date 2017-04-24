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

			<h3>Informacje podstawowe</h3>
			<div class="form-group">
				<label for="firstName">Imię:</label>
				<form:errors path="cart.customer.customerFirstName"
					cssStyle="color: red;" />
				<form:input path="cart.customer.customerFirstName" id="firstName"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="lastName">Nazwisko:</label>
				<form:errors path="cart.customer.customerLastName"
					cssStyle="color: red;" />
				<form:input path="cart.customer.customerLastName" id="lastName"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="email">Email:</label>
				<form:errors path="cart.customer.customerEmail"
					cssStyle="color: red;" />
				<form:input path="cart.customer.customerEmail" id="email"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="phone">Telefon:</label>
				<form:errors path="cart.customer.customerPhone"
					cssStyle="color: red;" />
				<form:input path="cart.customer.customerPhone" id="phone"
					class="form-control" />
			</div>


			<h3>Adres do faktury</h3>

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

			<br>
			<br>
			<input type="submit" value="Dalej" class="btn btn-default"
				name="_eventId_customerInfoCollected" />
			<button class="btn btn-default" name="_eventId_cancel">Anuluj</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token }">
		</form:form>




		<%@include file="/WEB-INF/views/template/footer.jsp"%>