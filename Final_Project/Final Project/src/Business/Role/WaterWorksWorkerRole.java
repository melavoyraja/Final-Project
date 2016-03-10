/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.City.City;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.WaterWorksOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.WaterWorksWorkerWorkArea.WaterWorksWorkerWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class WaterWorksWorkerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, City city, EcoSystem business) {
        return new WaterWorksWorkerWorkAreaJPanel(userProcessContainer, account, (WaterWorksOrganization)organization, enterprise);
    }
    
    
}
