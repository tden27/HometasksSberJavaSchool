package lesson5.calculator;

import lesson5.calculator.annotations.Metric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class PerformanceProxy implements InvocationHandler {
    private final Object delegate;
    private final Map<Object, Object> resultByArg = new HashMap<>();

    public PerformanceProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Metric.class)) return method.invoke(delegate, args);
        long startTime = System.nanoTime();
        Object result = method.invoke(delegate, args);
        long endTime = System.nanoTime();
        System.out.println("Время работы метода: " + (endTime - startTime) + " (в наносек)");
        return result;
    }
}
