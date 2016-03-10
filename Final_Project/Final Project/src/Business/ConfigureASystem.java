package Business;

import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author puneeth
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("System Admin");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("SYSADMIN", "SYSADMIN", employee, new SystemAdminRole());
        
        return system;
    }
    
}
