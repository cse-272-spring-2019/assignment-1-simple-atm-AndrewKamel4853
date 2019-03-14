package ATM;

import javafx.stage.Stage;

public class MathAndLogic {
    static double Balance;
   static String[]history=new String[100];
    static int i;
        public boolean verification(String password){
            String real = (String) password;
            real="241097";
            if(password.equals(real)){
                
       return true;
             }
            else
            {
                return false;
                }  
        }
        public double withdrawT(double amountWithd,double Balance){
            Balance=Balance-amountWithd;
            history[i]=("withdraw by: "+amountWithd);
            i++;
             return Balance;
        }
        public double Credit(double amountWithd,double Balance){
            Balance=Balance+amountWithd;
                        history[i]=("deposit by: "+amountWithd);
            i++;
             return Balance;
        }
}