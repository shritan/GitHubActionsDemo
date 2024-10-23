package com.test.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestReadFile {

    final static String filePath = "C:\\Users\\Mohan Rao\\relesecode_ws\\TestProject\\src\\main\\resources\\testFile.txt";

    public static void main(final String[] args) {
        // path
        try {
            final Path path = Paths.get(filePath);
            final List<String> lines = Files.readAllLines(path); // Read all lines from the file

            final Map<String, Long> map = lines.stream().collect(Collectors.groupingBy(t -> t, Collectors.counting()));
            System.out.println(map);

            final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6, 7, 7);

            // Using Collectors.groupingBy to group elements by their occurrences
            final Map<Integer, Long> occurrences = numbers.stream()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));

            System.out.println(occurrences);
            readFile();
        } catch (final IOException e) {
            e.printStackTrace();
        }

    }

    public static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            final Map<String, Long> wordOccurrences = reader.lines()
                .flatMap(line -> Arrays.stream(line.split("\\s+"))) // Split by whitespace
                // .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase()) // Remove
                // non-alphabetic
                // characters and
                // convert to lowercase
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

            /*
             * final List<String> repeatedWords = wordOccurrences.entrySet().stream() .filter(entry
             * -> entry.getValue() > 1) .map(Map.Entry::getKey) .collect(Collectors.toList());
             */

            System.out.println("Repeated words: " + wordOccurrences);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
