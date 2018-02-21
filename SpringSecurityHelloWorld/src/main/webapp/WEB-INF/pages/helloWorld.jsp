<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Hello World!</h3>
<form:form modelAttribute="person" action ="ShowUserDetails" method="post">
Name : <form:input path="name" />
Age : <form:input path="age" />
<input type="submit" value="submit"/>
</form:form>
<%-- <h4>Name : ${name}</h4>
<h4>Age: ${age}</h4>
<h4>${message}</h4> --%>

</body>
</html>