package Store;
import Customer.Person;
import java.util.HashMap;
public class Cook extends Person{
    public Cook(String country,String county,String city,String state,String postalcode){
        address.setter(country, county, city, state, postalcode);
        name="";
        password="";
        phoneNumber="";
        email="";
    /*
    name="Mr.chef";
    password="chef123";
    phoneNumber=98913;
    email="chef@yahoo.com";
    */
    }
    private Double wage=0.0;

    /*protected Double cooking(HashMap<String,Double> priceofFoods,HashMap<String,Integer> NumberofFoods){
        int length=priceofFoods.size();
        Double cost=0.0;
        for(String i: priceofFoods.keySet()){
            cost+=(priceofFoods.get(i))*(NumberofFoods.get(i))*(3/5);// Hallal profit
        }
        setwage(cost);
        return cost;
    }*/
    String path = "D:\\java_projects\\Market\\src\\Store\\CookFinance.txt";
    protected void cooking(Double m){
        wage=m+wage;
        Store.updatemoney(+1,m,path);
    }


}

