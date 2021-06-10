import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Login {
    public Login() {

    }

    @FXML
    private Button loginLogin;
    @FXML
    private Button loginRegister;
    
    @FXML
    private Label loginError;
    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;
    

    public void userLogin() throws IOException {   
        if(searchmeail()==0)
        {
            Alert msg = new Alert(AlertType.CONFIRMATION);
                            msg.setTitle(loginUsername.getText());
                            msg.setContentText("ENo such email");
                            msg.showAndWait();
                            
        }

        //Path to text file
        Path path = Paths.get("/home/mert/Desktop/hellofx/src/TextFiles/data.txt");
        
    
        

        //Counts number of line in text file
        long count = Files.lines(path).count();

        /// read each line
           for (int i = 0; i < count; i++) 
           {
                String line = Files.readAllLines(path).get(i);
                if(!line.trim().equals("")) 
                {

                    //According to format Name, Email, Password, Age, Gender
                    String[] profile = line.split(",");

                    String gender = profile[0];
                    String name = profile[1];
                    String email = profile[2];
                    String password = profile[3];
                    String rpass =  profile[4];
                    String phone =  profile[5];
                    String ID =  profile[6];
                    String username =  profile[7];
                    String surname =  profile[8];

                    //Email Matched!
                    if(username.trim().equals(loginUsername.getText()))
                    { //Note trim() method remove space from front and behind of string if there is any
                        //Now checking if password match
                        
                        if(password.trim().equals(loginPassword.getText())) 
                        {

                            Alert msg = new Alert(AlertType.CONFIRMATION);
                            msg.setTitle(loginUsername.getText());
                            msg.setContentText("Email and password matched. ");
                            msg.showAndWait();
                            

                            
                           
                            if(searchID(ID)==1){
                                App c = new App();
                            c.changeScene("managerHomepage.fxml");
                            
                            break; //Email match and pass match, Close loop

                            }
                            else
                            {
                                App c = new App();
                            c.changeScene("homepage.fxml");
                            
                            break; //Email match and pass match, Close loop
                            }

                            
                            

                        }
                        else {
                            Alert msg = new Alert(AlertType.CONFIRMATION);
                            msg.setTitle(loginUsername.getText());
                            msg.setContentText("Wrong password.");
                            msg.showAndWait();
                        }
                        
                    }
                }   
                 
            }

           

    }
    private int searchmeail() {
        try
           {
                   BufferedReader file = new BufferedReader(new FileReader("/home/mert/Desktop/hellofx/src/TextFiles/data.txt"));
                   String line;
                   String input = "";
                   while ((line = file.readLine()) != null) 
                   {
                       //System.out.println(line);
                       if (line.contains( loginUsername.getText()) && !(loginUsername.getText().equals("")))
                       {
                           
                           System.out.println("");
                           
                            return 1;
                           
                       }
                       input += line + '\n';
                   }
                   FileOutputStream File = new FileOutputStream("/home/mert/Desktop/hellofx/src/TextFiles/data.txt");
                   File.write(input.getBytes());
                   file.close();
                   File.close();
                   return 0;
    
           }
           catch (Exception e)
           {
                
                   System.out.println(e);
                   return 0;
    
           }
           
    
    
    
        }
    
        
        
        
    public void userRegister() throws IOException {
            App b = new App();
            b.changeScene("register.fxml");
            
    }
   
    private int searchID(String ID) 
    {
        try
        {
                   BufferedReader file = new BufferedReader(new FileReader("/home/mert/Desktop/hellofx/src/TextFiles/manager.txt"));
                   String line;
                   String input = "";
                   while ((line = file.readLine()) != null) 
                   {
                       //System.out.println(line);
                       if (line.contains( ID) && !(ID.equals("")))
                       {
                           
                           
                           
                            return 1;
                           
                       }
                       input += line + '\n';
                   }
                   FileOutputStream File = new FileOutputStream("/home/mert/Desktop/hellofx/src/TextFiles/manager.txt");
                   File.write(input.getBytes());
                   file.close();
                   File.close();
                   return 0;
    
        }
        catch(Exception e)
        {
            System.out.println("error at login search id" + e);
            return -1;
        }
        
        
    
    
    
        
        
    
    }

}
