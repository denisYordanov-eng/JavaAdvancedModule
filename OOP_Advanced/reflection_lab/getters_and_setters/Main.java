package getters_and_setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> cl = Reflection.class;
       Arrays.stream(cl.getDeclaredMethods())
               .filter(m -> m.getName().startsWith("get"))
               .sorted(Comparator.comparing(Method::getName))
               .forEach(m -> System.out.printf("%s will return %s%n"
                       ,m.getName()
                       ,m.getReturnType()));

       Arrays.stream(cl.getDeclaredMethods())
               .filter(m -> m.getName().startsWith("set"))
               .sorted(Comparator.comparing(Method::getName))
               .forEach(m ->
                   System.out.printf("%s and will set field of %s%n"
                   ,m.getName(),m.getParameterTypes()[0].getName()));

    }
}
