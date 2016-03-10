/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.City.City;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Notification.Notification;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;
import EDU.purdue.cs.bloat.shrink.Main;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author puneeth
 */
public class UserAccount {

    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private String base64String;
    private ArrayList<Notification> notificationList;
    //private ArrayList<UserAccount> approvedDoctors;
    // private SensorDirectory sensorDirectory;

    public UserAccount() {
        workQueue = new WorkQueue();
        notificationList = new ArrayList<>();
//        approvedDoctors = new ArrayList<>();
        // sensorDirectory = new SensorDirectory();
        BufferedImage img;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            img = ImageIO.read(new File("default.png"));
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            base64String = Base64.encode(baos.toByteArray());
            baos.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getBase64String() {
        return base64String;
    }

    public void setBase64String(String base64String) {

        this.base64String = base64String;
    }

    public static String imageTOString(BufferedImage img, JPanel jPanel) {
        String convertedImage = "";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, "jpg", baos);
            baos.flush();
            convertedImage = Base64.encode(baos.toByteArray());
            baos.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(jPanel,
                    "File Read Error, Please input a valid Image",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertedImage;
    }

    public static void displayImage(JLabel imageLabel, String image, JPanel jPanel) {
        byte[] bytearray = Base64.decode(image);
        BufferedImage tempImage = null;
        try {
            tempImage = ImageIO.read(new ByteArrayInputStream(bytearray));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(jPanel,
                    "File Read Error, Please input a valid Image",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        int width = imageLabel.getSize().width;
        int height = imageLabel.getSize().height;
        BufferedImage resizedImage = new BufferedImage(width, height, 4);
        Graphics2D graphics = resizedImage.createGraphics();
        graphics.drawImage(tempImage, 0, 0, width, height, null);
        imageLabel.setIcon(new ImageIcon(resizedImage));
    }

    public static String loadImage(JLabel imageLabel, String image, JPanel jPanel) {
        JFileChooser jFileChooser = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp");
        FileFilter filter1 = jFileChooser.getAcceptAllFileFilter();
        jFileChooser.removeChoosableFileFilter(filter1);
        jFileChooser.addChoosableFileFilter(filter);
        int returnVal = jFileChooser.showOpenDialog(jPanel);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            try {
                image = UserAccount.imageTOString(ImageIO.read(file), jPanel);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(jPanel,
                        "File Read Error, Please input a valid Image",
                        "Error!",
                        JOptionPane.ERROR_MESSAGE);
                // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            UserAccount.displayImage(imageLabel, image, jPanel);
        }
        return image;
    }

    public static boolean checkAvailability(EcoSystem system, String userName) {
        boolean check = false;

        for (UserAccount u : system.getUserAccountDirectory().getUserAccountList()) {
            if (userName.equals(u.getUsername())) {
                check = true;
                break;
            }
        }
        if (check == false) {
            for (Network n : system.getNetworkList()) {
                for (City c : n.getCityList()) {
                    for (UserAccount u : c.getUserAccountDirectory().getUserAccountList()) {
                        if (userName.equals(u.getUsername())) {
                            check = true;
                            break;
                        }
                        if (check == false) {
                            for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
                                for (UserAccount ua : e.getUserAccountDirectory().getUserAccountList()) {
                                    if (userName.equals(ua.getUsername())) {
                                        check = true;
                                        break;
                                    }
                                }
                                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                                    for (UserAccount uacc : o.getUserAccountDirectory().getUserAccountList()) {
                                        if (userName.equals(uacc.getUsername())) {
                                            check = true;
                                            break;
                                        }
                                    }
                                    if (check == true) {
                                        break;
                                    }
                                }
                                if (check == true) {
                                    break;
                                }
                            }
                        }
                        if (check == true) {
                            break;
                        }
                    }
                }
            }
        }
        /*for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
         for (UserAccount u : e.getUserAccountDirectory().getUserAccountList()) {
         if (userName.equals(u.getUsername())) {
         check = true;
         break;
         }
         }
         if (check == true) {
         break;
         }
         }
         if (check == true) {
         break;
         }
         }
         }

         if (check == false) {
         for (Network n : system.getNetworkList()) {
         for (Enterprise e : n.getEnterpriseDirectory().getEnterpriseList()) {
         for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
         for (UserAccount u : o.getUserAccountDirectory().getUserAccountList()) {
         if (userName.equals(u.getUsername())) {
         check = true;
         break;
         }
         }
         if (check == true) {
         break;
         }
         }
         if (check == true) {
         break;
         }
         }
         if (check == true) {
         break;
         }
         }
         }*/

        return check;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public ArrayList<Notification> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(ArrayList<Notification> notificationList) {
        this.notificationList = notificationList;
    }
    
    @Override
    public String toString() {
        return username;
    }

}
