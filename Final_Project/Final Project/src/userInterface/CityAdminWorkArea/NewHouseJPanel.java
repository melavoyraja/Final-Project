/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.CityAdminWorkArea;

import Business.Community.Community;
import Business.Community.CommunityDirectory;
import Business.House.House;
import Business.Utils.MyNumericVerifier;
import Business.Utils.MyStringVerifier;
import Business.Utils.MyZipCodeVerifier;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author puneeth
 */
public class NewHouseJPanel extends javax.swing.JPanel {

    /**
     * Creates new form NewHouseJPanel
     */
    private JPanel userProcessContainer;
    private CommunityDirectory communityDirectory;
    private String cityName;

    public NewHouseJPanel(JPanel userProcessContainer, CommunityDirectory communityDirectory, String cityName) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.communityDirectory = communityDirectory;
        this.cityName = this.cityName;
        populateComboBox();
        addVerifiers();
        cityNameJText.setText(cityName);
    }

    private void addVerifiers() {
        InputVerifier integerVerifier = new MyNumericVerifier();
        houseNoJText.setInputVerifier(integerVerifier);
        InputVerifier stringVerifier = new MyStringVerifier();
        streetNameJText.setInputVerifier(stringVerifier);
        cityNameJText.setInputVerifier(stringVerifier);
        stateNameJText.setInputVerifier(stringVerifier);
        InputVerifier zipCodeVerifier = new MyZipCodeVerifier();
        zipcodeJText.setInputVerifier(zipCodeVerifier);
    }

    public void populateComboBox() {
        communityComboBox.removeAllItems();

        for (Community c : communityDirectory.getCommunityList()) {
            communityComboBox.addItem(c);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        communityComboBox = new javax.swing.JComboBox();
        houseNoJText = new javax.swing.JTextField();
        streetNameJText = new javax.swing.JTextField();
        cityNameJText = new javax.swing.JTextField();
        stateNameJText = new javax.swing.JTextField();
        zipcodeJText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setText("Create New House");

        jLabel2.setText("House No:");

        jLabel3.setText("Street Name:");

        jLabel4.setText("City Name:");

        jLabel5.setText("State Name:");

        jLabel6.setText("ZIP Code:");

        jLabel7.setText("Community Name:");

        communityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cityNameJText.setEnabled(false);

        jButton1.setText("Create House");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
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
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(communityComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(houseNoJText)
                                    .addComponent(streetNameJText)
                                    .addComponent(cityNameJText)
                                    .addComponent(stateNameJText)
                                    .addComponent(zipcodeJText, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(292, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(communityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(houseNoJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(streetNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cityNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(stateNameJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(zipcodeJText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(62, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void clearData() {
        houseNoJText.setText("");
        streetNameJText.setText("");
        
        stateNameJText.setText("");
        zipcodeJText.setText("");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (checkBlankInput() == Boolean.TRUE) {
            if (communityComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this,
                        "Commnity cannot be empty!",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Community community = (Community) communityComboBox.getSelectedItem();
            House house = community.createAndAddHouse();

            int houseNo = Integer.parseInt(houseNoJText.getText());
            String streetName = streetNameJText.getText();
            String cityName = cityNameJText.getText();
            String stateName = stateNameJText.getText();
            int zipCode = Integer.parseInt(zipcodeJText.getText());

            house.setHouseNo(houseNo);
            house.setStreetName(streetName);
            house.setCityName(cityName);
            house.setStatename(stateName);
            house.setZipcode(String.valueOf(zipCode));

            JOptionPane.showMessageDialog(this,
                    "House created successfully!",
                    "Success!",
                    JOptionPane.INFORMATION_MESSAGE);

            clearData();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter all values", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private Boolean checkBlankInput() {
        if (houseNoJText.getText().length() == 0
                || streetNameJText.getText().length() == 0
                || cityNameJText.getText().length() == 0
                || stateNameJText.getText().length() == 0
                || zipcodeJText.getText().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageCommunityandHouseJPanel mch = (ManageCommunityandHouseJPanel) component;
        mch.loadHouseTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityNameJText;
    private javax.swing.JComboBox communityComboBox;
    private javax.swing.JTextField houseNoJText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField stateNameJText;
    private javax.swing.JTextField streetNameJText;
    private javax.swing.JTextField zipcodeJText;
    // End of variables declaration//GEN-END:variables
}
