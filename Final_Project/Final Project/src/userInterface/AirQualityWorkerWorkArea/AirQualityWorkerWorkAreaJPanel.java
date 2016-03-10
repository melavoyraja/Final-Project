/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.AirQualityWorkerWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.AirQualityOrganization;
import Business.SensorData.AirQualitySensorData;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.AirQualityWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puneeth
 */
public class AirQualityWorkerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AirQualityWorkerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private AirQualityOrganization organization;
    private Enterprise enterprise;
    private Object[] comboList;

    public AirQualityWorkerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, AirQualityOrganization organization, Enterprise enterprise) {
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

    public void populateAirQualityTable(String filter) {

        DefaultTableModel model = (DefaultTableModel) airQualityWorkRequestjTable.getModel();
        model.setRowCount(0);

        if (filter.equals(comboList[3].toString())) {

            organization.getWorkQueue().getWorkRequestList().stream().map((wr) -> {
                Object[] row = new Object[5];
                row[0] = wr;
                row[1] = ((AirQualitySensorData) wr.getSensorData()).getLevelOfHealthConcern();
                row[2] = wr.getStatus();
                row[3] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[4] = wr.getRequestDate();
                return row;
            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[1].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (wr.getStatus().equals("Sent"))).map((wr) -> {
                Object[] row = new Object[5];
                row[0] = wr;
                row[1] = ((AirQualitySensorData) wr.getSensorData()).getLevelOfHealthConcern();
                row[2] = wr.getStatus();
                row[3] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[4] = wr.getRequestDate();
                return row;
            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[0].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (!(wr.getReceiver() == null))).filter((wr) -> (wr.getReceiver().getUsername().equals(account.getUsername()))).map((wr) -> {
                Object[] row = new Object[5];
                row[0] = wr;
                row[1] = ((AirQualitySensorData) wr.getSensorData()).getLevelOfHealthConcern();
                row[2] = wr.getStatus();
                row[3] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[4] = wr.getRequestDate();
                return row;
            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[2].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (!(wr.getReceiver() == null))).filter((wr) -> (wr.getStatus().equals("Completed"))).map((wr) -> {
                Object[] row = new Object[5];
                row[0] = wr;
                row[1] = ((AirQualitySensorData) wr.getSensorData()).getLevelOfHealthConcern();
                row[2] = wr.getStatus();
                row[3] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[4] = wr.getRequestDate();
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
        airQualityWorkRequestjTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        filterJComboBox = new javax.swing.JComboBox();
        assignJButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("My Work Area - Air Quality Worker Role");

        airQualityWorkRequestjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "AQI Level", "Level Of Concern", "Status", "Receiver", "Request Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(airQualityWorkRequestjTable);

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

        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Change Picture");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(processJButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(104, 104, 104)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(27, 27, 27)
                                    .addComponent(filterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(assignJButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(276, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {assignJButton, jButton3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(assignJButton))
                .addGap(28, 28, 28)
                .addComponent(processJButton)
                .addContainerGap(140, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterJComboBoxActionPerformed
        // TODO add your handling code here:
        processJButton.setEnabled(false);
        assignJButton.setEnabled(false);
        if (!(filterJComboBox.getSelectedItem() == null)) {
            String filter = filterJComboBox.getSelectedItem().toString();
            populateAirQualityTable(filter);

            if (filterJComboBox.getSelectedItem().toString().equals(comboList[0].toString())) {
                processJButton.setEnabled(true);
            }
            if (filterJComboBox.getSelectedItem().toString().equals(comboList[1].toString())) {
                assignJButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_filterJComboBoxActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = airQualityWorkRequestjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(AirQualityWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) airQualityWorkRequestjTable.getValueAt(selectedRow, 0);

        ViewWorkRequestDetailsJPanel viewWorkRequestDetailsJPanel = new ViewWorkRequestDetailsJPanel(userProcessContainer, ((AirQualityWorkRequest) wr), account);
        userProcessContainer.add("viewWorkRequestDetailsJPanel", viewWorkRequestDetailsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = airQualityWorkRequestjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(AirQualityWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) airQualityWorkRequestjTable.getValueAt(selectedRow, 0);
        if (!wr.getStatus().equals("Sent")) {
            JOptionPane.showMessageDialog(AirQualityWorkerWorkAreaJPanel.this,
                    "Work request cannot be assigned as Status is not Sent!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        wr.setReceiver(account);
        wr.setStatus("Pending");
        JOptionPane.showMessageDialog(AirQualityWorkerWorkAreaJPanel.this,
                "Work Request assigned to you successfully!",
                "Success!",
                JOptionPane.INFORMATION_MESSAGE);
        populateComboBox();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = airQualityWorkRequestjTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(AirQualityWorkerWorkAreaJPanel.this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        WorkRequest wr = (WorkRequest) airQualityWorkRequestjTable.getValueAt(selectedRow, 0);

        ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, wr);
        userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_processJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //TODO add your handling code here:
        String image = Business.UserAccount.UserAccount.loadImage(imageLabel, account.getBase64String(), this);
        account.setBase64String(image);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable airQualityWorkRequestjTable;
    private javax.swing.JButton assignJButton;
    private javax.swing.JComboBox filterJComboBox;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    // End of variables declaration//GEN-END:variables
}