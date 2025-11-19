//ST10281011 Akhilesh Parshotam

package st10281011_prog5121_poe_part_3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**
 *
 * @author ST10281011 Akhilesh
 */
public class LoginTest 
{ 
    public LoginTest() 
    {
       
    }

    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserName() 
    {
        System.out.println("checkUserName");
        String Username = "Kyl_1";
        boolean expResult = true;
        boolean result = Login.checkUserName(Username);
        assertEquals(expResult, result);
        System.out.println("Welcome Kyle, Parshotam it is great to see you");
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() 
    {
        System.out.println("checkPasswordComplexity");
        String Password = "Ch&&sec@ke99!";
        boolean expResult = true;
        boolean result = Login.checkPasswordComplexity(Password);
        assertEquals(expResult, result);
        System.out.println("Password successfully captured");
      
    }

}
//ST10281011 Akhilesh Parshotam

