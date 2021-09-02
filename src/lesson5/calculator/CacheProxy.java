package lesson5.calculator;

import lesson5.calculator.annotations.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class CacheProxy implements InvocationHandler {
    private final Object delegate;
    private final Map<Object, Object> resultByArg = new HashMap<>();

    public CacheProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(!method.isAnnotationPresent(Cache.class)) return invoke(method,args);
        if(!resultByArg.containsKey(key(method,args))){
            System.out.println("Delegation of "+ method.getName());
            Object invoke = invoke(method,args);
            resultByArg.put(key(method,args), invoke);
        }
        return resultByArg.get(key(method,args));
    }

    private Object invoke(Method method, Object[] args) throws Throwable {
        try {
            return method.invoke(delegate, args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Impossible", e);
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }

    private Object key(Object method, Object[] args) {
        List<Object> key = new ArrayList<>();
        key.add(method);
        key.addAll(Arrays.asList(args));
        return key;
    }

    private void writeToFile(Method method, Object[] args, Object result) {}

    private Object readFile(Object method, Object[] args) {
        return null;
    }
}

