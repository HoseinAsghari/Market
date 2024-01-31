package Store;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class GrStore extends JFrame implements ActionListener {
    JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9;
    JLabel l2;
    JButton btnRegister;
    JButton btnApply;
    ArrayList<JTextField> text = new ArrayList<JTextField>();
    ArrayList<JTextField> foodtype = new ArrayList<JTextField>();
    ArrayList<JTextField> foodnumber = new ArrayList<JTextField>();
    ArrayList<JTextField> foodprice = new ArrayList<JTextField>();
    HashMap <String,Double> priceofFoods=new HashMap<String,Double>();
    HashMap <String,Integer> NumberofFoods=new HashMap<String,Integer>();
    Store s;
    Cook c;
    Postman p;
    Double totalcostofcook;
    public GrStore(){
        //
        setLayout(null);
        setTitle("Register as Store");
        setSize(1250,750);
        setLocation(205,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //
        JLabel l1 =new JLabel("Insert properties of your Store :");
        l1.setBounds(2, 2,300,20);
        JLabel l3 =new JLabel("Insert food name :");
        l3.setBounds(350, 2,250,20);
        JLabel l4 =new JLabel("Insert food number :");
        l4.setBounds(650, 2,250,20);
        JLabel l5 =new JLabel("Insert food price :");
        l5.setBounds(950, 2,250,20);
        setVisible(true);
        //
        l2 =new JLabel("");
        l2.setBounds(100,450, 300, 20);
        //
        add(l1);
        add(l2);
        add(l4);
        add(l3);
        add(l5);
        //
        text.add(new JTextField("name(At most 20 characters)", 20));
        text.get(0).setBounds(15,30, 300, 20);
        text.add(new JTextField("password(At most 20 characters)", 20));
        text.get(1).setBounds(15,55, 300, 20);
        text.add(new JTextField("phoneNumber(At most 20 characters)", 20));
        text.get(2).setBounds(15,80, 300, 20);
        text.add(new JTextField("cookname(At most 20 characters)", 20));
        text.get(3).setBounds(15,105, 300, 20);
        text.add(new JTextField("cookpassword(At most 20 characters)", 20));
        text.get(4).setBounds(15,130, 300, 20);
        text.add(new JTextField("cookphoneNumber(At most 20 characters)", 20));
        text.get(5).setBounds(15,155, 300, 20);
        text.add(new JTextField("cookemail(At most 20 characters)", 20));
        text.get(6).setBounds(15,180, 300, 20);
        text.add(new JTextField("postmanname(At most 20 characters)", 20));
        text.get(7).setBounds(15,205, 300, 20);
        text.add(new JTextField("postmanpassword(At most 20 characters)", 20));
        text.get(8).setBounds(15,230, 300, 20);
        text.add(new JTextField("postmanphoneNumber(At most 20 characters)", 20));
        text.get(9).setBounds(15,255, 300, 20);
        text.add(new JTextField("postmanemail(At most 20 characters)", 20));
        text.get(10).setBounds(15,280, 300, 20);
        text.add(new JTextField("country(At most 20 characters)", 20));
        text.get(11).setBounds(15,305, 300, 20);
        text.add(new JTextField("county(At most 20 characters)", 20));
        text.get(12).setBounds(15,330, 300, 20);
        text.add(new JTextField("city(At most 20 characters)", 20));
        text.get(13).setBounds(15,355, 300, 20);
        text.add(new JTextField("state(At most 20 characters)", 20));
        text.get(14).setBounds(15,380, 300, 20);
        text.add(new JTextField("postalcode(At most 20 characters)", 20));
        text.get(15).setBounds(15,400, 300, 20);
        // 4 type food
        ///
        foodtype.add(new JTextField("name(At most 20 characters)", 20));
        foodtype.get(0).setBounds(350,20, 250, 20);
        foodtype.add(new JTextField("name(At most 20 characters)", 20));
        foodtype.get(1).setBounds(350,45, 250, 20);
        foodtype.add(new JTextField("name(At most 20 characters)", 20));
        foodtype.get(2).setBounds(350,70, 250, 20);
        foodtype.add(new JTextField("name(At most 20 characters)", 20));
        foodtype.get(3).setBounds(350,95, 250, 20);
        ///
        foodnumber.add(new JTextField("number(At most 20 characters)", 20));
        foodnumber.get(0).setBounds(650,20, 250, 20);
        foodnumber.add(new JTextField("number(At most 20 characters)", 20));
        foodnumber.get(1).setBounds(650,45, 250, 20);
        foodnumber.add(new JTextField("number(At most 20 characters)", 20));
        foodnumber.get(2).setBounds(650,70, 250, 20);
        foodnumber.add(new JTextField("number(At most 20 characters)", 20));
        foodnumber.get(3).setBounds(650,95, 250, 20);
        ///
        foodprice.add(new JTextField("price(At most 20 characters)", 20));
        foodprice.get(0).setBounds(950,20, 250, 20);
        foodprice.add(new JTextField("price(At most 20 characters)", 20));
        foodprice.get(1).setBounds(950,45, 250, 20);
        foodprice.add(new JTextField("price(At most 20 characters)", 20));
        foodprice.get(2).setBounds(950,70, 250, 20);
        foodprice.add(new JTextField("price(At most 20 characters)", 20));
        foodprice.get(3).setBounds(950,95, 250, 20);

        ///
        //
        for (int i=0;i<16;i++){
            JTextField temp1=text.get(i);
            temp1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    temp1.setText("");
                }
            });
            text.add(temp1);
            add(temp1);
        }
        ///
        for (int i=0;i<4;i++){
            JTextField temp1=foodtype.get(i);
            temp1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    temp1.setText("");
                }
            });
            foodtype.add(temp1);
            add(temp1);
        }
        ///
        for (int i=0;i<4;i++){
            JTextField temp1=foodnumber.get(i);
            temp1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    temp1.setText("");
                }
            });
            foodnumber.add(temp1);
            add(temp1);
        }///
        for (int i=0;i<4;i++){
            JTextField temp1=foodprice.get(i);
            temp1.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e){
                    temp1.setText("");
                }
            });
            foodprice.add(temp1);
            add(temp1);
        }///
        //

        btnRegister =new JButton("Register");
        btnRegister.setBounds(100,250, 200, 30);
        btnRegister.addActionListener(this);
        add(btnRegister );
        btnRegister.setBounds(100,500, 100, 50);
        ///
        btnApply  =new JButton("Apply");
        btnApply.setBounds(100,250, 200, 30);
        btnApply.addActionListener(this);
        add(btnApply);
        btnApply.setBounds(700,200, 100, 50);
        ///


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object ob = ae.getSource();
        if (btnRegister == ob) {
            ArrayList<String> t = new ArrayList<String>();
            boolean iscomplete = true;
            int length = text.size();
            for (int i = 0; i < length; i++) {
                String temp = text.get(i).getText();
                t.add(temp);
                if (true == temp.equals("")) {
                    iscomplete = false;
                }
            }

            if (iscomplete == false) {
                l2.setText("information is not complete");
            } else {
                s = new Store(t.get(0), t.get(1), t.get(2), t.get(11), t.get(12), t.get(13), t.get(14), t.get(15));

                //
                c = new Cook(t.get(11), t.get(12), t.get(13), t.get(14), t.get(15));
                c.name = t.get(3);
                c.password = t.get(4);
                c.email = t.get(6);
                c.phoneNumber = (t.get(5));
                //
                p = new Postman(t.get(11), t.get(12), t.get(13), t.get(14), t.get(15));
                p.name = t.get(7);
                p.password = t.get(8);
                p.email = t.get(10);
                p.phoneNumber = (t.get(9));
                l2.setText("Registeration is done");

                ////////
                writeregister();

            }

        }


        if (ae.getSource() == btnApply) {
            ArrayList<String> tfoodtype = new ArrayList<String>();
            boolean iscompletefoodtype = true;
            ArrayList<Integer> tfoodnum = new ArrayList<Integer>();
            boolean iscompletefoodnum = true;
            ArrayList<Double> tfoodprice = new ArrayList<Double>();
            boolean iscompletefoodprice = true;
            int length = foodtype.size();
            for (int i = 0; i < length; i++) {
                String temp = foodtype.get(i).getText();
                tfoodtype.add(temp);
                if (true == temp.equals("")) {
                    iscompletefoodtype = false;
                }
                //
                Integer tempft = Integer.parseInt(foodnumber.get(i).getText());
                tfoodnum.add(tempft);
                if (true == tempft.equals("")) {
                    iscompletefoodnum = false;
                }
                //
                Double tempfp = Double.parseDouble(foodprice.get(i).getText());
                tfoodprice.add(tempfp);
                if (true == tempfp.equals("")) {
                    iscompletefoodprice = false;
                }
            }
            if ((iscompletefoodprice && iscompletefoodnum && iscompletefoodtype) == false) {
                l2.setText("information is not complete");
            } else {
                for (int i = 0; i < length; i++) {
                    NumberofFoods.put(tfoodtype.get(i), tfoodnum.get(i));
                    priceofFoods.put(tfoodtype.get(i), tfoodprice.get(i));
                }
                l2.setText("Registeration is done");
                totalcostofcook = 0.0;
                for (String i : priceofFoods.keySet()) {
                    Double cs = (NumberofFoods.get(i)) * (priceofFoods.get(i));
                    totalcostofcook += cs;
                }
                if (totalcostofcook <= (s.getFinance())) {
                    s.commandToCook(c, totalcostofcook);
                    writefileapply();
                } else {
                    JOptionPane.showMessageDialog(this, "You do not have enough finance");
                }
//////////////////////


            }


        }
    }


        public void writeregister(){
            boolean repeated = false;

            try {

                BufferedReader fr = new BufferedReader(new FileReader("D:\\java_projects\\Market\\src\\Manager\\Storeslogin.txt"));
                String line = null;

                if ((line = fr.readLine()) != null) {
                    do {

                        if (line.equals(s.name + "\t" + s.password + "\t" + s.phoneNumber + "\t" + s.address.country + "\t" + s.address.county + "\t" + s.address.city + "\t" + s.address.state + "\t" + s.address.postalcode+ "\t" + c.name + "\t" + c.password + "\t" + c.email + "\t" + c.phoneNumber+ "\t" + p.name + "\t" + p.password + "\t" + p.email + "\t" + p.phoneNumber)) {
                            JOptionPane.showMessageDialog(this, "this information is already written");
                            repeated = true;
                            break;
                        }
                    } while ((line = fr.readLine()) != null);
                    if (!(repeated)) {
                        writefilereg();

                    }
                } else {
                    writefilereg();
                }
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

        public void writefilereg () {
        String input=s.name + "\t" + s.password + "\t" + s.phoneNumber + "\t" + s.address.country + "\t" + s.address.county + "\t" + s.address.city + "\t" + s.address.state + "\t" + s.address.postalcode+ "\t" + c.name + "\t" + c.password + "\t" + c.email + "\t" + c.phoneNumber+ "\t" + p.name + "\t" + p.password + "\t" + p.email + "\t" + p.phoneNumber + "\n";
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("D:\\java_projects\\Market\\src\\Manager\\Storeslogin.txt", true));
            fw.write(input);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writefileapply () {
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("D:\\java_projects\\Market\\src\\Manager\\Foods\\"+s.name+".txt", true));
            fw.write("Food" + "\t" + "\t" + "Number" + "\t" + "\t" + "price" + "\n");
            for (String i : priceofFoods.keySet()) {
                fw.write(i + "\t" + "\t" + NumberofFoods.get(i) + "\t" + "\t" + priceofFoods.get(i) + "\n");

            }
            fw.close();
            priceofFoods.clear();
            NumberofFoods.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//////
