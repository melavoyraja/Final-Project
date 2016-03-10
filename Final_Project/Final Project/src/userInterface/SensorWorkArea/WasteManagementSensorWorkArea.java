/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SensorWorkArea;

import Business.Organization.Organization;
import Business.Organization.WasteManagementOrganization;
import Business.Sensor.Sensor;
import Business.Sensor.WasteManagementSensor;
import Business.SensorData.SensorData;
import Business.SensorData.WasteLevelSensorData;
import Business.WorkQueue.WasteManagementWorkRequest;
import Business.WorkQueue.WorkRequest;
import EDU.purdue.cs.bloat.shrink.Main;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.CardLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puneeth
 */
public class WasteManagementSensorWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form WasteManagementSensorWorkArea
     */
    private JPanel userProcessContainer;
    private WasteManagementSensor sensor;
    private Organization organization;
    private WasteManagementOrganization wasteManagementOrganization;
    private String image;
    private int random;
    
    public WasteManagementSensorWorkArea(JPanel userProcessContainer, WasteManagementSensor sensor, Organization organization, WasteManagementOrganization wasteManagementOrganization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.sensor = sensor;
        this.organization = organization;
        this.wasteManagementOrganization = wasteManagementOrganization;
        image = readImage();
        random = 0;
        populateSensorData();
    }
    
    public void populateSensorData() {
        DefaultTableModel model = (DefaultTableModel) sensorDataTable.getModel();
        model.setRowCount(0);
        
        sensor.getSensorDataDirectory().getSensorDataList().stream().filter((wmsd) -> (wmsd instanceof WasteLevelSensorData)).map((wmsd) -> {
            Object[] row = new Object[3];
            row[0] = wmsd;
            row[1] = wmsd.getDataRecordedDate();
            row[2] = ((WasteLevelSensorData) wmsd).getLevelOfConcern();
            return row;
        }).forEach((row) -> {
            model.addRow(row);
        });
        
    }
    
    public String readImage() {
        BufferedImage img;
        String image = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            img = ImageIO.read(new File("noimage.jpg"));
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            image = Base64.encode(baos.toByteArray());
            baos.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return image;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        wasteLevelJText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        sensorDataTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Generate Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Last Generated Waste Level:");

        wasteLevelJText.setEnabled(false);

        sensorDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Waste Level", "TimeStamp", "Levels of Concern"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(sensorDataTable);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("Waste Level Sensor Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(444, 444, 444)
                        .addComponent(wasteLevelJText, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(152, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wasteLevelJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(101, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int randomWasteLevel = 0;
        if (random < 6) {
            randomWasteLevel = sensor.randomWasteLevel(true);            
            random++;
            if (random == 5) {
                random = 0;
                randomWasteLevel = sensor.randomWasteLevel(false);                
            }
        }
        SensorData wmsd = sensor.getSensorDataDirectory().addSensorData(Sensor.SensorType.Waste);
        ((WasteLevelSensorData) wmsd).setWasteLevel(randomWasteLevel);
        String levelOfAQI = ((WasteLevelSensorData) wmsd).getLevelOfConcern();
        if (levelOfAQI.equals("Unhealthy") || levelOfAQI.equals("Hazardos")) {
            WorkRequest wmwr = new WasteManagementWorkRequest();
            wasteManagementOrganization.getWorkQueue().getWorkRequestList().add(wmwr);
            organization.getWorkQueue().getWorkRequestList().add(wmwr);
            wmwr.setMessage(levelOfAQI);
            wmwr.setRequestDate(new Date());
            wmwr.setStatus("Sent");
//            wmwr.setHouse(sensor.getHouse());
            ((WasteManagementWorkRequest) wmwr).setImage(image);
            ((WasteManagementWorkRequest) wmwr).setType(WorkRequest.RequestType.Sensor);
            ((WasteManagementWorkRequest) wmwr).setOrganization(organization);
            wmwr.setSensorData(wmsd);
            wmwr.setSensor(sensor);
        }
        wasteLevelJText.setText(String.valueOf(randomWasteLevel));
        populateSensorData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sensorDataTable;
    private javax.swing.JTextField wasteLevelJText;
    // End of variables declaration//GEN-END:variables
}