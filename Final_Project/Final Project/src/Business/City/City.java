/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.City;

import Business.Community.CommunityDirectory;
import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Role.CityAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class City extends Organization {

    private EnterpriseDirectory enterpriseDirectory;
    private CommunityDirectory communityDirectory;
    private int id;
    private static int count = 0;

    public City(String name) {
        super(name);
        enterpriseDirectory = new EnterpriseDirectory();
        communityDirectory = new CommunityDirectory();
        count++;
        id = count;
    }

    public CommunityDirectory getCommunityDirectory() {
        return communityDirectory;
    }

    public void setCommunityDirectory(CommunityDirectory communityDirectory) {
        this.communityDirectory = communityDirectory;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CityAdminRole());
        return roles;
    }

}
