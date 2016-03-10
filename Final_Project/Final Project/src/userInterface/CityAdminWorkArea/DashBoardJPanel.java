/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.CityAdminWorkArea;

import Business.City.City;
import Business.Community.Community;
import Business.Enterprise.Enterprise;
import Business.House.House;
import Business.Organization.HouseholdOrganization;
import Business.Organization.Organization;
import Business.Sensor.AirQualitySensor;
import Business.Sensor.Sensor;
import Business.Sensor.VitalSignsSensor;
import Business.Sensor.WasteManagementSensor;
import Business.Sensor.WaterQualitySensor;
import Business.SensorData.AirQualitySensorData;
import Business.SensorData.SensorData;
import Business.SensorData.VitalSignsSensorData;
import Business.SensorData.WasteLevelSensorData;
import Business.SensorData.WaterQualitySensorData;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puneeth
 */
public class DashBoardJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DashBoardJPanel
     */
    private JPanel userProcessContainer;
    private City city;
    private int count;
    private int pending;
    private int sent;
    private int completed;
    private int processing;

    public DashBoardJPanel(JPanel userProcessContainer, City city) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.city = city;
        populateCommunity();
        populateComboBox();
    }

    public void populateComboBox() {
        enterpriseJComboBox.removeAllItems();
        for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
            enterpriseJComboBox.addItem(e);
        }
    }

    public void populateCommunity() {
        DefaultTableModel dtm = (DefaultTableModel) communityJTable.getModel();
        dtm.setRowCount(0);
        count = 0;
        for (Community c : city.getCommunityDirectory().getCommunityList()) {

            for (House h : c.getHouseDirectory().getHouseList()) {
                for (Sensor s : h.getSensorDirectory().getSensorList()) {

                    if (s instanceof AirQualitySensor) {
                        for (SensorData sd : s.getSensorDataDirectory().getSensorDataList()) {
                            if (((AirQualitySensorData) sd).getLevelOfHealthConcern().equals(("Unhealthy"))
                                    || ((AirQualitySensorData) sd).getLevelOfHealthConcern().equals(("Very Unhealthy"))
                                    || ((AirQualitySensorData) sd).getLevelOfHealthConcern().equals(("Hazardos"))) {
                                count++;

                            }
                        }

                    }
                }
            }
            Object[] row = new Object[3];
            row[0] = c.getCommunityName();
            row[1] = Sensor.SensorType.Air;
            row[2] = count;
            dtm.addRow(row);
            count = 0;
            for (House h : c.getHouseDirectory().getHouseList()) {
                for (Sensor s : h.getSensorDirectory().getSensorList()) {
                    if (s instanceof WasteManagementSensor) {
                        for (SensorData sd : s.getSensorDataDirectory().getSensorDataList()) {
                            if (((WasteLevelSensorData) sd).getLevelOfConcern().equals(("Unhealthy"))
                                    || ((WasteLevelSensorData) sd).getLevelOfConcern().equals(("Hazardos"))) {
                                count++;

                            }
                        }

                    }
                }
            }
            Object[] row1 = new Object[3];
            row1[0] = c.getCommunityName();
            row1[1] = Sensor.SensorType.Waste;
            row1[2] = count;
            dtm.addRow(row1);
            count = 0;
            for (House h : c.getHouseDirectory().getHouseList()) {
                for (Sensor s : h.getSensorDirectory().getSensorList()) {
                    if (s instanceof WaterQualitySensor) {
                        for (SensorData sd : s.getSensorDataDirectory().getSensorDataList()) {
                            if (((WaterQualitySensorData) sd).getLevelOfConcern().equals(("Poor"))
                                    || ((WaterQualitySensorData) sd).getLevelOfConcern().equals(("Marginal"))) {
                                count++;

                            }
                        }

                    }
                }
            }
            Object[] row2 = new Object[3];
            row2[0] = c.getCommunityName();
            row2[1] = Sensor.SensorType.Water;
            row2[2] = count;
            dtm.addRow(row2);
            count = 0;
            for (House h : c.getHouseDirectory().getHouseList()) {
                for (Sensor s : h.getSensorDirectory().getSensorList()) {
                    if (s instanceof VitalSignsSensor) {
                        for (SensorData sd : s.getSensorDataDirectory().getSensorDataList()) {
                            if (((VitalSignsSensorData) sd).getStatus().equals(("Abnormal"))) {
                                count++;

                            }
                        }

                    }

                }
            }
            Object[] row3 = new Object[3];
            row3[0] = c.getCommunityName();
            row3[1] = Sensor.SensorType.VitalSigns;
            row3[2] = count;
            dtm.addRow(row3);
            count = 0;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        communityJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        enterpriseJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        organizationJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("City DashBoard");

        communityJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Community Name", "Type of Sensor", "Number of Abnormalities Reported"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(communityJTable);

        jLabel2.setText("List of Communities and Number of Abnormalities Reported:");

        jLabel3.setText("Number of Organization Work Requests based on status in an Enterprise:");

        enterpriseJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseJComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Enterprise Name:");

        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organization Name", "Completed", "Sent", "Pending", "Processing"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(organizationJTable);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                                .addComponent(jScrollPane2))
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addContainerGap(218, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enterpriseJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseJComboBoxActionPerformed
        // TODO add your handling code here:
        if (!(enterpriseJComboBox.getSelectedItem() == null)) {
            Enterprise enterprise = (Enterprise) enterpriseJComboBox.getSelectedItem();
            populateOrgTable(enterprise);
        }
    }//GEN-LAST:event_enterpriseJComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed
    public void populateOrgTable(Enterprise enterprise) {
        pending = 0;
        sent = 0;
        completed = 0;
        processing = 0;
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        model.setRowCount(0);
        //if (enterprise.getEnterpriseType().toString().equals(Enterprise.EnterpriseType.Hospital.toString())) {
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (!(o instanceof HouseholdOrganization)) {
                pending = 0;
                sent = 0;
                completed = 0;
                processing = 0;

                for (WorkRequest wr : o.getWorkQueue().getWorkRequestList()) {
                    if (wr.getStatus().equals("Sent")) {
                        sent++;
                    } else if (wr.getStatus().equals("Completed")) {
                        completed++;
                    } else if (wr.getStatus().equals("Pending")) {
                        pending++;
                    } else if (wr.getStatus().equals("Processing")) {
                        processing++;
                    }
                }
                Object[] row = new Object[5];
                row[0] = o;
//                row[1] = null;
                row[1] = completed;
                row[2] = sent;
                row[3] = pending;
                row[4] = processing;
                model.addRow(row);
            }
        }

//        } else if (enterprise.getEnterpriseType().toString().equals(Enterprise.EnterpriseType.HouseKeeping.toString())) {
//            for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
//                for (WorkRequest wr : o.getWorkQueue().getWorkRequestList()) {
//
//                }
//            }
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable communityJTable;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable organizationJTable;
    // End of variables declaration//GEN-END:variables
}
