package com.iostreams;

import java.io.*;

public class ObjectIODemo {

    public static void main(String[] args) throws IOException {
        writeObjectInFile();
        //readObjectFromFile();
    }

    public static void writeObjectInFile() throws IOException {

        Product p1 = new Product("laptop",25.00);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/tmp/objectfile.txt"));
        objectOutputStream.writeObject(p1);




    }

    public static void readObjectFromFile()  {


        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("/tmp/objectfile.txt"));
            Product p2 = null;
            p2 = (Product) objectInputStream.readObject();
            System.out.println(p2);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }
}
