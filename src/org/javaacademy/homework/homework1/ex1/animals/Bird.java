package org.javaacademy.homework.homework1.ex1.animals;

public class Bird extends Animal {
    public void flies() {
        System.out.println("Птица - летает ");
    }

    @Override
    public String toString() {
        return "Bird";
    }
}
