package encapsulation_Lab.salary_increase;

 class Person {

     private String firstName;

     private String lastName;

     private int age;

     private double salary;

      Person(String firstName, String lastName, int age, double salary) {
      setFirstName(firstName);
      setLastName(lastName);
      setAge(age);
      setSalary(salary);
     }

        private void setFirstName(String firstName) {
         this.firstName = firstName;
     }

     private void setLastName(String lastName) {
         this.lastName = lastName;
     }

    private void setAge(int age) {
         this.age = age;
     }

   private void setSalary(double salary) {
         this.salary = salary;
     }

     public void increaseSalary(double bonus) {
          if (this.age < 30){
              bonus = bonus / 2;
          }
          this.salary +=  this.salary * bonus / 100;

     }
     @Override
     public String toString() {
          return String.format("%s %s gets %s leva",this.firstName,this.lastName,this.salary);
     }
 }
