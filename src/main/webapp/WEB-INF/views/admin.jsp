<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">
			<div class="pull-right">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<c:url var="logoutUrl" value="/logout" />
				<form action="${logoutUrl}" method="post">
					<input class="btn btn-info" type="submit" value="Wyloguj" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</c:if>
		</div>
		<div class="page-header">
			<h1>Strona administratora</h1>

			<p class="lead">Tu można zarządzać produktami oraz użytkownikami.</p>
		</div>
		<div class="container">
			<h3>
				<a href="<c:url value="/admin/productInventory"/>">Zarządzanie
					produktami</a>
			</h3>
			<p>Umożliwia dodawanie, edycję oraz usuwanie dostępnych
				produktów.</p>
		</div>
		<div class="container">
			<h3>
				<a href="<c:url value="/admin/orderList"/>">Zamówienia</a>
			</h3>
			<p>Zarządzanie zamówieniami.</p>
		</div>
		
				<div class="container">
			<h3>
				<a href="<c:url value="/admin/customer"/>">Klienci</a>
			</h3>
			<p>Zarządzanie klientami.</p>
		</div>

		<%@include file="/WEB-INF/views/template/footer.jsp"%>