package com.iostreams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {

        String data ="Hello शशिकांत";
        FileOutputStream fileOutputStream = new FileOutputStream("/tmp/textData.txt",true);
        fileOutputStream.write(data.getBytes());
        fileOutputStream.close();
    }
}
