<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@include file="/WEB-INF/views/template/navbar.jsp"%>

<div class="container-wrapper">
	<div class="container">

	<!-- <center>
		<img class="market-logo"
						src="<c:url value="/resources/images/handmade-market-logo.png"/>"
						alt="MARKET LOGO"></center> -->


		<!-- Carousel
    ================================================== -->
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
				<li data-target="#myCarousel" data-slide-to="5"></li>
			</ol>
			<div class="carousel-inner home-image" role="listbox">
				<div class="item active">
					<img class="first-slide"
						src="<c:url value="/resources/images/carousel1.jpg"/>"
						alt="First slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Obrazy i ramki</h1>
							<p>
								Chcesz przyozdobić oryginalnie  ścianę? Polecamy ramki do zdjęć i nie tylko...
							</p>
							<p>
								<a class="btn btn-lg btn-primary" href="/Shop/product/productListByCategory/PAINTINGS" role="button"> Wejdź </a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="second-slide home-image"
						src="<c:url value="/resources/images/carousel2.jpg"/>"
						alt="Second slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Biżuteria</h1>
							<p>Tak prosto kogoś oczarować... Niepowtarzalne wzory naszyjników, bransolet, kolczyków i wiele innych!!!</p>
							<p>
								<a class="btn btn-lg btn-primary" href="/Shop/product/productListByCategory/JEWELLERY" role="button"> Wejdź </a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide home-image"
						src="<c:url value="/resources/images/carousel3.jpg"/>"
						alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Ceramika</h1>
							<p>Drobne bibeloty, by dodać piękna domowemu otoczeniu...</p>
							<p>
								<a class="btn btn-lg btn-primary" href="/Shop/product/productListByCategory/CERAMICS" role="button"> Wejdź</a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide home-image"
						src="<c:url value="/resources/images/carousel4.jpg"/>"
						alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Kartki i zaproszenia</h1>
							<p>Wyjatkowe kartki świąteczne i okolicznościowe. Spraw komuś radość!</p>
							<p>
								<a class="btn btn-lg btn-primary" href="/Shop/product/productListByCategory/CARDS" role="button"> Wejdź </a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide home-image"
						src="<c:url value="/resources/images/carousel5.jpg"/>"
						alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Meble</h1>
							<p>Poza wygodą meble mogą być także piękne i stylowe...</p>
							<p>
								<a class="btn btn-lg btn-primary" href="/Shop/product/productListByCategory/FERNITURES" role="button"> Wejdź</a>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img class="third-slide home-image"
						src="<c:url value="/resources/images/carousel6.jpg"/>"
						alt="Third slide">
					<div class="container">
						<div class="carousel-caption">
							<h1>Torby</h1>
							<p>Możesz zawsze mieć pod ręką taki niepowatrzalny gadżet... Zwaracamy szczególną uwagę na szeroki wybór toreb z filcu.</p>
							<p>
								<a class="btn btn-lg btn-primary" href="/Shop/product/productListByCategory/BAGS" role="button"> Wejdź</a>
							</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- /.carousel -->


		<!-- Marketing messaging and featurettes
    ================================================== -->
		<!-- Wrap the rest of the page in another container to center all the content. -->

		<div class="container marketing">

			<!-- Three columns of text below the carousel -->
			<div class="row">
				<div class="col-lg-4">
					<img class="img-circle"
						src="<c:url value="/resources/images/kategoria1.jpg"/>"
						alt="Generic placeholder image" width="140" height="140">
					<h2>Obrazy i ramki</h2>
					<p>Ręcznie malowane obrazy. Ramki do zdjęć wykonane różnymi technikami.</p>
					<p>
						<a class="btn btn-md btn-primary" href="/Shop/product/productListByCategory/PAINTINGS" role="button">Przejdź dalej
							&raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4">
					<img class="img-circle"
						src="<c:url value="/resources/images/kategoria2.jpg"/>"
						alt="Generic placeholder image" width="140" height="140">
					<h2>Biżuteria</h2>
					<p>Biżuteria z kamieni szlachetnych i minerałów. Ozdoby z filcu i haftu soutache.</p>
					<p>
						<a class="btn btn-md btn-primary" href="/Shop/product/productListByCategory/JEWELLERY" role="button">Przejdź dalej
							&raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4">
					<img class="img-circle"
						src="<c:url value="/resources/images/kategoria3.jpg"/>"
						alt="Generic placeholder image" width="140" height="140">
					<h2>Ceramika</h2>
					<p>Wybór bibelotow z ceramiki. Nadadzą niepowtarzalny charakter Twojej przestrzeni.</p>
					<p>
						<a class="btn btn-md btn-primary" href="/Shop/product/productListByCategory/CERAMICS" role="button">Przejdź dalej
							&raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-4">
					<img class="img-circle"
						src="<c:url value="/resources/images/kategoria4.jpg"/>"
						alt="Generic placeholder image" width="140" height="140">
					<h2>Kartki i zaproszenia</h2>
					<p>Oryginalne kartki świąteczne i okolicznościowe. Zaproszenia na przeróżne okazje.</p>
					<p>
						<a class="btn btn-md btn-primary" href="/Shop/product/productListByCategory/CARDS" role="button">Przejdź dalej
							&raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4">
					<img class="img-circle"
						src="<c:url value="/resources/images/kategoria5.jpg"/>"
						alt="Generic placeholder image" width="140" height="140">
					<h2>Meble</h2>
					<p>Meble rystykalne i nowoczesne. Wspaniałe wzornictwo i funkcjonalność.</p>
					<p>
						<a class="btn btn-md btn-primary" href="/Shop/product/productListByCategory/FERNITURES" role="button">Przejdź dalej
							&raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
				<div class="col-lg-4">
					<img class="img-circle"
						src="<c:url value="/resources/images/kategoria6.jpg"/>"
						alt="Generic placeholder image" width="140" height="140">
					<h2>Torby</h2>
					<p>Torby na codzień i od święta. Wykonane ręcznie z filcu, skóry i bawełny.</p>
					<p>
						<a class="btn btn-md btn-primary" href="/Shop/product/productListByCategory/BAGS" role="button">Przejdź dalej
							&raquo;</a>
					</p>
				</div>
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
		<%@include file="/WEB-INF/views/template/footer.jsp"%>