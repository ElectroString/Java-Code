/* ******************************************
File: Exception handling
Author: Cam Davies
Date 12/3/2024
Purpose: Intro to multiple and propagating exceptions
   ******************************************  */

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner((System.in));

    public static void main(String[] args) {
        // System.out.println("Test 1: " + test1());
        // System.out.println("Test 2: " + test2(null));

        test3();
    }

    // a method to demo multiple exception catches
    public static String test1(){
        String retString = "";

        double subTotal = 0.0;
        System.out.print("Enter subtotal: " );

        try {
            subTotal = Double.parseDouble(sc.nextLine());
            retString = String.format("Congrats, you entered a valid number %f", subTotal);
        }catch (NumberFormatException e){
            retString = String.format("Error! Invalid number: %s\n",e.toString());
        }catch (Exception ex){
            retString = String.format("Unknown Error: %s",ex.toString());
        } finally {
            // do stuff that needs to happen regardless of errors!
            retString += "\nFinished doing Stuff, Wrapping up!";
        }


        return retString;
    }

    // preventative exception handling through data validation
    public static String test2(String customerType){
        String retString = "";

        // prevent error when customer type was null
        if (customerType!= null){
            if (customerType.equalsIgnoreCase("R")){
                retString = "0.4";
            }else{
                retString = "0.6";
            }
        }
        return retString;
    }


    public static boolean isValidDouble(String inputString){
        boolean isValid = false;
        double test = 0.0;
            try{
                test = Double.parseDouble(inputString);
            }catch (NumberFormatException e){
                System.out.println("Error! Invalid decimal Value.\n");
                return false;
            }

            // range check
            if(test > 0 && test < 10000){
                isValid = true;
            }else{
                System.out.println("Error! Number must be between 0 and 10000");
            }



        return isValid;
    }

    // in main.java
    public static void test3(){
        double length = 0.0, width = 0.0;
        System.out.println("**** Area of a Rectangle ****");

        length = getDblFromConsole("Enter the length (m): ");
        width = getDblFromConsole("Enter the width(m): ");
        try{
            System.out.println("The area of the rectangle is" + calcRectangleArea(length,width));

        }catch (NumberFormatException e){
            System.out.println("Error: " + e.toString());
        }

    }

    // in Tools File
    public static double calcRectangleArea(double length, double width) {
        if (length == 0.0 || width == 0.0)
            throw new NumberFormatException("Incorrect numeric values! Must not be zero" );
        return Math.round(length * width);
    }

    public static double getDblFromConsole(String prompt){
        double returnValue = 0.0;
        System.out.print(prompt);
        boolean isValid = false;
        while(isValid == false) {

            try {
                returnValue = getDoubleFromConsole();
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.printf("An exception occurred with number format: calc cancelled: %s"
                        , e.toString());
            }
        }
        return returnValue;
    }

    // in Tools.java
    public static double getDoubleFromConsole() throws NumberFormatException{
        return Double.parseDouble(sc.nextLine());
    }


}