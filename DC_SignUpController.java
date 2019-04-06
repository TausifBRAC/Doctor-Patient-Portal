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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Tausif Nazim71
 */
public class DC_SignUpController implements Initializable {

     @FXML
    public TextField f_name;
     
   // String FN= f_name.getText();

    
    public TextField L_name;
    //String LN= L_name.getText();

    @FXML
   public TextArea education;
    //String edu= education.getText();

    @FXML
    public TextArea specialization;
    //String spc= specialization.getText();

    @FXML
    public TextArea Address;
    //String ads= Address.getText();

    @FXML
    public TextField NID;
    //String nd= NID.getText();

    @FXML
    public TextField visit_fee;
    //String vf= visit_fee.getText();    
    
    
    @FXML
    public TextField email1;
    //String eml= email1.getText();
    
    @FXML
    public PasswordField enter_pass;
    //String epass= enter_pass.getText();
    
    @FXML
    public PasswordField confirm_pass;
    //String cpass=confirm_pass.getText();
    
    public Button sign_up1;
    @FXML
    void handleButtonAction(ActionEvent event) {
         try {
             ConnectionClass connectionclass= new ConnectionClass();
             Connection connection=connectionclass.getConnectio();
             
             String sql="INSERT INTO `doctor info`(`fn`, `Ln`, `edu`, `spec`, `adrs`, `nid`, `fee`, `eml`, `pass`) VALUES (?,?,?,?,?,?,?,?,?)";
             PreparedStatement ps=connection.prepareStatement(sql);
             
                ps.setString(1,f_name.getText());
                ps.setString(2,L_name.getText());
                ps.setString(3,education.getText());
                ps.setString(4,specialization.getText());
                ps.setString(5,Address.getText());
                ps.setString(6,NID.getText());
                ps.setInt(7,Integer.parseInt(visit_fee.getText()));
                ps.setString(8,email1.getText());
                ps.setString(9,confirm_pass.getText());
            
            int x=ps.executeUpdate();
            
         }
         catch (Exception e) {
             e.printStackTrace();
         }
    }
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    
}
