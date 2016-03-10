/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author puneeth
 */
public class WasteManagementWorkRequest extends WorkRequest {

    private String image;
    // private WasteLevelSensorData wasteLevelSensorData;
    private RequestType type;

//    public WasteLevelSensorData getWasteLevelSensorData() {
//        return wasteLevelSensorData;
//    }
//
//    public void setWasteLevelSensorData(WasteLevelSensorData wasteLevelSensorData) {
//        this.wasteLevelSensorData = wasteLevelSensorData;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return String.valueOf(type.toString());
    }

}
