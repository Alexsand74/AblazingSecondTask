package org.javaacademy.homework.homework2.ex2;

import org.javaacademy.homework.homework1.Runner;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RunnerEx2 {
    private static final Integer HEAVY_CATEGORY = 10;
    private static final Integer MEDIUM_CATEGORY = 5;
    private static final Integer ZERO = 0;

    public static void start2() {
        ArrayList<String> arrayListCategory = sumSuitcaseWeightsCategory("luggage.csv");
        for (String line : arrayListCategory) {
            System.out.println(line);
        }
    }

    public static ArrayList<String> sumSuitcaseWeightsCategory(String fileName) {
        Integer light = ZERO;
        Integer medium = ZERO;
        Integer heavy = ZERO;
        Integer weightCurrentSuitcase = ZERO;
        try (Scanner scanner = new Scanner(Objects.requireNonNull(Runner.class
                .getClassLoader()
                .getResourceAsStream(fileName)))
        ) {
            String line;
            scanner.nextLine();
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] array = line.split(";");
                weightCurrentSuitcase = Integer.valueOf(array[1]);
                if (weightCurrentSuitcase > HEAVY_CATEGORY) {
                    heavy += weightCurrentSuitcase;
                } else if (weightCurrentSuitcase > MEDIUM_CATEGORY) {
                    medium += weightCurrentSuitcase;
                } else {
                    light += weightCurrentSuitcase;
                }
            }
            String word = "категория чемодана";
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(word + " легкий - " + light);
            arrayList.add(word + " средний - " + medium);
            arrayList.add(word + " тяжелый - " + heavy);
            return arrayList;
        }
    }
}
