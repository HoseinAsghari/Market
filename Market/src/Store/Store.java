package Store;
import Customer.Address;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.Id;

//////////////////////
@Entity
public class Store {
    @Id
    public String name;
    public String password;
    public String phoneNumber;
    public static boolean open=true;
    private Double finance=10000000.0;

    public Address address=new Address();
    String path;
    public Store(String name,String password,String phoneNumber,String country,String county,String city,String state,String postalcode){
        address.setter(country, county, city, state, postalcode);

        this.name=name;
        this.password=password;
        this.phoneNumber=phoneNumber;
        Cook c =new Cook(country, county, city, state, postalcode);
        Postman p=new Postman(country, county, city, state, postalcode);
        path = "D:\\java_projects\\Market\\src\\Store\\Store"+name+"Finance.txt";
    }

    public static LocalTime beginning=LocalTime.parse("08:00:00");
    public static LocalTime end=LocalTime.parse("23:00:00");
    public static LocalTime t =LocalTime.now();
    DateTimeFormatter f= DateTimeFormatter.ISO_TIME;
    public static boolean openclose(){
        if ((t.compareTo(beginning))>=0 && (t.compareTo(end))<=0){open=true;}
        else{open=false;}
        return open;
    }

    public void commandToCook(Cook c ,Double co ){
        Double ccc=((3/5)*co);
       c.cooking(ccc);
        finance-=ccc;
        updatemoney(-1,ccc,path);
    }
    public void commandToPost(Postman p,Double co){
        Double x=co*(15/100);
        p.post(x,p.name);
        finance-=x;
        updatemoney(-1,x,path);
    }
    public void sell(Double x)
    {
        finance+=x;
        updatemoney(+1,x,path);
    }
    public Double getFinance(){
        return finance;
    }

    public static void updatemoney(int profit,Double cash,String path) {
        if ((profit == 1) || (profit == -1)) {
            Double x = profit * cash;
            try {
                BufferedWriter fw = new BufferedWriter(new FileWriter(path, true));
                if (x > 0) {
                    fw.write("+ " + x +"\n");
                } else if (x < 0) {
                    fw.write("- " + (-1*x) +"\n");
                }

                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //private Integer Numberoffoods = typesAndNumberofFoods.size();
    /*
    public String sell (String typefood , int numfood){
        if(!(openclose())){return "Store is close";}
        if (numfood<=0){
            return "You have bought nothing";
        }
        else{
            if( typesAndNumberofFoods.containsKey(typefood) && (typesAndNumberofFoods.get(typefood)>=numfood)){
                finance+=(typesAndNumberofFoods.get(typefood))*(typesAndpriceofFoods.get(typefood));
                typesAndNumberofFoods.put(typefood,(typesAndNumberofFoods.get(typefood))-1);

                return "Thanks for puchase";
            }
            else{
                return "Your purchase is not valid";
            }

        }
    }

     */
}
