package primeAID;

import javax.swing.*;
import com.sun.jdi.InternalException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.URLEncoder;

import java.io.FileReader; 
import java.util.Iterator; 
import java.util.Map; 
  
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;

public class Register {

    static JFrame frame;
    static GraphicsConfiguration gc;
    static JLabel errorMessage;
    static JLabel usernameLabel;
    static JLabel passwordLabel;

    static String response;
    static String patientResponse;
    static String token;
    
    public Register(String email){
        run(email);
    }

    static void run(String email) {     
        
        frame = new JFrame("primeAID Registration");
        frame.setTitle("primeAID Registration");

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Register a spot");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBackground(Color.GREEN);
        titleLabel.setOpaque(true);
        titleLabel.setBounds(0, 20,600, 60);
        titleLabel.setFont(new Font("Courier", Font.BOLD,40));
        
        usernameLabel = new JLabel();
        usernameLabel.setText("Username: ");
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel.setBackground(Color.LIGHT_GRAY);
        usernameLabel.setOpaque(true);
        usernameLabel.setBounds(0, 125, 240, 25);
        
        passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setBackground(Color.LIGHT_GRAY);
        passwordLabel.setOpaque(true);
        passwordLabel.setBounds(0, 175, 240, 25);
        
        JLabel adminPasswordLabel = new JLabel();

        JTextField usernameInput = new JTextField();
        usernameInput.setText("");
        usernameInput.setBounds(300, 125, 130, 25);
        
        JTextField passwordInput = new JTextField();
        passwordInput.setText("");
        passwordInput.setBounds(300, 175, 130, 25);
        
        JButton loginButton = new JButton("Register!");
        loginButton.setBounds(300, 250, 130, 60);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
        loginButton.setOpaque(true);
        
        errorMessage = new JLabel();
        errorMessage.setText("");
        errorMessage.setBounds(0, 330, 3000, 20);
        errorMessage.setVisible(false);
        errorMessage.setBackground(Color.WHITE);
        errorMessage.setForeground(Color.RED);
        errorMessage.setOpaque(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setSize(600, 390);
        panel.setLayout(null);
        panel.setLocation(0, 0);
        panel.setOpaque(true);
        panel.add(titleLabel);
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(adminPasswordLabel);
        panel.add(usernameInput);
        panel.add(passwordInput);
        panel.add(errorMessage);
        panel.add(loginButton);

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
                String key = MedicalInterface.getKey(email);
                
                if(key.compareTo("") == 0) {
                    errorMessage.setText("Information is incorrect");
                    errorMessage.setVisible(true);
                } else {
                    
                    try {
                      setAuthentication(email, key);
                      getTokenFromJSON(response);
                      loginButton.setEnabled(false);
                      
                      //get user information for username and password checking.
                      getUserInformation();

                    } catch (ParseException e1) {
                      // TODO Auto-generated catch block
                      e1.printStackTrace();
                    }                      
                }
            }
        });
    }
    
    public static void setAuthentication(String email, String key) {
      
      String username = usernameLabel.getText();
      String playerPassword = passwordLabel.getText();  
      String urlParameters = "";
      
      try {
          //set parameter
          urlParameters =
              "client_id=" + URLEncoder.encode("f3030107nb689n4eb6n834dn1c96a4b6c3c4", "UTF-8") +
              "&client_secret=" + URLEncoder.encode("8a3d11dcn9477n4264n826dn0a6be1cd14ac", "UTF-8") + 
              "&grant_type=" + URLEncoder.encode("password", "UTF-8") +
              "&username=" + URLEncoder.encode(email, "UTF-8") + 
              "&password=" + URLEncoder.encode(key, "UTF-8");
          
        } catch (UnsupportedEncodingException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      
        //Make request for authentication token
        try {
            response = MedicalInterface.excutePost("https://sandbox030.tactiorpm7000.com/token.php", urlParameters, false);
            
        } catch (InternalException exc){
            errorMessage.setText(exc.getMessage());
            errorMessage.setVisible(true);
        }
    }
    
    
    public static void getUserInformation() {
      
        String username = usernameLabel.getText();
        String playerPassword = passwordLabel.getText();  
        String urlParameters = "";
    
        urlParameters = "";
        
        //Make request for authentication token
        try {
            patientResponse = MedicalInterface.excutePost("https://sandbox030.tactiorpm7000.com/tactio_clinical_restful_api.php/1.1.5/Observation", urlParameters, true);
            System.out.println(patientResponse);
            
        } catch (InternalException exc){
            errorMessage.setText(exc.getMessage());
            errorMessage.setVisible(true);
        }
    }
    
    
    public static void getTokenFromJSON(String response) throws ParseException {
        
        //Set up parsing object
        Object obj = new JSONParser().parse(response);
        
        JSONObject jo = (JSONObject) obj; 
          
        // getting firstName and lastName 
        token = (String) jo.get("access_token"); 
    }
    
    public static void closeFrame()
    {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}