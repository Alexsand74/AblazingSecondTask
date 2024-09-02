package org.javaacademy.homework.homework1.ex1;

import org.javaacademy.homework.homework1.ex1.animals.Animal;
import org.javaacademy.homework.homework1.ex1.animals.Bird;
import org.javaacademy.homework.homework1.ex1.animals.Dog;
import org.javaacademy.homework.homework1.ex1.animals.Tiger;

import java.util.ArrayList;
import java.util.List;


public class RunnerEx1 {
    //Задание №1 Зоопарк
    //1. Создать три вида животных: Тигр - умеет рычать, Собака - умеет лаять, Птица - умеет летать.
    //Общий родитель - животное (никаких атрибутов и методов в нем нет).
    //2. Создать зоопарк, который может хранить в себе 3 животных любого типа.
    //Т.е. могут быть следующие зоопарки:
    // Зоопарк в котором Тигр, Тигр, Птица
    // Зоопарк в котором Собака, Собака, Собака
    // Зоопарк в котором Птица, Птица, Тигр.
    //3. Сделать геттеры на всех животных.
    //Сделать так, чтобы при получении животного, мы могли воспользоваться специфичным для него действием.
    //Т.е. создали зоопарк Тигр, Собака, Птица (положили в этот зоопарк животных  при создании).
    //Получили первое животное (тигра) - вызвали у него рык
    //Получили второе животное (собака) - вызвали у него лай
    //Получили первое животное (птица) - вызвали у него полет
    //Запрещено пользоваться instanceOf.

    public static void start() {
        Zoo<Tiger, Tiger, Bird> zoo1 = new Zoo<>(new Tiger(), new Tiger(), new Bird());
        Zoo<Dog, Dog, Dog> zoo2 = new Zoo<>(new Dog(), new Dog(), new Dog());
        Zoo<Bird, Bird, Tiger> zoo3 = new Zoo<>(new Bird(), new Bird(), new Tiger());

        Tiger tiger = zoo1.getFirstAnimal();
        tiger.growls();
        Dog dog = zoo2.getThirdAnimal();
        dog.barks();
        Bird bird = zoo3.getSecondAnimal();
        bird.flies();

    }
}
