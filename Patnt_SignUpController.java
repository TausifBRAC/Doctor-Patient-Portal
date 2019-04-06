/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo3;

import Connectivity.ConnectionClass;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tausif Nazim71
 */
public class Patnt_SignUpController implements Initializable {

       @FXML
    public TextField f_name;

    @FXML
    public TextField L_name;

    @FXML
    public TextField nid;

    @FXML
    public Button signup;

    @FXML
    public TextField email;

    @FXML
    public PasswordField pass1;

    @FXML
    public PasswordField pass2;

    @FXML
    public TextField bg;

    @FXML
    public TextField wt;

    @FXML
    public Label gdr;

    @FXML
    public TextField age;

    @FXML
    public ComboBox<String> gdrcmb;
    
    String a="Male";
        String b="Female";
        ObservableList<String> list=FXCollections.observableArrayList(a,b);

    
     @Override
    public void initialize(URL url, ResourceBundle resources) {
        gdrcmb.setItems(list);
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        try {
             ConnectionClass connectionclass= new ConnectionClass();
             Connection connection=connectionclass.getConnectio();
             
             String sql="INSERT INTO `patient info`(`fn`, `Ln`, `eml`, `pass`, `bg`, `weight`, `gender`, `age`, `nid`) VALUES (?,?,?,?,?,?,?,?,?)";
             PreparedStatement ps=connection.prepareStatement(sql);
             
                ps.setString(1,f_name.getText());
                ps.setString(2,L_name.getText());
                ps.setString(3,email.getText());
                ps.setString(4,pass2.getText());
                ps.setString(5,bg.getText());
                ps.setInt(6,Integer.parseInt(wt.getText()));
                ps.setString(7,gdrcmb.getValue());
               ps.setInt(8,Integer.parseInt(age.getText()));
                ps.setString(9,nid.getText());
            
            int x = ps.executeUpdate();
            
         }
         catch (Exception e) {
             e.printStackTrace();
         } 
    }
    
       
      
       
    
}
