<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Szczegóły:</h1>

			<p class="lead">poniżej szczegółowe informacje o produkcie:</p>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<img src="#" alt="image" style="width: 100%; height: 300px;" />
				</div>

				<div class="col-md-5">
					<h3>${product.name}</h3>
					<p>${product.description}</p>
					<p>
						<strong>Producent:</strong>${product.manufacturer}</p>
					<p>
						<strong>Kategoria:</strong>${product.category}</p>
					<p>
						<strong>Stan:</strong>${product.condition}</p>
					<h4>${product.price}PLN</h4>
				</div>
			</div>

		</div>
		<%@include file="/WEB-INF/views/template/footer.jsp"%>