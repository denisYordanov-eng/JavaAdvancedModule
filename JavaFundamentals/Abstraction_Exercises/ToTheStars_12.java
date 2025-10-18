package Abstraction_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class planet {
    private String planetName;
    private  double x ;
    private  double y;

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName.toLowerCase();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean IsInRange(double spaceShipX, double spaceShipY) {
        return spaceShipX >=(x - 1) &&  spaceShipX <= (x + 1)
                && spaceShipY >= (y - 1) &&  spaceShipY <= (y + 1);

    }
}
public class ToTheStars_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // read input and put planets and coordinates in List of planets
        List<planet> planets = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            String [] input = scanner.nextLine().split("\\s+");
            String planetName = input[0];
            double x = Double.parseDouble(input[1]);
            double y = Double.parseDouble(input[2]);
             planet planet = new planet();
             planet.setPlanetName(planetName);
             planet.setX(x);
             planet.setY(y);
             planets.add(planet);
        }

        //read coordinates of the spaceship
        String[] spaceShipLocation = scanner.nextLine().split("\\s+");
        double spaceShipX = Double.parseDouble(spaceShipLocation[0]);
        double spaceShipY = Double.parseDouble(spaceShipLocation[1]);

         //read numbersOf turns
        int spaceShipTurnsCount = Integer.parseInt(scanner.nextLine());

        //for the numbers of turns  we create String location equal to "space" and check if in list of objects
        // in our case planets if ship x and ship y are in range if it's true set location to planet name
        // and increment spaceShipY
        // otherwise  print the location which is set to space  and increment  spaceShipY
        for (int i = 0; i <= spaceShipTurnsCount; i++) {
            String location = "space";

            for (planet planet : planets) {
                if (planet.IsInRange(spaceShipX, spaceShipY)) {
                    location = planet.getPlanetName();
                    break;
                }
            }
            System.out.println(location);
            spaceShipY++;
        }
    }
}
