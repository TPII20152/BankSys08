package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import banksys.control.AccountController;
import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;
import banksys.persistence.AccountPersistence;
//import banksys.persistence.AccountVector;

public class ViewController {

  private String input;
  private View view;
  private ViewRegister newViewRegister;
  private ViewRegisterController newViewRgisterController;
  private DoCreditView dcView;
  private DoDebitView ddView;
  private DoCreditController dcController;
  private DoDebitController ddController;

  private ActionListener actionListener;
  public static BankController bank = new BankController(new AccountPersistence()); // Same
  // as
  // Before.....
  // an vector to keep the accounts created

  /*
   * operation IS THE OBJECT RESPOSABLE FOR MAKING THE OPERATIONS ON
   * ACCOUNTS....
   */
  public static AccountController operation = new AccountController(bank.getRepository());

  public ViewController(View v) {
    this.view = v;

  }

  public void control() {
    UIManager.put("OptionPane.font", new FontUIResource(view.mainFont));

    actionListener = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        /* First, passing the action for the RegisterController.... */
        if (e.getSource() == view.getNewAccount() || e.getSource() == view.getNewAccountMenuItem()) {
          view.dispose();
          newViewRegister = new ViewRegister();
          newViewRgisterController = new ViewRegisterController(newViewRegister);
          newViewRgisterController.control();
        } else if (e.getSource() == view.getDoCredit() || e.getSource() == view.getDoCreditMenuItem()) {
          /* Now action goes to DoCreditController..... */
          //view.dispose();
          dcView = new DoCreditView();
          dcController = new DoCreditController(dcView);
          dcController.control();
        } else if (e.getSource() == view.getDoDebit() || e.getSource() == view.getDoDebitMenuItem()) {
          /* Now action goes to DoDebitController..... */
          //view.dispose();
          ddView = new DoDebitView();
          ddController = new DoDebitController(ddView);
          ddController.control();
        } else if (e.getSource() == view.getShowBalance() || e.getSource() == view.getShowBalanceMenuItem()) {
          input = JOptionPane.showInputDialog("Enter the account Number.");
          try {
            JOptionPane.showMessageDialog(null, "Balance: " + operation.getBalance(input));
          } catch (BankTransactionException bte) {
            JOptionPane.showMessageDialog(null, "Error: " + bte.getMessage());
          }
        } else if (e.getSource() == view.getRemoveAccount() || e.getSource()==view.getRemoveAccountMenuItem()) {
          input = JOptionPane.showInputDialog("Enter the account Number.");
          try {
            bank.removeAccount(input);
          } catch (BankTransactionException bte) {
            JOptionPane.showMessageDialog(null, "Error: " + bte.getMessage());
          }
          confirmOperation();
        } else if (e.getSource() == view.getEarnBonus() || e.getSource()==view.getEarnBonusMenuItem()) {
          input = JOptionPane.showInputDialog("Enter the account Number.");
          try {
            operation.doEarnBonus(input);
            confirmOperation();
          } catch (BankTransactionException bte) {
            JOptionPane.showMessageDialog(null, "Error: " + bte.getMessage());
          }
        } else if (e.getSource() == view.getEarnIterest() || e.getSource()==view.getEarnIterestMenuItem()) {
          input = JOptionPane.showInputDialog("Enter the account Number.");
          try {
            operation.doEarnInterest(input);
            confirmOperation();
          } catch (BankTransactionException bte) {
            JOptionPane.showMessageDialog(null, "Error: " + bte.getMessage());
          }
        } else if (e.getSource() == view.getDoTransfer() || e.getSource()==view.getDoTransferMenuItem()) {
          
          input = JOptionPane.showInputDialog("Enter the origin Account number.");
          if (input != null)
          {
        	  String destiny = JOptionPane.showInputDialog("Enter the destiny Account number.");
        	  if (destiny != null)
        	  {    
        		  String amount = JOptionPane.showInputDialog("Enter the amount to be transferred:");
        		  if (amount != null)
        		  {
			          double value = 0;
			          try {
			            value = Double.parseDouble(amount);
			          } catch (NumberFormatException nfe) {
			            JOptionPane.showMessageDialog(null, "Type Numbers, Please...");
			            //nfe.printStackTrace();
			          }
			          
			          try {
			            operation.doTransfer(input, destiny, value);
			            confirmOperation();
			          } catch (BankTransactionException bte) {
			        	JOptionPane.showMessageDialog(null, bte.getMessage());
			          }   
        		  }

        	  }
           }
          
        } else if (e.getSource() == view.getMainPigButton()) {
          JOptionPane.showMessageDialog(null,
              "Wellcome to the Our Bank\n" + "Automated Teller Machine\n"
                  + " [1] Add New OrdinaryAccount\n" + " [2] Do Credit\n" + " [3] Do Debit\n"
                  + " [4] Do Transfer\n" + " [5] Show Balance\n" + " [6] Remove OrdinaryAccount\n"
                  + " [7] Earn Iterest\n" + " [8] Earn Bonus\n" + " [9] Exit\n");
          
        } else if (e.getSource() == view.getCreditsMenuItem()) {  
        	JOptionPane.showMessageDialog(null,
                    "Wellcome to the Our Bank\n" + "Developed by:\n"
                        + " Thiago Nóbrega\n" + " Jonas Martins\n" + " Arthur Brito\n"
                        + " Matheus Silva\n");
        	
        }else if(e.getSource()==view.getExitMenuItem()){
          view.dispose();
          System.exit(0);
        }

      }

    };
    view.getNewAccount().addActionListener(actionListener);
    view.getDoCredit().addActionListener(actionListener);
    view.getDoDebit().addActionListener(actionListener);
    view.getDoTransfer().addActionListener(actionListener);
    view.getShowBalance().addActionListener(actionListener);
    view.getRemoveAccount().addActionListener(actionListener);
    view.getEarnIterest().addActionListener(actionListener);
    view.getEarnBonus().addActionListener(actionListener);
    view.getMainPigButton().addActionListener(actionListener);
    view.getAboutMenuItem().addActionListener(actionListener);
    view.getNewAccountMenuItem().addActionListener(actionListener);
    view.getDoCreditMenuItem().addActionListener(actionListener);
    view.getDoDebitMenuItem().addActionListener(actionListener);
    view.getDoTransfer().addActionListener(actionListener);
    view.getShowBalanceMenuItem().addActionListener(actionListener);
    view.getRemoveAccountMenuItem().addActionListener(actionListener);
    view.getEarnBonusMenuItem().addActionListener(actionListener);
    view.getEarnIterestMenuItem().addActionListener(actionListener);
    view.getCreditsMenuItem().addActionListener(actionListener);
    view.getExitMenuItem().addActionListener(actionListener);

  }

  public void confirmOperation() {
    JOptionPane.showMessageDialog(null, "Operation was successful");
  }

  public void shutView() {
    view.dispose();
  }
}