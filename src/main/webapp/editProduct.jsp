<%@ page import="com.markiewiczgrzegorz.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
 <%
     int indexOfProduct = Integer.valueOf(request.getParameter("Index")) - 1;
     List<Product> products = (List<Product>)request.getSession().getAttribute("products");
     Product product = products.get(indexOfProduct);
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
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getQuantity()%></td>
    </tr>
    <tr>
        <form action="/EditProduct" method="post">
            <td><input name="id" value="<%=product.getId()%>" readonly/></td>
            <td>Nowa nazwa:<br/><input name="name" value="<%=product.getName()%>"/></td>
            <td>Nowy opis:<br/><input name="description" value="<%=product.getDescription()%>"/></td>
            <td>Nowa cena:<br/><input name="price" value="<%=product.getPrice()%>"/></td>
            <td>Nowa ilosc:<br/><input name="quantity" value="<%=product.getQuantity()%>"/></td>
            <button type="submit">Edytuj</button>
        </form>
    </tr>
</table>
</body>
</html>
