package org.javaacademy.homework.homework5.ex1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runner {
    private static final BigDecimal AMOUNT_OF_MONEY = BigDecimal.valueOf(1500);

    public static void main(String[] args) throws ReflectiveOperationException {
        //Запрещено изменять модификаторы доступа!
        //Практически все будет через рефлексию
        //Создать банк с 1500 денег
        //Создать вора
        //Дописать метод stealMoney у вора так, чтобы он крал все деньги из банка себе
        //(увеличивал у себя деньги и обнулял деньги банка)
        //Вызвать здесь метод stealMoney
        //Распечатать вора и банк

        //Итог:
        //Вор - 1500 денег
        //Банк - 0 денег

        Bank bank = createBank(AMOUNT_OF_MONEY);
        System.out.print("Количество денег в банке = ");
        showBankMoney(bank);
        Thief thief = createThief();
        System.out.print("Количество денег у вора = ");
        showThiefMoney(thief);
        System.out.println("КРАЖА !");
        stealMoney(thief, bank);
        System.out.print("Количество денег в банке = ");
        showBankMoney(bank);
        System.out.print("Количество денег у вора = ");
        showThiefMoney(thief);
    }

    private static Bank createBank(BigDecimal money) throws ReflectiveOperationException {
        Class<Bank> bankClass = Bank.class;
        Constructor<Bank> declaredConstructor = bankClass.getDeclaredConstructor(BigDecimal.class);
        declaredConstructor.setAccessible(true);
        Bank bank = declaredConstructor.newInstance(money);
        declaredConstructor.setAccessible(false);
        return bank;
    }

    private static Thief createThief() throws ReflectiveOperationException {
        Class<Thief> thiefClass = Thief.class;
        Constructor<Thief> declaredConstructor = thiefClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Thief thief = declaredConstructor.newInstance();
        declaredConstructor.setAccessible(false);
        return thief;
    }


    private static void showBankMoney(Bank bank) throws IllegalAccessException {
        Class<Bank> bankClass = Bank.class;
        for (Field declaredField : bankClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            Object bankObj = declaredField.get(bank);
            System.out.println(bankObj);
            declaredField.setAccessible(false);
        }
    }

    private static void showThiefMoney(Thief thief) throws IllegalAccessException {
        Class<Thief> thiefClass = Thief.class;
        for (Field declaredField : thiefClass.getDeclaredFields()) {
            declaredField.setAccessible(true);
            Object thiefObject = declaredField.get(thief);
            System.out.println(thiefObject);
            declaredField.setAccessible(false);
        }
    }

    private static void stealMoney(Thief thief, Bank bank) throws ReflectiveOperationException {
        Class<Thief> thiefClass = Thief.class;
        Method stealMoney = thiefClass.getDeclaredMethod("stealMoney", Bank.class);
        stealMoney.setAccessible(true);
        stealMoney.invoke(thief, bank);
        stealMoney.setAccessible(false);
    }


}
