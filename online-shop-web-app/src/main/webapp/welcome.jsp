<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- Bean Instance created --%>
<jsp:useBean id="bean" scope="request"
	class="com.phoenix.web.models.LoginBean"></jsp:useBean>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>

<style>
* {
	margin: 0
}
</style>

</head>

<%@ include file="/header.html"%>

<body style="background: #ff1a1a; text-align: center;">
	<%
		//set the states of the user
		session.setAttribute("username", bean.getUsername());
		session.setAttribute("password", bean.getPassword());

		//set timeout 
		session.setMaxInactiveInterval(10);
		int sessionTimeout = session.getMaxInactiveInterval();

		//encode url using url rewriting 
		String encodedUrl = response.encodeURL("ProductAllServlet");
	%>
	<br>
	<br> Your Username:
	<jsp:getProperty property="username" name="bean" />&nbsp;&nbsp;&nbsp;
	Your Password: xxxxxxx
	<br>
	<br>
	<h1 style="color: yellow;">
		Welcome
		<%=bean.getUsername()%>!
	</h1>
	<br>
	<br>
	<br>


	<h2>
		Session will be timeout in <%=sessionTimeout%> seconds
	</h2>

	<br>
	<br>

	<h2>
		<a href="<%=encodedUrl%>">Go to Products Page...</a>
	</h2>
</body>

<%@ include file="/footer.html"%>