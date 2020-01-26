package primeAID;

import javax.swing.*;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class MedicalInterface extends JPanel{
  
    /**
   * 
   */
    private static final long serialVersionUID = 1L;
    private static ArrayList<Pair<String, String>> registrantNames = new ArrayList<>(10);;

    public static void MockEmails() {
      
      //For user login
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
        ConfirmEmail.run();
    }
    
    public static ArrayList<Pair<String, String>> getRegistrantList(){
        return registrantNames;
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
   
    public static String getKey(String email) {
       
        Pair<String, String> patientInformation;
        for(int i = 0; i < registrantNames.size(); i++) {
          
            patientInformation = registrantNames.get(i);
            
            if(patientInformation.getKey().compareTo(email) == 0) {
                return patientInformation.getValue();
            }
        } 
        return "";
    }
    
    public static String excutePost(String targetURL, String urlParameters, boolean getInfo)
    {
      
      URL url;
      HttpURLConnection connection = null;  
      
      try {
        
        //Create connection
        url = new URL(targetURL);
        
        //Setup connection
        connection = (HttpURLConnection) url.openConnection();
        
        if(getInfo) {
          connection.setRequestMethod("GET");
          connection.setRequestProperty("Authorization", "bearer " + new String(Register.token));
          connection.setDoOutput(true);
          //System.out.println("Bearer " + Register.token);
        } else {
          connection.setRequestMethod("POST");
        }
        
        //Set request properties
               
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");   
        
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        //Send request
        DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
        wr.writeBytes (urlParameters);
        wr.flush ();
        wr.close ();

        //Get Response    
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        
        while((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();

      } catch (Exception e) {

        e.printStackTrace();
        return null;

      } finally {

        //Disconnnect
        if(connection != null) {
          connection.disconnect(); 
        }
      }
    }
}