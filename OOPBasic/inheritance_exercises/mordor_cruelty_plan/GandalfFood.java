package mordor_cruelty_plan;

public class GandalfFood {
    private int calculateMood;

    public GandalfFood() {
        this.calculateMood = 0;
    }

    public void calculateFood(String food) {
        switch (food) {
            case "cram":
                this.calculateMood += 2;
                break;
            case "lembas":
                this.calculateMood += 3;
                break;
            case "apple":
            case "melon":
                this.calculateMood += 1;
                break;
            case "honeycake":
                this.calculateMood += 5;
                break;
            case "mushrooms":
                this.calculateMood -= 10;
                break;
            default:
                this.calculateMood -= 1;
                break;
        }
    }

    private String getMood() {
        if (this.calculateMood < -5) {
            return "Angry";
        } else if (this.calculateMood < 0) {
            return "Sad";
        } else if (this.calculateMood <= 15) {
            return "Happy";
        } else {
            return "JavaScript";
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(calculateMood);
        sb.append(System.lineSeparator());
        sb.append(getMood());
        return sb.toString();
    }
}
