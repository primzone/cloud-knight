<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCRYPE html>

<html>

<body>
<h2>Employee Info</h2>

<br>
<form:form action="saveEmployee" modelAttribute = "employee">


    <form:hidden path="id"/>

    Name<form:input path="name"/>
    <br><br>
    Surname<form:input path="surname"/>
    <br><br>
    Department<form:input path="department"/>
    <br><br>
    Salary<form:input path="salary"/>

    <input type="submit" value="ok">


</form:form>

</body>


</html>