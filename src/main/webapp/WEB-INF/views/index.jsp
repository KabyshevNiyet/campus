<%--
  Created by IntelliJ IDEA.
  User: Niyet
  Date: 11.04.2019
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Hello</h1>
    <c:forEach items="${advisors}" var="adv">
        <h2>
            ${adv.surname} - ${adv.name}
        </h2>
    </c:forEach>


</body>
</html>
