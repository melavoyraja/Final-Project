/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.House.House;

/**
 *
 * @author puneeth
 */
public class Employee {

    private String name;
    private int age;
    private int id;
    private static int count = 1;
    private boolean hasUserAccount;
    private House house;
//    private SensorDirectory sensorDirectory;

    public Employee() {
        id = count;
        count++;
        hasUserAccount = false;
        house = null;
//        sensorDirectory = new SensorDirectory();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHasUserAccount() {
        return hasUserAccount;
    }

    public void setHasUserAccount(boolean hasUserAccount) {
        this.hasUserAccount = hasUserAccount;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return name;
    }

}
