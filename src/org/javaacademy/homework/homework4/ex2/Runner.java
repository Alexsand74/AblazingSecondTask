package org.javaacademy.homework.homework4.ex2;

import java.util.HashSet;
import java.util.Set;

public class Runner {
    static final private int DEFAULT_VALUE_IS_ZERO = 0;
    static final private char SEARCH_LETTER = 'о';

    public static void main(String[] args) {
        //Задание №2 - Сколько здесь "о" ?
        //1. Создать набор уникальных слов: "тон", "тополь", "боль", "рой", "стройка"
        //2. Создать стрим у набора
        //2.1 Посчитать количество букв "о" в одном слове
        //2.2 Посчитать сумму количества букв "о" во всех словах из набора
        //2.3 Вывести на экран сумму букв "о". Если в словах нет буквы "о", то распечатать ноль.
        //
        //ожидаемый результат:
        //6

        Set<String> setWords = Set.of("тон", "тополь", "боль", "рой", "стройка");
        Set<String> words = new HashSet<>(setWords);
        words.stream()
                .map(Runner::letterCounter)
                .reduce(Integer::sum)
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println(DEFAULT_VALUE_IS_ZERO));
    }

    private static Integer letterCounter(String word) {
        char[] charArray = word.toCharArray();
        int counter = DEFAULT_VALUE_IS_ZERO;
        for (char letter : charArray) {
            if (letter == SEARCH_LETTER) {
                counter++;
            }
        }
        return counter;
    }
}
