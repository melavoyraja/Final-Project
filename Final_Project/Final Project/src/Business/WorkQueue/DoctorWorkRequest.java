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
public class DoctorWorkRequest extends WorkRequest {

//    private VitalSign VitalSign;
//    
//    public VitalSign getVitalSign() {
//        return VitalSign;
//    }
//
//    public void setVitalSign(VitalSign VitalSign) {
//        this.VitalSign = VitalSign;
//    }

    @Override
    public String toString() {
        return super.getSensor().getUserAccount().getEmployee().getName();
    }

}
