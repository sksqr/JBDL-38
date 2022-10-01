package com.iostreams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductListDemo {

    public static void main(String[] args) throws IOException {
//        writeObjectInFile();
        readObjectFromFile();
    }



    public static void writeObjectInFile() throws IOException {


        List<Product> list = new ArrayList<>();
        Product p1 = new Product("Laptop",100.00);
        list.add(p1);
        Product p2 = new Product("Mobile",50.00);
        list.add(p2);
        Product p3 = new Product("Charger",20.00);
        list.add(p3);
        ProductList productList = new ProductList(list);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/tmp/objectfile.txt"));
        objectOutputStream.writeObject(productList);



    }

    public static void readObjectFromFile() {

        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("/tmp/objectfile.txt"));
            ProductList productList = null;
            productList = (ProductList) objectInputStream.readObject();
            System.out.println(productList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
