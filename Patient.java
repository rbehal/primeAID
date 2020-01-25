package primeAID;


import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    


public class Patient {

    private PatientState state = PatientState.Waiting;
    private LocalDateTime arrivalTime;
    private LocalDateTime leaveTime;
    private String username;
    private String password;
    
    public Patient(String username, String password) {    
       DateTimeFormatter getTime = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
       LocalDateTime arrivalTime = LocalDateTime.now();  
       
       this.username = username;
       this.password = password;
    } 
    
    public void setLeaveTime(LocalDateTime leaveTime) {
      this.leaveTime = leaveTime;
    }
    
    public LocalDateTime getArrivalTime() {
      return arrivalTime;
    }
    
    public LocalDateTime getLeaveTime() {
      return leaveTime;
    }
    
    public void setState(PatientState state) {
      this.state = state;
    }
    
    public PatientState getState() {
      return state;
    }
    
    public String getUsername() {
      return username;
    }
}
