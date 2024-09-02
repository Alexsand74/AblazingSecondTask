package org.javaacademy.homework.homework1.ex1.animals;

public class Tiger extends Animal {
    public void growls() {
        System.out.println("Тигр - рычит ");
    }

    @Override
    public String toString() {
        return "Tiger";
    }
}
