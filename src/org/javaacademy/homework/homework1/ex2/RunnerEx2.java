package org.javaacademy.homework.homework1.ex2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class RunnerEx2 {
    public static void start() {
        //Задание №2 Гидрометцентр
        //Создать две структуры данных, в которых будет статистика по дням (среднесуточная температура воздуха)
        //Январь: 0,-1,-1,-2,-5,-6,-7,-8,-9,-10,-5,-5,-2,-7,-3,-1,-8,-9,-8,-8,-18,-20,-23,-24,-25,-9,-8,-7,-6,-5,-1
        //Февраль: -8,-10,-12,-13,-15,-16,-12,-7,-8,-10,-10,-9,-8,-8,-8,-9,-10,-9,-5,-6,-8,-7,-8,-9,-6,-5,-3,-1
        //Объединить данные за январь и февраль, посчитать среднесуточную температуру воздуха за 2 месяца.
        //Запрещено использовать массивы.

        List<Integer> january = List.of(0, -1, -1, -2, -5, -6, -7, -8, -9, -10,
                                                                       -5, -5, -2, -7, -3, -1, -8, -9, -8, -8, -18,
                                                                       -20, -23, -24, -25, -9, -8, -7, -6, -5, -1);
        List<Integer> february = List.of(-8, -10, -12, -13, -15, -16, -12, -7, -8,
                                                                       -10, -10, -9, -8, -8, -8, -9, -10, -9, -5,
                                                                             -6, -8, -7, -8, -9, -6, -5, -3,  -1);

        ArrayList<Integer> januaryAndFebruary = new ArrayList<>(january);
        januaryAndFebruary.addAll(february);
         BigDecimal averageDailyAirTemp = BigDecimal.valueOf(sumTemperaturesAllDays(januaryAndFebruary))
                        .divide(BigDecimal.valueOf(januaryAndFebruary.size()),1,RoundingMode.HALF_UP);
        System.out.format("Cреднесуточную температуру воздуха за 2 месяца = %.3f \n", averageDailyAirTemp);

    }

    private static Integer sumTemperaturesAllDays(ArrayList<Integer> arrayListTemperatures) {
        int sumOfTemperatures = 0;
        for (Integer temperatureForOneDay : arrayListTemperatures) {
            if (temperatureForOneDay == null) {
                throw new  RuntimeException(" The data contains the value null ! ");
            }
            sumOfTemperatures += temperatureForOneDay;
        }
        return sumOfTemperatures;
    }
}
