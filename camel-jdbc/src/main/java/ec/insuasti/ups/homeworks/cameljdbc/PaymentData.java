package ec.insuasti.ups.homeworks.cameljdbc;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(includeFieldNames=false)
public class PaymentData {
   
    private int id;
   
    private int limitBalance;
   
    private int sex;
   
    private int education;
   
    private int marriage;
    
    private int age;
   
    private int pay0;
   
    private int pay2;
   
    private int pay3;
   
    private int pay4;
    
    private int pay5;
    
    private int pay6;
    
    private int bill1;
   
    private int bill2;
   
    private int bill3;
   
    private int bill4;
    
    private int bill5;
   
    private int bill6;
   
    private int payv1;
    
    private int payv2;
   
    private int payv3;
  
    private int payv4;
   
    private int payv5;
    
    private int payv6;
    
    private int defaultPaymentNextMonth;

    public void setDefaultPaymentNextMonth(int defaultPaymentNextMonth) {
        this.defaultPaymentNextMonth = defaultPaymentNextMonth;
    }

    private boolean isValidPay(){
        if (payv1 <= 0 || payv2 <= 0 || payv3 <= 0 || payv4 <= 0 || payv5 <= 0 || payv6 <= 0 ){
            return false;
        }
        return true; 
    }

    private boolean isValidBil(){
        if (bill1 <= 0 || bill2 <= 0 || bill3 <= 0 || bill4 <= 0 || bill5 <= 0 || bill6 <= 0 ){
            return false;
        }
        return true; 
    }

    public boolean isValidEntry(){
        if (isValidPay() && isValidBil()){
            return true;
        } else { return false; }
    }


}
