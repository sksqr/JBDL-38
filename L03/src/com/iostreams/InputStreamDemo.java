package com.iostreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class InputStreamDemo {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("/tmp/textData.txt");

        Scanner scanner = new Scanner(fileInputStream);
        String data = scanner.nextLine();
        System.out.println(data);

//        while (fileInputStream.available()>0){
//            System.out.print((char)fileInputStream.read());
//        }
        fileInputStream.close();

    }
}
