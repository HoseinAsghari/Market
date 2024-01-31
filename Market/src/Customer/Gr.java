package Customer;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Gr extends JFrame implements ActionListener {

    Customer c;
    JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9;
    JLabel l2;
    ArrayList<JTextField> text = new ArrayList<JTextField>();
    public Gr(){

        //
        setLayout(null);
        setTitle("Register as Customer");
        setSize(384,450);
        setLocation(455,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //
        /*JLabel l =new JLabel("Welcome to online foodmarket");
        l.setBounds(500, 110,30,20);*/
        l2 =new JLabel("");
        l2.setBounds(10,350, 300, 20);;
        setVisible(true);
        //
        // add(l);
        add(l2);
        //
        text.add(new JTextField("name(At most 20 characters)", 20));
        text.get(0).setBounds(15,10, 300, 20);
        text.add(new JTextField("password(At most 20 characters)", 20));
        text.get(1).setBounds(15,35, 300, 20);
        text.add(new JTextField("email(At most 20 characters)", 20));
        text.get(2).setBounds(15,60, 300, 20);
        text.add(new JTextField("phoneNumber(At most 20 characters)", 20));
        text.get(3).setBounds(15,85, 300, 20);
        text.add(new JTextField("country(At most 20 characters)", 20));
        text.get(4).setBounds(15,110, 300, 20);
        text.add(new JTextField("county(At most 20 characters)", 20));
        text.get(5).setBounds(15,135, 300, 20);
        text.add(new JTextField("city(At most 20 characters)", 20));
        text.get(6).setBounds(15,160, 300, 20);
        text.add(new JTextField("state(At most 20 characters)", 20));
        text.get(7).setBounds(15,185, 300, 20);
        text.add(new JTextField("postalcode(At most 20 characters)", 20));
        text.get(8).setBounds(15,210, 300, 20);
        for (int i=0;i<9;i++){
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


        JButton b =new JButton("Register");
        b.setBounds(100,250, 200, 30);
        b.addActionListener(this);
        add(b);
        //


    }
    public void actionPerformed(ActionEvent ae) {
        ArrayList<String> t = new ArrayList<String>();
        boolean iscomplete = true;
        for (int i = 0; i < 9; i++) {
            String temp = text.get(i).getText();
            t.add(temp);
            if (true == temp.equals("")) {
                iscomplete = false;
            }
        }

        if (iscomplete == false) {
            l2.setText("information is not complete");
        } else {
            c = new Customer(t.get(4), t.get(5), t.get(6), t.get(7), t.get(8));
            c.name = t.get(0);
            c.password = t.get(1);
            c.email = t.get(2);
            c.phoneNumber = (t.get(3));

            l2.setText("Registeration is done");

            boolean repeated = false;

            try {

                BufferedReader fr = new BufferedReader(new FileReader("D:\\java_projects\\Market\\src\\Manager\\Customerslogin.txt"));
                String line = null;

                if ((line = fr.readLine()) != null) {
                    do {

                        if (line.equals(c.name + "\t" + c.password + "\t" + c.email + "\t" + c.phoneNumber + "\t" + c.address.country + "\t" + c.address.county + "\t" + c.address.city + "\t" + c.address.state + "\t" + c.address.postalcode)) {
                            JOptionPane.showMessageDialog(this, "this information is already written");
                            repeated = true;
                            break;
                        }
                    } while ((line = fr.readLine()) != null);
                    if (!(repeated)) {
                        writefile();

                    }
                } else {
                    writefile();
                }
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        }
        public void writefile () {
            String input=c.name + "\t" + c.password + "\t" + c.email + "\t" + c.phoneNumber + "\t" + c.address.country + "\t" + c.address.county + "\t" + c.address.city + "\t" + c.address.state + "\t" + c.address.postalcode + "\n";
            try {
                BufferedWriter fw = new BufferedWriter(new FileWriter("D:\\java_projects\\Market\\src\\Manager\\Customerslogin.txt", true));
                fw.write(input);
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

}
