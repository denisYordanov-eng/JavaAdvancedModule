package DefiningClass_Exercises.Google;

 class Car {
     private String carModel;
     private  int carSpeed;

  Car(String carModel, int carSpeed) {
         this.carModel = carModel;
         this.carSpeed = carSpeed;
     }
     @Override
     public String toString() {
      return String.format("%s %d%n", carModel, carSpeed);
     }
 }
