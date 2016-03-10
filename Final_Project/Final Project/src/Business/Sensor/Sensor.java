/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import Business.SensorData.SensorDataDirectory;
import Business.UserAccount.UserAccount;

/**
 *
 * @author puneeth
 */
public abstract class Sensor {

    private int sensorID;
    private String name;
    private String moreDetails;
    private SensorDataDirectory sensorDataDirectory;
    private UserAccount userAccount;
    // private House house;
    private double latitude;
    private double longitude;

    private static int count;

    public Sensor() {
        count++;
        sensorID = count;
        sensorDataDirectory = new SensorDataDirectory();
        // house = null;
    }

    public enum SensorType {

        Air("Air Quality Sensor"),
        Waste("Waste Management Sensor"),
        Water("Water Works Sensor"),
        VitalSigns("Vital Signs Sensor");

        private String value;

        private SensorType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    public int getSensorID() {
        return sensorID;
    }

    public void setSensorID(int sensorID) {
        this.sensorID = sensorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

//    public House getHouse() {
//        return house;
//    }
//
//    public void setHouse(House house) {
//        this.house = house;
//    }

    public String getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(String moreDetails) {
        this.moreDetails = moreDetails;
    }

    public SensorDataDirectory getSensorDataDirectory() {
        return sensorDataDirectory;
    }

    public void setSensorDataDirectory(SensorDataDirectory sensorDataDirectory) {
        this.sensorDataDirectory = sensorDataDirectory;
    }

    @Override
    public String toString() {
        return String.valueOf(sensorID);
    }

}
