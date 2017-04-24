<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">

		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Dziękujemy za złożenie zamówienia.</h1>
					<p>Przewidywany czas dostawy to 3 dni robocze.</p>
				</div>
			</div>
		</section>

		<section class="container">
			<p>

				<a href="<spring:url value="/"/>" class="btn btn-info">Zakończ</a>
			</p>
		</section>
	</div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>