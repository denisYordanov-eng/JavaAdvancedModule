package enumerations_and_annotations.custom_enum_annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

      Class<?> targerClass = null;
      if (input.equals("Rank")){
          targerClass = Rank.class;
      }else if (input.equals("Suit")){
          targerClass = Suit.class;
      }

      if (targerClass != null){
          CustomAnnotation customAnnotation = targerClass.getAnnotation(CustomAnnotation.class);
          if (customAnnotation != null){
              System.out.printf("Type = %s, Description = %s"
              ,customAnnotation.type(), customAnnotation.description());
          }
      }
    }

}
