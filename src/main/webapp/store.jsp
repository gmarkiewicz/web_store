<%@ page import="com.markiewiczgrzegorz.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Store</title>
</head>
<body>
<%
    String userName = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null){
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("login")){
                userName = cookie.getValue();

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
        <td>LP</td>
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
            String userRole = (String) request.getSession().getAttribute("userRole");
            if (userRole.equals("admin")){
        %>
        <td><button>Edit</button></td>
        <td><button>Remove</button></td>
        <%}%>
    </tr>
    <%}%>
</table>


</body>
</html>
