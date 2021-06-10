import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class managerHomepage implements Initializable
{
    @FXML
    private TextField ManagerUname;
    @FXML
    private TextField ManName;
    @FXML
    private TextField ManSurname;
    @FXML
    private TextField ManPhone;
    @FXML
    private TextField ManMail;
    @FXML
    private TextField ManGender;
    @FXML
    private Button manHomeAdd;
    @FXML
    private Button manHomeDel;
    

    

    
    
    @FXML
    private TableView<User> homepageTable;
    @FXML
    private Button Logout;
    @FXML
    private Button homeSettings;
    @FXML
    private TableColumn <User ,String> usernameColumn;
    @FXML
    private TableColumn <User ,String> nameColumn;
    @FXML
    private TableColumn <User ,String> surnameColumn;
    @FXML
    private TableColumn <User ,String> phoneColumn;
    @FXML
    private TableColumn<User ,String> emailColumn;
    @FXML
    private TableColumn<User ,String> genderColumn;
    
    
    
    int j;
    
    
    public void settings(ActionEvent event) throws IOException{
        App c = new App();
        c.changeScene("profileSettings.fxml");
    }
    public void Logout(ActionEvent event) throws IOException{
        App a = new App();
        a.changeScene("loginScreen.fxml");
    }
    public void DeleteUserButton(ActionEvent event) throws IOException
    {
        removeLine(ManMail.getText());
        Alert msg1 = new Alert(AlertType.CONFIRMATION);
            msg1.setTitle(ManMail.getText());
            msg1.setContentText("User deleted.");
            msg1.showAndWait();
            msg1.close();
        App d = new App();
        d.changeScene("managerHomepage.fxml");
    }
    
    public void AddUserButton(ActionEvent event) throws IOException
    {
        
        boolean flag = false;
        
        if(ManMail.getText().equals("")){
            Alert msg1 = new Alert(AlertType.CONFIRMATION);
            msg1.setTitle("Areas contain \"*\" cannot be blank.");
            msg1.setContentText("Please enter the email");
            msg1.showAndWait();
            msg1.close();
            flag=true;
        }
        
         if(ManSurname.getText().equals("")){
            Alert msg3 = new Alert(AlertType.CONFIRMATION);
            msg3.setTitle("Areas contain \"*\" cannot be blank.");
            msg3.setContentText("Please enter the surname");
            msg3.showAndWait();
            flag=true;
        }
         if(ManPhone.getText().equals("")){
            Alert msg4 = new Alert(AlertType.CONFIRMATION);
            msg4.setTitle("Areas contain \"*\" cannot be blank.");
            msg4.setContentText("Please enter the phone");
            msg4.showAndWait();
            flag=true;
        }
        if(ManName.getText().equals("")){
            Alert msg5 = new Alert(AlertType.CONFIRMATION);
            msg5.setTitle("Areas contain \"*\" cannot be blank.");
            msg5.setContentText("Please enter the name");
            msg5.showAndWait();
            flag=true;
        }
        
        if(ManagerUname.getText().equals("")){
            Alert msg7 = new Alert(AlertType.CONFIRMATION);
            msg7.setTitle("Areas contain \"*\" cannot be blank.");
            msg7.setContentText("Please enter the username");
            msg7.showAndWait();
            flag=true;
        }
        
        for(j =0;j<App.list.size();j++)
        {
               
           }
                if(!(App.list.get(j-1).getEmail().equals(ManMail.getText() ))&&!(App.list.get(j-1).getUsername().equals(ManagerUname.getText() ))&& flag ==false) 
                {
                addLine();
                    
                    
                        
                Alert msg9 = new Alert(AlertType.CONFIRMATION);
                msg9.setTitle(ManMail.getText());
                        
                        msg9.setContentText("User added.");
                        App.list.add(new User(ManGender.getText(),ManName.getText(),ManSurname.getText(),"123",ManMail.getText(),ManPhone.getText(),"123",ManagerUname.getText()));
                        msg9.showAndWait();
                        App a = new App();
                        a.changeScene("managerHomepage.fxml");
                    
                    
                }
                   
        
       

    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
            usernameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("name"));
            surnameColumn.setCellValueFactory(new PropertyValueFactory<User,String>("surname"));
            phoneColumn.setCellValueFactory(new PropertyValueFactory<User,String>("phone"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
            genderColumn.setCellValueFactory(new PropertyValueFactory<User,String>("gender"));
            
            homepageTable.setItems(App.list);
        
       
        
        

                 
    }
    private void addLine() 
    {
        String line = ManGender.getText()+","+ManName.getText() +"," +ManMail.getText() +"," +"123" +"," +"123"+"," +ManPhone.getText()+","+""+","+ManagerUname.getText()+","+ManSurname.getText() ;

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
    private void removeLine(String mail) {
        try
           {
                   BufferedReader file = new BufferedReader(new FileReader("/home/mert/Desktop/hellofx/src/TextFiles/data.txt"));
                   String line;
                   String input = "";
                   while ((line = file.readLine()) != null) 
                   {
                       
                       //System.out.println(line);
                       if (line.contains(mail))
                       {
                           int i;
                           for(i=0;i<App.list.size();i++)
                           {
                               if(App.list.get(i).getEmail().equals(mail))
                               {
                                
                                   break;
                               }
                           }
                           App.list.remove(i);
                           line = "";
                           System.out.println("User deleted.");
                       }
                       input += line + '\n';
                   }
                   FileOutputStream File = new FileOutputStream("/home/mert/Desktop/hellofx/src/TextFiles/data.txt");
                   File.write(input.getBytes());
                   file.close();
                   File.close();
           }
           catch (Exception e)
           {
                   System.out.println("Problem reading file.");
           }
        
    }
    
   
        
        

}
        
        
    
    
    
    

