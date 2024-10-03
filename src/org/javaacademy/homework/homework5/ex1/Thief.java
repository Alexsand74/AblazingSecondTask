package org.javaacademy.homework.homework5.ex1;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * Вор
 */
public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws IllegalAccessException {
        BigDecimal moneyBank = getMoney(bank);
        money = money.add(moneyBank);
        setMoney(bank, BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return "Thief{" +
               "money=" + money +
               '}';
    }

    private static void setMoney(Bank bank, BigDecimal value) throws IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        for (Field declaredField : bankClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            declaredField.set(bank, value);
            declaredField.setAccessible(false);
        }
    }

    private static BigDecimal getMoney(Bank bank) throws IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        for (Field declaredField : bankClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            BigDecimal result = (BigDecimal) declaredField.get(bank);
            declaredField.setAccessible(false);
            return result;
        }
        return BigDecimal.ZERO;
    }

}
