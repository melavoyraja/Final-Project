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
public class WaterWorksWorkRequest extends WorkRequest {

    private String image;
//    private WaterQualitySensorData waterQualitySensorData;
    private RequestType type;

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public WaterQualitySensorData getWaterQualitySensorData() {
//        return waterQualitySensorData;
//    }
//
//    public void setWaterQualitySensorData(WaterQualitySensorData waterQualitySensorData) {
//        this.waterQualitySensorData = waterQualitySensorData;
//    }

    @Override
    public String toString() {
        return type.toString();
    }

    
}
