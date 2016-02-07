package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import banksys.control.exception.BankTransactionException;

public class DoDebitController {

	private DoDebitView dv;
	private ActionListener actionListener;
	private String input;
	double value;

	public DoDebitController(DoDebitView _dv) {
		this.dv = _dv;
	}

	public void control() {
		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				input = dv.getAccount().getText();
				value = 0;
				try {
					value = Double.parseDouble(dv.getValue().getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Type Numbers.. Please...");
					nfe.printStackTrace();
				}
				try {
					ViewController.operation.doDebit(input, value);// do the
																	// debt....
				} catch (BankTransactionException bte) {
					JOptionPane.showMessageDialog(null, "Error: " + bte.getMessage());
				}
				dv.dispose();
				JOptionPane.showMessageDialog(null, "Done!");

			}
		};
		dv.getDone().addActionListener(actionListener);
	}

}
