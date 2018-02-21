<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${error eq 'true'}">
${msg}
</c:if>
<form name='loginForm' action="<c:url value='j_spring_security_check' />"
method='POST'>
 
<table>
<tr>
<td>User Name:</td>
<td><input type='text' name='j_username' value=''>
</td>
</tr>
<tr>
<td>Password:</td>
<td><input type='password' name='j_password' />
</td>
</tr>
<tr>
<td><input name="submit" type="submit"
value="submit" />
</td>
<td><input name="reset" type="reset" />
</td>
</tr>
</table>
 
</form>
</body>
</html>