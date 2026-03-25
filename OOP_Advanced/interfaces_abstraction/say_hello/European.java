package say_hello;

public class European implements Person {
    private String name;

    private void setName(String name) {
        this.name = name;
    }

    public European(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

}
