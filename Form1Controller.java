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
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Tausif Nazim71
 */
public class Form1Controller implements Initializable {
    
     public Button createAccount;
     public Button sign_in;
     
      public TextField email_label;

      public PasswordField pass_field;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource()==createAccount){
            
        try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
                
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.setScene(new Scene(root1));  
                stage.show();
               
                
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
        else if(event.getSource()==sign_in){
            String email=email_label.getText();
            String pass=pass_field.getText();
            
            try{
             ConnectionClass connectionclass= new ConnectionClass();
             Connection connection=connectionclass.getConnectio();
             
             String sql="SELECT * FROM `doctor info` WHERE eml='"+email+"'and pass='"+pass+"'";
             PreparedStatement ps=connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             //String sql2="SELECT * FROM `patient info` WHERE eml='"+email+"'and pass='"+pass+"'";
             //PreparedStatement ps2=connection.prepareStatement(sql2);
             //ResultSet rs2 = ps.executeQuery();
              
             
             if(rs.next()){
                 try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Doctor_LogIn.fxml"));
                
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.setScene(new Scene(root1));  
                stage.show();
               
                
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
      }
             else {
                 System.out.println("In pat");
                 String sql2="SELECT * FROM `patient info` WHERE eml='"+email+"'and pass='"+pass+"'";
                 PreparedStatement ps2=connection.prepareStatement(sql2);
                 ResultSet rs2 = ps2.executeQuery();
                 if(rs2.next()){
                 try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Patient_LogIn.fxml"));
                
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.setScene(new Scene(root1));  
                stage.show();
               
                
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
             }
                 else{
                     try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NoLogIn.fxml"));
                
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                
                stage.setScene(new Scene(root1));  
                stage.show();
               
                
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
                 }
             }
            
        }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
