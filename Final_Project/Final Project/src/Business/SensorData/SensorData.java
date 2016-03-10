/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SensorData;

import java.util.Date;

/**
 *
 * @author puneeth
 */
public class SensorData {
    private Date dataRecordedDate;

    public SensorData(){
        dataRecordedDate = new Date();
    }
    
    public Date getDataRecordedDate() {
        return dataRecordedDate;
    }

    public void setDataRecordedDate(Date dataRecordedDate) {
        this.dataRecordedDate = dataRecordedDate;
    }
    
}
