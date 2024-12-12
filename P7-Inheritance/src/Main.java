/*
File: Inheritance practice
Name: Cam Davies
Date March 2024
Purpose: Coding Inheritance
 */

public class Main {
    public static void main(String[] args) {

        People person = new People();
        person.toString(); // calls the toString from the people class
        Faculty clint = new Faculty();
        clint.setFirstName("Clint"); // setFirstName is a property of the parent class (People class)
        clint.setSupervisor("Nazeem");
       // clint.toString(); // calls the toString from the Faculty Class


        Faculty clint2 = new Faculty("Clint","Macdonald",5,16,1972,9053332222f,"Clint.macdonald@durhamcollege.ca","2000 simcoe",
                "SEIT","Nazeen",123456789,"BASc",17);

        System.out.print(clint2.toString());


    }
}