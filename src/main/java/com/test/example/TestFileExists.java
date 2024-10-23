package com.test.example;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFileExists {

    public static void main(final String[] args) {
        final String fileName = "qlaRequest.json";
        final Path path = Paths.get("c://opt//app//dotc//" + fileName);
        final File f = new File(path.toUri());
        if (!f.exists()) {
            System.out.println("is Exists");
        } else {
            final String dt = fileName.substring(0, fileName.length() - 5);
            System.out.println(dt);
        }
    }
}
