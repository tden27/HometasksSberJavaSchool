package lesson5.calculator;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CalculatorImpl calculator = new CalculatorImpl();
        calculator.sum(5, 3);

        // Вывести на консоль все методы класса, включая все родительские методы (включая приватные)
        Method[] methods1 = calculator.getClass().getMethods();
        Set<Method> methodSet = new HashSet<>(Arrays.asList(methods1));
        Method[] methods2 = calculator.getClass().getDeclaredMethods();
        methodSet.addAll(Arrays.asList(methods2));
        for (Method method : methodSet) {
            System.out.print(method.getName() + " ");
        }
        System.out.println();

        // Вывести все геттеры класса
        for (Method method : methodSet){
            if (method.getName().contains("get")) System.out.print(method.getName() + " ");
        }
        System.out.println();

        // Проверить что все String константы имеют значение = их имени
        Field[] fields = calculator.getClass().getFields();
        String result = "Все String константы имеют значение = их имени";
        for (Field field : fields){
            if (Modifier.isFinal(field.getModifiers())){
                try {
                    if (field.getName().equals(field.get(calculator))) {
                        result = "Поле " + field.getName() + " не имеют значение = их имени";
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(result);

        // Реализовать кэширующий прокси
        Calculator calculatorProxy= (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                calculator.getClass().getInterfaces(),
                new CacheProxy(calculator));
        System.out.println(calculatorProxy.calc(1));
        System.out.println(calculatorProxy.calc(5));
        System.out.println(calculatorProxy.calc(6));
        System.out.println(calculatorProxy.calc(1));
        System.out.println(calculatorProxy.calc(5));

        //  Создать свой аннотацию Metric.
        //  Реализовать proxy класс PerformanceProxy,
        //  который в случае если метод аннотирован Metric будет выводить на консоль время выполнения метода.
        Calculator calculatorPerformanceProxy = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                calculator.getClass().getInterfaces(), new PerformanceProxy(calculator));
        System.out.println(calculatorPerformanceProxy.calc(3));
    }
}
