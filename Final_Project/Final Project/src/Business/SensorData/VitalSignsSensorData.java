/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SensorData;

import Business.VitalSign.VitalSign;

/**
 *
 * @author puneeth
 */
public class VitalSignsSensorData extends SensorData {

    private VitalSign vitalSign;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public VitalSign getVitalSign() {
        return vitalSign;
    }

    public void setVitalSign(VitalSign vitalSign) {
        
        this.vitalSign = vitalSign;
    }

    
}
