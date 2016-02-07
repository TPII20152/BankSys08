package banksys.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
//import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.JTextField;

//import banksys.gui.MyJLabelVersion;

@SuppressWarnings("serial")
public class View extends JFrame {

  private JButton newAccount;
  private JButton doCredit;
  private JButton doDebit;
  private JButton doTransfer;
  private JButton showBalance;
  private JButton removeAccount;
  private JButton earnIterest;
  private JButton earnBonus;


  private static Font mainFont = new Font("serif", Font.BOLD, 15);



  public View() {

    super("Bank System");
    Container container = getContentPane();

    JPanel center = new JPanel();
    JPanel east = new JPanel();
    east = getBotoes();
    center = getMainScream();


    container.setLayout(new BorderLayout());
    container.add(BorderLayout.CENTER, center);
    container.add(BorderLayout.EAST, east);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 500);
    setVisible(true);
    setLocationRelativeTo(null);
  }

  public JPanel getBotoes() {

    JPanel container2 = new JPanel();
    container2.setLayout(new GridLayout(8, 1));
    newAccount = new JButton("New Account");
    newAccount.setFont(mainFont);

    container2.add(newAccount);
    doCredit = new JButton("Do Credit");
    doCredit.setFont(mainFont);

    container2.add(doCredit);
    doDebit = new JButton("Do Debit");
    doDebit.setFont(mainFont);

    container2.add(doDebit);
    doTransfer = new JButton("Do Transfer");
    doTransfer.setFont(mainFont);

    container2.add(doTransfer);
    showBalance = new JButton("Show Balance");
    showBalance.setFont(mainFont);

    container2.add(showBalance);
    removeAccount = new JButton("Remove Account");
    removeAccount.setFont(mainFont);

    container2.add(removeAccount);
    earnIterest = new JButton("Earn Iterest");
    earnIterest.setFont(mainFont);

    container2.add(earnIterest);
    earnBonus = new JButton("Earn Bonus");
    earnBonus.setFont(mainFont);

    container2.add(earnBonus);
    return container2;
  }


  public JPanel getMainScream() {

    String text = "********************************";
    String line = "Wellcome to the Our Bank";
    String line1 = "Automated Teller Machine";
    String line2 = " [1] Add New OrdinaryAccount";
    String line3 = " [2] Do Credit";
    String line4 = " [3] Do Debit";
    String line5 = " [4] Do Transfer";
    String line6 = " [5] Show Balance";
    String line7 = " [6] Remove OrdinaryAccount";
    String line8 = " [7] Earn Iterest";
    String line9 = " [8] Earn Bonus";
    String line10 = " [9] Exit";
    String line11 = "Press your desired option: ";

    JPanel mainScreen = new JPanel();

    mainScreen.setLayout(new GridLayout(20, 1, 0, 0));
    mainScreen.add(new MyJLabelVersion(text, mainFont));
    mainScreen.add(new MyJLabelVersion(line, mainFont));
    mainScreen.add(new MyJLabelVersion(line1, mainFont));
    mainScreen.add(new MyJLabelVersion(text, mainFont));
    mainScreen.add(new MyJLabelVersion(line2, mainFont));
    mainScreen.add(new MyJLabelVersion(line3, mainFont));
    mainScreen.add(new MyJLabelVersion(line4, mainFont));
    mainScreen.add(new MyJLabelVersion(line5, mainFont));
    mainScreen.add(new MyJLabelVersion(line6, mainFont));
    mainScreen.add(new MyJLabelVersion(line7, mainFont));
    mainScreen.add(new MyJLabelVersion(line8, mainFont));
    mainScreen.add(new MyJLabelVersion(line9, mainFont));
    mainScreen.add(new MyJLabelVersion(line10, mainFont));
    mainScreen.add(new MyJLabelVersion(line11, mainFont));
    mainScreen.add(new MyJLabelVersion(text, mainFont));
    mainScreen.add(new MyJLabelVersion("Your security is guaranteed using our Bank!", mainFont));
    return mainScreen;
  }
  public static void main(String[]args){
    new View();
  }
  public Font getMainFont() {
    return mainFont;
  }

  public JButton getNewAccount() {
    return newAccount;
  }

  public JButton getDoCredit() {
    return doCredit;
  }

  public JButton getDoDebit() {
    return doDebit;
  }

  public JButton getDoTransfer() {
    return doTransfer;
  }

  public JButton getShowBalance() {
    return showBalance;
  }

  public JButton getRemoveAccount() {
    return removeAccount;
  }

  public JButton getEarnIterest() {
    return earnIterest;
  }

  public JButton getEarnBonus() {
    return earnBonus;
  }

}