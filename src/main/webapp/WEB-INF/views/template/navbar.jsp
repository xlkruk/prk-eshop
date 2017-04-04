<!-- NAVBAR
================================================== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">J2EE PRP</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li><a href="<c:url value="/"></c:url>">Strona domowa</a></li>
						<li ><a href='<c:url value="/productList"></c:url>'>Produkty</a></li>
						<li ><a href='<c:url value="/../viewProduct"></c:url>'>TestProduktu</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
					</ul >
					<ul class="nav navbar-nav pull-right">
					<li><a href="<c:url value="/admin"></c:url>">Administrator</a></li>
					</ul>
				</div>
			</div>
			</nav>

		</div>
	</div>
