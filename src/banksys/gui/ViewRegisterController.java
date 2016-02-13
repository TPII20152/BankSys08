package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import banksys.account.AbstractAccount;
import banksys.account.OrdinaryAccount;
import banksys.account.SavingsAccount;
import banksys.account.SpecialAccount;
import banksys.account.TaxAccount;
import banksys.control.exception.BankTransactionException;

public class ViewRegisterController {

  private ViewController newViewController;
  private ActionListener actionListener;
  private ViewRegister viewRegister;
  private AbstractAccount account;
  private View newView;
  private String input;

  public ViewRegisterController(ViewRegister vc) {
    this.viewRegister = vc;
  }

  public void control() {

    actionListener = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        input = null;
        account = null;
        // After the user press some button... dealing with the
        // listeners

        if (e.getSource() == viewRegister.getOrdinaryButton()
            || e.getSource() == viewRegister.getOrdinaryAccountMenuItem()) {
          input = JOptionPane.showInputDialog("Enter the Ordinary Account Number");
          if (input != null) {
            account = new OrdinaryAccount(input);// crating a new
            // OrdinaryAccount
            confirmOperation();
          } else {
            cancelOperation();
          }
        } else if (e.getSource() == viewRegister.getTaxButton()
            || e.getSource() == viewRegister.getTaxAccountMenuItem()) {
          input = JOptionPane.showInputDialog("Enter the Tax Account Number");
          if (input != null) {
            account = new TaxAccount(input);// crating a new Tax
            // Account
            confirmOperation();
          } else {
            cancelOperation();
          }
        } else if (e.getSource() == viewRegister.getSavingButton()
            || e.getSource() == viewRegister.getSavingsAccountMenuItem()) {
          input = JOptionPane.showInputDialog("Enter the Savings Account Number");
          if (input != null) {
            account = new SavingsAccount(input);// crating a new
            // Savings Account
            confirmOperation();
          } else {
            cancelOperation();
          }
        } else if (e.getSource() == viewRegister.getSpecialButton()
            || e.getSource() == viewRegister.getSpecialAccountMenuItem()) {
          input = JOptionPane.showInputDialog("Enter the Special Account Number");
          if (input != null) {
            account = new SpecialAccount(input);// crating a new
            // Special Account
            confirmOperation();
          } else {
            cancelOperation();
          }
        } else if (e.getSource() == viewRegister.getMainMenuButton()
            || e.getSource() == viewRegister.getHomeMenuItem()) {
          viewRegister.dispose();
          newView = new View();
          newViewController = new ViewController(newView);
          newViewController.control();// Backing for the first
          // controller view
        } else if (e.getSource() == viewRegister.getMainPigButton()) {
          JOptionPane.showMessageDialog(null, "Add New OrdinaryAccount\n" + " [1] Ordinary\n"
              + " [2] Special\n" + " [3] Savings\n" + " [4] Tax\n");
        }else if( e.getSource() == viewRegister.getExitMenuItem()){
          viewRegister.dispose();
          System.exit(0);
        }

        // Finally I store the accounts created on the static object
        // bank from
        // viewController
        if (account != null) {
          try {
            ViewController.bank.addAccount(account);
          } catch (BankTransactionException e1) {
            e1.printStackTrace();
          }
        }
      }
    };
    viewRegister.getOrdinaryButton().addActionListener(actionListener);
    viewRegister.getTaxButton().addActionListener(actionListener);
    viewRegister.getSavingButton().addActionListener(actionListener);
    viewRegister.getSpecialButton().addActionListener(actionListener);
    viewRegister.getMainMenuButton().addActionListener(actionListener);
    viewRegister.getMainPigButton().addActionListener(actionListener);
    viewRegister.getOrdinaryAccountMenuItem().addActionListener(actionListener);
    viewRegister.getSpecialAccountMenuItem().addActionListener(actionListener);
    viewRegister.getSavingsAccountMenuItem().addActionListener(actionListener);
    viewRegister.getTaxAccountMenuItem().addActionListener(actionListener);
    viewRegister.getHomeMenuItem().addActionListener(actionListener);
    viewRegister.getExitMenuItem().addActionListener(actionListener);

  }

  public void confirmOperation() {
    JOptionPane.showMessageDialog(null, "Operation was successful");
  }

  public void cancelOperation() {
    JOptionPane.showMessageDialog(null, "Canceled operation");
  }

}