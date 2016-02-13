package banksys.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

//import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
//import javax.swing.JTextField;

//import banksys.gui.MyJLabelVersion;

@SuppressWarnings("serial")
public class View extends JFrame {

  private MyJButtonVersion newAccount;
  private MyJButtonVersion doCredit;
  private MyJButtonVersion doDebit;
  private MyJButtonVersion doTransfer;
  private MyJButtonVersion showBalance;
  private MyJButtonVersion removeAccount;
  private MyJButtonVersion earnIterest;
  private MyJButtonVersion earnBonus;
  private MyJButtonVersion mainPigButton;

  private JMenuBar menuBar;
  private JToolBar toolBar;
  private JMenu FileMenu;
  private JMenu CreditsMenu;

  private JMenuItem ExitMenuItem;
  private JMenuItem NewAccountMenuItem;
  private JMenuItem AboutMenuItem;
  private JMenuItem DoCreditMenuItem;
  private JMenuItem DoDebitMenuItem;
  private JMenuItem ShowBalanceMenuItem;
  private JMenuItem DoTransferMenuItem;
  private JMenuItem RemoveAccountMenuItem;
  private JMenuItem EarnBonusMenuItem;
  private JMenuItem EarnIterestMenuItem;
  private JMenuItem CreditsMenuItem;

  public Font mainFont = new Font("serif", Font.BOLD, 15);

  //

  public View() {

    super("Bank System");

    Container container = getContentPane();

    JPanel center = new JPanel();
    JPanel east = new JPanel();
    east = getBotoes();

    toolBar = new JToolBar();
    toolBar.setFont(mainFont);
    menuBar = new JMenuBar();
    menuBar.setFont(mainFont);
    toolBar.add(menuBar);

    AboutMenuItem = new JMenuItem("About This   ");
    AboutMenuItem.setFont(mainFont);

    ExitMenuItem = new JMenuItem("Exit          ");
    ExitMenuItem.setFont(mainFont);

    NewAccountMenuItem = new JMenuItem("New Account    ");
    NewAccountMenuItem.setFont(mainFont);

    DoCreditMenuItem = new JMenuItem("Do Credit      ");
    DoCreditMenuItem.setFont(mainFont);

    DoDebitMenuItem = new JMenuItem("Do Debit      ");
    DoDebitMenuItem.setFont(mainFont);

    DoTransferMenuItem = new JMenuItem("Do Transfer       ");
    DoTransferMenuItem.setFont(mainFont);

    ShowBalanceMenuItem = new JMenuItem("Show Balance    ");
    ShowBalanceMenuItem.setFont(mainFont);

    RemoveAccountMenuItem = new JMenuItem("Remove Account     ");
    RemoveAccountMenuItem.setFont(mainFont);

    EarnIterestMenuItem = new JMenuItem("Earn Iterest   ");
    EarnIterestMenuItem.setFont(mainFont);

    EarnBonusMenuItem = new JMenuItem("Earn Bonus    ");
    EarnBonusMenuItem.setFont(mainFont);

    FileMenu = new JMenu(" File  ");
    FileMenu.setFont(mainFont);
    menuBar.add(FileMenu);
    FileMenu.add(NewAccountMenuItem);
    FileMenu.add(DoDebitMenuItem);
    FileMenu.add(DoTransferMenuItem);
    FileMenu.add(ShowBalanceMenuItem);
    FileMenu.add(RemoveAccountMenuItem);
    FileMenu.add(EarnIterestMenuItem);
    FileMenu.add(EarnBonusMenuItem);
    FileMenu.add(AboutMenuItem);
    FileMenu.add(ExitMenuItem);

    CreditsMenuItem = new JMenuItem(" Creditis ");
    CreditsMenuItem.setFont(mainFont);

    CreditsMenu = new JMenu(" Credits ");
    CreditsMenu.setFont(mainFont);
    menuBar.add(CreditsMenu);
    CreditsMenu.add(CreditsMenuItem);

    mainPigButton = new MyJButtonVersion();
    mainPigButton.setToolTipText("Bank System");
    mainPigButton.setBackground(new Color(255, 255, 255));
    mainPigButton.setIcon(new ImageIcon(getClass().getResource("icons/tool9.png")));
    center.add(mainPigButton);

    container.setLayout(new BorderLayout(0, 0));
    container.add(BorderLayout.NORTH, toolBar);
    container.add(BorderLayout.CENTER, center);
    container.add(BorderLayout.EAST, east);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(585, 532);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
  }



  public JPanel getBotoes() {

    JPanel container2 = new JPanel();
    container2.setLayout(new GridLayout(8, 1));
    newAccount = new MyJButtonVersion();
    newAccount.setToolTipText("New Account");
    newAccount.setBackground(new Color(255, 255, 255));
    newAccount.setIcon(new ImageIcon(getClass().getResource("icons/label39.png")));

    container2.add(newAccount);
    doCredit = new MyJButtonVersion();
    doCredit.setToolTipText("Do Credit");
    doCredit.setBackground(new Color(255, 255, 255));
    doCredit.setIcon(new ImageIcon(getClass().getResource("icons/money132.png")));
    container2.add(doCredit);

    doDebit = new MyJButtonVersion();
    doDebit.setToolTipText("Do Debit");
    doDebit.setBackground(new Color(255, 255, 255));
    doDebit.setIcon(new ImageIcon(getClass().getResource("icons/payment7.png")));
    container2.add(doDebit);

    doTransfer = new MyJButtonVersion();
    doTransfer.setToolTipText("Do Transfer");
    doTransfer.setBackground(new Color(255, 255, 255));
    doTransfer.setIcon(new ImageIcon(getClass().getResource("icons/direction21.png")));
    container2.add(doTransfer);

    showBalance = new MyJButtonVersion();
    showBalance.setToolTipText("Show Balance");
    showBalance.setBackground(new Color(255, 255, 255));
    showBalance.setIcon(new ImageIcon(getClass().getResource("icons/magnifier13.png")));
    container2.add(showBalance);

    removeAccount = new MyJButtonVersion();
    removeAccount.setToolTipText("Remove Account");
    removeAccount.setBackground(new Color(255, 255, 255));
    removeAccount.setIcon(new ImageIcon(getClass().getResource("icons/rubbish7.png")));
    container2.add(removeAccount);

    earnIterest = new MyJButtonVersion();
    earnIterest.setToolTipText("Earn Iterest");
    earnIterest.setBackground(new Color(255, 255, 255));
    earnIterest.setIcon(new ImageIcon(getClass().getResource("icons/maths76.png")));
    container2.add(earnIterest);

    earnBonus = new MyJButtonVersion();
    earnBonus.setToolTipText("Earn Bonus");
    earnBonus.setBackground(new Color(255, 255, 255));
    earnBonus.setIcon(new ImageIcon(getClass().getResource("icons/plus2.png")));
    container2.add(earnBonus);
    return container2;
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
  public JMenuItem getDoDebitMenuItem() {
    return DoDebitMenuItem;
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

  public JButton getMainPigButton() {
    return mainPigButton;
  }

  public JMenuItem getExitMenuItem() {
    return ExitMenuItem;
  }

  public JMenuItem getNewAccountMenuItem() {
    return NewAccountMenuItem;
  }

  public JMenuItem getAboutMenuItem() {
    return AboutMenuItem;
  }

  public JMenuItem getDoCreditMenuItem() {
    return DoCreditMenuItem;
  }

  public JMenuItem getShowBalanceMenuItem() {
    return ShowBalanceMenuItem;
  }

  public JMenuItem getDoTransferMenuItem() {
    return DoTransferMenuItem;
  }

  public JMenuItem getRemoveAccountMenuItem() {
    return RemoveAccountMenuItem;
  }

  public JMenuItem getEarnBonusMenuItem() {
    return EarnBonusMenuItem;
  }

  public JMenuItem getEarnIterestMenuItem() {
    return EarnIterestMenuItem;
  }

}