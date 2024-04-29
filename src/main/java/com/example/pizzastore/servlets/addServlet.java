package com.example.pizzastore.servlets;

import com.example.pizzastore.dao.DbConnection;
import com.example.pizzastore.dao.PizzaService;
import com.example.pizzastore.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@WebServlet(name = "addServlet", value = "/add")
public class addServlet extends HttpServlet {

    private DbConnection service;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        List<Pizza> all = service.all();

        request.setAttribute("allPizzas", all);
        RequestDispatcher dispatcher = request
                .getServletContext()
                .getRequestDispatcher("/add.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            saveClient(req);
            addOrder(req);
            resp.setContentType("text/html");
            RequestDispatcher dispatcher = req
                    .getServletContext()
                    .getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
        }
        catch(Exception e) {
            doGet(req,resp);
        }
    }

    private void saveClient(HttpServletRequest req) {
        String client = req.getParameter("client");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Client newClient = new Client(client, phone, email, address);

        service.add(newClient);
    }
    private void addOrder(HttpServletRequest req) {

        Integer client_id = service.getClientIdByEmail(req.getParameter("email"));
        Integer pizza_id = Integer.valueOf(req.getParameter("pizzaId"));
        String size = req.getParameter("size");
        String topping = req.getParameter("topping");
        Double price = sizeFactor(size) * service.getPizzaCostById(pizza_id);
        Order order = new Order(client_id,pizza_id,size,topping,price);
        service.add(order);
    }


    private double sizeFactor (String size) {
        if (size.equals("S")) {
            return 1;
        }
        else if (size.equals("M")) {
            return 1.4;
        }
        else {
            return 1.8;
        }
    }
    private void idOrder(HttpServletRequest request) {

        int idGet = Integer.parseInt(request.getParameter("id"));
        Order idOrder = service.idOrder(idGet);
        request.setAttribute("idOrder", idOrder);
    }
    private void allOrders(HttpServletRequest request) {

        List<Order> allOrders = service.allOrders();

        request.setAttribute("allOrders", allOrders);
    }

    @Override
    public void init()  {
        service = new PizzaService();
    }

    @Override
    public void destroy() {
        service.close();
    }

}
