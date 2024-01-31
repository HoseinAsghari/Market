package Store;
import Customer.Person;
import Customer.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalTime;
public class Postman extends Person {
    String path;
    public Postman(String country,String county,String city,String state,String postalcode){
        address.setter(country, county, city, state, postalcode);
        name="";
        password="";
        phoneNumber="";
        email="";
        path = "D:\\java_projects\\Market\\src\\Store\\PostmanFinance.txt";
    }
    private Double wage=0.0;

    public void post(Double x,String nam){
        x=x*(15/100);
        wage=x+wage;
        //Store.updatemoney(+1,x,path);

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("D:\\java_projects\\Market\\src\\Store\\Postman"+nam+"Finance.txt", true));
            fw.write("+ " + x + "\n");
            fw.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    protected Double distance(Customer c){
        /*
         * calculate by GPS
         *
         */
        // default case
        if (c.address.city.equals(this.address.city)){
            return 4.0;// km
        }
        if (!(c.address.city.equals(this.address.city))){
            return 24.0;// km
        }
        else{
            return -1.0 ;// not valid
        }
        // default case
    }
    protected LocalTime deliverytime(Customer c){
        Double dist=distance(c);
        if(dist==0){return null;}
        if(dist==4){
            return (LocalTime.now()).plusMinutes(10);
        }
        if(dist==24){
            return (LocalTime.now()).plusMinutes(72);
        }
        else{return null;}
    }

}



//////////////////////
