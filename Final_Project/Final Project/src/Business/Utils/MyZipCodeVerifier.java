package Business.Utils;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author puneeth
 */
public class MyZipCodeVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        if (!(text.length()  == 5)) {
            input.setBackground(Color.red);
            JOptionPane.showMessageDialog(input, "Please enter 5 digited value only!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }else{
            if (text.length() > 0) {
                try {
                    int i = Integer.parseInt(text);
                    input.setBackground(Color.white);
                    if (i <= 0) {
                        input.setBackground(Color.red);
                        JOptionPane.showMessageDialog(input, "Please enter positive value", "Error", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                    return true;
                } catch (NumberFormatException e) {
                    input.setBackground(Color.red);
                    JOptionPane.showMessageDialog(input, "Please enter 5 digited value only!", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } else {
                input.setBackground(Color.white);
                return true;
            }
            
        }
    }
}
