<%--
  Created by IntelliJ IDEA.
  User: peiwendu
  Date: 11/16/20
  Time: 01:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
<center>
    <h2>
        <a href="/toItem">Create or Delete Item</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/toCart">Show Shopping Cart</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Shopping cart</h2></caption>
        <tr>
            <th>item name</th>
            <th>time</th>
            <th>modify</th>
        </tr>
        <c:forEach var="tran" items="${trans}">
            <tr>
                <td><c:out value="${tran.iname}" /></td>
                <td>
                    <c:out value="${tran.time}" />
                </td>
                <td>
                    <a href="/deleteCart?iid=<c:out value='${tran.iid}'/>&uid=<c:out value='${tran.uid}'/>">delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
