/*
File: Main Class file for running this application
Name: Cam Davies
Date: 25/3/2024
Purpose: Learning file IO, JavaDocs, wrapper helper functions
 */
import java.util.Scanner;
import java.io.IOException;

/**
 * The Main application static class for executing the program
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    /**
     * the application starting method
     * @param args - String array representing Execution Arguments
     */
    public static void main(String[] args) {
        // initializeProgram();
        runProgram();
        // closeProgram();

    }

    private static void runProgram(){

        // obtain file name from user
        String fileName = getFileName();

        // read data from file amd store in queue
        readFile(fileName);


        // allow editing of data
        for(Task task: Task.tasks){
            System.out.print(task.toString());
            task.setDueDate(task.getDueDate().plusDays(7));
        }

        // write data to a file
        writeFile(fileName);

    }

    /**
     * A method to obtain  file name string from the console window
     * @return String - represents the filename entered by the user
     */
    private static String getFileName(){
        // NOTE: BYPASSING DATA VALIDATION AND EXCEPTION HANDLING
        System.out.print("Enter the name of the file to read");
        String fileName = sc.nextLine();
        return fileName;
    }


    private static boolean readFile(String fileName) {
        try {
            Task.readFromFile(fileName);
        }catch (IOException ioe){
            System.out.println("an error occured: "+ ioe.getMessage());
            return false;
        }
        return true;
    }

    private static boolean writeFile(String fileName){
        try{
            Task.writeToFile(fileName);
        }catch (IOException ioe){
            System.out.println("A write error occured" + ioe.getMessage());
            return false;
        }
        return true;
    }
}