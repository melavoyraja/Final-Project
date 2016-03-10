/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.City.City;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.WasteManagementOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.WasteManagementWorkArea.WasteManagementWorkerWorkAreaJPanel;

/**
 *
 * @author puneeth
 */
public class WasteManagementWorkerRole extends Role{
    

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, City city, EcoSystem system) {
        return new WasteManagementWorkerWorkAreaJPanel(userProcessContainer, account, (WasteManagementOrganization)organization, enterprise);
    }
}
