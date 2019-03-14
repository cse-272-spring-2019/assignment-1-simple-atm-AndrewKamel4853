package ATM;
import static ATM.MathAndLogic.Balance;
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
public class yourBalance extends Application {
              
    @Override

    public void start(Stage primaryStage) throws Exception{
       Menu authentication2 = new Menu();
     MathAndLogic authentication1 = new MathAndLogic();
       primaryStage.setTitle("Credit");
       Label Pin11=new Label("Enter the amount of money you want to deposit in your account"); 
       TextField Amount=new TextField("");
       Label user=new Label();
       Button complete=new Button("transaction completed");
       Button back=new Button("<--Return to menu");
       GridPane grid=new GridPane();
       grid.add(Pin11,0,0);
       grid.add(complete,0,2);
       grid.add(Amount,0,1);
       grid.add(user,0,4);
       grid.add(back,0,3);
       Scene scene1 = new Scene(grid,500,350);
       primaryStage.setScene(scene1);
       primaryStage.show();
       complete.setOnAction(new EventHandler<ActionEvent>(){

       @Override
       public void handle(ActionEvent event){ 
       String AmountWithd=Amount.getText();
        Double AmountWD=Double.parseDouble(AmountWithd);
       double BalanceWithd=authentication1.Credit(AmountWD,Balance);        
       
             user.setText("Mission Accomplished ");
        Balance=BalanceWithd;
        }
       });           
       back.setOnAction(new EventHandler<ActionEvent>(){
          @Override       
        public void handle(ActionEvent event){ 
            
              try {
                  authentication2.start(primaryStage);
              } catch (Exception ex) {
                  Logger.getLogger(Withdraw.class.getName()).log(Level.SEVERE, null, ex);
              }
}
    });
    }
}