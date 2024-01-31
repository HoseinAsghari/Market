package Customer;
import Store.Store;
import javax.persistence.Entity;
import javax.persistence.Id;

//////////////////////
@Entity
public class Customer extends Person{
    @Id
    String path;
    public Customer(String country,String county,String city,String state,String postalcode){
        address.setter(country, county, city, state, postalcode);
        name="";
        password="";
        phoneNumber="";
        email="";
        path = "D:\\java_projects\\Market\\src\\Customer\\Customer"+name+"Finance.txt";
        /*
        name="Mr.chef";
        password="chef123";
        phoneNumber=98913;
        email="chef@yahoo.com";
        */
    }

    private Double money=1000.0;
    public void setMoney(Double m){
        money=m;
    }
    public Double getMoney(){
        return money;
    }
    public void buy(Double m,String name1){
        setMoney(m);
        Store.updatemoney(-1,m,"D:\\java_projects\\Market\\src\\Customer\\Customer"+name1+"Finance.txt");
    }

}
