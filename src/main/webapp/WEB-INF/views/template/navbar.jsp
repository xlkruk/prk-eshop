<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="<c:url value="/" /> ">PRK JEE</a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<!-- <li><a href="<c:url value="/" /> ">Strona domowa</a></li> -->
							<li><a href="<c:url value="/product/productList" />">Oferta</a></li>
							<li><a href="#contact">Kontakt</a></li>
						</ul>
						<ul class="nav navbar-nav pull-right">
							<c:if test="${pageContext.request.userPrincipal.name != null}">
								<li><a>Witaj ${pageContext.request.userPrincipal.name}</a></li>
								<li><a href="<c:url value="/logout?logout" />">Wyloguj</a>
								</li>
								<c:if
									test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value="/customer/cart" />">Koszyk</a></li>
								</c:if>
								<c:if
									test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value="/customer/${pageContext.request.userPrincipal.name}" />">Konto</a></li>
								</c:if>
								<c:if
									test="${pageContext.request.userPrincipal.name == 'admin'}">
									<li><a href="<c:url value="/admin" />">Administrator</a></li>
								</c:if>
							</c:if>
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<li><a href="<c:url value="/login/" />">Zaloguj</a></li>
								<li><a href="<c:url value="/register" />">Zarejestruj</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>