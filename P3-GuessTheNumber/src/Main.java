/*
Program: Guess the Number
Name: Cam Davies
Date: 2024/1/16
Purpose: Create a higher or lower game for the user to play
 */
//Generate random number between 1 and 1000
//Get user to guess value
//Tell if higher or lower

import java.util.Scanner;

public class Main {
    static int MINIMUM_RANDOM_VALUE = 0,MAXIMUM_RANDOM_VALUE = 10;
    public static void main(String[] args) {
        introduceGame();
    }

    public static void  introduceGame(){
        System.out.println("Welcome to Guess the number minigame");
        System.out.println("This Game will generate a number between 1 and 1000");
        System.out.println("You will be told if the answer is higher or lower than your guess");
        guessTheNumber(getRandomNumber());
    }

    public static short getRandomNumber(){
        short randomValue;
        do{
            randomValue = (short)(Math.random()*MAXIMUM_RANDOM_VALUE);
        }while (randomValue < MINIMUM_RANDOM_VALUE);
        return randomValue;
    }

    public static void guessTheNumber(short randomNumber){

        Scanner scanner = new Scanner(System.in);
        short numGuesses = 0;
        short userGuess;

        //Loops while user has not guessed the correct number
        do {
            //Gets user guess
            System.out.print("Please enter your guess: ");
            userGuess = scanner.nextShort();
            numGuesses++;

            //Checks if user guess is higher than, lower than, or equivilant to the randomly chosen value
            if (userGuess == randomNumber){
                System.out.println("Congratulations, you have guess the number! " +
                        "It took you " + numGuesses + " Attempts");

            } else if (userGuess < randomNumber){
                System.out.println("The correct number is higher!");

            }else{
                System.out.println("The correct number is lower!");

            }

        }while (userGuess != randomNumber);
        selectPlayAgain();

    }
    //Asks user if they would like to play the game again or not.
    public static void selectPlayAgain(){

        Scanner scanner = new Scanner(System.in);
        String playAgainAnswer;

        //loops until user selects yes or no
        do{
            System.out.print("Would you like to play again? type y for yes, or n for no: ");
            playAgainAnswer = scanner.nextLine();
            playAgainAnswer = playAgainAnswer.toUpperCase();

            if (playAgainAnswer.equals("Y")){
                guessTheNumber(getRandomNumber());
            }else if (!playAgainAnswer.equals("N")){
                System.out.println("Error: Input must be y for yes or n for no");
            }

        }while (!playAgainAnswer.equals("N") && !playAgainAnswer.equals("Y"));
    }
    //Generates and returns a random number
    //Plays the higher or lower game
    //Sets a title to introduce the game
}