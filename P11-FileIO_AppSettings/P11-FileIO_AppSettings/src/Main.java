public class Main {


    public static void main(String[] args) {


        AppSettings.loadSettings();
        ToolsConsole.outputMessage("Min = " + AppSettings.Values.MIN_VALUE);
        ToolsConsole.outputMessage("Max = " + AppSettings.Values.MAX_VALUE);

        AppSettings.Values.MIN_VALUE = ToolsConsole.getInt("Enter min value:",0,1000);
        AppSettings.Values.MAX_VALUE = ToolsConsole.getInt("Enter max value:",0,1000);

        AppSettings.saveSettings();

    }
}