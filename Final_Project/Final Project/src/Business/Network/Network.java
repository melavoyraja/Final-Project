/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.City.City;
import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class Network {

    private String name;
    private ArrayList<City> cityList;
    private int id;

    private static int count = 0;

    public Network() {
        cityList = new ArrayList<>();
        count++;
        id = count;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<City> cityList) {
        this.cityList = cityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public City addCity(String name){
        City city = new City(name);
        cityList.add(city);
        return city; 
    }
    
}
