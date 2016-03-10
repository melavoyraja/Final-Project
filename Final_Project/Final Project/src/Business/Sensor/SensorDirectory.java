/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Sensor;

import Business.Sensor.Sensor.SensorType;
import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class SensorDirectory {

    private ArrayList<Sensor> sensorList;

    public SensorDirectory() {
        sensorList = new ArrayList<>();
    }

    public Sensor createAndAddSensor(SensorType type) {
        Sensor sensor = null;
        if (type.getValue().equals(SensorType.Air.getValue())) {
            sensor = new AirQualitySensor();
            sensorList.add(sensor);
        } else if (type.getValue().equals(SensorType.Water.getValue())) {
            sensor = new WaterQualitySensor();
            sensorList.add(sensor);
        } else if (type.getValue().equals(SensorType.Waste.getValue())) {
            sensor = new WasteManagementSensor();
            sensorList.add(sensor);
        } else if (type.getValue().equals(SensorType.VitalSigns.getValue())) {
            sensor = new VitalSignsSensor();
            sensorList.add(sensor);
        }
        return sensor;
    }

    public ArrayList<Sensor> getSensorList() {
        return sensorList;
    }

    public void setSensorList(ArrayList<Sensor> sensorList) {
        this.sensorList = sensorList;
    }
}
