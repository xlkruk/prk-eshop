<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Dane użytkownika ${customer.username}</h1>
			<p class="lead">Poniżej możesz zmodyfikować swoje dane:</p>
		</div>
		<form:form
			action="${pageContext.request.contextPath}/customer/editCustomer"
			method="post" commandName="customer" enctype="multipart/form-data"
			accept-charset="UTF-8">
			<h3>Informacje podstawowe</h3>
			<h2>${customer.customerFirstName} ${customer.customerLastName}</h2>
			<div class="form-group">
				<label for="email">Nowe hasło:</label>
				<form:errors path="password" cssStyle="color: red;" />
				<form:password path="password" id="password" class="form-control" />
			</div>
			<!-- <input type="hidden" name="password" value="${customer.password}"> -->

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

			<h3>Adres do faktury</h3>

			<div class="form-group">
				<label for="billingStreet">Ulica:</label>
				<form:errors path="billingStreet" cssStyle="color: red;" />
				<form:input path="billingStreet" id="billingStreet"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="billingApartmentNumber">Numer domu:</label>
				<form:errors path="billingApartmentNumber" cssStyle="color: red;" />
				<form:input path="billingApartmentNumber"
					id="billingApartmentNumber" class="form-control" />
			</div>

			<div class="form-group">
				<label for="billingCity">Miasto:</label>
				<form:errors path="billingCity" cssStyle="color: red;" />
				<form:input path="billingCity" id="billingCity" class="form-control" />
			</div>

			<div class="form-group">
				<label for="billingZipCode">Kod pocztowy:</label>
				<form:errors path="billingZipCode" cssStyle="color: red;" />
				<form:input path="billingZipCode" id="billingZipCode"
					class="form-control" />
			</div>

			<h3>Adres do wysyłki</h3>

			<div class="form-group">
				<label for="shippingStreet">Ulica:</label>
				<form:errors path="shippingStreet" cssStyle="color: red;" />
				<form:input path="shippingStreet" id="shippingStreet"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="shippingApartmentNumber">Numer domu:</label>
				<form:errors path="shippingApartmentNumber" cssStyle="color: red;" />
				<form:input path="shippingApartmentNumber"
					id="shippingApartamentNumber" class="form-control" />
			</div>

			<div class="form-group">
				<label for="shippingCity">Miasto:</label>
				<form:errors path="shippingCity" cssStyle="color: red;" />
				<form:input path="shippingCity" id="shippingCity"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="shippingZipCode">Kod pocztowy:</label>
				<form:errors path="shippingZipCode" cssStyle="color: red;" />
				<form:input path="shippingZipCode" id="shippingZipCode"
					class="form-control" />
			</div>
			<input type="hidden" name="customerId" value="${customer.customerId}">

			<input type="hidden" name="customerFirstName"
				value="${customer.customerFirstName}">
			<input type="hidden" name="customerLastName"
				value="${customer.customerLastName}">
			<input type="hidden" name="username" value="${customer.username}">
			<br>
			<br>
			<input type="submit" value="Zapisz" class="btn btn-default">
			<a href="<c:url value="/customer/${customer.username}"/>"
				class="btn btn-default">Anuluj</a>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token }">
		</form:form>

		<%@include file="/WEB-INF/views/template/footer.jsp"%>