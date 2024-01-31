import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//////
import Customer.Order;
import Manager.Feedback;
import Store.StoreRegister;
import Customer.CustomerRegister;
////


public class GrApplication extends JFrame implements ActionListener{
    JButton btnRegisterAsCustomer,btnRegisterAsStore,btnfeedback,btnOrder,btnOrderState ;
    public  GrApplication(){
        setLayout(null);
        setTitle("Welcome to online Market");
        setSize(440,400);
        setLocation(455,100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //
        btnRegisterAsCustomer =new JButton("Register As Customer");
        btnRegisterAsCustomer .setBounds(10,10, 400, 50);
        btnRegisterAsCustomer .addActionListener(this);
        add(btnRegisterAsCustomer  );
        ///
        btnRegisterAsStore  =new JButton("Register As Store");
        btnRegisterAsStore .setBounds(10,80, 400, 50);
        btnRegisterAsStore .addActionListener(this);
        add(btnRegisterAsStore );
        ///
        btnfeedback =new JButton("Feedback");
        btnfeedback .setBounds(10,150, 400, 50);
        btnfeedback .addActionListener(this);
        add(btnfeedback );
        ///
        btnOrder =new JButton("Order");
        btnOrder.setBounds(10,220, 400, 50);
        btnOrder.addActionListener(this);
        add(btnOrder);
        ///
        btnOrderState =new JButton("OrderState");
        btnOrderState.setBounds(10,290, 400, 50);
        btnOrderState.addActionListener(this);
        add(btnOrderState);




    }
    @Override
    public void actionPerformed(ActionEvent ae){
        Object ob=ae.getSource();
        if(btnRegisterAsCustomer  ==ob){
            CustomerRegister gc=new CustomerRegister();
        }

        if(ae.getSource()==btnRegisterAsStore ){
            StoreRegister sr=new StoreRegister();
        }
        if(ae.getSource()==btnfeedback ){
            Feedback f=new Feedback();
        }
        if(ae.getSource()==btnOrder ){
            Order O=new Order();
        }
        if(ae.getSource()==btnOrderState ){

        }
    }

}
////////////////////////
