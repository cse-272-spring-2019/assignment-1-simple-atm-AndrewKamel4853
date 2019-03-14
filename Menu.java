package ATM ;



import static ATM.MathAndLogic.Balance;
import static ATM.MathAndLogic.history;
import static ATM.MathAndLogic.i;
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
import static javafx.application.Application.launch;

public class Menu {
   
       
       
   public void start(Stage primaryStage) throws Exception{
       yourBalance Bibo = new yourBalance();
       Withdraw Wizzo = new Withdraw();
       primaryStage.setTitle("ATM");
       Label Pin1=new Label("Choose one of the operations below"); 
       Button Withdraw=new Button("credit");
       Button Credit=new Button("withdraw");
       Button PreviousTransaction=new Button("<--Previous transaction");
       Button NextTransaction=new Button("Next transaction-->");
       Button YourBalance=new Button("Show Your Balance");
       Label balance = new Label();
       GridPane grid=new GridPane();
       grid.add(Pin1,0,0);
       grid.add(Credit,0,1);
       grid.add(Withdraw,2,1);
       grid.add(PreviousTransaction,0,2);
       grid.add(NextTransaction,2,2);
       grid.add(YourBalance,1,3);
       grid.add(balance,1,4);
       Scene scene1 = new Scene(grid,500,350);
       primaryStage.setScene(scene1);
       primaryStage.show();
       Withdraw.setOnAction(new EventHandler<ActionEvent>(){
       @Override
       public void handle(ActionEvent event){
               try {
                   Bibo.start(primaryStage);
               } catch (Exception ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
       });
       YourBalance.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
           balance.setText("Your Balance is "+Balance);
           }
       });
       Credit.setOnAction(new EventHandler<ActionEvent>(){
       @Override
       public void handle(ActionEvent event){
               try {
                   Wizzo.start(primaryStage);
               } catch (Exception ex) {
                   Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
       });
       PreviousTransaction.setOnAction(new EventHandler<ActionEvent>(){
       @Override
       public void handle(ActionEvent event){
       
       if(i==0){
           balance.setText("No previous transactions");
           i--;
       }else
       {
           balance.setText(history[i-1]);
       i--;
       }
       }
           
       });
       NextTransaction.setOnAction(new EventHandler<ActionEvent>(){
       @Override
       public void handle(ActionEvent event){
           if(history[i+1]!=null){
           balance.setText(history[i+1]);
       i++;
           }else{
               balance.setText("No more transactions");
           i++;
           
           }
           
           }
       });
         




               }}