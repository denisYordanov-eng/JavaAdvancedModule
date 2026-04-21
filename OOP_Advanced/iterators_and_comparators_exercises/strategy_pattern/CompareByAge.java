package strategy_pattern;

import java.util.Comparator;

public class CompareByAge  implements Comparator<Person> {
    @Override
    public int compare(Person personOne, Person personTwo) {
        return personOne.getAge() - personTwo.getAge();
    }
}
