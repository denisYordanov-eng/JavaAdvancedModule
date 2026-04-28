package coding_tracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tracker {

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> cl){
        Map<String,List<String>> map = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();
        for (Method m : methods) {
            Author annotation =  (Author) m.getAnnotation(Author.class);
            if (annotation != null) {
                String methodName = m.getName() + "()";
                String annotationName = annotation.name();
                map.putIfAbsent(annotationName,new ArrayList<>());
                map.get(annotationName).add(methodName);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
        }
    }
}
