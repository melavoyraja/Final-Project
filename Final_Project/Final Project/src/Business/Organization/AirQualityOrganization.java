/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AirQualityWorkerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class AirQualityOrganization extends Organization {

    public AirQualityOrganization() {
        super(Organization.Type.AirQuality.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AirQualityWorkerRole());
        return roles;
    }
}
