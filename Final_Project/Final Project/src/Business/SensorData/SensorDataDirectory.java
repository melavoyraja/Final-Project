/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SensorData;

import Business.Sensor.Sensor.SensorType;
import java.util.ArrayList;

/**
 *
 * @author puneeth
 */
public class SensorDataDirectory {

    private ArrayList<SensorData> sensorDataList;

    public SensorDataDirectory() {
        sensorDataList = new ArrayList<>();
    }

    public ArrayList<SensorData> getSensorDataList() {
        return sensorDataList;
    }

    public void setSensorDataList(ArrayList<SensorData> sensorDataList) {
        this.sensorDataList = sensorDataList;
    }

    public SensorData addSensorData(SensorType type) {

        SensorData sensorData = null;

        if (type.getValue().equals(SensorType.Air.getValue())) {
            sensorData = new AirQualitySensorData();
            sensorDataList.add(sensorData);
        } else if (type.getValue().equals(SensorType.Waste.getValue())) {
            sensorData = new WasteLevelSensorData();
            sensorDataList.add(sensorData);
        } else if (type.getValue().equals(SensorType.Water.getValue())) {
            sensorData = new WaterQualitySensorData();
            sensorDataList.add(sensorData);
        } else if (type.getValue().equals(SensorType.VitalSigns.getValue())) {
            sensorData = new VitalSignsSensorData();
            sensorDataList.add(sensorData);
        }

        return sensorData;
    }

}
