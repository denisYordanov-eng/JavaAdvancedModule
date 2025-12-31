public class ExplainingLifeWithRecursion {
    public static void main(String[] args) {
        int yearBirth = 0;
        int yearOfDeath = 0;

        String life = living(yearBirth, yearOfDeath);

        System.out.println(life);
    }

    private static String living(int yearBirth, int yearOfDeath) {
        if(!isAlive(yearOfDeath)){
            return "You are dead!";
        }
        return living(yearBirth, yearOfDeath + 1);
    }

    private static boolean isAlive(int yearOfDeath) {
        if(yearOfDeath < 100){
            return true;
        }
        return false;
    }
}
