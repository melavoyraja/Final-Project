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
public class WasteManagementSensor extends Sensor {

    public int randomWasteLevel(boolean inOut) {
        int randomWasteLevel = 0;
        if (inOut) {
            randomWasteLevel = getRandomNumberInRange(0, 80);
        } else {
            randomWasteLevel = getRandomNumberInRange(81, 100);
        }
//        Random randomGenerator = new Random();
//        randomWasteLevel = randomGenerator.nextInt(101);   
//        
        return randomWasteLevel;
    }

}
