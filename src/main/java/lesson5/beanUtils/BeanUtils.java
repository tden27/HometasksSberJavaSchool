package lesson5.beanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Method[] methodsFrom = from.getClass().getMethods();
        for (Method methodFrom : methodsFrom) {
            if (methodFrom.getName().contains("get")) {
                String getMethodName = methodFrom.getName().substring(3);
                String setMethodName = "set" + getMethodName;
                try {
                    Method methodSet = to.getClass().getMethod(setMethodName, methodFrom.getReturnType());
                    methodSet.invoke(to, methodFrom.invoke(from));
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    System.out.println("Метода " + setMethodName + " нет в классе " + to.getClass().getName());
                    //e.printStackTrace();
                }
            }
        }
    }
}

