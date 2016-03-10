/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import Business.VitalSign.VitalSign;
import java.util.Random;

/**
 *
 * @author puneeth
 */
public class VitalSignsSensor extends Sensor {

    public VitalSign randomVitalSigns(boolean inOut, int age) {
        VitalSign vs = new VitalSign();
        int respiratoryRate = 0;
        int heartRate = 0;
        int bloodPressure = 0;
        int weight = 0;

        /*Toddler*/
        if (age >= 1 && age <= 3) {
            if (inOut) {
                respiratoryRate = getRandomNumberInRange(21, 30);
                heartRate = getRandomNumberInRange(81, 130);
                bloodPressure = getRandomNumberInRange(81, 110);
                weight = getRandomNumberInRange(23, 30);
            } else {
                respiratoryRate = getRandomNumberInRange(31, 40);
                heartRate = getRandomNumberInRange(131, 140);
                bloodPressure = getRandomNumberInRange(111, 130);
                weight = getRandomNumberInRange(32, 200);
            }
        }

        /*Preschooler*/
        if (age >= 4 && age <= 5) {
            if (inOut) {
                respiratoryRate = getRandomNumberInRange(21, 30);
                heartRate = getRandomNumberInRange(81, 120);
                bloodPressure = getRandomNumberInRange(81, 110);
                weight = getRandomNumberInRange(32, 40);
            } else {
                respiratoryRate = getRandomNumberInRange(31, 40);
                heartRate = getRandomNumberInRange(121, 140);
                bloodPressure = getRandomNumberInRange(111, 130);
                weight = getRandomNumberInRange(41, 200);
            }

        }
        /*School Age*/
        if (age >= 6 && age <= 12) {
            if (inOut) {
                respiratoryRate = getRandomNumberInRange(21, 30);
                heartRate = getRandomNumberInRange(71, 110);
                bloodPressure = getRandomNumberInRange(81, 120);
                weight = getRandomNumberInRange(42, 92);
            } else {
                respiratoryRate = getRandomNumberInRange(31, 40);
                heartRate = getRandomNumberInRange(111, 140);
                bloodPressure = getRandomNumberInRange(121, 130);
                weight = getRandomNumberInRange(93, 200);
            }
        }

        /*Adolescent*/
        if (age >= 13) {
            if (inOut) {
                respiratoryRate = getRandomNumberInRange(13, 20);
                heartRate = getRandomNumberInRange(56, 105);
                bloodPressure = getRandomNumberInRange(111, 120);
                weight = getRandomNumberInRange(111, 200);
            } else {
                respiratoryRate = getRandomNumberInRange(21, 40);
                heartRate = getRandomNumberInRange(106, 140);
                bloodPressure = getRandomNumberInRange(121, 130);
                weight = getRandomNumberInRange(201, 300);
            }
        }

        vs.setRespiratoryRate(respiratoryRate);
        vs.setHeartRate(heartRate);
        vs.setBloodPressure(bloodPressure);
        vs.setWeight(weight);

        return vs;
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
