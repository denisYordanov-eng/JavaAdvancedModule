package DefiningClass_Exercises.Google;

import java.util.ArrayList;
import java.util.List;

class Person {
     //multiple parents, chidlren and pokemon
     private String name;
     private  Car car;
     private  Company company;

     private List<Parents> parents =  new ArrayList<>();
     private List<Child> children = new ArrayList<>();
     private List<Pokemon> pokemons = new ArrayList<>();

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Car car, Company company) {
        this.name = name;
        this.car = car;
        this.company = company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Child> getChildren() {
        return children;
    }

    public  List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }
}
