package DefiningClass_Exercises.Google;

 class Parents {
     private String parentName;
     private String parentBirthday;

     Parents(String parentName, String parentBirthday) {
         this.parentName = parentName;
         this.parentBirthday = parentBirthday;
     }
     @Override
     public String toString() {
         return String.format("%s %s%n",this.parentName,this.parentBirthday);
     }
 }
