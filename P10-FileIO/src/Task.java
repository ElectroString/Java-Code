/* **********************************
File:       Task Class and Interface Definition
Author:     Clint MacDonald
Date:       March 2024
Purpose:    Defining both the task interface and the task instance class
************************************* */
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Queue;
import java.util.LinkedList;

interface TaskInterface {
    public void assignToUser(String user);
    public void changeStatus(Task.Status status);
    public String toString();
}

public class Task implements TaskInterface {

    //<editor-fold desc="Static Variables and Globals">
    public static int taskAutoID = 1;
    public static Queue<Task> tasks = new LinkedList<Task>();

    public static enum Status {
        PENDING,
        IN_PROGRESS,
        TESTING,
        FOR_REVIEW,
        COMPLETE,
        CLOSED,
        CANCELLED
    }

    public static enum Priority {
        LOW,
        MEDIUM,
        HIGH,
        EMERGENCY
    }
    //</editor-fold>

    //<editor-fold desc="Properties">
    private int taskID;
    private String title;
    private String details;
    private String userAssigned;
    private Status status;
    private Priority priority;
    private LocalDate dueDate;
    //</editor-fold>

    //<editor-fold desc="Getters and Setters">

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID() {
        this.taskID = taskAutoID++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUserAssigned() {
        return userAssigned;
    }

    public void setUserAssigned(String userAssigned) {
        this.userAssigned = userAssigned;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //</editor-fold>

    //<editor-fold desc="Constructors">
    // Default Constructor
    public Task() {
        setTaskID();
    }

    // Parameterized Constructor
    public Task(String title, String details, String userAssigned,
                Status status, Priority priority, LocalDate dueDate) {
        setTaskID();
        setTitle(title);
        setDetails(details);
        setUserAssigned(userAssigned);
        setStatus(status);
        setPriority(priority);
        setDueDate(dueDate);
    }

    //</editor-fold>

    //<editor-fold desc="Instance Methods">
    public void assignToUser(String user) {

    };
    public void changeStatus(Task.Status status) {

    };

    @Override
    public String toString() {
        return String.format("""
                TaskID:     %d
                User:       %s
                Title:      %s
                Details:    %s
                Priority:   %s
                Status:     %s
                Due Date:   %s
                """, taskID, userAssigned, title, details, priority, status,
                dueDate.toString());

    }
    //</editor-fold>
    //<editor-fold desc="Static Methods">

    /**
     * A Static method to read tasks from a scv file and instantiate the
     * results into a static Queue of Tasks
     * @param fileName String - representing the CSV file to load tasks from
     * @throws IOException - propagate the exception to the UI for Handling
     */
    public static void readFromFile(String fileName) throws IOException {

        // open input stream to a file
        FileReader fr = new FileReader(fileName); // opens a stream
        BufferedReader in = new BufferedReader(fr); // the memory

        // read the data from the buffer and creating tasks
        String line = in.readLine();
        while(line != null){
            System.out.println(line); // ONLY for testing and debugging purposes
            tasks.add(createTaskFromCSVLine(line));
            line = in.readLine();
        }

        // MUST CLOSE THE FILE
        in.close();
        // fr.close(); // Not required as auto happens when method terminates, but must release memory
    }


    private static Task createTaskFromCSVLine(String line){
        // Sample Line: task 1 title,task 1 details,,PENDING,LOW,2024-04-13
        String[] items;
        items = line.split(",");

        Task task = new Task();
        task.setTitle(items[0]);
        task.setDetails(items[1]);
        task.setUserAssigned(items[2]);
        // status
        for (Status status: Task.Status.values()){
            if (items[3].equalsIgnoreCase(status.toString())){
                task.setStatus(status);
            }
        }
        // Priority
        for (Priority priority: Task.Priority.values()){
            if (items[4].equalsIgnoreCase(priority.toString())){
                task.setPriority(priority);
            }
        }
        task.setDueDate(LocalDate.parse(items[5]));
        // NOTE: NEEDED VALIDATION AND EXCEPTION HANDLING ABOVE

        return task;
    }


    public static void writeToFile(String fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName); // Create stream to the file
        BufferedWriter b = new BufferedWriter(fw); // connecting to memory
        PrintWriter out = new PrintWriter(b); // allowing us to write to memory

        for (Task task: tasks){
            out.println(String.format("%s,%s,%s,%s,%s,%s",
                    task.title,task.details,task.userAssigned,
                    task.status.toString(), task.priority.toString(),
                    task.dueDate.toString()));
        }

        // MUST CLOSE
        out.close(); // SAVE HAPPENS HERE!!!!!
        b.close();
        // fw.close(); // happens automatically on ending curly brace
    }
    //</editor-fold>

}
