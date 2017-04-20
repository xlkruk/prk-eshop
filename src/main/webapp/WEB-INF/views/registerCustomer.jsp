<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Rejestracja</h1>

			<p class="lead">Wypełnij poniższe dane:</p>
		</div>
		<form:form action="${pageContext.request.contextPath}/register"
			method="post" commandName="customer">

			<h3>Informacje podstawowe</h3>
			<div class="form-group">
				<label for="firstName">Imię:</label>
				<form:errors path="customerFirstName" cssStyle="color: red;" />
				<form:input path="customerFirstName" id="firstName"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="lastName">Nazwisko:</label>
				<form:errors path="customerLastName" cssStyle="color: red;" />
				<form:input path="customerLastName" id="lastName"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="email">Email:</label>
				<form:errors path="customerEmail" cssStyle="color: red;" />
				<form:input path="customerEmail" id="email" class="form-control" />
			</div>

			<div class="form-group">
				<label for="phone">Telefon:</label>
				<form:errors path="customerPhone" cssStyle="color: red;" />
				<form:input path="customerPhone" id="phone" class="form-control" />
			</div>

			<div class="form-group">
				<label for="username">Nazwa użytkownika:</label>
				<form:errors path="username" cssStyle="color: red;" />
				<form:input path="username" id="username" class="form-control" />
			</div>

			<div class="form-group">
				<label for="password">Hasło:</label>
				<form:errors path="password" cssStyle="color: red;" />
				<form:password path="password" id="password" class="form-control" />
			</div>

			<h3>Adres do faktury</h3>

			<div class="form-group">
				<label for="billingStreet">Ulica:</label>
				<form:errors path="billingAddress.street" cssStyle="color: red;" />
				<form:input path="billingAddress.street" id="billingStreet"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="billingApartamentNumber">Numer domu:</label>
				<form:errors path="billingAddress.apartmentNumber"
					cssStyle="color: red;" />
				<form:input path="billingAddress.apartmentNumber"
					id="billingApartamentNumber" class="form-control" />
			</div>

			<div class="form-group">
				<label for="billingCity">Miasto:</label>
				<form:errors path="billingAddress.city" cssStyle="color: red;" />
				<form:input path="billingAddress.city" id="billingCity"
					class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="billingZipCode">Kod pocztowy:</label>
				<form:errors path="billingAddress.zipCode" cssStyle="color: red;" />
				<form:input path="billingAddress.zipCode" id="billingZipCode"
					class="form-control" />
			</div>
			
			<h3>Adres do wysyłki</h3>

			<div class="form-group">
				<label for="shippingStreet">Ulica:</label>
				<form:errors path="shippingAddress.street" cssStyle="color: red;" />
				<form:input path="shippingAddress.street" id="shippingStreet"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="shippingApartamentNumber">Numer domu:</label>
				<form:errors path="shippingAddress.apartmentNumber"
					cssStyle="color: red;" />
				<form:input path="shippingAddress.apartmentNumber"
					id="shippingApartamentNumber" class="form-control" />
			</div>

			<div class="form-group">
				<label for="shippingCity">Miasto:</label>
				<form:errors path="shippingAddress.city" cssStyle="color: red;" />
				<form:input path="shippingAddress.city" id="shippingCity"
					class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="shippingZipCode">Kod pocztowy:</label>
				<form:errors path="shippingAddress.zipCode" cssStyle="color: red;" />
				<form:input path="shippingAddress.zipCode" id="shippingZipCode"
					class="form-control" />
			</div>

			<br>
			<br>
			<input type="submit" value="Dodaj" class="btn btn-default">
			<a href="<c:url value="/"/>"
				class="btn btn-default">Anuluj</a>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token }">
		</form:form>




		<%@include file="/WEB-INF/views/template/footer.jsp"%>