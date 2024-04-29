package com.example.pizzastore.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
private Integer id;
private Integer client_id;
private Integer pizza_id;
private String size;
private String topping;
private Double price;

    public Order(Integer client_id, Integer pizza_id, String size, String topping, Double price) {
        this.client_id = client_id;
        this.pizza_id = pizza_id;
        this.size = size;
        this.topping = topping;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(Integer pizza_id) {
        this.pizza_id = pizza_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.client_id = resultSet.getInt("client_id");
            this.pizza_id = resultSet.getInt("pizza_id");
            this.size = resultSet.getString("size");
            this.topping = resultSet.getString("topping");
            this.price = resultSet.getDouble("price");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client_id=" + client_id +
                ", pizzas_id=" + pizza_id +
                ", size='" + size + '\'' +
                ", topping='" + topping + '\'' +
                ", price=" + price +
                '}';
    }
}
