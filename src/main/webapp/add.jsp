<%@ page import="com.example.pizzastore.model.Pizza" %>
<%@ page import="java.util.List" %>
  Created by IntelliJ IDEA.
  User: User
  Date: 15.04.2024
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Add new Order</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">

</head>

<body>
<div>
    <h1>Pizza Store</h1>
</div>

<div>

    <div>
        <div>
            <h2>Выберите пиццу</h2>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/add">
            <select name="pizzaId" class="select-css">
                <%List<Pizza> allPizzas = (List<Pizza>) request.getAttribute("allPizzas"); %>
                <%for (Pizza allPizza : allPizzas) {%>
                <option value="<%=allPizza.getId()%>"><%=allPizza.getName()%>
                </option>
                <%}%>
            </select>
            <h2>Выберите размер:</h2>
            <select name="size" class="select-css">
                <option value="S">Small</option>
                <option value="M">Medium</option>
                <option value="L">Large</option>
            </select>
            <br/>
            <h2>Введите данные для доставки:</h2>
            <div class="form-style-8">
                <label>Топпинги:
                    <input type="text" name="topping"><br/>
                </label>
                <label>Имя клиента:
                    <input type="text" name="client"><br/>
                </label>
                <label>Телефон:
                    <input type="text" name="phone"><br/>
                </label>
                <label>Email:
                    <input type="email" name="email"><br/>
                </label>
                <label>Адрес доставки:
                    <input type="text" name="address"><br/>
                </label>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/allOrders'">Детали заказа</button>
</div>

</body>
</html>
