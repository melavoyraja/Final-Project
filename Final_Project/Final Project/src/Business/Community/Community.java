/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Community;

import Business.House.House;
import Business.House.HouseDirectory;

/**
 *
 * @author puneeth
 */
public class Community {

    private String communityName;
    private int id;
    private HouseDirectory houseDirectory;

    private static int count = 0;

    public Community() {
        houseDirectory = new HouseDirectory();
        count++;
        id = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public HouseDirectory getHouseDirectory() {
        return houseDirectory;
    }

    public void setHouseDirectory(HouseDirectory houseDirectory) {
        this.houseDirectory = houseDirectory;
    }
    
    @Override
    public String toString() {
        return communityName;
    }

    public House createAndAddHouse() {
        House house = new House();
        houseDirectory.getHouseList().add(house);
        return house;
    }

}
