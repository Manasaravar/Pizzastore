<%@ page import="com.example.pizzastore.model.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 29.04.2024
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<div class="container">
  <div class="modal">


    <% List<Order> orders = (List<Order>) request.getAttribute("allOrders");%>

    <table class="responseTable" align="center">
      <thead>
      <tr>

        <th class="cell">Размер пиццы</th>
        <th class="cell">Топпинг</th>
        <th class="cell">Цена</th>
      </tr>

      </thead>
      <tbody>
      <h1> Заказы </h1>

            <%for  (Order order:orders) {%>
      <tr>
        <td class="cell"><%=order.getSize()%></td>
        <td class="cell"><%=order.getTopping()%></td>
        <td class="cell"><%=order.getPrice()%></td>
      </tr>
      <%}%>
      </tbody>
    </table>
  </div>
</div>
</body>
</html>
