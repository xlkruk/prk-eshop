<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List produkt�w</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Nazwa produktu</th>	
				<th>Kategoria</th>
				<th>Stan</th>
				<th>Cena</th>
			</tr>
		</thead>
		<tr>
			<td>${product.name}</td>
			<td>${product.category}</td>
			<td>${product.condition}</td>
			<td>${product.price}</td>
		</tr>

	</table>

</body>
</html>