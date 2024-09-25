package org.javaacademy.homework.homework4.ex1;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Runner {
    static final private int DEFAULT_VALUE_IS_ZERO = 0;
    static final private int ELEMENT_NUMBER_LIMIT = 50;
    static final private int MINIMUM_VALUE = 39;
    static final private int MAXIMUM_VALUE = 50;

    public static void main(String[] args) {
        //ИСПОЛЬЗОВАНИЕ FOR, WHILE ЗАПРЕЩЕНО В ЭТОЙ ДЗ! Только СТРИМЫ.

        //Задание №1 - Список спец номеров
        //Нам необходимо распечатать список номеров, которые принадлежат чиновникам
        //1. Создать класс машина. У машины есть номер.
        //2. Создать 50 машин с номерами а0[01-50]ан799 (где [01-50] - это все значения от 01 до 50)
        //3. Создать 50 машин с номерами к0[01-50]се178 (где [01-50] - это все значения от 01 до 50)
        //4. Объединить машины в единый стрим
        //5. Оставить в объединенном стриме машины с номерами 04[0-9] - это номера, выдаваемые чиновникам
        //6. Получить из оставшихся машин номера.
        //7. Распечатать номера.
        //ожидаемый результат:
        // a040ан799
        // a041ан799
        // ...
        // k048се178
        // k049се178

        AtomicInteger number = new AtomicInteger(DEFAULT_VALUE_IS_ZERO);
        List<Car> carListOne = Stream.generate(() -> number.addAndGet(1))
                .limit(ELEMENT_NUMBER_LIMIT)
                .map(digit -> new Car(createNumberByDigit(digit, "a00ан799")))
                .toList();

        number.set(DEFAULT_VALUE_IS_ZERO);
        List<Car> carListTwo = Stream.generate(() -> number.addAndGet(1))
                .limit(ELEMENT_NUMBER_LIMIT)
                .map(digit -> new Car(createNumberByDigit(digit, "a00се178")))
                .toList();

        Stream<Car> streamCarFull = Stream.concat(carListOne.stream(), carListTwo.stream());

        streamCarFull
                .filter(car ->
                     cutOutNumber(car) > MINIMUM_VALUE && cutOutNumber(car) < MAXIMUM_VALUE)
                .map(Car::getNumber)
                .forEach(System.out::println);
    }

    private static String createNumberByDigit(int value, String word) {
        String lastPartWord = word.substring(3, 8);
        String firstPartWord = word.substring(0, 2);
        return value < 10 ? firstPartWord + 0 + value + lastPartWord
                           : firstPartWord + value + lastPartWord;
    }

    private static Integer cutOutNumber(Car car) {
        return Integer.parseInt(car
                .getNumber()
                .substring(2, 4));
    }
}
