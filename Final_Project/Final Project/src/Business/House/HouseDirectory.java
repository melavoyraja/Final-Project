/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.House;

import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class HouseDirectory {
    private ArrayList<House> houseList;

    public HouseDirectory(){
        houseList = new ArrayList<>();
    }
    
    public ArrayList<House> getHouseList() {
        return houseList;
    }

    public void setHouseList(ArrayList<House> houseList) {
        this.houseList = houseList;
    }
    
    
}
