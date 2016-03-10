/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.WasteManagementWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.WasteManagementOrganization;
import Business.SensorData.WasteLevelSensorData;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WasteManagementWorkRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.WorkRequest.RequestType;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puneeth
 */
public class WasteManagementWorkerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WasteManagementWorkerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private WasteManagementOrganization organization;
    private Enterprise enterprise;
    private Object[] comboList;

    public WasteManagementWorkerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, WasteManagementOrganization organization, Enterprise enterprise) {
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

    public void populateWasteManagementTable(String filter) {

        DefaultTableModel model = (DefaultTableModel) wasteManagementjTable.getModel();
        model.setRowCount(0);

        if (filter.equals(comboList[3].toString())) {

            organization.getWorkQueue().getWorkRequestList().stream().map((wr) -> {
                Object[] row = new Object[6];
                row[0] = wr;
                if (!(wr.getSensorData() == null)) {
                    row[2] = ((WasteLevelSensorData) wr.getSensorData()).getLevelOfConcern();
                    row[1] = ((WasteLevelSensorData) wr.getSensorData()).getWasteLevel();
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
                    row[2] = ((WasteLevelSensorData) wr.getSensorData()).getLevelOfConcern();
                    row[1] = ((WasteLevelSensorData) wr.getSensorData()).getWasteLevel();
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
                    row[2] = ((WasteLevelSensorData) wr.getSensorData()).getLevelOfConcern();
                    row[1] = ((WasteLevelSensorData) wr.getSensorData()).getWasteLevel();
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
                    row[2] = ((WasteLevelSensorData) wr.getSensorData()).getLevelOfConcern();
                    row[1] = ((WasteLevelSensorData) wr.getSensorData()).getWasteLevel();
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
        wasteManagementjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        filterJComboBox = new javax.swing.JComboBox();
        assignJButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("My Work Area - Waste Management Worker Role");

        wasteManagementjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request Type", "Waste Level", "Level of Concern", "Status", "Receiver", "Request Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(wasteManagementjTable);

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
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(assignJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jButton3))
                                    .addComponent(processJButton)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(26, 26, 26)
                                    .addComponent(filterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton4)))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignJButton)
                    .addComponent(jButton3))
                .addGap(31, 31, 31)
                .addComponent(processJButton)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterJComboBoxActionPerformed
        // TODO add your handling code here:
        processJButton.setEnabled(false);
        assignJButton.setEnabled(false);
        if (!(filterJComboBox.getSelectedItem() == null)) {
            String filter = filterJComboBox.getSelectedItem().toString();
            populateWasteManagementTable(filter);

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
        int selectedRow = wasteManagementjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(WasteManagementWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) wasteManagementjTable.getValueAt(selectedRow, 0);

        wr.setReceiver(account);
        wr.setStatus("Pending");
        JOptionPane.showMessageDialog(WasteManagementWorkerWorkAreaJPanel.this,
                "Work Request assigned to you successfully!",
                "Success!",
                JOptionPane.INFORMATION_MESSAGE);
        populateComboBox();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = wasteManagementjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(WasteManagementWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) wasteManagementjTable.getValueAt(selectedRow, 0);

        ViewSensorTypeWasteWorkRequestDetailJPanel viewWorkRequestDetailsJPanel = new ViewSensorTypeWasteWorkRequestDetailJPanel(userProcessContainer, ((WasteManagementWorkRequest) wr), account);
        userProcessContainer.add("viewWorkRequestDetailsJPanel", viewWorkRequestDetailsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = wasteManagementjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(WasteManagementWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        WorkRequest wr = (WorkRequest) wasteManagementjTable.getValueAt(selectedRow, 0);

        WasteRequestProcessJPanel processWorkRequestJPanel = new WasteRequestProcessJPanel(userProcessContainer, wr);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
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
    private javax.swing.JTable wasteManagementjTable;
    // End of variables declaration//GEN-END:variables
}
