package org.javaacademy.homework.homework2.ex2;

import org.javaacademy.homework.homework1.Runner;

import java.util.*;

public class RunnerEx2 {
    private static final Integer HEAVY_CATEGORY = 10;
    private static final Integer MEDIUM_CATEGORY = 5;
    private static final String LIGHT = "LIGHT";
    private static final String MEDIUM = "MEDIUM";
    private static final String HEAVY = "HEAVY";
    private static final String FILE_NAME = "luggage.csv";
    private static final Integer ZERO = 0;
    private static final int GET_WEIGHT = 1;

    public static void start2()  {

        HashMap<String, Integer> hashMapCategory = new HashMap<>();
        hashMapCategory.put(HEAVY, ZERO);
        hashMapCategory.put(MEDIUM, ZERO);
        hashMapCategory.put(LIGHT, ZERO);

        HashMap<String, Integer> hashMap = sumOfSuitcasesWeightByCategory(FILE_NAME, hashMapCategory);
        String word = "категория чемодана";
        System.out.printf("%s легкий - %d  \n", word, hashMap.get(LIGHT));
        System.out.printf("%s средний - %d  \n", word, hashMap.get(MEDIUM));
        System.out.printf("%s тяжелый - %d  \n", word, hashMap.get(HEAVY));
    }

    private static HashMap<String, Integer> sumOfSuitcasesWeightByCategory(String fileName,
                                                              HashMap<String, Integer> hashMap) {
        if (hashMap.isEmpty()) {
            throw  new IllegalArgumentException("Error entering argument hashMap" + hashMap);
        }
        Integer weightCurrentSuitcase;
        try (Scanner scanner = new Scanner(Objects.requireNonNull(Runner.class.getClassLoader()
                                                                  .getResourceAsStream(fileName)))
        ) {
            String line;
            while (scanner.hasNext()) {
                line = scanner.nextLine();
                String[] array = line.split(";");
                try {
                    weightCurrentSuitcase = Integer.valueOf(array[GET_WEIGHT]);
                } catch (NumberFormatException e) {
                    continue;
                }
                if (weightCurrentSuitcase > HEAVY_CATEGORY) {
                    hashMap.put(HEAVY, hashMap.get(HEAVY) + weightCurrentSuitcase);
                } else if (weightCurrentSuitcase > MEDIUM_CATEGORY) {
                    hashMap.put(MEDIUM, hashMap.get(MEDIUM) + weightCurrentSuitcase);
                } else {
                    hashMap.put(LIGHT, hashMap.get(LIGHT) + weightCurrentSuitcase);
                }
            }
            return hashMap;
        }
    }
}
