/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.HouseholderRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class HouseholdOrganization extends Organization {

    public String address;
    
    public HouseholdOrganization() {
        super(Organization.Type.Household.getValue());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new HouseholderRole());
        return roles;
    }
}
