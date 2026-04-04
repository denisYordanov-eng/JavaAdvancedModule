package military_elite;

public class SpecialisedSoldierImpl extends PrivateImpl  {
    private String corps;

    public SpecialisedSoldierImpl(String firstName, String lastName, int id, double salary, String corps) {
        super(firstName, lastName, id, salary);
        setCorps(corps);
    }

    public void setCorps(String corps) {
        if (corps.equals("Airforces") || corps.equals("Marines")) {
            this.corps = corps;
        }
    }

    public String getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(System.lineSeparator());
        sb.append("Corps: ").append(this.corps);
        return sb.toString();
    }
}
