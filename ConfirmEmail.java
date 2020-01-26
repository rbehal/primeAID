package primeAID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ConfirmEmail {

    static JFrame frame;
    static GraphicsConfiguration gc;

    public ConfirmEmail(){
        run();
    }

    static void run() {     
        
        frame = new JFrame("primeAID Registration");
        frame.setTitle("primeAID Registration");

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Confirm Email");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setOpaque(true);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(0, 20,600, 60);
        titleLabel.setFont(new Font("Courier", Font.BOLD,40));
        
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon("./src/primeAID/media/PLogo.png"));
        image.setVisible(true);
        image.setSize(300, 130);
        image.setLocation(55, 215);
        
        JLabel emailLabel = new JLabel();
        emailLabel.setText("Email: ");
        emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        emailLabel.setBackground(Color.WHITE);
        emailLabel.setOpaque(true);
        emailLabel.setBounds(0, 125, 240, 25);
        
        JLabel adminPasswordLabel = new JLabel();

        JTextField emailInput = new JTextField();
        emailInput.setText("");
        emailInput.setBounds(300, 125, 130, 25);
        
        JButton loginButton = new JButton("Check!");
        loginButton.setBounds(300, 250, 130, 60);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        loginButton.setOpaque(true);
        
        JLabel errorMessage = new JLabel();
        errorMessage.setText("");
        errorMessage.setBounds(0, 330, 600, 20);
        errorMessage.setVisible(false);
        errorMessage.setBackground(Color.WHITE);
        errorMessage.setForeground(Color.RED);
        errorMessage.setOpaque(true);
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setSize(600, 390);
        panel.setLayout(null);
        panel.setLocation(0, 0);
        panel.setOpaque(true);
        panel.add(titleLabel);
        panel.add(emailLabel);
        panel.add(emailInput);
        panel.add(adminPasswordLabel);
        panel.add(errorMessage);
        panel.add(loginButton);
        panel.add(image);
        panel.setVisible(true);
     
        frame.add(panel);
        
        frame.setSize(600,400);
        frame.setLocation(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailInput.getText();
                
                if(MedicalInterface.UserExists(email) == -1) {
                    errorMessage.setVisible(true);
                    errorMessage.setText("No user found!");
                } else {
                    Register.run(email);
                    closeFrame();
                }
            }
        });
    }
    public static void closeFrame()
    {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}