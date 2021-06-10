import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;
public class register implements Initializable {

    @FXML
    private Button registerLogin;
    @FXML
    private Button registerRegister;
    @FXML
    private TextField registerName;
    @FXML
    private TextField registerSurname;
    @FXML
    private PasswordField registerPass;
    @FXML
    private PasswordField registerRPass;
    @FXML
    private TextField registerEmail;
    @FXML
    private TextField registerUName;
    @FXML
    private TextField registerPhone;
    @FXML
    private TextField registerID;
    @FXML
    private TextField registerGender;
    
    int i;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        


        //Open windows for sign up if nall else do this
        if(registerEmail.getText() !=null )
        {
            //Disable everything
            
        }
            





    }

    public void regisLogin(ActionEvent event) throws IOException{
        App a = new App();
        a.changeScene("loginScreen.fxml");
    }
    
    public void regisRegister(ActionEvent event) throws IOException
    {
        
        boolean flag = false;
        
        if(registerEmail.getText().equals("")){
            Alert msg1 = new Alert(AlertType.CONFIRMATION);
            msg1.setTitle("Areas contain \"*\" cannot be blank.");
            msg1.setContentText("Please enter your email");
            msg1.showAndWait();
            msg1.close();
            flag=true;
        }
         if(searchID() == 0 && !(registerID.getText().equals(""))){
            Alert msg2 = new Alert(AlertType.CONFIRMATION);
            msg2.setTitle("Your manager id is not valid");
            msg2.setContentText("Please enter a valid manager Id");
            msg2.showAndWait();
            flag=true;
        }
         if(registerSurname.getText().equals("")){
            Alert msg3 = new Alert(AlertType.CONFIRMATION);
            msg3.setTitle("Areas contain \"*\" cannot be blank.");
            msg3.setContentText("Please enter your surname");
            msg3.showAndWait();
            flag=true;
        }
         if(registerPhone.getText().equals("")){
            Alert msg4 = new Alert(AlertType.CONFIRMATION);
            msg4.setTitle("Areas contain \"*\" cannot be blank.");
            msg4.setContentText("Please enter your phone");
            msg4.showAndWait();
            flag=true;
        }
        if(registerName.getText().equals("")){
            Alert msg5 = new Alert(AlertType.CONFIRMATION);
            msg5.setTitle("Areas contain \"*\" cannot be blank.");
            msg5.setContentText("Please enter your name");
            msg5.showAndWait();
            flag=true;
        }
        if(registerPass.getText().equals("")){
            Alert msg6 = new Alert(AlertType.CONFIRMATION);
            msg6.setTitle("Areas contain \"*\" cannot be blank.");
            msg6.setContentText("Please enter your password");
            msg6.showAndWait();
            flag=true;
        }
        if(registerUName.getText().equals("")){
            Alert msg7 = new Alert(AlertType.CONFIRMATION);
            msg7.setTitle("Areas contain \"*\" cannot be blank.");
            msg7.setContentText("Please enter your username");
            msg7.showAndWait();
            flag=true;
        }
        if(registerRPass.getText().equals(registerPass.getText()) && !(registerPass.getText().equals("")))
        {
           for(i =0;i<App.list.size();i++)
           {
               
           }
           if(i>0)
           {
                if(!(App.list.get(i-1).getEmail().equals(registerEmail.getText() ))&&!(App.list.get(i-1).getUsername().equals(registerUName.getText() ))&& flag ==false) 
                {
                    addLine();
                    if(searchID()==1)
                    {
                        
                        
                        Alert msg9 = new Alert(AlertType.CONFIRMATION);
                        msg9.setTitle(registerEmail.getText());
                        msg9.setContentText("Succesfull manager signup.");
                        msg9.showAndWait();
                        App.list.add(new Manager(registerGender.getText(),registerName.getText(),registerSurname.getText(),registerPass.getText(),registerEmail.getText(),registerPhone.getText(),registerRPass.getText(),registerUName.getText(),registerID.getText()));
                        App a = new App();
                        a.changeScene("loginScreen.fxml");
                    
                    }
                    else{
                        
                        
                        Alert msg9 = new Alert(AlertType.CONFIRMATION);
                        msg9.setTitle(registerEmail.getText());
                        msg9.setContentText("Succesfull user signup.");
                        App.list.add(new User(registerGender.getText(),registerName.getText(),registerSurname.getText(),registerPass.getText(),registerEmail.getText(),registerPhone.getText(),registerRPass.getText(),registerUName.getText()));
                        msg9.showAndWait();
                        App a = new App();
                        a.changeScene("loginScreen.fxml");
                    }
                    
                }
           }
           

           }
                   
        }
       

    
    
        
       
        
        
        
    
    private void addLine() 
    {
        String line = registerGender.getText()+","+registerName.getText() +"," +registerEmail.getText() +"," +registerPass.getText() +"," +registerRPass.getText() +"," +registerPhone.getText()+","+registerID.getText()+","+registerUName.getText()+","+registerSurname.getText() +"\n";

         FileWriter file_writer;
        try {
            file_writer = new FileWriter("/home/mert/Desktop/hellofx/src/TextFiles/data.txt",true);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
            buffered_Writer.write(line);   
            buffered_Writer.flush();
            buffered_Writer.close();

        } catch (IOException e) {
            System.out.println("Add line failed!!" +e);
        }

    }

   
       



    
    private int searchID() 
    {
        try
        {
                   BufferedReader file = new BufferedReader(new FileReader("/home/mert/Desktop/hellofx/src/TextFiles/manager.txt"));
                   String line;
                   String input = "";
                   while ((line = file.readLine()) != null) 
                   {
                       //System.out.println(line);
                       if (line.contains( registerID.getText()) && !(registerID.getText().equals("")))
                       {
                           
                           System.out.println("you have a validmanager id.");
                           
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
           catch (Exception e)
           {
                
                   System.out.println(e);
                   return 0;
    
           }
           
    
    
    
    }
        
                            
            

}
                            
                          

                        
                        
                 

    

