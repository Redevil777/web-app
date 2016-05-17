<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kobri
  Date: 14.05.2016
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
hello department

<li><a href="<spring:url value='/and/department/add' ></spring:url>"
       title="department-add">add department</a></li>

<li><a href="<spring:url value='/and/department/all' ></spring:url>"
       title="department-all">get all department</a></li>
<li><a href="<spring:url value='/and/employee/all' ></spring:url>"
       title="department-all">get all employee</a></li>
</body>
</html>
