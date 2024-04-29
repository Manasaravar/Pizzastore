package com.example.pizzastore.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    private Integer id;
    private String client;
    private String phone;
    private String email;
    private String address;

    public Client(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt("id");
        this.client = resultSet.getString("client");
        this.phone = resultSet.getString("phone");
        this.email = resultSet.getString("email");
        this.address = resultSet.getString("address");
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Client(String client, String phone, String email, String address) {
       // this.id = id;
        this.client = client;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
