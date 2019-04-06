/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Tausif Nazim71
 */
public class SignUpController implements Initializable {

       public ComboBox<String> combo2;
        
            String a="Doctor";
        String b="patient";
        ObservableList<String> list=FXCollections.observableArrayList(a,b);

    
     @Override
    public void initialize(URL url, ResourceBundle resources) {
        combo2.setItems(list);
    } 
    private Button cont2;

    @FXML
    void handleButtonAction(ActionEvent event) {
        //String d=combo2.getValue();
        //System.err.println(d);
        if(combo2.getValue().equals("Doctor")){
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DC_SignUp.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();}
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else{
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Patnt_SignUp.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();}
        catch(IOException e){
            e.printStackTrace();
        }
        }

    }
    
}
