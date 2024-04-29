<%@ page import="com.example.pizzastore.model.Order" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
</head>
<body>
<div class="container">
  <div class="modal">


    <% Order order = (Order) request.getAttribute("idOder");%>

    <table class="responseTable" align="center">
      <thead>
      <tr>

        <th class="cell">Размер пиццы</th>
        <th class="cell">Топпинг</th>
        <th class="cell">Цена</th>
      </tr>

      </thead>
      <tbody>
      <%if (order != null) {%>
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
