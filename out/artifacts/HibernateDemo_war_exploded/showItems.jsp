
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
        <caption><h2>Item List</h2></caption>
        <tr>
            <th>item name</th>
        </tr>
        <c:forEach var="item" items="${items}">
            <tr>
                <td><c:out value="${item.iname}" /></td>
                <td>
                    <a href="/deleteItem?id=<c:out value='${item.iid}' />">delete</a>
                </td>
                <td>
                    <a href="/addCart?id=<c:out value='${item.iid}' />">add cart</a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <form action="addItem">
                <td><input type="input" name="itemName"/></td>
                <td><input type="submit" value="add" /></td>
            </form>
        </tr>
    </table>
</div>
</body>
</html>
