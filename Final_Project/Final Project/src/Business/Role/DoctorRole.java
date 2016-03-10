/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.City.City;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.DoctorWorkArea.DoctorWorkAreaJPanel;

/**
 *
 * @author puneeth
 */
public class DoctorRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, City city, EcoSystem system) {
        return new DoctorWorkAreaJPanel(userProcessContainer, account, (DoctorOrganization) organization, enterprise);
    }

}
