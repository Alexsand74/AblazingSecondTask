package org.javaacademy.homework.homework1.ex3;

import java.util.ArrayList;
import java.util.List;

public class RunnerEx3 {
    public static void start() {
        //Задание №3 Ресторанный гуру
        //Николай Петрович ходит по ресторанам. За 5 дней он был во множестве ресторанов.
        //Он обратился к вам, чтобы узнать в каком ресторане(ах) он был каждый день
        // (т.е. найти ресторан(ы) в которых он был и в понедельник, и во вторник, и в среду и тд).

        ArrayList<String> monday = new ArrayList<>(List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон", "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));

        ArrayList<String> everyDay = new ArrayList<>(monday);
        everyDay.retainAll(tuesday);
        everyDay.retainAll(wednesday);
        everyDay.retainAll(thursday);
        everyDay.retainAll(friday);
        System.out.println(everyDay);
    }
}
