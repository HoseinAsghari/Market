package Manager;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
public class Feedback extends JFrame implements ActionListener{
    String complain=null;
    JTextField text1;
    JLabel l2;
    public Feedback(){
        setLayout(null);
        setTitle("Register as Customer");
        setSize(1200,300);
        setLocation(10,10);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        text1=new JTextField("",1000);
        JButton btn=new JButton("feedback");
        l2=new JLabel("");
        text1.setBounds(10,10,1000,30);
        btn.setBounds(400,60,100,80);
        l2.setBounds(200,60,300,150);
        text1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                text1.setText("");
            }
        });
        add(text1);
        add(btn);
        btn.addActionListener(this);
        add(l2);


    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(!((text1.getText()).equals(""))) {
            complain = text1.getText();
            text1.setText("");
            l2.setText("Thanks for your feedback");
            feedbackfile();
        }
        else{
            l2.setText("You have entered nothing");
        }
    }

    public void feedbackfile(){
        try {
            BufferedWriter fw = new BufferedWriter(new FileWriter("D:\\java_projects\\Market\\src\\Manager\\FeedbacksOfUsers.txt", true));
            fw.write(complain+"\n");
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
