<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Nowy produkt</h1>

			<p class="lead">Podaj informacje o produkcie:</p>
		</div>
		<form:form
			action="${pageContext.request.contextPath}/admin/productInventory/addProduct"
			method="post" commandName="product" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Nazwa:</label>
				<form:input path="name" id="name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="manufacturer">Producent:</label>
				<form:input path="manufacturer" id="manufacturer"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="category">Kategoria:</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="kategoria1" />Kategoria 1</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="kategoria2" />Kategoria 2</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="kategoria3" />Kategoria 3</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="kategoria4" />Kategoria 4</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="kategoria5" />Kategoria 5</label> <label
					class="checkbox-inline"><form:radiobutton path="category"
						id="category" value="kategoria6" />Kategoria 6</label>
			</div>

			<div class="form-group">
				<label for="description">Opis:</label>
				<form:textarea rows="7" path="description" id="description"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="price">Cena:</label>
				<form:input path="price" id="price" class="form-control" />
			</div>

			<div class="form-group">
				<label for="discount">Rabat:</label>
				<form:input path="discount" id="discount" class="form-control" />
			</div>

			<div class="form-group">
				<label for="status">Status:</label> <label class="checkbox-inline"><form:radiobutton
						path="status" id="status" value="active" />Aktywny</label> <label
					class="checkbox-inline"><form:radiobutton path="status"
						id="status" value="inactive" />Nieaktywny</label>
			</div>
			<div class="form-group">
				<label for="stock">Stan magazynu:</label>
				<form:input path="stock" id="stock" class="form-control" />
			</div>
			
			<div class="form-group">
				<label class="control-label" for="productImage">Dodaj
					obrazek:</label>
				<form:input path="productImage" id="productImage" type="file"
					class="form:input-large" />
			</div>
			<br>
			<br>
			<input type="submit" value="Dodaj" class="btn btn-default">
			<a href="<c:url value="/admin/productInventory"/>"
				class="btn btn-default">Anuluj</a>
		</form:form>




		<%@include file="/WEB-INF/views/template/footer.jsp"%>