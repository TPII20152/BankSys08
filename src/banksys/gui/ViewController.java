package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import banksys.control.AccountController;
import banksys.control.BankController;
import banksys.control.exception.BankTransactionException;
import banksys.persistence.AccountVector;

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
  public static BankController bank = new BankController(new AccountVector()); // Same
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

    actionListener = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        /* First, passing the action for the RegisterController.... */
        if (e.getSource() == view.getNewAccount()) {
          view.dispose();
          newViewRegister = new ViewRegister();
          newViewRgisterController = new ViewRegisterController(newViewRegister);
          newViewRgisterController.control();
        } else if (e.getSource() == view.getDoCredit()) {
          /* Now action goes to DoCreditController..... */
          view.dispose();
          dcView = new DoCreditView();
          dcController = new DoCreditController(dcView);
          dcController.control();
        } else if (e.getSource() == view.getDoDebit()) {
          /* Now action goes to DoDebitController..... */
          view.dispose();
          ddView = new DoDebitView();
          ddController = new DoDebitController(ddView);
          ddController.control();
        } else if (e.getSource() == view.getShowBalance()) {
          input = JOptionPane.showInputDialog("Enter the account Number.");
          try {
            JOptionPane.showMessageDialog(null,"Balance: "+ operation.getBalance(input));
          } catch (BankTransactionException bte) {
            JOptionPane.showMessageDialog(null, "Error: " + bte.getMessage());
          }
        } else if (e.getSource() == view.getRemoveAccount()) {
          input = JOptionPane.showInputDialog("Enter the account Number.");
          try {
            bank.removeAccount(input);
          } catch (BankTransactionException bte) {
            JOptionPane.showMessageDialog(null, "Error: " + bte.getMessage());
          }
          confirmOperation();
        } else if (e.getSource() == view.getEarnBonus()) {
          input = JOptionPane.showInputDialog("Enter the account Number.");
          try {
            operation.doEarnBonus(input);
            confirmOperation();
          } catch (BankTransactionException bte) {
            JOptionPane.showMessageDialog(null, "Error: " + bte.getMessage());
          }
        } else if (e.getSource() == view.getDoTransfer()) {
          input = JOptionPane.showInputDialog("Enter the origin Account number.");
          String destiny = JOptionPane.showInputDialog("Enter the destiny Account number.");
          String amount = JOptionPane.showInputDialog("Enter the amount to be transferred:");
          double value = 0;
          try {
            value = Double.parseDouble(amount);
          } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Type Numbers.. Please...");
            nfe.printStackTrace();
          }
          try {
            operation.doTransfer(input, destiny, value);
            confirmOperation();
          } catch (BankTransactionException bte) {
            System.out.println("Error: " + bte.getMessage());
          }

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

  }

  public void confirmOperation() {
    JOptionPane.showMessageDialog(null, "Operation was successful");
  }
  public void shutView(){
    view.dispose();
  }
}