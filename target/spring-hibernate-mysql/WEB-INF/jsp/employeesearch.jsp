<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kobri
  Date: 16.05.2016
  Time: 2:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee search</title>
</head>
<body>

<h2>You choose date between ${from} and ${to} </h2>

<table style="border: 1px solid; width: 500px; text-align:center" border="1">

    <tr>
        <td>№</td>
        <td>First name</td>
        <td>Last name</td>
        <td>Middle Name</td>
        <td>Birthday</td>
        <td>Salary</td>
        <td>Department</td>
    </tr>


    <c:forEach items="${employee}" var="employee">

        <tr>
            <td><c:out value="${employee.id}" /></td>
            <td><c:out value="${employee.fname}" /></td>
            <td><c:out value="${employee.lname}" /></td>
            <td><c:out value="${employee.mname}" /></td>
            <td><c:out value="${employee.birthday}" /></td>
            <td><c:out value="${employee.salary}" /></td>
            <td>
                <c:forEach items="${department}" var="department">
                    <c:choose>
                        <c:when test="${department.id == employee.dep_id }">
                            <c:out value="${department.name}" />
                        </c:when>
                    </c:choose>
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<c:url var="mainUrl" value="/and/home/index" />
<p>Return to <a href="${mainUrl}">Main List</a></p>
</body>
</html>
