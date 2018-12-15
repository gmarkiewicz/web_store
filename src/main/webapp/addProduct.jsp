<%@ page import="com.markiewiczgrzegorz.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<%
    List<Product> products = (List<Product>)request.getSession().getAttribute("products");
%>
<table>
    <tr>
        <td>ID</td>
        <td>Nazwa</td>
        <td>Opis</td>
        <td>Cena</td>
        <td>Ilość sztuk</td>
    </tr>
    <tr>
        <form action="/AddProduct" method="post">
            <td><input name="id" value="<%=products.size()+1%>" readonly/></td>
            <td><input name="name"/></td>
            <td><input name="description"/></td>
            <td><input name="price"/></td>
            <td><input name="quantity"/></td>
            <button type="submit">dodaj</button>
        </form>
    </tr>
</table>
</body>
</html>
