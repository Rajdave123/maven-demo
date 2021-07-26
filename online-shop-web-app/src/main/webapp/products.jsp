<%@page import="com.phoenix.data.Product"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products Page</title>
<style>
* {
	margin: 0 auto;
}
</style>
</head>
<body style="background-color: yellow; text-align: center;">
	<jsp:include page="/header.html"></jsp:include>

	<%
		HttpSession ss = request.getSession(false);

		if (ss != null) {
			String name = (String) ss.getAttribute("username");
			List<Product> products = (List<Product>) ss.getAttribute("products");
			System.out.print(products);
	%>

	<h1 style='color: blue'>
		Hi <b style='color: red'> <%=name%></b>,<br /> Greetings! You can buy
		the products of your choices!
	</h1>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<table border="5px solid #095484">

		<tr bordercolor="black">
			<th>ProductName</th>
			<th>Brand</th>
			<th>Price</th>
		</tr>
		<%
			for (Product p : products) {
		%>

		<tr>
			<td><%=p.getName()%></td>
			<td><%=p.getBrand()%></td>
			<td><%=p.getPrice()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
	%>
	<h2 style="margin-top: 50px;">Sorry! &#128542; your session has
		expired.</h2>
	<h3 style="margin-top: 20px; color: red">You can try again after
		login successfully.</h3>
	<%
		}
	%>

	<jsp:include page="/footer.html"></jsp:include>
</body>
</html>