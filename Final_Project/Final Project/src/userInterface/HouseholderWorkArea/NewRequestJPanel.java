/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.HouseholderWorkArea;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.WasteManagementOrganization;
import Business.Organization.WaterWorksOrganization;
import Business.UserAccount.UserAccount;
import Business.Utils.MyStringVerifier;
import Business.Utils.MyStringVerifier_TextArea;
import Business.WorkQueue.WasteManagementWorkRequest;
import Business.WorkQueue.WaterWorksWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.Random;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author puneeth
 */
public class NewRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewRequestJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private Enterprise enterprise;
    private String image;
    private WaterWorksOrganization wwo;
    private WasteManagementOrganization wmo;
    private double latitude;
    private double longitude;
    private Organization organization;

    public NewRequestJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.enterprise = enterprise;
        this.organization = organization;
        imageLabel.setSize(200, 200);
        image = "";
        imageLabel.setIcon(null);
        populateComboBox();
        pullOrganizations();
        addVerifiers();
    }

    private void addVerifiers() {

        InputVerifier stringVerifier = new MyStringVerifier_TextArea();
        descriptionjTextArea.setInputVerifier(stringVerifier);
    }

    public void populateComboBox() {
        organizationJCombo.removeAllItems();
        for (Organization.Type type : Organization.Type.values()) {
            if ((type.getValue().equals(Organization.Type.WaterWorks.getValue())
                    || type.getValue().equals(Organization.Type.WasteManagement.getValue()))) {
                organizationJCombo.addItem(type);
            }
        }
    }

    public void pullOrganizations() {
        wwo = null;
        wmo = null;
        for (Organization o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof WaterWorksOrganization) {
                wwo = (WaterWorksOrganization) o;
            }

            if (o instanceof WasteManagementOrganization) {
                wmo = (WasteManagementOrganization) o;
            }
        }
    }

    public static double randomLong() {
        double start = -45;
        double end = 45;
        double randomLong = new Random().nextDouble();
        double result = start + (randomLong * (end - start));
        return result;
    }

    public static double randomLat() {
        double start = -45;
        double end = 45;
        double randomLat = new Random().nextDouble();
        double result = start + (randomLat * (end - start));
        return result;
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        organizationJCombo = new javax.swing.JComboBox();
        imageLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        longitudeJText = new javax.swing.JTextField();
        latitudeJText = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionjTextArea = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("New Request");

        jButton1.setText("Upload Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Organization:");

        organizationJCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        imageLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), null));

        jLabel4.setText("Image:");

        jLabel5.setText("Description:");

        jLabel6.setText("Longitude:");

        jLabel7.setText("Latitude:");

        longitudeJText.setEnabled(false);

        latitudeJText.setEnabled(false);

        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Raise Request");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        descriptionjTextArea.setColumns(20);
        descriptionjTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionjTextArea);

        jButton4.setText("Generate Longitude & Latitude");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7)
                                            .addComponent(jButton2))))
                                .addGap(102, 102, 102)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(latitudeJText, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(longitudeJText, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(imageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(93, 93, 93)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton4)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(103, 103, 103)
                                .addComponent(organizationJCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(organizationJCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6)
                        .addGap(49, 49, 49)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(longitudeJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(41, 41, 41)
                        .addComponent(latitudeJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton2))))
                .addContainerGap(156, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageRequestWorkArea mrw = (ManageRequestWorkArea) component;
        mrw.loadRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        image = Business.UserAccount.UserAccount.loadImage(imageLabel, image, this);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (checkBlankInput() == Boolean.TRUE) {
//            if (image.trim().isEmpty()) {
            if (imageLabel.getIcon() == null) {
                JOptionPane.showMessageDialog(this,
                        "Image should be uploaded for raising the request!",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Type type = (Type) organizationJCombo.getSelectedItem();

            if ((wwo == null && type.getValue().equals(Organization.Type.WaterWorks.getValue()))
                    || (wmo == null && type.getValue().equals(Organization.Type.WasteManagement.getValue()))) {
                JOptionPane.showMessageDialog(this,
                        "Organizations not found, Request your Administrators to create organizations first!",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (type.getValue().equals(Organization.Type.WaterWorks.getValue())) {
                WorkRequest wwwr = new WaterWorksWorkRequest();
                wwo.getWorkQueue().getWorkRequestList().add(wwwr);
                account.getWorkQueue().getWorkRequestList().add(wwwr);
                wwwr.setRequestDate(new Date());
                wwwr.setDescription(descriptionjTextArea.getText());
                wwwr.setLongitude(longitude);
                wwwr.setLatitude(latitude);
                wwwr.setSender(account);
                wwwr.setStatus("Sent");
                wwwr.setOrganization(null);
                ((WaterWorksWorkRequest) wwwr).setImage(image);
                ((WaterWorksWorkRequest) wwwr).setType(WorkRequest.RequestType.HouseHolder);
                wwwr.setSensorData(null);
                JOptionPane.showMessageDialog(this,
                        "Work Request submitted successfully!",
                        "Success!",
                        JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else if (type.getValue().equals(Organization.Type.WasteManagement.getValue())) {
                WorkRequest wmwr = new WasteManagementWorkRequest();
                wmo.getWorkQueue().getWorkRequestList().add(wmwr);
                account.getWorkQueue().getWorkRequestList().add(wmwr);
                wmwr.setRequestDate(new Date());
                wmwr.setDescription(descriptionjTextArea.getText());
                wmwr.setLatitude(latitude);
                wmwr.setLongitude(longitude);
                wmwr.setSender(account);
                wmwr.setStatus("Sent");
                ((WasteManagementWorkRequest) wmwr).setImage(image);
                ((WasteManagementWorkRequest) wmwr).setType(WorkRequest.RequestType.HouseHolder);
                wmwr.setOrganization(null);
                wmwr.setSensorData(null);
                JOptionPane.showMessageDialog(this,
                        "Work Request submitted successfully!",
                        "Success!",
                        JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter all values", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void clearFields() {
        descriptionjTextArea.setText("");
        imageLabel.setText("");
        imageLabel.setIcon(null);
        latitudeJText.setText("");
        longitudeJText.setText("");
    }

    private Boolean checkBlankInput() {
        if (descriptionjTextArea.getText().length() == 0 || longitudeJText.getText().length() == 0 || latitudeJText.getText().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        latitude = randomLat();
        longitude = randomLong();
        latitudeJText.setText(String.valueOf(latitude));
        longitudeJText.setText(String.valueOf(longitude));
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea descriptionjTextArea;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField latitudeJText;
    private javax.swing.JTextField longitudeJText;
    private javax.swing.JComboBox organizationJCombo;
    // End of variables declaration//GEN-END:variables
}
