package com.example.pizzastore.dao;

import com.example.pizzastore.model.Client;
import com.example.pizzastore.model.Order;
import com.example.pizzastore.model.Pizza;

import java.util.List;

    public interface DbConnection {
        List<Pizza> all();
        List<Client> allClients();
        Integer getPizzaCostById(Integer id);
        Integer getClientIdByEmail(String email);
        Pizza add (Pizza pizza);
        Client add (Client client);
        Order add (Order order);
        Order idOrder(Integer id);
        List<Order> allOrders();
        void close();

    }

