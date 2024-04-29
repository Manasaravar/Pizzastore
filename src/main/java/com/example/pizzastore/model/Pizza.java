package com.example.pizzastore.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pizza {

    private Integer id;
    private String name;

//    @Override
//    public String toString() {
//        return "Pizza{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", cost=" + cost +
//                '}';
//    }

    private Integer cost;

    public Pizza(Integer id, String name, Integer cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }
    public Pizza (ResultSet resultSet) {
        try {
            this.id = resultSet.getInt("id");
            this.name = resultSet.getString("name");
            this.cost = resultSet.getInt("cost");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
