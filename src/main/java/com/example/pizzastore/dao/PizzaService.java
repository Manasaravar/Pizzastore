package com.example.pizzastore.dao;


import com.example.pizzastore.model.Client;
import com.example.pizzastore.model.Order;
import com.example.pizzastore.model.Pizza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaService implements DbConnection {
    Connection connection;
    // <тип драйвера>:<тип БД>://<хост>:<порт>/<название БД>
    private final String DB_URL = "jdbc:postgresql://localhost:5432/dz";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "Sk3295318";
    private final String DB_DRIVER = "org.postgresql.Driver";

    public PizzaService() {
        try {
            // инициализация  драйвера БД
            Class.forName(DB_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection not impassible");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not connect");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Pizza> all() {
        String query = "SELECT * FROM pizzas";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Pizza> result = getALLFromResultSet(resultSet);
            result.forEach(System.out::println);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Client> allClients() {
        String query = "SELECT * FROM clients";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Client> result = getALLFromResultSetClients(resultSet);
            result.forEach(System.out::println);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pizza add(Pizza pizza) {
        String query = "INSERT INTO pizzas (name, cost) VALUES ('"
                .concat(pizza.getName())
                .concat("', ")
                .concat(String.valueOf(pizza.getCost()))
                .concat(");");
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            return pizza;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Client add(Client client) {
        String query = "INSERT INTO clients (client, phone, email, address) VALUES ('"
                .concat(client.getClient())
                .concat("', '")
                .concat(client.getPhone())
                .concat("', '")
                .concat(client.getEmail())
                .concat("', '")
                .concat(client.getAddress())
                .concat("');");
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            return client;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Pizza> getALLFromResultSet(ResultSet resultSet) throws SQLException {
        List<Pizza> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Pizza(resultSet));
        }
        return result;
    }
    private List<Client> getALLFromResultSetClients(ResultSet resultSet) throws SQLException {
        List<Client> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Client(resultSet));
        }
        return result;
    }
    @Override
    public Integer getClientIdByEmail(String email) {
        String query = String.format("SELECT id FROM clients WHERE (email = '%s');", email);
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Integer getPizzaCostById(Integer id) {
        String query = String.format("SELECT cost FROM pizzas WHERE (id = '%d');", id);
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            resultSet.next();
            return resultSet.getInt("cost");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getPizzaNameById(Integer id) {
        String query = String.format("SELECT name FROM pizzas WHERE (id = '%d');", id);
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            resultSet.next();
            return resultSet.getString("name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order idOrder(Integer id) {
        String query = ("SELECT * FROM orders WHERE ID = " + id);
        Statement statement;

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            Order result = new Order(resultSet);
            System.out.println(result);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order add (Order order){
        String query =
                "INSERT INTO orders (client_id, pizza_id, size, topping, price) VALUES ("
                .concat(String.valueOf(order.getClient_id()))
                .concat(", ")
                .concat(String.valueOf(order.getPizza_id()))
                .concat(", '")
                .concat(order.getSize())
                .concat("', '")
                .concat(order.getTopping())
                .concat("', ")
                .concat(String.valueOf(order.getPrice()))
                .concat(");");
                Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private List<Order> getALLFromResultSetOrders(ResultSet resultSet) {
        List<Order> result = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            result.add(new Order(resultSet));
        }
        return result;
    }

    @Override
    public List<Order> allOrders() {
        String query = "SELECT * FROM orders";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Order> result = getALLFromResultSetOrders(resultSet);
            result.forEach(System.out::println);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

