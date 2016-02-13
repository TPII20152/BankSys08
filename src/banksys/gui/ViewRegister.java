package banksys.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;


@SuppressWarnings("serial")
public class ViewRegister extends JFrame{


  private MyJButtonVersion OrdinaryButton;
  private MyJButtonVersion TaxButton;
  private MyJButtonVersion SavingButton;
  private MyJButtonVersion SpecialButton;
  private MyJButtonVersion MainMenuButton;
  private MyJButtonVersion mainPigButton;


    private JMenuBar menuBar;
  private JToolBar toolBar;
  private JMenu FileMenu;

  private JMenuItem ExitMenuItem;

  private JMenuItem OrdinaryAccountMenuItem;
  private JMenuItem SpecialAccountMenuItem;
  private JMenuItem SavingsAccountMenuItem;
  private JMenuItem TaxAccountMenuItem;
  private JMenuItem HomeMenuItem;



  private static Font mainFont = new Font("serif", Font.BOLD, 15);

  public ViewRegister(){

    super("Bank System");
    Container container = getContentPane();

    JPanel center = new JPanel();
    JPanel east = new JPanel();
    east = getBotoesCadastro();


    toolBar = new JToolBar();
  toolBar.setFont(mainFont);
  menuBar = new JMenuBar();
  menuBar.setFont(mainFont);
  toolBar.add(menuBar);


  OrdinaryAccountMenuItem = new JMenuItem("Create Ordinary Account ");
  OrdinaryAccountMenuItem.setFont(mainFont);

  SpecialAccountMenuItem = new JMenuItem("Create Special Account ");
    SpecialAccountMenuItem.setFont(mainFont);

    SavingsAccountMenuItem = new JMenuItem("Create Savings Account ");
    SavingsAccountMenuItem.setFont(mainFont);

    TaxAccountMenuItem = new JMenuItem("Create Tax Account    ");
    TaxAccountMenuItem.setFont(mainFont);

    HomeMenuItem = new JMenuItem("Get Back to Home     ");
    HomeMenuItem.setFont(mainFont);

    ExitMenuItem = new JMenuItem("Exit          ");
    ExitMenuItem.setFont(mainFont);


    FileMenu = new JMenu(" Options  ");
  FileMenu.setFont(mainFont);
  menuBar.add(FileMenu);
  FileMenu.add(OrdinaryAccountMenuItem);
  FileMenu.add(SpecialAccountMenuItem);
  FileMenu.add(SavingsAccountMenuItem);
  FileMenu.add(TaxAccountMenuItem);
  FileMenu.add(HomeMenuItem);
  FileMenu.add(ExitMenuItem);



    mainPigButton = new MyJButtonVersion();
    mainPigButton.setBackground(new Color(33,150,243));
    mainPigButton.setToolTipText("Choose an Account type");
    mainPigButton.setIcon(new ImageIcon(getClass().getResource("icons/piggy9.png")));
    center.add(mainPigButton);

    container.setLayout(new BorderLayout(0, 0));
  container.add(BorderLayout.NORTH, toolBar);
    container.add(BorderLayout.CENTER, center);
    container.add(BorderLayout.EAST, east);


    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(585, 532);
    setVisible(true);
    setLocationRelativeTo(null);
    setResizable(false);
  }

  public JPanel getBotoesCadastro(){

    JPanel cadastro = new JPanel();
    cadastro.setLayout(new GridLayout(5, 1));

    OrdinaryButton = new MyJButtonVersion();
    OrdinaryButton.setToolTipText("Ordinary account");
    OrdinaryButton.setBackground(new Color(255, 255, 255));
    OrdinaryButton.setIcon(new ImageIcon(getClass().getResource("icons/silhouette49.png")));


    TaxButton = new MyJButtonVersion();
    TaxButton.setToolTipText("Tax Account");
    TaxButton.setBackground(new Color(255, 255, 255));
    TaxButton.setIcon(new ImageIcon(getClass().getResource("icons/man249.png")));

    SpecialButton = new MyJButtonVersion();
    SpecialButton.setToolTipText("Special Account");
    SpecialButton.setBackground(new Color(255, 255, 255));
    SpecialButton.setIcon(new ImageIcon(getClass().getResource("icons/ribbon85.png")));


    SavingButton = new MyJButtonVersion();
    SavingButton.setToolTipText("Savings Account");
    SavingButton.setBackground(new Color(255, 255, 255));
    SavingButton.setIcon(new ImageIcon(getClass().getResource("icons/businessman53.png")));

    MainMenuButton = new MyJButtonVersion();
    MainMenuButton.setToolTipText("Home");
    MainMenuButton.setBackground(new Color(255, 255, 255));
    MainMenuButton.setIcon(new ImageIcon(getClass().getResource("icons/home4.png")));


    cadastro.add(OrdinaryButton);
    cadastro.add(SpecialButton);
    cadastro.add(SavingButton);
    cadastro.add(TaxButton);
    cadastro.add(MainMenuButton);
    return cadastro;
  }


  /* GETTERS FOR BUTTONS */
  public JButton getOrdinaryButton() {
    return OrdinaryButton;
  }

  public JButton getTaxButton() {
    return TaxButton;
  }

  public JButton getSavingButton() {
    return SavingButton;
  }

  public JButton getSpecialButton() {
    return SpecialButton;
  }

  public static Font getMainFont() {
    return mainFont;
  }

  public JButton getMainMenuButton() {
    return MainMenuButton;
  }
  public JButton getMainPigButton() {
      return mainPigButton;
    }
  public JMenuItem getExitMenuItem() {
    return ExitMenuItem;
  }

  public JMenuItem getOrdinaryAccountMenuItem() {
    return OrdinaryAccountMenuItem;
  }

  public JMenuItem getSpecialAccountMenuItem() {
    return SpecialAccountMenuItem;
  }

  public JMenuItem getSavingsAccountMenuItem() {
    return SavingsAccountMenuItem;
  }

  public JMenuItem getTaxAccountMenuItem() {
    return TaxAccountMenuItem;
  }

  public JMenuItem getHomeMenuItem() {
    return HomeMenuItem;
  }

}


