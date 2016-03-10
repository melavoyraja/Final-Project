/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.WaterWorksWorkerRole;
import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class WaterWorksOrganization extends Organization{

    public WaterWorksOrganization() {
        super(Organization.Type.WaterWorks.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new WaterWorksWorkerRole());
        return roles;
    }
    
}
