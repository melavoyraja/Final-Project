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
public class WaterQualitySensor extends Sensor {

    public int randomWQI(boolean inOut) {
        int randomInt = 0;
        if (inOut) {
            randomInt = getRandomNumberInRange(65, 100);
        } else {
            randomInt = getRandomNumberInRange(0, 64);
        }
//        int randomWaterQuality = 0;
//
//        Random randomGenerator = new Random();
//        randomWaterQuality = randomGenerator.nextInt(101);

        return randomInt;
    }

}
