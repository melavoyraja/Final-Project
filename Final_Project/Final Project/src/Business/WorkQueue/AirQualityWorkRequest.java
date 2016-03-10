/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.SensorData.AirQualitySensorData;

/**
 *
 * @author puneeth
 */
public class AirQualityWorkRequest extends WorkRequest {

    @Override
    public String toString() {
        return String.valueOf(((AirQualitySensorData)super.getSensorData()).getAirQualityIndex());
//        return String.valueOf(aqi.getAirQualityIndex());
    }
    
}
