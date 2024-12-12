import java.io.*;

public class AppSettings {

    private static final String fileName = "C:\\Users/Cameron\\Desktop\\School\\Programming\\Java\\Projects\\SETTINGS\\P11\\AppSettings.txt";

    public static class Values{

        public static int MIN_VALUE = 0;
        public static int MAX_VALUE = 100;


    }

    public static void loadSettings(){
        try{
            readFromFile(fileName);
        } catch(IOException ioe){
            ToolsConsole.outputMessage(ioe.getMessage());
        }
    }

    public static void saveSettings(){
        try{
            writeToFile(fileName);
        }catch (IOException ioe){
            ToolsConsole.outputMessage(ioe.getMessage());
        }
    }

    private static void readFromFile(String fileName) throws IOException {
        // open stream/buffer
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        // read each line from the memory and set setting
        String line = br.readLine();
        while (line != null){
            String[] items = line.split(":");

            switch(items[0].toUpperCase()){
                case "MIN_VALUE":
                    Values.MIN_VALUE = Integer.parseInt(items[1]);
                    break;
                case "MAX_VALUE":
                    Values.MAX_VALUE = Integer.parseInt(items[1]);
                    break;
            }
            line = br.readLine();
        }

    }

    private static void writeToFile(String fileName) throws IOException {
        // open stream, buffer and print writer
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bf = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bf);

        // write settings to memory
        out.println("MIN_VALUE:" + Values.MIN_VALUE);
        out.println("MAX_VALUE:" + Values.MAX_VALUE);

        //Save and close the file buffer
        out.close();
        bf.close();
        fw.close();

    }

}
