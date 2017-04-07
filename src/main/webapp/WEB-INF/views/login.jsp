<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container ">
		<div id="login-box" class="col-md-4">
			<h2>Zaloguj się</h2>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
				<c:if test="${not empty error}">
					<div class="error" style="color: red;">${error}</div>
				</c:if>
				<div class="form-group">
					<label for="username">Login: </label> <input type="text"
						id="username" name="username" class="form-control">
				</div>
				<div class="form-group">
					<label for="password">Hasło: </label> <input type="password"
						id="password" name="password" class="form-control">
				</div>
				<input type="submit" value="Zaloguj" class="btn btn-default">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token }">
			</form>

		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>