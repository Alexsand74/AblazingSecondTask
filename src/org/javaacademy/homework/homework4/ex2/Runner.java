package org.javaacademy.homework.homework4.ex2;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Runner {
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
        List<String> listWords = List.of("тон", "тополь", "боль", "рой", "стройка");
        Set<String> words = new HashSet<>();
        words.addAll(listWords);
        Integer sum = words.stream()
                .peek(e -> System.out.println(e))
                .map(word -> {
                    char[] charArray = word.toCharArray();
                    int result = 0;
                    for (char letter : charArray) {
                        if (letter == 'о') {
                            result++;
                        }
                    }
                    return Integer.valueOf(result);
                }).mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
    }
}
