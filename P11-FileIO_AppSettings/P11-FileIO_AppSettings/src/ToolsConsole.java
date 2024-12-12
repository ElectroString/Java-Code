import java.util.Scanner;

public class ToolsConsole {
    static Scanner sc = new Scanner(System.in);

    public static String getString(String inputPrompt){
        outputMessage(inputPrompt);
        String input = sc.nextLine();
        return input;
    }

    public static int getInt(String prompt){
        int inputNum = -1;
        do{
            outputMessage(prompt);
            while(!sc.hasNextInt()){
                outputMessage("That was not a number");
                sc.next();
            }
            inputNum = sc.nextInt();
        }while(inputNum<=0);

        return inputNum;
    }

    public static int getInt(String prompt, int minValue, int maxValue){
        int inputNum;
        do{
            outputMessage(prompt);
            while(!sc.hasNextInt()){
                outputMessage("That was not a number");
                sc.next();
            }
            inputNum = sc.nextInt();
        }while(inputNum < minValue || inputNum > maxValue);

        return inputNum;
    }

    public static void outputMessage(String message){
        System.out.println(message);
    }
}
