<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<body>
<h2>Hello World!</h2>
<form:form action ="ShowUserDetails" modelAttribute="Person">
Name : <form:input path="name"/>
Age :  <form:input path="age"/>
<input type="submit" value="submit"/>
</form:form>
</body>
