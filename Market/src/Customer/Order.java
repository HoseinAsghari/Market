package Customer;

import Store.Orderstate;
import Store.Store;
import Store.Postman;
import Store.GrStoreOrderstate;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order extends JFrame implements ActionListener {
    JComboBox foods, numbers, store;
    JTextField usertxt, passtxt, pricetxt;
    JButton btnlogin, btnorder;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;

    String[] storename, foodname, foodnumber, foodprice;
    boolean validlogin = false;
    String susenm, spasswd, selectedStore, selectedfood, selectednum;
    int index, indexcustomer, storeindex,foodindex;
    Double totalprice;
    ArrayList<String> f,n,p;


    public Order() {

        setLayout(null);
        setTitle("Register as Customer");
        setSize(1000, 700);
        setLocation(1, 1);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        /////
        usertxt = new JTextField("Name", 30);
        passtxt = new JTextField("Password", 30);
        usertxt.setBounds(10, 50, 200, 30);
        passtxt.setBounds(10, 100, 200, 30);
        usertxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                usertxt.setText("");
            }
        });
        passtxt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                passtxt.setText("");
            }
        });
        add(passtxt);
        add(usertxt);
        pricetxt = new JTextField("price");
        pricetxt.setBounds(750, 50, 100, 30);
        pricetxt.setEnabled(false);
        add(pricetxt);
        ////
        l1 = new JLabel("Login as Cusromer");
        l1.setBounds(10, 10, 200, 20);
        add(l1);
        l2 = new JLabel("result");
        l2.setBounds(10, 180, 200, 20);
        add(l2);
        l3 = new JLabel("Stores");
        l3.setBounds(250, 10, 100, 20);
        add(l3);
        l4 = new JLabel("Foods");
        l4.setBounds(400, 10, 100, 20);
        add(l4);
        l5 = new JLabel("Numbers");
        l5.setBounds(550, 10, 100, 20);
        add(l5);
        l7 = new JLabel("Price");
        l7.setBounds(750, 10, 100, 20);
        add(l7);
        l6 = new JLabel("");
        l6.setBounds(550, 300, 300, 20);
        add(l6);
        l8 = new JLabel("");
        l8.setBounds(650, 200, 300, 20);
        add(l8);
        /////

        btnlogin = new JButton("Login");
        btnlogin.setBounds(10, 250, 100, 50);
        btnlogin.addActionListener(this);
        add(btnlogin);
        /////


    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object ob = ae.getSource();
        if (store == ob) {
            selectedStore = store.getSelectedItem().toString();
            storeindex = store.getSelectedIndex();
            // System.out.println(selectedStore);
            File myfile = new File("D:\\java_projects\\Market\\src\\Manager\\Foods\\" + selectedStore + ".txt");
            String regex = "(\\w+)\\s*(\\d+)\\s*(\\d+)";
             f = readinfo(myfile, regex, 1, true);
            foodname = Arrays.copyOf(f.toArray(), f.size(), String[].class);
            n = readinfo(myfile, regex, 2, true);
            foodnumber = Arrays.copyOf(n.toArray(), n.size(), String[].class);
             p = readinfo(myfile, regex, 3, true);
            foodprice = Arrays.copyOf(p.toArray(), p.size(), String[].class);

            foods = new JComboBox(foodname);
            //numbers.setEnabled(true);
            foods.setBounds(400, 50, 100, 30);
            foods.addActionListener(this);
            add(foods);

        }
        if (foods == ob) {
            selectedfood = foods.getSelectedItem().toString();
            foodindex=foods.getSelectedIndex();
            //System.out.println(selectedfood);

            int len = Arrays.asList(foodname).size();
            for (int i = 0; i < len; i++) {
                if (selectedfood.equals(foodname[i])) {
                    index = i;
                }
            }
            //System.out.println("");
            //System.out.println(index);
            //System.out.println(foodnumber[index]);
            int maxn = Integer.parseInt(foodnumber[index]);
            String[] t = new String[maxn + 1];
            for (int i = 0; i <= maxn; ++i) {
                t[i] = Integer.toString(i);
            }
            numbers = new JComboBox(t);
            //numbers.setEnabled(true);
            numbers.setBounds(550, 50, 100, 30);
            numbers.addActionListener(this);
            add(numbers);
            pricetxt.setText(foodprice[index]);

        }

        if (ae.getSource() == btnlogin) {
            String regex = "(\\w+)\\s*(\\S+)";
            File myfile = new File("D:\\java_projects\\Market\\src\\Manager\\Customerslogin.txt");
            ArrayList<String> username = readinfo(myfile, regex, 1, false);
            ArrayList<String> password = readinfo(myfile, regex, 2, false);
            susenm = usertxt.getText();
            spasswd = passtxt.getText();
            //System.out.println(username);
            //System.out.println(password);
            if (username.contains(susenm) && password.contains(spasswd) && (username.indexOf(susenm) == password.indexOf(spasswd))) {
                indexcustomer = username.indexOf(susenm);
                l2.setText("Successful Login");
                validlogin = true;
                //foods.setEnabled(true);
                //numbers.setEnabled(true);
                ///

                myfile = new File("D:\\java_projects\\Market\\src\\Manager\\Storeslogin.txt");
                regex = "(\\w+)";
                ArrayList<String> s = readinfo(myfile, regex, 1, false);
                storename = Arrays.copyOf(s.toArray(), s.size(), String[].class);
                store = new JComboBox(storename);
                //foods.setEnabled(false);
                store.setBounds(250, 50, 100, 30);
                add(store);
                store.addActionListener(this);
                store.setEditable(true);

            } else {
                l2.setText("Invalid Inputs");
            }


        }
        if (ae.getSource() == btnorder) {
            String regex = "(\\w+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)";
            File myfile = new File("D:\\java_projects\\Market\\src\\Manager\\Customerslogin.txt");

            Customer c = new Customer(readinfo(myfile, regex, 5, false).get(indexcustomer), readinfo(myfile, regex, 6, false).get(indexcustomer), readinfo(myfile, regex, 7, false).get(indexcustomer), readinfo(myfile, regex, 8, false).get(indexcustomer), readinfo(myfile, regex, 9, false).get(indexcustomer));
            c.name = readinfo(myfile, regex, 1, false).get(indexcustomer);
            c.password = readinfo(myfile, regex, 2, false).get(indexcustomer);
            c.phoneNumber = (readinfo(myfile, regex, 3, false).get(indexcustomer));
            c.email = readinfo(myfile, regex, 4, false).get(indexcustomer);

            if (((c.getMoney()) >= totalprice)&&((Store.openclose()))) {
                l6.setText("Thanks for your purchase");
                ArrayList<String> username = readinfo(myfile, regex, 1, false);

                regex = "(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)\\s*(\\S+)";
                myfile = new File("D:\\java_projects\\Market\\src\\Manager\\Storeslogin.txt");

                Store str = new Store(selectedStore, (readinfo(myfile, regex, 2, false).get(storeindex)), readinfo(myfile, regex, 3, false).get(storeindex), readinfo(myfile, regex, 4, false).get(storeindex), readinfo(myfile, regex, 5, false).get(storeindex), readinfo(myfile, regex, 6, false).get(storeindex), readinfo(myfile, regex, 7, false).get(storeindex), readinfo(myfile, regex, 8, false).get(storeindex));
                Postman pst = new Postman(readinfo(myfile, regex, 4, false).get(storeindex), readinfo(myfile, regex, 5, false).get(storeindex), readinfo(myfile, regex, 6, false).get(storeindex), readinfo(myfile, regex, 7, false).get(storeindex), readinfo(myfile, regex, 8, false).get(storeindex));
                pst.name = readinfo(myfile, regex, 13, false).get(storeindex);
                pst.password = readinfo(myfile, regex, 14, false).get(storeindex);
                pst.phoneNumber = readinfo(myfile, regex, 16, false).get(storeindex);
                pst.email = readinfo(myfile, regex, 15, false).get(storeindex);

                Orderstate os = new Orderstate(c, selectedfood, Integer.parseInt(selectednum), str, pst);
                GrStoreOrderstate gos = new GrStoreOrderstate(os);
                c.setMoney((c.getMoney()) - totalprice);
                JOptionPane.showMessageDialog(this, "After purchase you have :" + c.getMoney() + " $");
                updatefood(selectedStore,foodindex,Integer.parseInt(selectednum));
                str.sell(totalprice);
                //str.commandToPost(pst,totalprice);
                pst.post(totalprice,pst.name);
                c.buy(totalprice,c.name);


            } else if(!((c.getMoney()) >= totalprice)){
                JOptionPane.showMessageDialog(this, "You do not have enough money");

            }
            else if(!(Store.openclose())){
                JOptionPane.showMessageDialog(this, "Store is close");

            }

        }
        if (ae.getSource() == numbers) {
            selectednum = numbers.getSelectedItem().toString();
            btnorder = new JButton("Order");
            btnorder.setBounds(500, 400, 100, 50);
            //btnorder.setEnabled(false);
            btnorder.addActionListener(this);
            add(btnorder);
            totalprice = ((Integer.parseInt(selectednum)) * (Double.parseDouble(foodprice[index])));
            l8.setText("Total cost is: " + totalprice);

        }

    }

    public ArrayList<String> readinfo(File myfile, String regex, int groupnum, boolean hasfirst) {

        ArrayList<String> f = new ArrayList<String>();
        try {

            Scanner sc = new Scanner(myfile);
            if (hasfirst) {
                sc.nextLine();
            }
            //
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                //System.out.println(s);
                Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
                Matcher m = p.matcher(s);
                if (m.find()) {
                    f.add(m.group(groupnum));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    ////
    protected void updatefood(String sname, int fnameindex, int fnum) {
        String path="D:\\java_projects\\Market\\src\\Manager\\Foods\\" + sname + ".txt";
        String x=Integer.toString((Integer.parseInt(n.get(fnameindex)))-fnum);
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter(path, false));
            fw.write("");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            int length=f.size();
            BufferedWriter fw = new BufferedWriter(new FileWriter(path, true));
            fw.write("Food" + "\t" + "\t" + "Number" + "\t" + "\t" + "price" + "\n");
            for (int i=0;i<length;i++){
                if(i==fnameindex){
                    fw.write(f.get(i) + "\t" + "\t" + x + "\t" + "\t" + p.get(i) + "\n");
                    continue;
                }
                fw.write(f.get(i) + "\t" + "\t" + n.get(i) + "\t" + "\t" + p.get(i) + "\n");
            }

            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
