/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.City.City;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.HouseholdOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.HouseholderWorkArea.HouseholderWorkAreaJPanel;

/**
 *
 * @author puneeth
 */
public class HouseholderRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, City city, EcoSystem system) {
        return new HouseholderWorkAreaJPanel(userProcessContainer, account, (HouseholdOrganization) organization, enterprise,city);
    }

}
