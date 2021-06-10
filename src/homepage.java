import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class homepage implements Initializable
{
    private User loginUser; 

    
    
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
    @FXML
    private Label isim;
    
    
    
    public void userLogout(ActionEvent event) throws IOException{
        
        App d = new App();
        d.changeScene("loginScreen.fxml");
        
        
    }
    public void settings(ActionEvent event) throws IOException{
        App c = new App();
        c.changeScene("profileSettings.fxml");
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
    
   
        
        

}
        
        
    
    
    
    

