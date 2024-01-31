package Store;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class GrStoreOrderstate  extends JFrame{
    JLabel l1,lt1,l2,lt2,l3,lt3,l4,lt4,l5,lt5,l6,lt6,l7,lt7,l8,lt8,l9,lt9,l10,lt10,l11,lt11;
    public GrStoreOrderstate(Orderstate o) {
        setLayout(null);
        setTitle("Orderstate");
        setSize(1000,450);
        setLocation(455,100);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //

        //
        l1 =new JLabel("food : ");
        l1.setBounds(10,10, 300, 20);
        lt1 =new JLabel(o.food);
        lt1.setBounds(310,10, 300, 20);
        add(l1);
        add(lt1);
        //
        l2 =new JLabel("number : ");
        l2.setBounds(10,35, 300, 20);
        lt2 =new JLabel(o.number);
        lt2.setBounds(310,35, 300, 20);
        add(l2);
        add(lt2);
        //
        l3 =new JLabel("Customername : ");
        l3.setBounds(10,60, 300, 20);
        lt3 =new JLabel(o.Customername);
        lt3.setBounds(310,60, 300, 20);
        add(l3);
        add(lt3);
        //
        l4 =new JLabel("Customerphonenumber : ");
        l4.setBounds(10,85, 300, 20);
        lt4 =new JLabel(o.Customerphonenumber);
        lt4.setBounds(310,85, 300, 20);
        add(l4);
        add(lt4);
        //
        l5 =new JLabel("CustomerAddress : ");
        l5.setBounds(10,110, 600, 20);
        lt5 =new JLabel("Country: "+ o.CustomerAddress.country + "County: "+ o.CustomerAddress.county + "City: "+ o.CustomerAddress.city + "State: "+ o.CustomerAddress.state + "Postalcode: "+ o.CustomerAddress.postalcode);
        lt5.setBounds(310,110, 600, 20);
        add(l5);
        add(lt5);
        //
        l6 =new JLabel("Storename : ");
        l6.setBounds(10,135, 300, 20);
        lt6 =new JLabel(o.Storename);
        lt6.setBounds(310,135, 300, 20);
        add(l6);
        add(lt6);
        //
        l7 =new JLabel("Storephonenumber : ");
        l7.setBounds(10,185, 300, 20);
        lt7 =new JLabel(o.Storephonenumber);
        lt7.setBounds(310,185, 300, 20);
        add(lt7);
        add(l7);
        //
        l8 =new JLabel("StoreAddress : ");
        l8.setBounds(10,210, 600, 20);
        lt8 =new JLabel("Country: "+ o.StoreAddress.country + "County: "+ o.StoreAddress.county + "City: "+ o.StoreAddress.city + "State: "+ o.StoreAddress.state + "Postalcode: "+ o.StoreAddress.postalcode);
        lt8.setBounds(310,210, 300, 20);
        add(l8);
        add(lt8);
        //
        l9 =new JLabel("Postmanname : ");
        l9.setBounds(10,235, 300, 20);
        lt9 =new JLabel(o.Postmanname);
        lt9.setBounds(310,235, 300, 20);
        add(l9);
        add(lt9);
        //
        l10 =new JLabel("PostmanphoneNumber : ");
        l10.setBounds(10,260, 600, 20);
        lt10 =new JLabel(o.PostmanphoneNumber);
        lt10.setBounds(310,260, 300, 20);
        add(l10);
        add(lt10);
        //
        //
        l11 =new JLabel("Deliverytime : ");
        l11.setBounds(10,285, 300, 20);
        lt11 =new JLabel((o.Deliverytime).toString());
        lt11.setBounds(310,285, 300, 20);
        add(l11);
        add(lt11);
        orderstatefile();
        //
    }
    private void orderstatefile(){
        String path="D:\\java_projects\\Market\\src\\Customer\\OSof"+lt3.getText()+".txt";

        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(path, false));
            fw.write("");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {

            BufferedWriter fw = new BufferedWriter(new FileWriter(path, true));
            fw.write("food : " + "\t" + "\t" + lt1.getText() + "\n");
            fw.write("number : " + "\t" + "\t" + lt2.getText() + "\n");
            fw.write("Customername : " + "\t" + "\t" + lt3.getText() + "\n");
            fw.write("Customerphonenumber : " + "\t" + "\t" + lt4.getText() + "\n");
            fw.write("CustomerAddress : " + "\t" + "\t" + lt5.getText() + "\n");
            fw.write("Storename : " + "\t" + "\t" + lt6.getText() + "\n");
            fw.write("Storephonenumber : " + "\t" + "\t" + lt7.getText() + "\n");
            fw.write("StoreAddress : " + "\t" + "\t" + lt8.getText() + "\n");
            fw.write("Postmanname : " + "\t" + "\t" + lt9.getText() + "\n");
            fw.write("PostmanphoneNumber : " + "\t" + "\t" + lt10.getText() + "\n");
            fw.write("Deliverytime : " + "\t" + "\t" + lt11.getText() );
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



