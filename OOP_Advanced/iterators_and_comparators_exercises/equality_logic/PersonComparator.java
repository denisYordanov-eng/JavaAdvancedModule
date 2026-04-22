package equality_logic;

import java.util.Comparator;

public class PersonComparator  implements Comparator<Person> {
    @Override
    public int compare(Person personOne, Person personTwo) {
        int result = personOne.getName().compareTo(personTwo.getName());
        if (result == 0) {
            result = personOne.getAge().compareTo(personTwo.getAge());
        }
        return result;
    }
}
