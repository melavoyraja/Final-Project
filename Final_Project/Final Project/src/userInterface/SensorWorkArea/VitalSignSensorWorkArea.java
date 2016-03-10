/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.SensorWorkArea;

import Business.City.City;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Organization.Organization;
import Business.Sensor.Sensor;
import Business.Sensor.VitalSignsSensor;
import Business.SensorData.SensorData;
import Business.SensorData.VitalSignsSensorData;
import Business.VitalSign.VitalSign;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puneeth
 */
public class VitalSignSensorWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form VitalSignSensorWorkArea
     */
    private JPanel userProcessContainer;
    private VitalSignsSensor sensor;
    private City city;
    private int check;
    private Organization organization;
    private int random;

    public VitalSignSensorWorkArea(JPanel userProcessContainer, VitalSignsSensor sensor, City city, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.sensor = sensor;
        this.city = city;
        this.organization = organization;
        check = 0;
        random = 0;
        populateSensorData();
    }

    public void populateSensorData() {
        DefaultTableModel model = (DefaultTableModel) vitalSignJTable.getModel();
        model.setRowCount(0);

        sensor.getSensorDataDirectory().getSensorDataList().stream().filter((vssd) -> (vssd instanceof VitalSignsSensorData)).map((vssd) -> {
            Object[] row = new Object[5];
            row[0] = ((VitalSignsSensorData) vssd).getVitalSign().getRespiratoryRate();
            row[1] = ((VitalSignsSensorData) vssd).getVitalSign().getHeartRate();
            row[2] = ((VitalSignsSensorData) vssd).getVitalSign().getBloodPressure();
            row[3] = ((VitalSignsSensorData) vssd).getVitalSign().getWeight();
            row[4] = ((VitalSignsSensorData) vssd).getStatus();

            return row;
        }).forEach((row) -> {
            model.addRow(row);
        });

    }

    private String vitalSignStatus(VitalSign vitalSign, int patientAge) {
        String vitalSignStatus = "Abnormal";

        int respirationRate = vitalSign.getRespiratoryRate();
        int heartRate = vitalSign.getHeartRate();
        int bloodPressure = vitalSign.getBloodPressure();
        int weight = vitalSign.getWeight();

        /*Toddler*/
        if (patientAge >= 1 && patientAge <= 3) {
            if ((respirationRate > 20 && respirationRate < 31) /*Respiration Rate*/
                    && (heartRate > 80 && heartRate < 131) /*Heart Rate*/
                    && (bloodPressure > 80 && bloodPressure < 111) /*Blood Pressure*/
                    && (weight > 22 && weight < 32)) /*Weight*/ {
                vitalSignStatus = "Normal";
            }
        }
        /*Preschooler*/
        if (patientAge >= 4 && patientAge <= 5) {
            if ((respirationRate > 20 && respirationRate < 31)
                    && (heartRate > 80 && heartRate < 121)
                    && (bloodPressure > 80 && bloodPressure < 111)
                    && (weight > 31 && weight < 41)) {
                vitalSignStatus = "Normal";
            }
        }
        /*School Age*/
        if (patientAge >= 6 && patientAge <= 12) {
            if ((respirationRate > 20 && respirationRate < 31)
                    && (heartRate > 70 && heartRate < 111)
                    && (bloodPressure > 80 && bloodPressure < 121)
                    && (weight > 41 && weight < 93)) {
                vitalSignStatus = "Normal";
            }
        }
        /*Adolescent*/
        if (patientAge >= 13) {
            if ((respirationRate > 12 && respirationRate < 21)
                    && (heartRate > 55 && heartRate < 106)
                    && (bloodPressure > 110 && bloodPressure < 121)
                    && (weight > 110 && weight < 201)) {
                vitalSignStatus = "Normal";
            }
        }
        return vitalSignStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vitalSignJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rrJText = new javax.swing.JTextField();
        hrJText = new javax.swing.JTextField();
        bpJText = new javax.swing.JTextField();
        weightJText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("Vital Sign Sensor Work Area");

        vitalSignJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Respiratory Rate", "Heart Rate", "Systolic Blood Pressure", "Weight(In Pounds)", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vitalSignJTable);

        jLabel1.setText("Last Generated Data:");

        rrJText.setEnabled(false);

        hrJText.setEnabled(false);

        bpJText.setEnabled(false);

        weightJText.setEnabled(false);

        jLabel3.setText("Respiratory Rate:");

        jLabel4.setText("Heart Rate:");

        jLabel5.setText("Systolic Blood Pressure:");

        jLabel6.setText("Weight:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hrJText, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(rrJText))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bpJText, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(weightJText)))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rrJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bpJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hrJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if (check == 0) {
            Organization orga = null;
            for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization org : e.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof DoctorOrganization) {
                        orga = org;
                    }
                }
            }
            check++;
            if (orga == null) {
                JOptionPane.showMessageDialog(this,
                        "Contact Admin, Hospital Organization Not Found!", "Error!", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        VitalSign vs = null;

        if (random < 6) {
            vs = sensor.randomVitalSigns(true, sensor.getUserAccount().getEmployee().getAge());
            random++;
            if (random == 5) {
                random = 0;
                vs = sensor.randomVitalSigns(false, sensor.getUserAccount().getEmployee().getAge());
            }
        }

        rrJText.setText(String.valueOf(vs.getRespiratoryRate()));
        hrJText.setText(String.valueOf(vs.getHeartRate()));
        bpJText.setText(String.valueOf(vs.getBloodPressure()));
        weightJText.setText(String.valueOf(vs.getWeight()));
        // UserAccount ua = sensor.getUserAccount();
//        Employee emp = sensor.getEmployee();
        SensorData vssd = sensor.getSensorDataDirectory().addSensorData(Sensor.SensorType.VitalSigns);
        ((VitalSignsSensorData) vssd).setVitalSign(vs);
        ((VitalSignsSensorData) vssd).setStatus(vitalSignStatus(vs, sensor.getUserAccount().getEmployee().getAge()));
        String status = ((VitalSignsSensorData) vssd).getStatus();

        if (status.equals("Abnormal")) {
            WorkRequest dwr = new DoctorWorkRequest();
            // airQualityOrganization.getWorkQueue().getWorkRequestList().add(aqwr);

            dwr.setSensor(sensor);
            dwr.setMessage(status);
            dwr.setRequestDate(new Date());
            dwr.setStatus("Sent");
//            dwr.setHouse(sensor.getHouse());
            // ((AirQualityWorkRequest) aqwr).setOrganization(organization);

            dwr.setSensorData(vssd);
            organization.getWorkQueue().getWorkRequestList().add(dwr);
            for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    if (o instanceof DoctorOrganization) {
                        o.getWorkQueue().getWorkRequestList().add(dwr);
                    }
                }
            }

        }
        populateSensorData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bpJText;
    private javax.swing.JTextField hrJText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rrJText;
    private javax.swing.JTable vitalSignJTable;
    private javax.swing.JTextField weightJText;
    // End of variables declaration//GEN-END:variables
}
