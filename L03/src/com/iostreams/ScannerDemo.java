package com.iostreams;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {

        System.out.println("Enter your name: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello! "+name);

    }
}
