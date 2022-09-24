package com.iostreams;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = -68497940754667710L;

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';

    }

//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.write(this.toString().getBytes());
//    }

//    private void readObject(ObjectInputStream in)   throws IOException, ClassNotFoundException{
//
//    }


}

