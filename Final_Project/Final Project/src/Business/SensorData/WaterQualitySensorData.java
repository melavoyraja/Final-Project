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
public class WaterQualitySensorData extends SensorData{
    private int waterQualityIndex;
    private String levelOfConcern;

    public int getWaterQualityIndex() {
        return waterQualityIndex;
    }

    public void setWaterQualityIndex(int waterQualityIndex) {
        
        if(waterQualityIndex >= 95 && waterQualityIndex <= 100){
            levelOfConcern = "Excellent";
        }else if(waterQualityIndex >= 80 && waterQualityIndex <= 94){
            levelOfConcern = "Good";
        }else if(waterQualityIndex >= 65 && waterQualityIndex <= 79){
            levelOfConcern = "Fair";
        }else if(waterQualityIndex >= 45 && waterQualityIndex <= 64){
            levelOfConcern = "Marginal";
        }else if(waterQualityIndex >= 0 && waterQualityIndex <= 44){
            levelOfConcern = "Poor";
        }
        
        this.waterQualityIndex = waterQualityIndex;
    }

    public String getLevelOfConcern() {
        return levelOfConcern;
    }

    public void setLevelOfConcern(String levelOfConcern) {
        this.levelOfConcern = levelOfConcern;
    }
    
    @Override
    public String toString() {
        return String.valueOf(waterQualityIndex);
    }
}
