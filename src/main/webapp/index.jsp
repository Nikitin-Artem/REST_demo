<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 25.04.2022
  Time: 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
</head>
<body>

<h3>Spring REST demo</h3>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">hello page</a>
<br>
<a href="${pageContext.request.contextPath}/api/students">Students page</a>

</body>
</html>
