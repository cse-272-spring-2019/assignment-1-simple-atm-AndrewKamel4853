/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hppp
 */
public class ATM extends Application {
    MathAndLogic authentication;
    public static void main(String[] args){
        launch(args);
    }
   
    @Override
        public void start(Stage primaryStage) throws Exception{
            authentication =new MathAndLogic();
        Menu authentication1 = new Menu(); 
       primaryStage.setTitle("ATM");
       Label Pin=new Label("Enter Your Password");
       PasswordField Inputp=new PasswordField(); 
       Button logIn=new Button("Log in");
       Label validationLabel =new Label();
       GridPane grid=new GridPane();
       grid.add(Pin,0,0);
       grid.add(Inputp,0,1);
       grid.add(logIn,2,1);
       grid.add(validationLabel,3,1);
       logIn.setOnAction(new EventHandler<ActionEvent>(){
           @Override
           public void handle(ActionEvent event) {
               String password=Inputp.getText();
              boolean valid = authentication.verification(password);
              if(valid){
                   try {
                       authentication1.start(primaryStage);
                   } catch (Exception ex) {
                       Logger.getLogger(ATM.class.getName()).log(Level.SEVERE, null, ex);
                   }
                 
                  
              }else{
                  validationLabel.setText("Incorrect pin");
                  
                  
              }
               }
           });
           
       
       Scene scene = new Scene(grid,500,350);
       primaryStage.setScene(scene);
       primaryStage.show();
       
    }
        };