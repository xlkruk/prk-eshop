﻿<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Edytuj produkt</h1>

			<p class="lead">Podaj informacje o produkcie:</p>
		</div>
		<form:form
			action="${pageContext.request.contextPath}/admin/product/editProduct"
			method="post" commandName="product" enctype="multipart/form-data"
			accept-charset="UTF-8">
			<div class="form-group">
				<label for="name">Nazwa:</label>
				<form:errors path="name" cssStyle="color: red;" />
				<form:input path="name" id="name" class="form-control"
					value="${product.name}" />
				<form:hidden path="id" value="${product.id}" />
			</div>
			<div class="form-group">
				<label for="manufacturer">Producent:</label>
				<form:input path="manufacturer" id="manufacturer"
					class="form-control" value="${product.manufacturer}" />
			</div>

						<div class="form-group">
				<label for="category">Kategoria:</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="biżuteria" />biżuteria</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="ceramika" />ceramika</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="kartki i zaproszenia" />kartki i zaproszenia</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="meble" />meble</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="obrazy i ramki" />obrazy i ramki</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="torby" />torby</label>
			</div>

			<div class="form-group">
				<label for="description">Opis:</label>
				<form:textarea rows="7" path="description" id="description"
					class="form-control" value="${product.description}" />
			</div>

			<div class="form-group">
				<label for="price">Cena:</label>
				<form:errors path="price" cssStyle="color: red;" />
				<form:input path="price" id="price" class="form-control"
					value="${product.price}" />
			</div>

			<div class="form-group">
				<label for="discount">Rabat:</label>
				<form:errors path="discount" cssStyle="color: red;" />
				<form:input path="discount" id="discount" class="form-control"
					value="${product.discount}" />
			</div>

			<div class="form-group">
				<label for="status">Status:</label> <label class="checkbox-inline"><form:radiobutton
						path="status" id="status" value="active" />Aktywny</label> <label
					class="checkbox-inline"><form:radiobutton path="status"
						id="status" value="inactive" />Nieaktywny</label>
			</div>
			<!--
			<div class="form-group">
				<label for="stock">Stan magazynu:</label>
				<form:errors path="stock" cssStyle="color: red;" />
				<form:input path="stock" id="stock" class="form-control"
					value="${product.stock}" />
			</div>-->

			<div class="form-group">
				<label class="control-label" for="productImage">Dodaj
					obrazek:</label>
				<form:input path="productImage" id="productImage" type="file"
					class="form:input-large" />
			</div>
			<br>
			<br>
			<input type="submit" value="Zapisz" class="btn btn-default">
			<a href="<c:url value="/admin/productInventory"/>"
				class="btn btn-default">Anuluj</a>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token }">
		</form:form>
	</div>
</div>



<%@include file="/WEB-INF/views/template/footer.jsp"%>