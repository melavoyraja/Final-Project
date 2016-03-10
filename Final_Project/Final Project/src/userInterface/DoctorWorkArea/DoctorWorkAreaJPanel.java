/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DoctorWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.DoctorOrganization;
import Business.Sensor.Sensor;
import Business.SensorData.VitalSignsSensorData;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author puneeth
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorWorkAreaJPanel1
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private DoctorOrganization organization;
    private Enterprise enterprise;
    private Object[] comboList;

    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DoctorOrganization organization, Enterprise enterprise) {
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

    public void populateWorkRequestTable(String filter) {

        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);

        if (filter.equals(comboList[3].toString())) {

            organization.getWorkQueue().getWorkRequestList().stream().map((wr) -> {
                Object[] row = new Object[9];
                row[0] = wr;
                row[1] = wr.getSensor().getUserAccount().getEmployee().getAge();
                row[2] = ((VitalSignsSensorData) wr.getSensorData()).getStatus();
                row[3] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getRespiratoryRate();
                row[4] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getHeartRate();
                row[5] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getBloodPressure();
                row[6] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getWeight();
                row[7] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[8] = wr.getStatus();
                return row;

            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[1].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (wr.getStatus().equals("Sent"))).map((wr) -> {
                Object[] row = new Object[9];
                row[0] = wr;
                row[1] = wr.getSensor().getUserAccount().getEmployee().getAge();
                row[2] = ((VitalSignsSensorData) wr.getSensorData()).getStatus();
                row[3] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getRespiratoryRate();
                row[4] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getHeartRate();
                row[5] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getBloodPressure();
                row[6] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getWeight();
                row[7] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[8] = wr.getStatus();
                return row;
            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[0].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (!(wr.getReceiver() == null))).filter((wr) -> (wr.getReceiver().getUsername().equals(account.getUsername()))).map((wr) -> {
                Object[] row = new Object[9];
                row[0] = wr;
                row[1] = wr.getSensor().getUserAccount().getEmployee().getAge();
                row[2] = ((VitalSignsSensorData) wr.getSensorData()).getStatus();
                row[3] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getRespiratoryRate();
                row[4] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getHeartRate();
                row[5] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getBloodPressure();
                row[6] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getWeight();
                row[7] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[8] = wr.getStatus();
                return row;
            }).forEach((row) -> {
                model.addRow(row);
            });
        } else if (filter.equals(comboList[2].toString())) {
            organization.getWorkQueue().getWorkRequestList().stream().filter((wr) -> (!(wr.getReceiver() == null))).filter((wr) -> (wr.getStatus().equals("Completed"))).map((wr) -> {
                Object[] row = new Object[9];
                row[0] = wr;
                row[1] = wr.getSensor().getUserAccount().getEmployee().getAge();
                row[2] = ((VitalSignsSensorData) wr.getSensorData()).getStatus();
                row[3] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getRespiratoryRate();
                row[4] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getHeartRate();
                row[5] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getBloodPressure();
                row[6] = ((VitalSignsSensorData) wr.getSensorData()).getVitalSign().getWeight();
                row[7] = wr.getReceiver() == null ? null : wr.getReceiver().getUsername();
                row[8] = wr.getStatus();
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
        workRequestJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        filterJComboBox = new javax.swing.JComboBox();
        processJButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        imageLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("My Work Area - Doctor Role");

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient Name", "Age", "Vital Signs Status", "Respiratory Rate", "Heart Rate", "Blood Pressure", "Weight", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        jButton1.setText("View Patient Vital  Sign Record");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Filter:");

        filterJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        filterJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterJComboBoxActionPerformed(evt);
            }
        });

        processJButton.setText("Process Request");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        jButton3.setText("View Patient's House Conditions ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Change Picture");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(filterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(assignJButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(processJButton))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(335, 335, 335)
                            .addComponent(jLabel1))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton2)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processJButton)
                    .addComponent(assignJButton))
                .addContainerGap(211, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        Sensor sensor = wr.getSensor();

        ViewPatientVitalSignRecord viewPatientVitalSignRecord = new ViewPatientVitalSignRecord(userProcessContainer, sensor);
        userProcessContainer.add("viewPatientVitalSignRecord", viewPatientVitalSignRecord);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void filterJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterJComboBoxActionPerformed
        // TODO add your handling code here:
        processJButton.setEnabled(false);
        assignJButton.setEnabled(false);
        if (!(filterJComboBox.getSelectedItem() == null)) {
            String filter = filterJComboBox.getSelectedItem().toString();
            populateWorkRequestTable(filter);

            if (filterJComboBox.getSelectedItem().toString().equals(comboList[0].toString())) {
                processJButton.setEnabled(true);
            }
            if (filterJComboBox.getSelectedItem().toString().equals(comboList[1].toString())) {
                assignJButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_filterJComboBoxActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);

        DoctorRequestProcessJPanel doctorRequestProcessJPanel = new DoctorRequestProcessJPanel(userProcessContainer, wr);
        userProcessContainer.add("doctorRequestProcessJPanel", doctorRequestProcessJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);


    }//GEN-LAST:event_processJButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);
        Sensor sensor = wr.getSensor();

        ViewPatientHouseCondition viewPatientHouseCondition = new ViewPatientHouseCondition(userProcessContainer, sensor.getUserAccount().getEmployee().getHouse());
        userProcessContainer.add("viewPatientHouseCondition", viewPatientHouseCondition);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this,
                    "Please select a work request form the list!",
                    "Message!",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkRequest wr = (WorkRequest) workRequestJTable.getValueAt(selectedRow, 0);

        wr.setReceiver(account);
        wr.setStatus("Pending");
        JOptionPane.showMessageDialog(this,
                "Work Request assigned to you successfully!",
                "Success!",
                JOptionPane.INFORMATION_MESSAGE);
        populateComboBox();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //TODO add your handling code here:
        String image = Business.UserAccount.UserAccount.loadImage(imageLabel, account.getBase64String(), this);
        account.setBase64String(image);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JComboBox filterJComboBox;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
