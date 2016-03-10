/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import static Business.Sensor.VitalSignsSensor.getRandomNumberInRange;

/**
 *
 * @author puneeth
 */
public class AirQualitySensor extends Sensor {

    public int randomAQI(boolean inOut) {
        int randomInt = 0;
        if (inOut) {
            randomInt = getRandomNumberInRange(0, 150);
        } else {
            randomInt = getRandomNumberInRange(151, 500);
        }

//        Random randomGenerator = new Random();
//        int randomInt = randomGenerator.nextInt(501);
//        Random randomGenerator1 = new Random();
//        int randomInt1 = randomGenerator.nextInt(20);
//        if (randomInt1 == 0) {
//            randomInt1 = 1;
//        }
//        randomInt = (Integer) randomInt / randomInt1;
        return randomInt;
    }

    /*public AirQualitySensorData saveSensorData(int sensorData) {
        
        
     SensorData aqi = super.getSensorDataDirectory().getSensorDataList().
     ((AirQualitySensorData)aqi).setAirQualityIndex(sensorData);
     dataList.add(aqi);
     return aqi;
     }*/
}
