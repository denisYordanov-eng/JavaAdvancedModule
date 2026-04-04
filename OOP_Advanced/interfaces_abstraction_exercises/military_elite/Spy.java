package military_elite;

public class Spy extends SoldierImpl implements ISpy {
    private String code;

    public Spy(int id, String firstName, String lastName, String code) {
        super(id, firstName, lastName);
        this.code = code;
    }

    @Override
    public String getCode() {

        return this.code;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s%n",
                super.getFirstName()
                , super.getLastName()
                , super.getId()));
        sb.append(String.format("Code Number: %s", this.code));
        return sb.toString();
    }
}
