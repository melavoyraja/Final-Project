/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SensorData;

/**
 *
 * @author puneeth
 */
public class WasteLevelSensorData extends SensorData{
    
    private int wasteLevel;
    private String levelOfConcern;

    public int getWasteLevel() {
        return wasteLevel;
    }

    public void setWasteLevel(int wasteLevel) {
        if(wasteLevel >= 0 && wasteLevel <= 60){
            levelOfConcern = "Good";
        }else if(wasteLevel >= 61 && wasteLevel <= 80){
            levelOfConcern = "Moderate";
        }else if(wasteLevel >= 81 && wasteLevel <= 90){
            levelOfConcern = "Unhealthy";
        }else if(wasteLevel >= 91 && wasteLevel <= 100){
            levelOfConcern = "Hazardos";
        }
        this.wasteLevel = wasteLevel;
    }

    public String getLevelOfConcern() {
        return levelOfConcern;
    }

    public void setLevelOfConcern(String levelOfConcern) {
        this.levelOfConcern = levelOfConcern;
    }
    
    @Override
    public String toString() {
        return String.valueOf(wasteLevel);
    }
}
