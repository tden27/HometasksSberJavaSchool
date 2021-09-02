package lesson5.calculator;

import lesson5.calculator.annotations.Cache;
import lesson5.calculator.annotations.Metric;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @Cache
    @Metric
    int calc (int number);
}
