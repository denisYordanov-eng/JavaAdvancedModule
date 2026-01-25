package DefiningClass_Exercises.Google;

 class Child {
     private String childName;
     private String childBirthday;

      Child(String childName, String childBirthday) {
         this.childName = childName;
         this.childBirthday = childBirthday;
     }

     @Override
     public String toString()
     {
         return String.format("%s %s%n",childName, childBirthday);
     }
 }
