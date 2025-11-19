//ST10281011 Akhilesh Parshotam

package st10281011_prog5121_poe_part_3;
import javax.swing.JOptionPane;

/**
 *
 * @author ST10281011 Akhilesh
 */
public class Login 
{
    
    //Method to check if the Username meets the length requirments and contains and underscore("_"). 
    public static boolean checkUserName(String Username)
    {
        return (Username.length() <= 5  //Checks if username is no more then 5 characters long
                && Username.contains("_"));  //Checks if username contains an underscore
    }
    
    //*********************************************************************************************************************************
    
    /*
    Method to check if the Password meets the length requirments, contains a capital letter a number 
    and a special character.
    */ 
    public static boolean checkPasswordComplexity(String Password)
    {
        return (Password.length() >= 8 //Checks if password is at least 8 characters long
                && Password.matches(".*[A-Z].*") //Checks if password contains a Capital letter.
                && Password.matches(".*\\d.*") //Checks if password contains a number.
                && Password.matches(".*[!@#$%^&*()].*")); //Checks if password contains a special character.      
    }
    
    //************************************************************************************************************************************
    
    //Method that propts the user a enter their first name, last name, username and password to register their account.
    public static String reqisterUser(String Username, String Password,String First_Name, String Last_Name, String Full_Name)       
    {
        JOptionPane.showMessageDialog(null, "Please create and register your account.");

        First_Name = JOptionPane.showInputDialog("Please enter your First Name: ");
        Last_Name = JOptionPane.showInputDialog("Please enter your Last Name: ");

         Full_Name = First_Name + ", " + Last_Name;
         
        /*
        A while loop that prompts the user to enter a Username that meets the length requirments and contains and underscore. 
        Displaying the appropriate messaging when the the Username is inputed correctly and when the Username is inputted incorrectly 
        */ 
        
        //Attribution for a While loop https://www.w3schools.com/java/java_while_loop.asp 
        while (true) 
        {
            Username = JOptionPane.showInputDialog("Please create a Username that is no more than 5 characters in length and contains "
                                                    + "an underscore: ");
            
            if (checkUserName(Username)) 
            {
                JOptionPane.showMessageDialog(null, "Username successfully captured");
                break;
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains "
                        + "an underscore and is no more than 5 characters in length.");
            }
        }

        /*
        A while loop that prompts the user to enter a Password that meets the length requirments and the complexity rules.
        Displaying the appropriate messaging when the the Password is inputed correctly and when the Password is inputted incorrectly.
        */
        while (true) 
        {
            Password = JOptionPane.showInputDialog("Please create a Password that is at least 8 characters long, contains a capital "
                                                     + "letter, a number and a special character: ");
            
            if (checkPasswordComplexity(Password)) 
            {
                JOptionPane.showMessageDialog(null, "Password successfully captured.");
                break;
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains "
                                                 + "at least 8 characters, a capital letter, a number and a special character.");
            }
        }
        return Full_Name;
        
    } 
    
    //****************************************************************************************************************************************************
    
    //Method that checks if the registration details entered in the reqisterUser Method matches the login details entered.
    public static boolean loginUser(String Username, String Password)
    {
          return ((Username.equals(Username)) && (Password.equals(Password)));  
    }
    
    //*************************************************************************************************************************************************
    
    //Method that propts the user a enter their first name, last name, username and password to login to their account.
    public static String returnLoginStatus(String Username, String Password, String Full_Name)
    {
//        Scanner scan = new Scanner(System.in);
        
        String login = JOptionPane.showInputDialog("Would you like to Login to Your Account (Y/N)");
             
        // A switch statement that asks the uesr weather or not they would like to login the their account.
        
        //Attribution for a Switch Statement https://www.w3schools.com/java/java_switch.asp
        switch (login) 
        {
            case "Y":
                /*
                While loop that prompts the user to enter their Username & Password that matches the Username & Password entered 
                in the reqisterUser Method Displaying the appropriate messaging when the the Username & Password is inputed correctly 
                and when the Username & Password is inputted incorrectly.
                */
                while(true) 
                {
                        Username = JOptionPane.showInputDialog("Please enter your Username: " );

                        Password = JOptionPane.showInputDialog("Please enter your Password: ");
            
                    if ((checkUserName(Username)) && (checkPasswordComplexity(Password)))
                    {
                            JOptionPane.showMessageDialog(null, "Welcome "+ Full_Name + " it is great to see you again.");
                        return "continue";
                    }
                    else 
                    {
                         JOptionPane.showMessageDialog(null, "Username or Password incorrect, please try again");    
                    }
                }
                
            case "N":
                return "exit";
                 
            default:
                return "exit"; 
        }
    }
}

//ST10281011 Akhilesh Parshotam    

