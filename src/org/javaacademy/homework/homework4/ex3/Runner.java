package org.javaacademy.homework.homework4.ex3;

import java.util.Comparator;
import java.util.List;

public class Runner {
    static final private int HEIGHT_ONE_KILOMETER = 1000;
    static final private String DEFAULT_STRING = "Небоскребов выше километра - нет.";

    public static void main(String[] args) {
        //Задание №3 - Небоскребы, небоскребы, а я...
        //1. Создать Класс Небоскреб - имя небоскреба, его высота в метрах.
        //2. Необходимо создать небоскребы:
        //Всемирный торговый центр - 541м
        //Шанхайская башня - 632м
        //Бурдж-Халифа - 828м
        //Международный финансовый центр Пинань - 599м
        //Абрадж аль-Бейт - 601м
        //Всемирный центр Лотте - 555м

        //3. Занести небоскребы в List! Дважды положить бурдж халифа в лист.

        //4. С помощью стримов:
        //4.1 Убрать дубликаты и сохранить в новый лист (далее работаем с этим листом).
        //(РАЗНЫЕ СТРИМЫ!)
        //4.2. Вывести только первые три небоскреба.
        //4.3. Вывести самый высокий небоскреб.
        //4.4. Вывести те небоскребы, которые выше километра.
        //Если выше километра нет, то вывести на экран: небоскреба выше километра - нет.

        List<Skyscraper> listSkyscraper = List.of(new Skyscraper("Всемирный торговый центр", 541),
                                        new Skyscraper("Шанхайская башня", 632),
                                        new Skyscraper("Бурдж-Халифа", 828),
                                        new Skyscraper("Международный финансовый центр Пинань", 599),
                                        new Skyscraper("Абрадж аль-Бейт", 601),
                                        new Skyscraper("Всемирный центр Лотте", 555),
                                        new Skyscraper("Бурдж-Халифа", 828));

        System.out.println("4.1_____________________________________________");
        List<Skyscraper> listSkyscraperNoDuplicates = listSkyscraper.stream().distinct().toList();
        listSkyscraperNoDuplicates.forEach(System.out::println);

        System.out.println("4.2_____________________________________________");
        listSkyscraperNoDuplicates.stream().limit(3).forEach(System.out::println);

        System.out.println("4.3_____________________________________________");
        System.out.println(listSkyscraperNoDuplicates.stream()
                           .max(Comparator.comparingInt(Skyscraper::getHeight))
                           .get());

        System.out.println("4.4_____________________________________________");
//        подсказка от Юрия:
//        вам нужно отфильтровать элементы -> произвести их печать -> вытащить первый элемент ,
//        если его нет то распечатать "небоскребов нет",
//        если он есть ничего не делать (метод ifPresentOrElse у optional).
        listSkyscraperNoDuplicates.stream()
                .filter(e -> e.getHeight() > HEIGHT_ONE_KILOMETER)
                .findAny()
                .ifPresentOrElse(
                        e -> listSkyscraperNoDuplicates.stream()
                                .filter(el -> el.getHeight() > HEIGHT_ONE_KILOMETER)
                                .forEach(System.out::println),
                        () -> System.out.println(DEFAULT_STRING)
            );
    }
}
