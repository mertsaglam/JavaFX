import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class profileSettings 
{

    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField settingsEmail;
    @FXML
    private PasswordField settingsNewPass;
    @FXML
    private PasswordField settingsOldPass;
    @FXML
    private PasswordField settingsNewPassRepeat;
    
    
    int i;

    public void cancel(ActionEvent event) throws IOException{
        App z = new App();
        z.changeScene("homepage.fxml");
    }
    
    public void save(ActionEvent event) throws IOException
    {
        
        try
        {
                BufferedReader file = new BufferedReader(new FileReader("/home/mert/Desktop/hellofx/src/TextFiles/data.txt"));
                String line;
                String input = "";
                while ((line = file.readLine()) != null) 
                {
                    
                    //System.out.println(line);
                    if (line.contains(settingsEmail.getText()))
                    {
                        int i;
                        for(i=0;i<App.list.size();i++)
                        {
                            if(App.list.get(i).getEmail().equals(settingsEmail.getText())&&App.list.get(i).getPassword().equals(settingsOldPass.getText()))
                            {
                                
                             
                                break;
                            }
                        }
                        User copyuser = App.list.get(i);
                        App.list.get(i).setPassword(settingsNewPass.getText());
                        
                        copyuser.setPassword(settingsNewPass.getText());
                       
                        //gender,name,emailll,pass,pass,phone,comolokko,uname,surname
                        line = copyuser.getGender()+","+copyuser.getName()+","+copyuser.getEmail()+","+copyuser.getPassword()+","+copyuser.getPassword()+","+copyuser.getPhone()+","+copyuser.getID()+","+copyuser.getUsername()+","+copyuser.getSurname();
                       
                    }
                    input += line + '\n';
                }
                FileOutputStream File = new FileOutputStream("/home/mert/Desktop/hellofx/src/TextFiles/data.txt");
                File.write(input.getBytes());
                file.close();
                File.close();
                App z = new App();
                z.changeScene("Login.fxml");
        }
        catch (Exception e)
        {
                System.out.println(e);
        }
        
        
        
    }
    

}
    
    
    
