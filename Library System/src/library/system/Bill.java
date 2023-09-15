
package library.system;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class Bill {
    public Date paymentDate = new Date();
    public static int bill_id = 0;
    public double totalPrice;
    
    public Bill(){}

    public void createBill(List<String> booktitle, List<String> booktype, List<Double> bookPrice){
        
        bill_id++;
        
        for(int j=0 ; j<bookPrice.size(); j++){
            this.totalPrice+= bookPrice.get(j);
        }      
        
        System.out.println("\t----------------------------BILL WITH ID:" + bill_id + "----------------------------");
        
        System.out.println("\tThe Book Type:\tThe Book Title:\t\t\t\t\tPrice:");
        
        for(int i=0 ; i<booktitle.size() ; i++){    
            System.out.println("\t" + booktype.get(i) + "\t" + booktitle.get(i));  
            System.out.println("\t\t\t\t\t\t\t\t\t " + bookPrice.get(i));
        }
        
        System.out.println("\t---------------------------------------------------------------------");
        
        System.out.println("\tTotal price is: "+ this.totalPrice);
        System.out.println("\tDate of bill: " + this.paymentDate);
        System.out.print("\tlimited time to return book after one month at " );
        
        Calendar c = Calendar.getInstance();
        c.setTime(paymentDate);
        c.add(Calendar.MONTH, 1);
        Date returnDate = c.getTime();
        
        System.out.println(returnDate);
        
    }
}
