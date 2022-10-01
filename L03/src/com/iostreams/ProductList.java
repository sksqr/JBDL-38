package com.iostreams;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductList implements Serializable {

    private static final long serialVersionUID = -68497940754667710L;

    private List<Product> productList;

    public ProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        for(Product product: productList){
            String data = product.getName()+","+product.getPrice()+"\n";
            out.write(data.getBytes());
        }
    }

    private void readObject(ObjectInputStream in)   throws IOException, ClassNotFoundException{
        Scanner scanner = new Scanner(in);
        while (scanner.hasNext()){
            String data = scanner.nextLine();
            System.out.println(data);
            String[] arr=data.split(",");
            String name = arr[0];
            Double price = Double.valueOf(arr[1]);
            Product product = new Product(name,price);
            if(productList == null){
                productList = new ArrayList<>();
            }
            productList.add(product);
        }
    }


    @Override
    public String toString() {
        return "ProductList{" +
                "productList=" + productList +
                '}';
    }
}
