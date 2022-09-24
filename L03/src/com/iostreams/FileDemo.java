package com.iostreams;

import java.io.File;

public class FileDemo {

    public static void main(String[] args) {

        File file = new File("/tmp/test.txt");

        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.exists());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());

    }

}
