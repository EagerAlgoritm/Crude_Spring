<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>Input your data</h2>
<br>

<form:form action="saveUser" modelAttribute="User">

    <form:hidden path="id"/>

    Name <form:input path="name"/>
    <br><br>
    LastName <form:input path="lastName"/>
    <br><br>
    Age <form:input path="age"/>
    <br><br>
    Hobby <form:input path="hobby"/>
    <br><br>
    <input type="submit" value="OK">
    <input type="button" value="Return"
           onclick="window.location.href = '/'">

</form:form>



</body>



</html>