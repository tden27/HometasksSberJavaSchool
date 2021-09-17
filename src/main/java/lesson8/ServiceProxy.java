package lesson8;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ServiceProxy implements InvocationHandler {
    private final Object delegate;
    private final Map<Object, Object> cacheMemory = new HashMap<>();

    private String fileName;

    public ServiceProxy(Object delegate) {
        this.delegate = delegate;
    }

    private Object startMethodWithoutCaching(Method method, Object[] args) {
        Object result = null;
        try {
            result = method.invoke(delegate, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (!method.isAnnotationPresent(Cache.class)) return startMethodWithoutCaching(method, args);
        if (method.getAnnotation(Cache.class).fileName() != null) {
            fileName = method.getAnnotation(Cache.class).fileName();
        } else fileName = method.getName();
        switch (method.getAnnotation(Cache.class).cacheType()) {
            case IN_MEMORY:
                result = cacheInMemory(method, args);
                break;
            case FILE:
                result = cacheFile(method, args);
                break;
        }
        return result;
    }

    // метод возвращающий результат работы метода из файла
    private Object cacheFile(Method method, Object[] args) {
        return null;
    }

    // метод возвращающий результат работы метода из памяти JVM
    private Object cacheInMemory(Method method, Object[] args) {
        if (!cacheMemory.containsKey(key(method, args))) {
            System.out.println("Delegation of " + method.getName());
            Object invoke = startMethodWithoutCaching(method, args);
            cacheMemory.put(key(method, args), invoke);
        }
        return cacheMemory.get(key(method, args));
    }

    private Object key(Object method, Object[] args) {
        List<Object> key = new ArrayList<>();
        key.add(method);
        key.addAll(Arrays.asList(args));
        return key;
    }

    private File findFile() {
        File result = null;
        File[] files = CacheProxy.rootDirectory.listFiles();
        if (files != null)
            for (File file : files) {
                if (fileName.equalsIgnoreCase(file.getName())) result = file;
            }
        return result;
    }

    private Object readFile(Method method, Object[] args) {
        Object result = null;
        File fileCache = findFile();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileCache));
             ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileCache))) {
            if (fileCache != null) {
                result = inputStream.readObject();
            } else {
                result = startMethodWithoutCaching(method, args);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
