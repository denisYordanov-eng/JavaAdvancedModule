public class RecursionStackOverFlow {
    public static void main(String[] args) {
        int yearBirth = 0;
        int yearOfDeath = 0;
      try {
          int hustleTillDeath = life(yearBirth,yearOfDeath);
      }
      catch (StackOverflowError e) {
          System.out.println("You are dead");
      }
    }

    private static int life(int yearOfBirth, int currentYear) {
        return yearOfBirth + life(yearOfBirth, currentYear + 1);
    }
}
