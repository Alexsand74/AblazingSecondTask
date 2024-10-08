package org.javaacademy.homework.homework1.ex1;

import org.javaacademy.homework.homework1.ex1.animals.Animal;

public class Zoo<T extends Animal, U extends Animal, W extends Animal>  {
    private final T firstAnimal;
    private final U secondAnimal;
    private final W thirdAnimal;

    public Zoo(T firstAnimal, U secondAnimal, W thirdAnimal) {
        this.firstAnimal = firstAnimal;
        this.secondAnimal = secondAnimal;
        this.thirdAnimal = thirdAnimal;
    }

    public T getFirstAnimal()  {
        return  firstAnimal;
    }

    public U getSecondAnimal() {
        return secondAnimal;
    }

    public W getThirdAnimal() {
        return thirdAnimal;
    }
}
