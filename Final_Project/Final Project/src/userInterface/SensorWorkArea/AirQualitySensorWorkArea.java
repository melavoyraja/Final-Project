/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SensorWorkArea;

import Business.Organization.AirQualityOrganization;
import Business.Organization.Organization;
import Business.Sensor.AirQualitySensor;
import Business.Sensor.Sensor;
import Business.SensorData.AirQualitySensorData;
import Business.SensorData.SensorData;
import Business.WorkQueue.AirQualityWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puneeth
 */
public class AirQualitySensorWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form AirQualitySensor
     */
    private JPanel userProcessContainer;
    private AirQualitySensor sensor;
    private Organization organization;
    private AirQualityOrganization airQualityOrganization;
    private int random;
    
    public AirQualitySensorWorkArea(JPanel userProcessContainer, AirQualitySensor sensor, Organization organization, AirQualityOrganization airQualityOrganization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.sensor = sensor;
        this.organization = organization;
        this.airQualityOrganization = airQualityOrganization;
        random = 0;
        populateSensorData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sensorDataTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        aqiJText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        sensorDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AQI", "TimeStamp", "Levels of Health Concern"
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

        jLabel1.setText("Last Generated Air Quality Index:");

        aqiJText.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("Air Quality Sensor Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(444, 444, 444)
                            .addComponent(aqiJText, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButton2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1))
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel2)))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aqiJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void populateSensorData() {
        DefaultTableModel model = (DefaultTableModel) sensorDataTable.getModel();
        model.setRowCount(0);
        
        sensor.getSensorDataDirectory().getSensorDataList().stream().filter((aqi) -> (aqi instanceof AirQualitySensorData)).map((aqi) -> {
            Object[] row = new Object[3];
            row[0] = aqi;
            row[1] = aqi.getDataRecordedDate();
            row[2] = ((AirQualitySensorData) aqi).getLevelOfHealthConcern();
            return row;
        }).forEach((row) -> {
            model.addRow(row);
        });
        
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int randomAQI = 0;
        if (random < 6) {
            randomAQI = sensor.randomAQI(true);            
            random++;
            if (random == 5) {
                random = 0;
                randomAQI = sensor.randomAQI(false);                
            }
        }
        
        SensorData aqi = sensor.getSensorDataDirectory().addSensorData(Sensor.SensorType.Air);
        ((AirQualitySensorData) aqi).setAirQualityIndex(randomAQI);
        String levelOfAQI = ((AirQualitySensorData) aqi).getLevelOfHealthConcern();
        if (levelOfAQI.equals("Unhealthy") || levelOfAQI.equals("Very Unhealthy") || levelOfAQI.equals("Hazardos")) {
            WorkRequest aqwr = new AirQualityWorkRequest();
            airQualityOrganization.getWorkQueue().getWorkRequestList().add(aqwr);
            organization.getWorkQueue().getWorkRequestList().add(aqwr);
            aqwr.setMessage(levelOfAQI);
            aqwr.setRequestDate(new Date());
            aqwr.setStatus("Sent");
            ((AirQualityWorkRequest) aqwr).setOrganization(organization);
            aqwr.setSensorData(aqi);
            aqwr.setSensor(sensor);
            if(levelOfAQI.equals("Hazardos")){
            playSound();    
            }
            
            
        }
        aqiJText.setText(String.valueOf(randomAQI));
        populateSensorData();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed
public void playSound() {
        try {
            /*InputStream in = new FileInputStream("bird.wav");
             AudioStream audioStream = new AudioStream(in);
             AudioPlayer.player.start(audioStream);*/

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("siren.wav").getAbsoluteFile());
            AudioFormat audioFormat = audioInputStream.getFormat();

            SourceDataLine line = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();

            int nBytesRead = 0;
            byte[] abData = new byte[1000];
            while (nBytesRead != -1) {
                try {
                    nBytesRead = audioInputStream.read(abData, 0, abData.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (nBytesRead >= 0) {
                    int nBytesWritten = line.write(abData, 0, nBytesRead);
                }
            }

            line.drain();
            line.close();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aqiJText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sensorDataTable;
    // End of variables declaration//GEN-END:variables
}
