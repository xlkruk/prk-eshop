<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Strona administratora</h1>

			<p class="lead">Tu można zarządzać produktami oraz użytkownikami.</p>
		</div>
<h3>
	<a href="<c:url value="/admin/productInventory"/>" >Zarządzanie produktami</a>
</h3>
<p>Umożliwia dodawanie, edycję oraz usuwanie dostępnych produktów.</p>

		<%@include file="/WEB-INF/views/template/footer.jsp"%>