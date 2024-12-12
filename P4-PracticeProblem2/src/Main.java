/*
    Title: Practice question 2
    Name: Cam Davies
    Date: 2024/1/18
    Purpose:
 */


import  java.lang.Math;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    static int previousAnswer;
    static boolean continueCalculations = false;
    public static void main(String[] args) {
        doCalculations();
        //getFirstNumber();
    }

//********************************************//
//ATTEMPT 1 WORKING, UNOPTIMIZED
/*
    //Gets the first number of the equation
    public static void getFirstNumber(){
        int firstNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        firstNumber = scanner.nextInt();
        getRestOfEquation(firstNumber);

    }

    //Gets the second number and operator
    public static void getRestOfEquation(int firstNumber){

        Scanner scanner = new Scanner(System.in);
        int secondNumber,result;
        String operator;

        //Loops While there is a division by 0
        do {
            //if (previousAnswer)
            System.out.print("Please input the second number: ");
            secondNumber = scanner.nextInt();

            //gets the operator of choice from the user and checks if it is valid
            do {
                System.out.print("Please input the operator: ");
                operator = scanner.next();
                if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") && !operator.equals("^") && !operator.equals("%")){
                    System.out.println("Error, please enter a valid operator");
                }
            }while(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") && !operator.equals("^") && !operator.equals("%"));
            //Checks for division by 0
            if(secondNumber == 0 && operator.equals("/")){
                System.out.println("ERROR, Cannot divide by 0, please re-enter values");
        }
        }while (secondNumber == 0 && operator.equals("/"));

        result = doCalculation(firstNumber,secondNumber,operator);
        System.out.println("The Result of the calculation is: " + result);
        previousAnswer = result;
        exitOrContinueCalculations();
    }

    //Does calculations based off user inputs
    public static int doCalculation(int firstNumber, int secondNumber, String operator){
        int result = 0;
        switch (operator){
            case "+" :
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result= firstNumber / secondNumber;
                break;
            case "^":
                //result = Math.pow(firstNumber,secondNumber);
                break;
            case "%":
                result = firstNumber % secondNumber;
                break;
        }
        return result;
    }


    //Determines if the user would like to continue calculating  with the existing value,
    // start over with a new calculation or exit the program
    public static void exitOrContinueCalculations(){
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.print("Would you like to continue(c), start over(n) or exit?(x)");
            choice = scanner.next();
            choice = choice.toUpperCase();
            if (!choice.equals("C") && !choice.equals("X") && !choice.equals("N")){
                System.out.println("Error, Please enter a valid option");
            }
        }while (!choice.equals("C") && !choice.equals("X") && !choice.equals("N"));

        if (choice.equals("C")){
            getRestOfEquation(previousAnswer);
        }else if (choice.equals("N")) {
            getFirstNumber();
        }


    }
    */
//******************************************************* end of Unoptimized attempt//




    public static void doCalculations(){
        int result = 0;
        int firstNumber,secondNumber;
        String operator;

        //Gets values and operator: Checks if user chose to continue from prior calculation
        if (!continueCalculations){
            System.out.print("Please enter the first number: ");
            firstNumber = getNumber();
        }else{
            firstNumber = previousAnswer;
        }
        do {
            System.out.print("Please enter the second number: ");
            secondNumber = getNumber();

            System.out.print("Please enter the operator: ");
            operator = getOperator();

            if (operator.equals("/") && secondNumber == 0){
                System.out.println("Error, cannot divide by 0, Please re-enter");
            }

        }while(operator.equals("/") && secondNumber == 0);

        //calculates results using user-inputted values and operator
        switch (operator){
            case "+" :
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result= firstNumber / secondNumber;
                break;
            case "^":
                //result = Math.pow(firstNumber,secondNumber);
                break;
            case "%":
                result = firstNumber % secondNumber;
                break;
        }
        System.out.println("The result of the operation is: "+result);
        previousAnswer = result;
        chooseContinueOrExit();
    }

    // Lets the user choose if they'd like to continue calculating with the existing answer,
    // start a new calculation or exit
    public static void chooseContinueOrExit(){
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.print("Would you like to continue(C), start over(N) or exit?(X)?: ");
            choice = scanner.next();
            choice = choice.toUpperCase();
            if (!choice.equals("C") && !choice.equals("X") && !choice.equals("N")){
                System.out.println("Error, Please enter a valid option");
            }
        }while (!choice.equals("C") && !choice.equals("X") && !choice.equals("N"));

        if (choice.equals("C")){
            continueCalculations = true;
            doCalculations();
        }else if (choice.equals("N")) {
            doCalculations();
        }
    }

    //Gets user input
    public static int getNumber(){
        Scanner scanner = new Scanner(System.in);
        int newNumber = scanner.nextInt();
        return newNumber;
    }

    public static String getOperator(){
        Scanner scanner = new Scanner(System.in);
        String operator;
        do {
            System.out.print("Please input the operator: ");
            operator = scanner.next();
            if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") && !operator.equals("^") && !operator.equals("%")) {
                System.out.println("Error, please enter a valid operator");
            }
        }while(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/") && !operator.equals("^") && !operator.equals("%"));
        return operator;
    }


}