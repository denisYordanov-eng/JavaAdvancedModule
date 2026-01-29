package encapsulation_Lab.first_and_reserve_team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;

    private List<Person> people = new ArrayList<>();

    private List<Person> reservedPeople =  new ArrayList<>();

    Team(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    List<Person> getPlayers() {
        return Collections.unmodifiableList(people);
    }

    List<Person> getReservedPlayers() {
        return Collections.unmodifiableList(reservedPeople);
    }

    void addPlayer(Person person) {
        if (person.getAge() > 40) {
            reservedPeople.add(person);
        } else {
            people.add(person);
        }
    }
}
