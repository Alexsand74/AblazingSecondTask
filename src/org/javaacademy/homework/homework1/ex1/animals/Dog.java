package org.javaacademy.homework.homework1.ex1.animals;

public class Dog extends Animal {
    public void barks() {
        System.out.println("Собака - лает");
    }

    @Override
    public String toString() {
        return "Dog";
    }
}
