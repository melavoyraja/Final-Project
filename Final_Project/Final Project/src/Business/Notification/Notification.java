/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Notification;

import java.util.Date;

/**
 *
 * @author puneeth
 */
public class Notification {
    private Date notificationDate;
    private String message;

    public Notification(){
        notificationDate = new Date();
    }
    
    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.valueOf(notificationDate);
    }
    
}
