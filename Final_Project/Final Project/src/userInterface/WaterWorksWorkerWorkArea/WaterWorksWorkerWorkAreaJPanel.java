/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.WaterWorksWorkerWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.WaterWorksOrganization;
import Business.SensorData.WaterQualitySensorData;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WaterWorksWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puneeth
 */
public class WaterWorksWorkerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WaterWorksWorkerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private WaterWorksOrganization organization;
    private Enterprise enterprise;
    private Object[] comboList;

    public WaterWorksWorkerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, WaterWorksOrganization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;

        this.comboList = new Object[4];
        comboList[3] = "All";
        comboList[2] = "Completed";
        comboList[1] = "Open Requests";
        comboList[0] = "Assigned to me";

        imageLabel.setSize(120, 120);
        UserAccount.displayImage(imageLabel, account.getBase64String(), this);
        populateComboBox();

    }

    public void populateWaterQualityTable(String filter) {

        DefaultTableModel model = (DefaultTableModel) waterQualityjTable.getModel();
        model.setRowCount(0);

        if (filter.equals(comboList[3].toString())) {

            organization.getWorkQueue().getWorkRequestList().stream().map((wr) -> {
                Object[] row = new Object[6];
                row[0] = wr;
                if (!(wr.getSensorData() == null)) {
                    row[1] = ((WaterQualitySensorData) wr.getSensorData()).getWaterQualityIndex();
                    row[2] = ((WaterQualitySensorData) wr.getSensorData()).getLevelOfConcern();
                } else {
                    row[1] = null;
                    row[2] = null;
                }
                row[3] = wr.getStatus();
                row[4] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[5] = wr.getRequestDate();
                return row;

            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[1].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (wr.getStatus().equals("Sent"))).map((wr) -> {
                Object[] row = new Object[6];
                row[0] = wr;
                if (!(wr.getSensorData() == null)) {
                    row[1] = ((WaterQualitySensorData) wr.getSensorData()).getWaterQualityIndex();
                    row[2] = ((WaterQualitySensorData) wr.getSensorData()).getLevelOfConcern();
                } else {
                    row[1] = null;
                    row[2] = null;
                }
                row[3] = wr.getStatus();
                row[4] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[5] = wr.getRequestDate();
                return row;
            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[0].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (!(wr.getReceiver() == null))).filter((wr) -> (wr.getReceiver().getUsername().equals(account.getUsername()))).map((wr) -> {
                Object[] row = new Object[6];
                row[0] = wr;
                if (!(wr.getSensorData() == null)) {
                    row[1] = ((WaterQualitySensorData) wr.getSensorData()).getWaterQualityIndex();
                    row[2] = ((WaterQualitySensorData) wr.getSensorData()).getLevelOfConcern();
                } else {
                    row[1] = null;
                    row[2] = null;
                }
                row[3] = wr.getStatus();
                row[4] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[5] = wr.getRequestDate();
                return row;
            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[2].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (!(wr.getReceiver() == null))).filter((wr) -> (wr.getStatus().equals("Completed"))).map((wr) -> {
                Object[] row = new Object[6];
                row[0] = wr;
                if (!(wr.getSensorData() == null)) {
                    row[1] = ((WaterQualitySensorData) wr.getSensorData()).getWaterQualityIndex();
                    row[2] = ((WaterQualitySensorData) wr.getSensorData()).getLevelOfConcern();
                } else {
                    row[1] = null;
                    row[2] = null;
                }
                row[3] = wr.getStatus();
                row[4] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[5] = wr.getRequestDate();
                return row;
            }).forEach((row) -> {
                model.addRow(row);
            });
        }
    }

    public void populateComboBox() {
        filterJComboBox.removeAllItems();
        for (Object o : comboList) {
            filterJComboBox.addItem(o.toString());

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
        waterQualityjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        filterJComboBox = new javax.swing.JComboBox();
        assignJButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("My Work Area - Water Works Worker Role");

        waterQualityjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Type", "AQI", "Level of Concern", "Status", "Receiver", "Request Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(waterQualityjTable);

        jLabel2.setText("Filter:");

        filterJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        filterJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterJComboBoxActionPerformed(evt);
            }
        });

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        jButton3.setText("View Details");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        processJButton.setText("Process Request");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Change Picture");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addComponent(filterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(assignJButton)
                                    .addGap(496, 496, 496)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addComponent(jButton3))
                                        .addComponent(processJButton)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1)))
                .addContainerGap(281, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton4)))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(assignJButton))
                .addGap(31, 31, 31)
                .addComponent(processJButton)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterJComboBoxActionPerformed
        // TODO add your handling code here:
        processJButton.setEnabled(false);
        assignJButton.setEnabled(false);
        if (!(filterJComboBox.getSelectedItem() == null)) {
            String filter = filterJComboBox.getSelectedItem().toString();
            populateWaterQualityTable(filter);

            if (filterJComboBox.getSelectedItem().toString().equals(comboList[0].toString())) {
                processJButton.setEnabled(true);
            }
            if (filterJComboBox.getSelectedItem().toString().equals(comboList[1].toString())) {
                assignJButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_filterJComboBoxActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = waterQualityjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(WaterWorksWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) waterQualityjTable.getValueAt(selectedRow, 0);

        wr.setReceiver(account);
        wr.setStatus("Pending");
        JOptionPane.showMessageDialog(WaterWorksWorkerWorkAreaJPanel.this,
                "Work Request assigned to you successfully!",
                "Success!",
                JOptionPane.INFORMATION_MESSAGE);
        populateComboBox();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = waterQualityjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(WaterWorksWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) waterQualityjTable.getValueAt(selectedRow, 0);

        ViewWaterQualityWorkRequestDetailJPanel viewWaterQualityWorkRequestDetailJPanel = new ViewWaterQualityWorkRequestDetailJPanel(userProcessContainer, ((WaterWorksWorkRequest) wr), account);
        userProcessContainer.add("viewWaterQualityWorkRequestDetailJPanel", viewWaterQualityWorkRequestDetailJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = waterQualityjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(WaterWorksWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        WorkRequest wr = (WorkRequest) waterQualityjTable.getValueAt(selectedRow, 0);

        WaterQualityRequestProcessJPanel waterQualityRequestProcessJPanel = new WaterQualityRequestProcessJPanel(userProcessContainer, wr);
        userProcessContainer.add("waterQualityRequestProcessJPanel", waterQualityRequestProcessJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_processJButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //TODO add your handling code here:
        String image = Business.UserAccount.UserAccount.loadImage(imageLabel, account.getBase64String(), this);
        account.setBase64String(image);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JComboBox filterJComboBox;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable waterQualityjTable;
    // End of variables declaration//GEN-END:variables
}
