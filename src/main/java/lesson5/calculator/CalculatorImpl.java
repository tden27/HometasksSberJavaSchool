package lesson5.calculator;

import lesson5.calculator.annotations.Cache;

public class CalculatorImpl extends Calc implements Calculator{
    private int num1;
    private int num2;
    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";
    public static final String FRIDAY = "SUNDAY";
    public static final String WEDNESDAY = "WEDNESDAY";

    public CalculatorImpl(){
        num1 = 5;
        num2 = 3;
    }

    @Override
    public int calc(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result = result * i;
        }
        return result;
    }

    @Cache
    public int sum(int num1, int num2){
        return num1 + num2;
    }

    @Cache
    private int subtraction(int num1, int num2){
        return num1 - num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
