package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import banksys.control.exception.BankTransactionException;

public class DoCreditController {

  private DoCreditView cv;
  private ActionListener actionListener;
  private String input;
  private View view;
  private ViewController viewController;
  double value;

  public DoCreditController(DoCreditView _cv) {
    this.cv = _cv;
  }

  public void control() {
    actionListener = new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        input = cv.getAccount().getText();
        value = 0;
        try {
          value = Double.parseDouble(cv.getValue().getText());
        } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(null, "Type Numbers.. Please...");
          nfe.printStackTrace();
        }
        try {
          ViewController.operation.doCredit(input, value);// do the
          cv.dispose();                 // credit....
          view = new View();
          //main menu
          viewController = new ViewController(view);
          viewController.control();

        } catch (BankTransactionException bte) {
          JOptionPane.showMessageDialog(null,"Error: " + bte.getMessage());
        }
        cv.dispose();
        JOptionPane.showMessageDialog(null, "Done!");

      }
    };
    cv.getDone().addActionListener(actionListener);
  }

}