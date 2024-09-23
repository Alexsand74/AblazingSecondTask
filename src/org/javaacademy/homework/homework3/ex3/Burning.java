package org.javaacademy.homework.homework3.ex3;

@FunctionalInterface
public interface Burning<T extends Fuel> {
    void glow(T t);
}
