package reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InstantiationException
            , IllegalAccessException
            , NoSuchMethodException
            , InvocationTargetException {
        Class<Reflection> cl = Reflection.class;
        System.out.println("class " + cl.getSimpleName());
        System.out.println(cl.getSuperclass());

        Class<?>[] interfaces = cl.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Reflection reflection =  cl.getDeclaredConstructor().newInstance();
        System.out.println(reflection);
    }
}
