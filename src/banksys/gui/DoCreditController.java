package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


import banksys.account.OrdinaryAccount;

public class DoCreditController {

	private DoCreditView cv;
	private ActionListener actionListener;
	private String input;
	double value;
	public DoCreditController(DoCreditView _cv) {
		this.cv = _cv;
	}

	public void control() {
		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				input = cv.getAccount().getText();
				value=0;
				try{
					value = Double.parseDouble(cv.getValue().getText());
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Type Numbers.. Please...");
					nfe.printStackTrace();
				}
				//How to know what kind of account it is?
				ViewController.absAccount = new OrdinaryAccount(input);
				cv.dispose();
				JOptionPane.showMessageDialog(null, "Done!");
				/*
				 * 
				 * 	stop right here!!!
				 * 
				 * */
				
			}
		};
		cv.getDone().addActionListener(actionListener);
	}

}
