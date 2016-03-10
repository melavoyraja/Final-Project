/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())) {
            organization = new DoctorOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.WaterWorks.getValue())) {
            organization = new WaterWorksOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.WasteManagement.getValue())) {
            organization = new WasteManagementOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.AirQuality.getValue())) {
            organization = new AirQualityOrganization();
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Household.getValue())) {
            organization = new HouseholdOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}
