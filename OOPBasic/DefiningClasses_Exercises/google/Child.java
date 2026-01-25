package DefiningClass_Exercises.Google;

 class Child {
     private String childName;
     private String childBirthday;

      Child(String childName, String childBirthday) {
         this.childName = childName;
         this.childBirthday = childBirthday;
     }

     public String getChildName() {
         return childName;
     }

     public String getChildBirthday() {
         return childBirthday;
     }

     public void setChildName(String childName) {
         this.childName = childName;
     }
     public void setChildBirthday(String childBirthday) {}

     @Override
     public String toString()
     {
         return String.format("%s %s%n",childName, childBirthday);
     }
 }
