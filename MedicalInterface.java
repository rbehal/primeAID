package primeAID;

import javax.swing.*;
import javafx.util.Pair;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import com.sun.jdi.InternalException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MedicalInterface extends JPanel{
  
    private static ArrayList<Pair<String, String>> registrantNames = new ArrayList<>(10);
  
    private static JFrame medicalDisplay = new JFrame();
    private static JPanel panelDisplay = new JPanel();
    private static Dimension screenSize;
    
    private static JTextField emailInput = new JTextField();
    private static JTextField usernameInput = new JTextField();
    private static JTextField passwordInput = new JTextField();
    private static TextField textField = new TextField();
    private static JButton RegisterButton = new JButton();
    private static JButton checkButton = new JButton();
    private static JLabel errorMessage = new JLabel();
    
    private static int screenY;
    private static int screenX;
    
    private static int labelWidth = 500;
    private static int labelheight = 100;
    
    public static void GetScreenDimension() {
      
   // Get screen dimensions
      screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      
      screenX = (int) (screenSize.getHeight());
      screenY = (int) (screenSize.getWidth());
    }

    public static void SetUpFrame() {
      medicalDisplay.setVisible(true);
      medicalDisplay.setSize(screenX, screenY);
      medicalDisplay.setLocation(0, 0);
      medicalDisplay.setLayout(null);
    }
    
    public static void SetUpPanel() {
      panelDisplay.setVisible(true);
      panelDisplay.setSize(screenX, screenY);
    }
    
    public static void SetUpTextLabel() {
      textField = new TextField();
      textField.setVisible(true);
      textField.setText("Search patient!");
       
    }
    
    public static void MockEmails() {
      
      registrantNames.add(new Pair<String, String>("patient1@mailinator.com", "juVr2q2P"));       
      registrantNames.add(new Pair<String, String>("patient2@mailinator.com", "g2MWvy5v"));       
      registrantNames.add(new Pair<String, String>("patient3@mailinator.com", "bJVv5h?k"));       
      registrantNames.add(new Pair<String, String>("patient4@mailinator.com", "PZMs3CHx"));       
      registrantNames.add(new Pair<String, String>("patient5@mailinator.com", "TapvuL5r"));       
      registrantNames.add(new Pair<String, String>("patient6@mailinator.com", "Tu9vgvyx"));       
      registrantNames.add(new Pair<String, String>("patient7@mailinator.com", "SmpZKc2Y"));       
      registrantNames.add(new Pair<String, String>("patient8@mailinator.com", "Qm325NyW"));       
      registrantNames.add(new Pair<String, String>("patient9@mailinator.com", "2sA6cZr5"));       
      registrantNames.add(new Pair<String, String>("patient10@mailinator.com", "8uJUSFz6"));       
     
    }
   
    public static void main(String[] args) {
        
        MockEmails();
        GetScreenDimension();
        SetUpFrame();
        SetUpPanel();
        SetUpTextLabel();
        
        emailInput = new JTextField();
        emailInput.setText("Email           ");
        emailInput.setBounds(300, 200, labelWidth, labelheight);
        emailInput.setVisible(true);
        emailInput.setOpaque(true);
        
        checkButton = new JButton("Check");
        checkButton.setBounds(300, 500, labelWidth / 2, labelheight / 2);
        checkButton.setOpaque(true);
        checkButton.setVisible(true);
        
        usernameInput = new JTextField();
        usernameInput.setText("Username         ");
        usernameInput.setBounds(300, 200, labelWidth, labelheight);
        usernameInput.setVisible(false);
        usernameInput.setOpaque(true);
        
        passwordInput = new JTextField();
        passwordInput.setText("Password         ");
        passwordInput.setBounds(300, 300, labelWidth, labelheight);
        passwordInput.setVisible(false);
        passwordInput.setOpaque(true);
        
        RegisterButton = new JButton("Register");
        RegisterButton.setBounds(300, 500, labelWidth / 2, labelheight / 2);
        RegisterButton.setOpaque(true);
        RegisterButton.setVisible(false);
        
        errorMessage = new JLabel();
        errorMessage.setText("");
        errorMessage.setBounds(300, 600, 3000, 20);
        errorMessage.setVisible(false);
        errorMessage.setBackground(Color.WHITE);
        errorMessage.setForeground(Color.RED);
        errorMessage.setOpaque(false);
        
        panelDisplay.add(errorMessage);
        panelDisplay.add(RegisterButton);
        panelDisplay.add(passwordInput);
        panelDisplay.add(emailInput);
        panelDisplay.add(checkButton);
        panelDisplay.add(usernameInput);
        medicalDisplay.add(panelDisplay);
        
        
        //check if email exists.
        checkButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             //Get username and password
              String email = emailInput.getText();
              int index = UserExists(email);
              
              try {
                  // Set up query link
                
                  // Patient does not exist
                  if(index == -1) {
                    errorMessage.setText("No user with that email");
                    errorMessage.setVisible(true);
                       
                  
                  } else {
                    errorMessage.setVisible(false);
                    checkButton.setVisible(false);
                    emailInput.setVisible(false);
                    
                    RegisterButton.setVisible(true);
                    usernameInput.setVisible(true);
                    passwordInput.setVisible(true);
                    
                    //Get patient information
                    getUserInformation(index);       
                  }
                
              } catch (InternalException exc){
                  errorMessage.setText("Patient does not exist!");
                  errorMessage.setVisible(true);
              }
          }
      });
        
   }
    
    // -1 -> not found
   public static int UserExists(String email) {
     
     Pair<String, String> patientInformation;
     
     for(int i = 0; i < registrantNames.size(); i++) {
       
       patientInformation = registrantNames.get(i);
       
       if(patientInformation.getKey().compareTo(email) == 0) {
         return i;
       }
     } 
     return -1;
   }
   
   public static void getUserInformation(int index) throws IOException {
     
     Pair<String, String> patientIndex = registrantNames.get(index);
     System.out.println(patientIndex.getValue());
     
  // POST query
     
     HttpClient client = HttpClient.newHttpClient();
     
     HttpResponse<Path> response = client.send(
         HttpRequest
             .newBuilder(new URI("http://www.foo.com/"))
             .headers("Foo", "foovalue", "Bar", "barvalue")
             .POST(BodyProcessor.fromString("Hello world"))
             .build(),
         BodyHandler.asFile(Paths.get("/path"))
     );
     int statusCode = response.statusCode();
     Path body = response.body(); // should be "/path"
     
   }
}