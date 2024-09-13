package org.javaacademy.homework.homework2.ex1;

import org.javaacademy.homework.homework1.Runner;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class RunnerEx1 {

    private static LinkedList<String> listLinesFile = new LinkedList<>();

    private static final int FIRST_COLUMN_INDEX = 0;
    private static final int INDEX_SECOND_COLUMN = 1;
    private static final int QUANTITY_ON_TAPE = 10;
    private static int counter = 0;

    public static void startTask1() throws IOException, InterruptedException {
        String filename = "luggage.csv";
        LinkedList<String> list = new LinkedList<>();
        do {
            list.addAll(deliveringBaggageInBatches(filename, counter));
            int numberCycles = list.size();
            System.out.println("Лента загружена, начинается выдача багажа");
            for (int i = 0; i < numberCycles; i++) {
                System.out.println((1 + counter) + " - " + list.poll() + " выдан");
                counter++;
            }
            System.out.println("Лента пустая, закончена выдача багажа");

            Thread.sleep(2000);

        } while (counter < listLinesFile.size());
    }

    private static LinkedList<String> deliveringBaggageInBatches(String fileName, int numberPreviouslyReadLines) {
        if(numberPreviouslyReadLines == 0) {
            try (Scanner scanner = new Scanner(Objects.requireNonNull(Runner.class
                    .getClassLoader()
                    .getResourceAsStream(fileName)))
            ) {
                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String[] array = line.split(";");
                    try {
                        Integer.valueOf(array[INDEX_SECOND_COLUMN]);
                    } catch (NumberFormatException e) {
                        continue;
                    }
                    listLinesFile.add(array[FIRST_COLUMN_INDEX]);
                }
            }
        }
        LinkedList<String> result = new LinkedList<>();
        for (int i = numberPreviouslyReadLines;
               i < (QUANTITY_ON_TAPE + numberPreviouslyReadLines)
                                          && i < listLinesFile.size(); i++) {
            result.add(listLinesFile.get(i));
        }
        return result;
    }
}
