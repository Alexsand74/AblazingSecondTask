package org.javaacademy.homework.homework3;

import org.javaacademy.homework.homework3.ex1.Apple;
import org.javaacademy.homework.homework3.ex1.Apricot;
import org.javaacademy.homework.homework3.ex1.Garden;
import org.javaacademy.homework.homework3.ex2.Divination;
import org.javaacademy.homework.homework3.ex2.Human;
import org.javaacademy.homework.homework3.ex3.Burning;
import org.javaacademy.homework.homework3.ex3.Uranium;
import org.javaacademy.homework.homework3.ex3.Wood;
import org.javaacademy.homework.homework3.ex4.Animal;
import org.javaacademy.homework.homework3.ex4.Boat;
import org.javaacademy.homework.homework3.ex4.Ruler;
import org.javaacademy.homework.homework3.ex5.Review;

import java.time.LocalDateTime;
import java.util.*;

public class Runner {
    private static final int AGE_AND_HEIGHT_MEANING_210 = 210;
    private static final int PARITY_DIVIDER = 2;

    public static void main(String[] args) {
        //Задание №1: Сад
        //Создать два класса, которые являются фруктами (намек на еще один класс): яблоко, абрикос.
        //(Без полей и методов).
        //Создать функциональный интерфейс сад, который умеет выращивать ФРУКТ и всех наследников фрукта.
        //Метод ничего не принимает.
        //Создать с помощью лямбд выражений 2 фермы: яблочная, абрикосовая.
        //Яблочная ферма должна отдавать яблоко(не фрукт!), абрикосовая - абрикос(не фрукт!).

        {
            Garden<Apple> appleFarm = () -> new Apple();
            Garden<Apricot> apricotFarm = () -> new Apricot();
            Apple apple = appleFarm.growing();
            Apricot apricot = apricotFarm.growing();
            System.out.println(apple);
            System.out.println(apricot);
            System.out.println("____________________________________________");
        }

        //Задание №2: Поиск пары с помощью гадания
        //Создать функциональный интерфейс гадание, который на вход принимает аргумент любого типа,
        //на выход возвращает да/нет.
        //Создать с помощью лямбд выражений:
        //ромашку: принимает имя, возвращает да если в имени четное кол-во букв, нет если нечетное
        //бабку гадалку: принимает Человека(возраст, рост),
        //возвращает да - если (возраст + рост) больше 210, нет - если меньше или равно

        {
            Divination<String> chamomile = (String name) -> name.length() % PARITY_DIVIDER == 0;
            Divination<Human> fortuneTellerGranny = (Human human) ->
                    (human.getAge() + human.getHeight()) > AGE_AND_HEIGHT_MEANING_210;
            String name1 = "Владимир";
            String name2 = "Николай";
            System.out.printf("Имя %s имеет четное количество букв = %s \n", name1,
                    chamomile.fortuneTelling(name1) ? "да" : "нет");
            System.out.printf("Имя %s имеет четное количество букв = %s \n", name2,
                    chamomile.fortuneTelling(name2) ? "да" : "нет");
            Human human1 = new Human(174, 40);
            Human human2 = new Human(172, 20);
            System.out.printf("Возраст и рост больше %d - %s \n", AGE_AND_HEIGHT_MEANING_210,
                    fortuneTellerGranny.fortuneTelling(human1) ? "да" : "нет");
            System.out.printf("Возраст и рост больше %d - %s \n", AGE_AND_HEIGHT_MEANING_210,
                    fortuneTellerGranny.fortuneTelling(human2) ? "да" : "нет");
            System.out.println("____________________________________________");
        }

        //Задание №3: Гори ясно!
        //Создать функциональный интерфейс сжигание, ничего не возвращает, принимает аргумент
        //любого типа.
        //Создать класс уран (без атрибутов и методов)
        //Создать класс дерево (без атрибутов и методов)
        //Создать с помощью лямбд выражений:
        //атомный реактор: принимает в себя уран, печатает на экран: зеленый свет вокруг!
        //костер: принимает в себя дерево, печатает на экран: желто-красный свет вокруг!

        {
            Burning<Uranium> nuclearReactor = (Uranium uranium) -> System.out.println("зеленый свет вокруг!");
            Burning<Wood> bonfire = (Wood wood) -> System.out.println("желто-красный свет вокруг!");
            Uranium uranium = new Uranium();
            nuclearReactor.glow(uranium);
            Wood wood = new Wood();
            bonfire.glow(wood);
            System.out.println("____________________________________________");
        }

        //Задание №4: универсальная линейка
        //Создать функциональный интерфейс линейка: принимает в себя любой тип, возвращает Integer
        //Создать класс животное (длина тела, длина хвоста)
        //Создать класс лодка(длина)
        //Создать с помощью лямбд выражений:
        //Измеритель лодок: на вход лодка, возвращает длину лодки
        //Измеритель животных: на вход животное, возвращает сумму длин тела и хвоста

        {
            Ruler<Boat> boatMeasurer = (Boat boat) -> boat.getLength();
            Ruler<Animal> animalMeasurer = (Animal animal) -> animal.getBodyLength() + animal.getTailLength();
            Boat boat = new Boat(20_000);
            System.out.printf("Длинна лодки = %d \n", boatMeasurer.measuringLength(boat));
            Animal animal = new Animal(235, 80);
            System.out.printf("Длинна животного = %d \n", animalMeasurer.measuringLength(animal));
            System.out.println("____________________________________________");
        }

        //Задание №5: сортировка отзывов
        //Создать класс отзыв с полями: id отзыва, текст отзыва, количество лайков,
        // дата + время отзыва (LocalDateTime)  - НЕ ИСПОЛЬЗОВАТЬ COMPARABLE!
        //Создать коллекцию, которая хранит отсортированные отзывы по:
        // 1.лайкам
        // 2.(Если лайки совпадают) дата + время отзыва
        // 3.(Если лайки и дата + время отзыва совпадают) id

        //Уникальность определяется на основе сортировки.
        //Создать comparator через лямбда выражение, для сортировки отзывов:

        //Пример, отсортированный :
        //        (id, текст, кол-во лайков, дата+время)
        //отзыв №1: 1, отличный товар, 200, 25.01.2024 13:37
        //отзыв №2: 2, так себе товар, 100, 25.01.2024 16:37
        //отзыв №4: 4, плохой товар, 100, 25.01.2024 13:37
        //отзыв №3: 3, плохой товар, 100, 25.01.2024 13:37

        {
            Comparator<Review> byLikes = (el1, el2) -> el1.getNumberLikes() - el2.getNumberLikes();
            Comparator<Review> byLocalDateTime = (el1, el2) ->
                                          el1.getLocalDateTime().compareTo(el2.getLocalDateTime());
            Comparator<Review> byId = (el1, el2) -> el1.getId() - el2.getId();

            Comparator<Review> comparatorFull = byLikes.thenComparing(byLocalDateTime).thenComparing(byId);

            Review review1 = new Review(1, "отличный товар", 200,
                    LocalDateTime.of(2024, 01, 25, 13, 37));
            Review review2 = new Review(2, "так себе товар", 100,
                    LocalDateTime.of(2024, 01, 25, 16, 37));
            Review review4 = new Review(4, "плохой товар", 100,
                    LocalDateTime.of(2024, 01, 25, 13, 37));
            Review review3 = new Review(3, "плохой товар", 10,
                    LocalDateTime.of(2024, 01, 25, 13, 37));


            Set<Review> feedbacks = new TreeSet<>(comparatorFull);
            feedbacks.add(review1);
            feedbacks.add(review2);
            feedbacks.add(review4);
            feedbacks.add(review3);
            feedbacks.stream().forEach((feedback) -> System.out.println(feedback));
            System.out.println("____________________________________________");

            LinkedList<Review> linkedListReview = new LinkedList<>();
            linkedListReview.add(review1);
            linkedListReview.add(review2);
            linkedListReview.add(review4);
            linkedListReview.add(review3);

            Collections.sort(linkedListReview, comparatorFull);
            linkedListReview.stream().forEach((feedback) -> System.out.println(feedback));


        }
    }
}
