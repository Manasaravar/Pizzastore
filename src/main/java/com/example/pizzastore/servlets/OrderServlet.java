package com.example.pizzastore.servlets;

import com.example.pizzastore.dao.DbConnection;
import com.example.pizzastore.dao.PizzaService;
import com.example.pizzastore.model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(value = "/allOrders")
public class OrderServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

            allOrders(request);

            RequestDispatcher rd = request.getRequestDispatcher("allOrders.jsp");
            rd.forward(request, response);


    }
    private void allOrders(HttpServletRequest request) {
        DbConnection service = new PizzaService();
        List<Order> allOrders = service.allOrders();
        service.close();
        request.setAttribute("allOrders", allOrders);
    }
}

