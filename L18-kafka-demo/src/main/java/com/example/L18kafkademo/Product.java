package com.example.L18kafkademo;

import java.io.Serializable;

public class Product implements Serializable {

    private String name;
    private Double price;
    private String orderId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
