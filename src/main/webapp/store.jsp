<%@ page import="com.markiewiczgrzegorz.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Store</title>
</head>
<body>
<%
    String userRole = (String) request.getSession().getAttribute("userRole");
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null){
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("login")){
                userName = cookie.getValue();
                break;
            }
        }
    }

    if(userName == null){
        response.sendRedirect("index.jsp");
    }
%>
<div>
    <h3>Witaj użytkowniku <%= userName%></h3>
    <form action="Logout" method="post">
        <button type="submit">Logout</button>
    </form>
</div>
<h1>Sklep</h1>

<table>
    <tr>
        <td>ID</td>
        <td>Nazwa</td>
        <td>Opis</td>
        <td>Cena</td>
        <td>Ilość sztuk</td>
    </tr>
    <%
        List<Product> products = (List<Product>) request.getSession().getAttribute("products");
        for(Product product : products){
    %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getQuantity()%></td>
        <td><button>Add to Cart</button></td>
        <%
            if (userRole.equals("admin")){
        %>
        <td><a href=<%="\"/editProduct.jsp?Index=" + product.getId() + "\""%>><button>Edytuj</button></a></td>
        <td><a href=<%="\"/Remove?Index=" + product.getId() + "\""%>><button>Usun</button></a></td>
        <%}%>
    </tr>
    <%}%>
    <%
        if (userRole.equals("admin")){
    %>
    <tr>
        <td><a href="/addProduct.jsp"><button>Dodaj produkt</button></a></td>
    </tr>
    <%}%>
</table>


</body>
</html>
