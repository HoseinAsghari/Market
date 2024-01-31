package Customer;

public class Address {
    public String country;
    public String county;
    public String city;
    public String postalcode;
    public String state;
    public void setter(String country,String county,String city,String state,String postalcode){
        this.country=country;
        this.county=county;
        this.city=city;
        this.postalcode=postalcode;
        this.state=state;
    }

}
