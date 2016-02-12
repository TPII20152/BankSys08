package banksys.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



@SuppressWarnings("serial")
public class DoCreditView extends JFrame{

  private JTextField account;
  private JTextField value;
  private JButton done;
  private static Font mainFont = new Font("serif", Font.BOLD, 15);

  public DoCreditView(){

    super("Enter Data");

    JLabel title = new JLabel(" Input");
    title.setFont(mainFont);
    JLabel accountNumber = new JLabel("Number:");
    accountNumber.setFont(mainFont);
    JLabel valueS = new JLabel(" $: ");
    valueS.setFont(mainFont);


    Container c = getContentPane();
    c.setLayout(new BorderLayout());
    JPanel p = new JPanel();
    p.setLayout(null);

    account = new JTextField();
    account.setFont(mainFont);
    value = new JTextField();
    value.setFont(mainFont);

    done = new JButton("Done");
    done.setFont(mainFont);
    done.setBounds(180,132,200,25);


    /* IN ORDER */
    title.setBounds(240, 10, 200, 30);
    accountNumber.setBounds(40,57,100,30);
    account.setBounds(180, 60, 200, 25);
    valueS.setBounds(70,97,80,30);
    value.setBounds(180, 100, 200, 25);

    p.add(title);
    p.add(accountNumber);
    p.add(account);
    p.add(valueS);
    p.add(value);
    p.add(done);
    c.add(BorderLayout.CENTER,p);

    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(500, 200);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);

  }
  public JButton getDone() {
    return done;
  }
  public void setAccount(JTextField account) {
    this.account = account;
  }
  public void setValue(JTextField value) {
    this.value = value;
  }
  public JTextField getAccount() {
    return account;
  }
  public JTextField getValue() {
    return value;
  }
  /*
  public static void main(String[]args){
    new DoCreditView();
  }*/

}