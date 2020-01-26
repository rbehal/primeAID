package primeAID;

import javax.swing.*;
import com.sun.jdi.InternalException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
    static String patientResponse = new String();
    static String token;
    
    //private static ArrayList<Pair<String, String>> registrantNames = new ArrayList<>(MedicalInterface.getRegistrantList().size());;
    
    private static ArrayList<Patient> patientWaitingList = new ArrayList<>();
    
    private static boolean patientExists = false;
    
    public Register(String email){
        run(email);
    }

    static void run(String email) {     
        
        frame = new JFrame("primeAID Registration");
        frame.setTitle("primeAID Registration");

        JLabel titleLabel = new JLabel();
        titleLabel.setText("Register a patient");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBackground(Color.BLACK);
        titleLabel.setOpaque(true);
        titleLabel.setBounds(0, 20,600, 60);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Courier", Font.BOLD,40));
        
        JLabel image = new JLabel();
        image.setIcon(new ImageIcon("./src/primeAID/media/PLogo.png"));
        image.setVisible(true);
        image.setSize(300, 130);
        image.setLocation(55, 215);
        
        usernameLabel = new JLabel();
        usernameLabel.setText("Username: ");
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel.setBackground(Color.WHITE);
        usernameLabel.setOpaque(true);
        usernameLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        usernameLabel.setBounds(0, 125, 240, 25);
        
        passwordLabel = new JLabel();
        passwordLabel.setText("Password: ");
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setBackground(Color.WHITE);
        passwordLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
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
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        loginButton.setOpaque(true);
        
        errorMessage = new JLabel();
        errorMessage.setText("");
        errorMessage.setBounds(0, 330, 600, 20);
        errorMessage.setVisible(false);
        errorMessage.setBackground(Color.WHITE);
        errorMessage.setForeground(Color.RED);
        errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
        errorMessage.setOpaque(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
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
        panel.add(image);

        panel.setVisible(true);
     
        frame.add(panel);
        
        frame.setSize(600,400);
        frame.setLocation(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        
        JButton returnButton = new JButton();
        returnButton.setFont(new Font("Courier", Font.PLAIN,10));
        returnButton.setSize(50, 25);
        returnButton.setText("Return");
        returnButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        returnButton.setOpaque(true);
        returnButton.setLocation(480,125);
        returnButton.setVisible(true);
        
        panel.add(returnButton);
        
        //return button to User screen
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmEmail.run();
                Register.closeFrame();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // Get key attached to email
                String key = MedicalInterface.getKey(email);
                
                if(key.equals("")) {
                  
                    errorMessage.setForeground(Color.RED);
                    errorMessage.setText("Information is incorrect...");
                    errorMessage.setVisible(true);
                    
                } else {
                    
                    try {
                      String username = usernameInput.getText();
                      String password = passwordInput.getText(); 
                      
                      setAuthentication(email, key);
                      getTokenFromJSON(response);
                      
                      //get user information for username and password checking.
                      //getUserInformation();
                      
                      //find person and register 
                      parseThroughResponse(patientResponse, email, username, password);
                      
                      if(!patientExists) {
                        errorMessage.setForeground(Color.RED);
                        errorMessage.setText("Credentials are incorrect...");
                        errorMessage.setVisible(true);
                      }
                                        
                    } catch (ParseException e1) {
                      // TODO Auto-generated catch block
                      e1.printStackTrace();
                    } catch (FileNotFoundException e1) {
                      // TODO Auto-generated catch block
                      e1.printStackTrace();
                    } catch (IOException e1) {
                      // TODO Auto-generated catch block
                      e1.printStackTrace();
                    }                      
                }
            }
        });
    }
    
    public static void setAuthentication(String email, String key) {
       
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
      
        String urlParameters = "";
        
        //Make request for authentication token
        try {
            patientResponse = MedicalInterface.excutePost("https://sandbox030.tactiorpm7000.com/tactio_clinical_restful_api.php/1.1.5/Patient", urlParameters, true);
            
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
    
    public static void parseThroughResponse(String response, String oldEmail, String inputUsername, String inputPassword) throws ParseException, FileNotFoundException, IOException {
      
        Object fileReader = new JSONParser().parse(new FileReader("./src/primeAID/expectedOutcome.json")); 
        
        JSONObject resource, resourceName, resourceEmail, nameIndices, patientTitle, telecom;
       
        String patientFamilyName;
        String patientFirstName;
        
        //Email found in database for comparison
        String finalEmail;
        
        
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) fileReader; 
        
        int incrementor = 0;

        JSONArray entryname, nameName, givenName, telecomList;
        entryname = (JSONArray) jo.get("entry");
        
        for(int i = 0; i < entryname.size(); i++) {
          
            //Set to json
            resource = (JSONObject) entryname.get(i);
            
            //get name of individual
            resourceName = (JSONObject) resource.get("resource");
            resourceEmail = (JSONObject) resource.get("resource");
            
            //get first and last name
            nameName = (JSONArray) resourceName.get("name");
            telecomList = (JSONArray) resourceEmail.get("telecom");
            
            //GGet index location of name
            nameIndices = (JSONObject) nameName.get(0);
            telecom = (JSONObject) telecomList.get(0);
            //patientTitle = (JSONObject) name.get("family");
            
            givenName = (JSONArray) nameIndices.get("given");
            
            //Final list
            
            finalEmail = (String) telecom.get("value");
            patientFirstName = (String) givenName.get(0);
            patientFamilyName = (String) nameIndices.get("family");
            
            
          //Check if user exists
            checkUserCredentials(patientFirstName, patientFamilyName, finalEmail, oldEmail, inputUsername, inputPassword);
            
            
        }  
    }
    
    public static void checkUserCredentials(String username, String password, String newEmail, String oldEmail, String inputUsername, String inputPassword){
        
        for(int i = 0; i < MedicalInterface.getRegistrantList().size(); i++) {
            
            // make sure name, password and email all matc to database
            
            if(username.equals(inputUsername) && password.equals(inputPassword) && newEmail.equals(oldEmail)) {
                //Create a patient in registration
                System.out.println(patientWaitingList.size());
                //Check to make sure the patient doesn't already exist
                if(patientWaitingList.size() == 0) {
                    patientWaitingList.add(new Patient(username, password));
                    patientExists = true;
                    
                    errorMessage.setForeground(Color.GREEN);
                    errorMessage.setText("Successfully added patient to queue...");
                    errorMessage.setVisible(true);
                    
                    break;
                } else {patientExists = false;}
              
                for(Patient patient : patientWaitingList) {
                  
                    //No replicates
                    if(!patient.getUsername().equals(username) || !patient.getPassword().equals(password)) {
                      
                      //Add patient to list
                        patientWaitingList.add(new Patient(username, password));
                        
                        patientExists = true;
                        
                        errorMessage.setForeground(Color.GREEN);
                        errorMessage.setText("Successfully added patient to queue...");
                        errorMessage.setVisible(true);
                        
                        break;
                      
                    } else {
                        errorMessage.setForeground(Color.RED);
                        errorMessage.setText("Patient already registered...");
                        errorMessage.setVisible(true);
                        
                        patientExists = false;
                    }
                }
                
                if(patientExists) break;
            } 
        } 
    }
    
    
    public static void closeFrame()
    {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }
}