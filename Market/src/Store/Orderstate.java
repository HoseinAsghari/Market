package Store;
import java.time.LocalTime;
import Customer.Address;
import Customer.Customer;
import javax.persistence.Entity;
import javax.persistence.Id;

//////////////////////
@Entity
public class Orderstate {
    @Id
    String food,number,Customername,Customerphonenumber,Storename,Storephonenumber,Postmanname,PostmanphoneNumber;
    LocalTime Deliverytime;
    Address CustomerAddress,StoreAddress;
    public Orderstate(Customer c,String typefood , Integer numfood, Store s ,Postman p){
        food=typefood;
        number=numfood.toString();
        Customername=c.name;
        Customerphonenumber=c.phoneNumber;
        CustomerAddress= c.address;
        Storename=s.name;
        Storephonenumber=s.phoneNumber.toString();
        StoreAddress = s.address;
        Postmanname=p.name;
        PostmanphoneNumber=p.phoneNumber.toString();
        Deliverytime=p.deliverytime(c);


    }
}


