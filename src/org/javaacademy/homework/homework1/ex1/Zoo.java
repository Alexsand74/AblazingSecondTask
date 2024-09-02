package org.javaacademy.homework.homework1.ex1;

import org.javaacademy.homework.homework1.ex1.animals.Animal;

public class Zoo<T extends Animal>  {
    private final T firstAnimal;
    private final T secondAnimal;
    private final T thirdAnimal;

    public Zoo(T firstAnimal, T secondAnimal, T thirdAnimal) {
        this.firstAnimal = firstAnimal;
        this.secondAnimal = secondAnimal;
        this.thirdAnimal = thirdAnimal;
    }

    public <T> T getFirstAnimal()  {
        return (T) firstAnimal;
    }

    public <T> T getSecondAnimal() {
        return (T) secondAnimal;
    }

    public <T> T getThirdAnimal() {
        return (T) thirdAnimal;
    }
}
