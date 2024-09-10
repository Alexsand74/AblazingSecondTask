package org.javaacademy.homework.homework2.ex1;

import org.javaacademy.homework.homework1.Runner;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class RunnerEx1 {
    private static final int QUANTITY_ON_TAPE = 10;

    public static void start1() throws IOException {
        String filename = "luggage.csv";
        LinkedList<String> list = new LinkedList<>();
        try (Scanner scanner = new Scanner(Objects.requireNonNull(Runner.class
                .getClassLoader()
                .getResourceAsStream(filename)))
        ) {
            String line;
            scanner.nextLine();
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] array = line.split(";");
                list.add(array[0]);
            }
        }
        int counter = 0;
        while (!list.isEmpty()) {
            System.out.println("Лента загружена, начинается выдача багажа");
            for (int i = 0; i < QUANTITY_ON_TAPE; i++) {
                counter++;
                System.out.println(counter + " - " + list.poll() + " выдан");
            }
            System.out.println("Лента пустая, закончена выдача багажа");
        }
    }
}
