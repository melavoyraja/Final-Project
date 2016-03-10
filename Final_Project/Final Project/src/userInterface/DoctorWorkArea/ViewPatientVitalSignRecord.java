/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DoctorWorkArea;

import Business.Sensor.Sensor;
import Business.SensorData.SensorData;
import Business.SensorData.SensorDataDirectory;
import Business.SensorData.VitalSignsSensorData;
import Business.VitalSign.VitalSign;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author puneeth
 */
public class ViewPatientVitalSignRecord extends javax.swing.JPanel {

    /**
     * Creates new form ViewPatientVitalSignRecord
     */
    private JPanel userProcessContainer;
    private Sensor sensor;
    private String employeeName;
    private SensorDataDirectory sdd;

    public ViewPatientVitalSignRecord(JPanel userProcessContainer, Sensor sensor) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.sensor = sensor;
        employeeName = sensor.getUserAccount().getEmployee().getName();
        sdd = sensor.getSensorDataDirectory();
        drawLineChart();

    }

    public void drawLineChart() {
        JFreeChart barChart = ChartFactory.createLineChart(
                "Blood Pressure",
                employeeName,
                "Value",
                createDataset(sdd, employeeName),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setSize(jPanel2.getHeight(), jPanel2.WIDTH);
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(chartPanel);

        JFreeChart barChart1 = ChartFactory.createLineChart(
                "Respiratory Rate",
                employeeName,
                "Value",
                createDataset1(sdd, employeeName),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel2 = new ChartPanel(barChart1);
        chartPanel2.setSize(jPanel1.getHeight(), jPanel1.WIDTH);
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(chartPanel2);

        JFreeChart barChart2 = ChartFactory.createLineChart(
                "Heart Rate",
                employeeName,
                "Value",
                createDataset2(sdd, employeeName),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel3 = new ChartPanel(barChart2);
        chartPanel2.setSize(jPanel3.getHeight(), jPanel3.WIDTH);
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(chartPanel3);

        JFreeChart barChart3 = ChartFactory.createLineChart(
                "Weight",
                employeeName,
                "Value",
                createDataset3(sdd, employeeName),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel4 = new ChartPanel(barChart3);
        chartPanel2.setSize(jPanel4.getHeight(), jPanel4.WIDTH);
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel4.add(chartPanel4);
    }

    private CategoryDataset createDataset(SensorDataDirectory sd, String personName) {
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        for (SensorData sensorData : sdd.getSensorDataList()) {
            VitalSign vs = ((VitalSignsSensorData) sensorData).getVitalSign();
            Date recordedDate = sensorData.getDataRecordedDate();

            dataset.addValue(Double.valueOf(String.valueOf(vs.getBloodPressure())), "Blood Pressure", recordedDate);
        }
        return dataset;
    }

    private CategoryDataset createDataset1(SensorDataDirectory sdd, String personName) {
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        for (SensorData sensorData : sdd.getSensorDataList()) {
            VitalSign vs = ((VitalSignsSensorData) sensorData).getVitalSign();
            Date recordedDate = sensorData.getDataRecordedDate();
            dataset.addValue(Double.valueOf(String.valueOf(vs.getRespiratoryRate())), "Respiratory Rate", recordedDate);
        }
        return dataset;
    }

    private CategoryDataset createDataset2(SensorDataDirectory sdd, String personName) {
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        for (SensorData sensorData : sdd.getSensorDataList()) {
            VitalSign vs = ((VitalSignsSensorData) sensorData).getVitalSign();
            Date recordedDate = sensorData.getDataRecordedDate();
            dataset.addValue(Double.valueOf(String.valueOf(vs.getHeartRate())), "Heart Rate", recordedDate);
        }
        return dataset;
    }

    private CategoryDataset createDataset3(SensorDataDirectory sdd, String personName) {
        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        for (SensorData sensorData : sdd.getSensorDataList()) {
            VitalSign vs = ((VitalSignsSensorData) sensorData).getVitalSign();
            Date recordedDate = sensorData.getDataRecordedDate();
            dataset.addValue(Double.valueOf(String.valueOf(vs.getWeight())), "Weight", recordedDate);
        }
        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
