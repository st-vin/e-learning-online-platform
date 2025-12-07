package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame {

    private JTextField regNoField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Separate service class for validation
    private final LoginService loginService = new LoginService();

    public LoginGUI() {
        // Window setup
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center window
        setLayout(new GridLayout(3, 2, 5, 5));

        // Components
        JLabel regNoLabel = new JLabel("RegNo:");
        regNoField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        // Add components
        add(regNoLabel);
        add(regNoField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel("")); // spacer
        add(loginButton);

        // Action listener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        setVisible(true);
    }

    // Handle login button click
    private void handleLogin() {
        String regNo = regNoField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Basic input validation
        if (regNo.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both RegNo and Password",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Delegate validation to LoginService
        boolean success = loginService.validateUser(regNo, password);

        if (success) {
            JOptionPane.showMessageDialog(this,
                    "Login Successful!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid RegNo or Password",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
