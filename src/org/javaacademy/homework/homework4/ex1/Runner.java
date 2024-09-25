package org.javaacademy.homework.homework4.ex1;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Runner {
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
        AtomicInteger number = new AtomicInteger(0);
        List<Car> carListOne = Stream.generate(() -> number.addAndGet(1))
                .limit(50)
                .map(e -> new Car(e < 10 ? "a00" + e + "ан799" : "a0" + e + "ан799"))
                .toList();

        number.set(0);
        List<Car> carListTwo = Stream.generate(() -> number.addAndGet(1))
                .limit(50)
                .map(e -> new Car(e < 10 ? "a00" + e + "се178" : "a0" + e + "се178"))
                .toList();

        Stream<Car> streamCarFull = Stream.concat(carListOne.stream(), carListTwo.stream());

        streamCarFull
                .filter(e -> {
                    int result = Integer.parseInt(e.getNumber().substring(2, 4));
                    return result > 39 && result < 50;
                })
                .map(Car::getNumber)
                .forEach(System.out::println);

//        streamCarFull.map(e -> e.getNumber().substring(2,4)).forEach(e-> System.out.println(e.toString()));

//        streamCarFull.forEach(e-> System.out.println(e.toString()));
    }
}
