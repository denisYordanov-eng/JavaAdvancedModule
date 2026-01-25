package DefiningClass_Exercises.Google;

class Company {
     private String companyName;
     private String department;
     private  double salary;

    public Company() {
    }

    Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
   public String toString() {
         return String.format("%s %s %.2f%n"
                 , this.companyName, this.department, this.salary);
    }
}
