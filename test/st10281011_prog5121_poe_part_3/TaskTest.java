//ST10281011 Akhilesh Parshotam
package st10281011_prog5121_poe_part_3;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ST10281011 Akhilesh Parshotam
 */
public class TaskTest 
{
    public TaskTest() 
    {
        
    }
    /**
     * Test of checkTaskDescription method, of class Task.
     */
    @Test
    public void testCheckTaskDescription() 
    {
        System.out.println("checkTaskDescription");
        String[] Task_Descriptions = {"Test for both success and failure"};
        boolean expResult = true;
        boolean result = Task.checkTaskDescription(Task_Descriptions);
        assertEquals(expResult, result);
        System.out.println("Task successfully captured");     
    }
    
    //********************************************************************************************************************************
    
    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() 
    {
        System.out.println("createTaskID");
        
        System.out.println("Task ID for Test case 1");
        String Task_Name = "Login Feature";
        int Task_Number = 0;
        String First_Name = "Robyn";
        String expResult = "LO:0:BYN";
        String result = Task.createTaskID(Task_Name, Task_Number, First_Name);
        assertEquals(expResult, result);
        System.out.println("LO:0:BYN"); 
        
        System.out.println("Task ID for Test case 2");
        
        String[] First_Names= {"IKE", "ARD", "THA", "NDS"};
        String[] expectedTaskIDs = {"CR:0:IKE", "CR:1:ARD", "CR:2:THA", "CR:3:NDS"};

        for (int i = 0; i < First_Names.length; i++) 
        {
            String Developer_Name = First_Names[i];
            String expectedTaskID = expectedTaskIDs[i];

            String actualTaskID = Task.createTaskID("CR", i, Developer_Name);
            assertEquals(expectedTaskID, actualTaskID);        
        }
        System.out.println("Task successfully captured\n"); 
    }
    
    //********************************************************************************************************************************

    /**
     * Test of testreturnTotalHours method, of class Task.
     */
    @Test
    public void testreturnTotalHours() 
    {
        System.out.println("returnTotalHours");
        
        int[][] All_Durations = 
        {
            {10, 8},           // Test data for case 1
            {10, 12, 55, 11, 1} // Test data for when 5 taskes are added
        };
        
        int[] expResult = {18, 89};   // Expected total hours for each case
        
        for (int i = 0; i < All_Durations.length; i++) 
        {
            int[] Durations = All_Durations[i];
            
            int Total_Hours = 0;
            for (int Dur : Durations) 
            {
                Total_Hours += Dur;
            }
            assertEquals(expResult[i], Total_Hours);
        }
        System.out.println("Total hours for task 1 and task 2 is 18 hours");
        System.out.println("Total hours when 5 tasks are added is 89 hours");
        System.out.println("Task successfully captured\n"); 
    }  
    
    //********************************************************************************************************************************

    @Test
    public void testDisplayTasksWithStatus() 
    {
        System.out.println("displayTasksWithStatus");
        
        ArrayList<String> Task_Statuses = new ArrayList<>();
        Task_Statuses.add("To Do");
        Task_Statuses.add("Doing");
        Task_Statuses.add("Done");
        Task_Statuses.add("To Do");

        ArrayList<String> Developer_First_Names = new ArrayList<>();
        Developer_First_Names.add("Mike");
        Developer_First_Names.add("Edward");
        Developer_First_Names.add("Samantha");
        Developer_First_Names.add("Glenda");

        ArrayList<String> Developer_Last_Names = new ArrayList<>();
        Developer_Last_Names.add("Smith");
        Developer_Last_Names.add("Harrison");
        Developer_Last_Names.add("Paulson");
        Developer_Last_Names.add("Oberholzer");

        ArrayList<String> Task_Names = new ArrayList<>();
        Task_Names.add("Create Login");
        Task_Names.add("Create Add Features");
        Task_Names.add("Create Reports");
        Task_Names.add("Add Arrays");

        ArrayList<Integer> Task_Durations = new ArrayList<>();
        Task_Durations.add(5);
        Task_Durations.add(8);
        Task_Durations.add(2);
        Task_Durations.add(11);

        String Status = "Done";

        
        ArrayList<String> result = Task.displayTasksWithStatus(Task_Statuses, Status, Developer_First_Names, Developer_Last_Names, 
                Task_Names, Task_Durations);

        // Assert
        String expResult = "Developer: Samantha Paulson\nTask Name: Create Reports\nDuration: 2 hours";
        Assertions.assertEquals(expResult, result.get(0));
        
        System.out.println("Samantha Paulson, Create Reports, 2 hours\n");
    }
    
    //********************************************************************************************************************************

    @Test
    public void testDeveloperArrayPopulation() 
    {
        System.out.println("dveloperArrayPopulation");
        
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};

        ArrayList<String> Developers_First_Names = new ArrayList<>();
        Developers_First_Names.add("Mike");
        Developers_First_Names.add("Edward");
        Developers_First_Names.add("Samantha");
        Developers_First_Names.add("Glenda");

        ArrayList<String> Developers_Last_Names = new ArrayList<>();
        Developers_Last_Names.add("Smith");
        Developers_Last_Names.add("Harrington");
        Developers_Last_Names.add("Paulson");
        Developers_Last_Names.add("Oberholzer");

        String[] actualDevelopers = new String[Developers_First_Names.size()];
        for (int i = 0; i < Developers_First_Names.size(); i++) 
        {
            actualDevelopers[i] = Developers_First_Names.get(i) + " " + Developers_Last_Names.get(i);
        }

        Assert.assertArrayEquals(expectedDevelopers, actualDevelopers);
        
        System.out.println("\"Mike Smith\", \"Edward Harrington\", \"Samantha Paulson\", \"Glenda Oberholzer\"\n");
    }
    
    //********************************************************************************************************************************

    /**
     * Test of displayTaskWithLongestDuration method, of class Task.
     */
    @Test
    public void testDisplayTaskWithLongestDuration() 
    {
        System.out.println("displayTaskWithLongestDuration");
        
        ArrayList<String> Developer_First_Name = new ArrayList<>();
        Developer_First_Name.add("Mike");
        Developer_First_Name.add("Edward");
        Developer_First_Name.add("Samantha");
        Developer_First_Name.add("Glenda");

        ArrayList<String> Developer_Last_Names = new ArrayList<>();
        Developer_Last_Names.add("Smith");
        Developer_Last_Names.add("Harrison");
        Developer_Last_Names.add("Paulson");
        Developer_Last_Names.add("Oberholzer");

        ArrayList<Integer> Task_Durations = new ArrayList<>();
        Task_Durations.add(5);
        Task_Durations.add(8);
        Task_Durations.add(2);
        Task_Durations.add(11);

        String expResult = "Developer: Glenda Oberholzer\nDuration: 11 hours";
        String Result = Task.displayTaskWithLongestDuration(Developer_First_Name, Developer_Last_Names, Task_Durations);

        assertEquals(expResult, Result);   
        
        System.out.println("Glenda Oberholzer, 11\n");
    }
    
    //********************************************************************************************************************************

    /**
     * Test of searchTaskByName method, of class Task.
     */
    @Test
    public void searchTaskByTaskName() 
    {
        System.out.println("searchTaskByTaskName");
        
        ArrayList<String> Task_Names = new ArrayList<>();
        Task_Names.add("Create Login");
        Task_Names.add("Create Add Features");
        Task_Names.add("Create Reports");
        Task_Names.add("Add Arrays");
        

        ArrayList<String> Developer_First_Names = new ArrayList<>();
        Developer_First_Names.add("Mike");
        Developer_First_Names.add("Edward");
        Developer_First_Names.add("Samantha");
        Developer_First_Names.add("Glenda");

        ArrayList<String> Developer_Last_Names = new ArrayList<>();
        Developer_Last_Names.add("Smith");
        Developer_Last_Names.add("Harrison");
        Developer_Last_Names.add("Paulson");
        Developer_Last_Names.add("Oberholzer");

        ArrayList<String> Task_Statuses = new ArrayList<>();
        Task_Statuses.add("To Do");
        Task_Statuses.add("Doing");
        Task_Statuses.add("Done");
        Task_Statuses.add("To Do");
        
        String Search_Task_Name = "Create Login";
        String expResult = "Task Name: Create Login\nDeveloper: Mike Smith\nTask Status: To Do";
        String Result = Task.searchTaskByTaskName(Task_Names, Developer_First_Names, Developer_Last_Names, Task_Statuses, 
                Search_Task_Name);
        
        assertEquals(expResult, Result);
        
        System.out.println("Mike Smith, Create Login\n");
    }

    //********************************************************************************************************************************
  
    /**
     * Test of searchTasksByDeveloper method, of class Task.
     */
    @Test
    public void testsearchTasksByDeveloperName() 
    {
        System.out.println("searchTasksByDeveloperName");
        
        ArrayList<String> Task_Names = new ArrayList<>();
        Task_Names.add("Create Login");
        Task_Names.add("Create Add Features");
        Task_Names.add("Create Reports");
        Task_Names.add("Add Arrays");
        
        ArrayList<String> Developer_First_Names = new ArrayList<>();
        Developer_First_Names.add("Mike");
        Developer_First_Names.add("Edward");
        Developer_First_Names.add("Samantha");
        Developer_First_Names.add("Glenda");

        ArrayList<String> Developers_Last_Names = new ArrayList<>();
        Developers_Last_Names.add("Smith");
        Developers_Last_Names.add("Harrison");
        Developers_Last_Names.add("Paulson");
        Developers_Last_Names.add("Oberholzer");

        ArrayList<String> Task_Statuses = new ArrayList<>();
        Task_Statuses.add("To Do");
        Task_Statuses.add("Doing");
        Task_Statuses.add("Done");
        Task_Statuses.add("To Do");
        
       String Search_Developer_Full_Name = "Samantha Paulson";
        // Call the method to search tasks by developer
        String expResult = "Task Name: Create Reports\nTask Status: Done";
        ArrayList<String> Result = Task.searchTasksByDeveloperName(Task_Names, Developer_First_Names, Developers_Last_Names,
                Task_Statuses, Search_Developer_Full_Name);

        assertEquals(expResult, Result.get(0));
        
        System.out.println("Create Reports\n");
    }
    
    //********************************************************************************************************************************

    /**
     * Test of deleteTaskByName method, of class Task.
     */
    @Test
    public void testdeleteTaskByTaskName() 
    {
        System.out.println("deleteTaskByTaskName");
        
        ArrayList<String> Task_Names = new ArrayList<>();
        Task_Names.add("Create Login");
        Task_Names.add("Create Add Features");
        Task_Names.add("Create Reports");
        Task_Names.add("Add Arrays");

        ArrayList<String> Developer_First_Names = new ArrayList<>();
        Developer_First_Names.add("Mike");
        Developer_First_Names.add("Edward");
        Developer_First_Names.add("Samantha");
        Developer_First_Names.add("Glenda");

        ArrayList<String> Developer_Last_Names = new ArrayList<>();
        Developer_Last_Names.add("Smith");
        Developer_Last_Names.add("Harrison");
        Developer_Last_Names.add("Paulson");
        Developer_Last_Names.add("Oberholzer");

        ArrayList<String> Task_Statuses = new ArrayList<>();
        Task_Statuses.add("To Do");
        Task_Statuses.add("Doing");
        Task_Statuses.add("Done");
        Task_Statuses.add("To Do");

        String Task_To_Delete = "Create Reports";

        // Call the method to delete the task by name
        String expResult = "Task deleted successfully";
        String Result = Task.deleteTaskByTaskName(Task_Names, Developer_First_Names, Developer_Last_Names, Task_Statuses, 
                Task_To_Delete);
        
        assertEquals(expResult, Result);
        
        System.out.println("Entry “Create reports” successfully deleted\n");
    }

    //********************************************************************************************************************************
    
    /**
     * Test of displayAllTasks method, of class Task.
     */
    @Test
    public void testDisplayAllTasks() 
    {
        System.out.println("deisplayAllTasks");
        
        ArrayList<Integer> Task_Numbers = new ArrayList<>();
        Task_Numbers.add(0);
        Task_Numbers.add(1);
        Task_Numbers.add(2);
        Task_Numbers.add(3);
        
        ArrayList<String> Task_Names = new ArrayList<>();
        Task_Names.add("Create Login");
        Task_Names.add("Create Add Features");
        Task_Names.add("Create Reports");
        Task_Names.add("Add Arrays");
        
        ArrayList<String> Task_Descriptions = new ArrayList<>();
        Task_Descriptions.add("Creating Login Feature");
        Task_Descriptions.add("Creating Add Tasks Feature");
        Task_Descriptions.add("Creating Show Report Feature");
        Task_Descriptions.add("Adding Arrays to store Task Details");
        
        ArrayList<String> Developer_First_Names = new ArrayList<>();
        Developer_First_Names.add("Mike");
        Developer_First_Names.add("Edward");
        Developer_First_Names.add("Samantha");
        Developer_First_Names.add("Glenda");

        ArrayList<String> Developer_Last_Names = new ArrayList<>();
        Developer_Last_Names.add("Smith");
        Developer_Last_Names.add("Harrison");
        Developer_Last_Names.add("Paulson");
        Developer_Last_Names.add("Oberholzer");
        
        ArrayList<Integer> Task_Durations = new ArrayList<>();
        Task_Durations.add(5);
        Task_Durations.add(8);
        Task_Durations.add(2);
        Task_Durations.add(11
        );
        ArrayList<String> Task_IDs = new ArrayList<>();
        Task_IDs.add("CR:0:IKE");
        Task_IDs.add("CR:1:ARD");
        Task_IDs.add("CR:2:THA");
        Task_IDs.add("AD:3:NDA");
        
        ArrayList<String> Task_Statuses = new ArrayList<>();
        Task_Statuses.add("To Do");
        Task_Statuses.add("Doing");
        Task_Statuses.add("Done");
        Task_Statuses.add("To Do");
        
        ArrayList<Integer> Total_Hours = new ArrayList<>();
        Total_Hours.add(0);
        Total_Hours.add(0);
        Total_Hours.add(0);
        Total_Hours.add(0);

        ArrayList<String> result = Task.displayAllTasks(Task_Numbers, Task_Names, Task_Descriptions, Developer_First_Names, 
                Developer_Last_Names, Task_Durations, Task_IDs, Task_Statuses, Total_Hours);
                

        Assertions.assertEquals(4, result.size());

        // Task 1
        Assertions.assertTrue(result.get(0).contains("Task Status: To Do"));
        Assertions.assertTrue(result.get(0).contains("Developer Details: Mike Smith"));
        Assertions.assertTrue(result.get(0).contains("Task Number: 0"));
        Assertions.assertTrue(result.get(0).contains("Task Name: Create Login"));
        Assertions.assertTrue(result.get(0).contains("Task Description: Creating Login Feature"));
        Assertions.assertTrue(result.get(0).contains("Task ID: CR:0:IKE"));
        Assertions.assertTrue(result.get(0).contains("Duration: 5 hours"));

        // Task 2
        Assertions.assertTrue(result.get(1).contains("Task Status: Doing"));
        Assertions.assertTrue(result.get(1).contains("Developer Details: Edward Harrison"));
        Assertions.assertTrue(result.get(1).contains("Task Number: 1"));
        Assertions.assertTrue(result.get(1).contains("Task Name: Create Add Features"));
        Assertions.assertTrue(result.get(1).contains("Task Description: Creating Add Tasks Feature"));
        Assertions.assertTrue(result.get(1).contains("Task ID: CR:1:ARD"));
        Assertions.assertTrue(result.get(1).contains("Duration: 8 hours"));

        // Task 3
        Assertions.assertTrue(result.get(2).contains("Task Status: Done"));
        Assertions.assertTrue(result.get(2).contains("Developer Details: Samantha Paulson"));
        Assertions.assertTrue(result.get(2).contains("Task Number: 2"));
        Assertions.assertTrue(result.get(2).contains("Task Name: Create Reports"));
        Assertions.assertTrue(result.get(2).contains("Task Description: Creating Show Report Feature"));
        Assertions.assertTrue(result.get(2).contains("Task ID: CR:2:THA"));
        Assertions.assertTrue(result.get(2).contains("Duration: 2 hours"));

        // Task 4
        Assertions.assertTrue(result.get(3).contains("Task Status: To Do"));
        Assertions.assertTrue(result.get(3).contains("Developer Details: Glenda Oberholzer"));
        Assertions.assertTrue(result.get(3).contains("Task Number: 3"));
        Assertions.assertTrue(result.get(3).contains("Task Name: Add Arrays"));
        Assertions.assertTrue(result.get(3).contains("Task Description: Adding Arrays to store Task Details"));
        Assertions.assertTrue(result.get(3).contains("Task ID: AD:3:NDA"));
        Assertions.assertTrue(result.get(3).contains("Duration: 11 hours"));
        
        System.out.println("All Tasks successfully displayed");
    }
}
//ST10281011 Akhilesh Parshotam