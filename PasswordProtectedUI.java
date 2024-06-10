import javax.swing.*;
import java.awt.event.*;

public class PasswordProtectedUI {
    private JFrame frame;
    private JPasswordField passwordField;
    private JButton authenticateButton;
    private final String correctPassword = "Faizan9108";

    public PasswordProtectedUI() {
        frame = new JFrame("Password Protected Interface");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel passwordLabel = new JLabel("Enter Password:");
        frame.add(passwordLabel);

        passwordField = new JPasswordField(20);
        frame.add(passwordField);

        authenticateButton = new JButton("Authenticate");
        authenticateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });
        frame.add(authenticateButton);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                on_close();
            }
        });

        frame.setVisible(true);
    }

    private void authenticate() {
        String enteredPassword = new String(passwordField.getPassword());

        if (enteredPassword.equals(correctPassword)) {
            System.out.println("Authentication Successful!");
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void on_close() {
        String closePassword = JOptionPane.showInputDialog(frame, "Enter password to close:");

        if (closePassword != null && closePassword.equals(correctPassword)) {
            frame.dispose();
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordProtectedUI();
            }
        });
    }
}

