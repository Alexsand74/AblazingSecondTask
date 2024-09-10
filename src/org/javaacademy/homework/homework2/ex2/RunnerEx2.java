package org.javaacademy.homework.homework2.ex2;

import org.javaacademy.homework.homework1.Runner;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RunnerEx2 {
    private static final Integer HEAVY_CATEGORY = 10;
    private static final Integer MEDIUM_CATEGORY = 5;
    private static final int QUANTITY_CATEGORIES = 3;
    private static final int LIGHT = 0;
    private static final int MEDIUM = 1;
    private static final int HEAVY = 2;
    private static final Integer ZERO = 0;

    public static void start2() {
        ArrayList<Integer> arrayListCategory = sumSuitcaseWeightsCategory("luggage.csv");
        String word = "категория чемодана";
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(word + " легкий - " + arrayListCategory.get(LIGHT));
        arrayList.add(word + " средний - " + arrayListCategory.get(MEDIUM));
        arrayList.add(word + " тяжелый - " + arrayListCategory.get(HEAVY));
        for (String line : arrayList) {
            System.out.println(line);
        }
    }

    public static ArrayList<Integer> sumSuitcaseWeightsCategory(String fileName) {
        ArrayList<Integer> arrayListCategory = new ArrayList<>();
        for (int i = 0; i < QUANTITY_CATEGORIES; i++) {
            arrayListCategory.add(ZERO);
        }
        Integer weightCurrentSuitcase;
        try (Scanner scanner = new Scanner(Objects.requireNonNull(Runner.class.getClassLoader()
                                                               .getResourceAsStream(fileName)))
        ) {
            String line;
            scanner.nextLine();
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] array = line.split(";");
                try {
                    weightCurrentSuitcase = Integer.valueOf(array[1]);
                } catch (NumberFormatException e) {
                    continue;
                }
                if (weightCurrentSuitcase > HEAVY_CATEGORY) {
                    arrayListCategory.set(HEAVY, arrayListCategory.get(HEAVY) + weightCurrentSuitcase);
                } else if (weightCurrentSuitcase > MEDIUM_CATEGORY) {
                    arrayListCategory.set(MEDIUM, arrayListCategory.get(MEDIUM) + weightCurrentSuitcase);
                } else {
                    arrayListCategory.set(LIGHT, arrayListCategory.get(LIGHT) + weightCurrentSuitcase);
                }
            }
            return arrayListCategory;
        }
    }
}
