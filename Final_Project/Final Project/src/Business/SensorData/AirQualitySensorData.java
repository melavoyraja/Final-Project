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
public class AirQualitySensorData extends SensorData{

    private int airQualityIndex;
    private String levelOfHealthConcern;


    public int getAirQualityIndex() {
        return airQualityIndex;
    }

    public String getLevelOfHealthConcern() {
        return levelOfHealthConcern;
    }

    public void setLevelOfHealthConcern(String levelOfHealthConcern) {
        this.levelOfHealthConcern = levelOfHealthConcern;
    }

    public void setAirQualityIndex(int airQualityIndex) {
        if(airQualityIndex >= 0 && airQualityIndex <= 50){
            levelOfHealthConcern = "Good";
        }else if(airQualityIndex >= 51 && airQualityIndex <= 100){
            levelOfHealthConcern = "Moderate";
        }else if(airQualityIndex >= 101 && airQualityIndex <= 150){
            levelOfHealthConcern = "Fair";
        }else if(airQualityIndex >= 151 && airQualityIndex <= 200){
            levelOfHealthConcern = "Unhealthy";
        }else if(airQualityIndex >= 201 && airQualityIndex <= 300){
            levelOfHealthConcern = "Very Unhealthy";
        }else if(airQualityIndex >= 301 && airQualityIndex <= 500){
            levelOfHealthConcern = "Hazardos";
        }        
        
        this.airQualityIndex = airQualityIndex;
    }

    @Override
    public String toString() {
        return String.valueOf(airQualityIndex);
    }

}
