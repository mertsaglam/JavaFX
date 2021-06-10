import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.image.Image;
import javafx.stage.Stage;
 
public class App extends Application {
    public static ObservableList<User> list = FXCollections.observableArrayList();
    
    private static Stage stg;
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        ReadFile();
        stg = primaryStage;
        primaryStage.setResizable(true);
        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        primaryStage.setTitle("Management App");
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
    }
        
        
        
        
    
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        
    }
   public static void main(String[] args) 
   {
        launch(args);
    }
    public void ReadFile(){
        try{
            //tableView.setItems(getUsers());
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
                    String Rpass = profile[4];
                    String phone =  profile[5];
                    String ID =  profile[6];
                    String username = profile[7];
                    String surname = profile[8];
                    list.add(new User(gender,name,surname,password,email,phone,Rpass,username));
                    
                    
                    
                }          
            }
            
        }
        
        catch (Exception e) 
        {
            System.out.println("hata burada!!" +e);
        }

    } 

}
