package strategy_pattern;

import java.util.Comparator;

public class CompareByName implements Comparator<Person> {
    @Override
    public int compare(Person personOne, Person PersonTwo) {
        int result = personOne.getName().length() - PersonTwo.getName().length();
        if(result == 0) {
            char firstCharPersonOne = Character.toLowerCase(personOne.getName().charAt(0));
            char firstCharPersonTwo = Character.toLowerCase(PersonTwo.getName().charAt(0));
            result = Character.compare(firstCharPersonOne, firstCharPersonTwo);
        }
        return result;
    }
}
