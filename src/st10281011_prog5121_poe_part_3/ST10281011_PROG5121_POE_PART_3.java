//ST10281011 Akhilesh Parshotam
package st10281011_prog5121_poe_part_3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ST10281011 Akhilesh
 */
public class ST10281011_PROG5121_POE_PART_3 
{

    public static void main(String[] args)
    {
        //Declaring the Variables for the Login class.
        String Username = " ";
        String Password = " ";
        String First_Name = " ";
        String Last_Name = " ";
        String Full_Name = " ";

        //Declaring the Variables for the Task class.
        int T_Num = 0;
        String T_Name = " ";
        String T_Descrip = " ";
        String Dev_F_Name = " ";
        String Dev_L_Name = " ";
        int T_Dur = 0;
        String T_ID = " ";
        String T_Status = " ";

        //Declaring Array List variables.
        ArrayList<Integer> Task_Numbers = new ArrayList<>();
        ArrayList<String> Task_Names = new ArrayList<>();
        ArrayList<String> Task_Descriptions = new ArrayList<>();
        ArrayList<String> Developers_First_Names = new ArrayList<>();
        ArrayList<String> Developers_Last_Names = new ArrayList<>();
        ArrayList<Integer> Task_Durations = new ArrayList<>();
        ArrayList<String> Task_IDs = new ArrayList<>();
        ArrayList<String> Task_Statuses = new ArrayList<>();
        ArrayList<Integer> Total_Hours = new ArrayList<>();

        //Calling the registerUser module where it is getting the Full_Name variable from.
        Full_Name = Login.reqisterUser(Username, Password, First_Name, Last_Name, Full_Name);
        JOptionPane.showMessageDialog(null, "User succesfully registered");

        //Calling the returnLoginStatus module where the Full_Name variable is being used.
        String Easy_Kaban_Login = Login.returnLoginStatus(Username, Password, Full_Name);

        //If statement that will only prompt if the user successfuly login.
        if (Easy_Kaban_Login.equals("continue")) 
        {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

            while (true) 
            {
                String Choice = JOptionPane.showInputDialog("Choose an option:\n" +
                                                        "1. Add tasks\n" + 
                                                        "2. Show report\n" +
                                                        "3. Display tasks with task status of 'Done'\n" + 
                                                        "4. Display the task with the longest duration\n" +                                                           
                                                        "5. Search for task by Task Name\n" + 
                                                        "6. Search for task by developer name\n" + 
                                                        "7. Delete Task\n" + 
                                                        "8. Quit");

                /*
                Switch statements thats asks the user if they want to add tasks, see the report, Display tasks with task status
                of 'Done', Display the task with the longest duration, Search for task by Task Name, Search for task by 
                developer name, Delete Task or quit.
                */
                
                switch (Choice) 
                {
                    case "1":
                        //Calling the addTasks method from the Task Class.
                        Task.addTasks(Task_Numbers, Task_Names, Task_Descriptions, Developers_First_Names, Developers_Last_Names,
                                Task_Durations, Task_IDs, Task_Statuses, Total_Hours);

                        //Calling the printTaskDetails method from the Task Class.
                        Task.printTaskDetails(T_Num, T_Name, T_Descrip, T_Dur, T_ID, T_Status, Dev_F_Name, Dev_L_Name);

                        //Calling the retrnTotalHours method from the Task Class.
                        Task.returnTotalHours(T_Dur, Total_Hours);
                        break;

                    case "2":
                        //Calling the displayAllTasks method from the Task Class.
                        ArrayList<String> Disp_All_Tasks = Task.displayAllTasks(Task_Numbers, Task_Names, Task_Descriptions,
                                        Developers_First_Names, Developers_Last_Names, Task_Durations, Task_IDs, Task_Statuses, 
                                        Total_Hours);

                        // Iterate over the tasks and display each task in a separate message dialog box.
                        for (String Show_Tasks : Disp_All_Tasks) 
                        {
                            JOptionPane.showMessageDialog(null, Show_Tasks, "Task Report", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case "3":
                        //Calling the displayTasksWithStatus method from the Task Class.
                        ArrayList<String> Disp_Status = Task.displayTasksWithStatus(Task_Statuses, "Done", Developers_First_Names, 
                                        Developers_Last_Names, Task_Names, Task_Durations);

                        // Iterate over the tasks and display each task in a separate message dialog box
                        for (String Status_of_Tasks : Disp_Status) 
                        {
                            JOptionPane.showMessageDialog(null, Status_of_Tasks);
                        }
                        break;

                    case "4":
                        //Calling the displayTaskWithLongestDuration method from the Task Class.
                        String Disp_Dur = Task.displayTaskWithLongestDuration(Developers_First_Names, Developers_Last_Names, 
                                        Task_Durations);
                        
                        JOptionPane.showMessageDialog(null, Disp_Dur);
                        break;

                    case "5":
                        //Calling the searchTaskByTaskName method from the Task Class.
                        String Entered_Task_Name = JOptionPane.showInputDialog("Enter the task name you want to search for:");
                        String Search_Task_Name = Task.searchTaskByTaskName(Task_Names, Developers_First_Names, Developers_Last_Names, 
                                                Task_Statuses, Entered_Task_Name);
                        
                        JOptionPane.showMessageDialog(null, Search_Task_Name);
                        break;

                    case "6":
                        //Calling the searchTasksByDeveloperName method from the Task Class.
                        String Entered_Dev_Name = JOptionPane.showInputDialog("Enter the developer's full name you want to "
                                                                              + "search for:");
                        
                        ArrayList<String> Search_Dev_Name = Task.searchTasksByDeveloperName(Task_Names, Developers_First_Names, 
                                        Developers_Last_Names, Task_Statuses, Entered_Dev_Name);

                        // Iterate over the tasks and display each task in a separate message dialog box.
                        for (String Dev_of_Task : Search_Dev_Name) 
                        {
                            JOptionPane.showMessageDialog(null, Dev_of_Task);
                        }
                        break;

                    case "7":
                        //Calling the deleteTaskByTaskName method from the Task Class.
                        String Enter_Task_To_Del = JOptionPane.showInputDialog("Enter the task name of the task you would "
                                                                            + "like to delete:");
                        
                        String Delete_Task = Task.deleteTaskByTaskName(Task_Names, Developers_First_Names, Developers_Last_Names, 
                                            Task_Statuses, Enter_Task_To_Del);
                        
                        JOptionPane.showMessageDialog(null, Delete_Task);
                        break;

                    case "8":
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice");
                }
            }
        } 
        else if (Easy_Kaban_Login.equals("exit")) 
        {
            System.exit(0);
        }
    }
}
//ST10281011 Akhilesh Parshotam 
