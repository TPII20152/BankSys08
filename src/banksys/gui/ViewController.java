package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import banksys.account.AbstractAccount;
import banksys.control.BankController;
import banksys.persistence.AccountVector;

public class ViewController {

	private View view;
	private ViewRegister newViewRegister;
	private ViewRegisterController newViewRgisterController;

	private ActionListener actionListener;
	public static BankController bank = new BankController(new AccountVector()); // Same as Before.....
	// an vector to keep the accounts created

	public static AbstractAccount absAccount = null;

	//private String input;


	public ViewController(View v){
		this.view=v;

	}

	public void control(){

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/*First, passing the action for the RegisterController....*/
				if(e.getSource()==view.getNewAccount()){
					view.dispose();
					newViewRegister = new ViewRegister();
					newViewRgisterController = new ViewRegisterController(newViewRegister);
					newViewRgisterController.control();
				}
				/*
				 * 	ON THE NEXT COMMIT I'LL FINISH THE GUI......
				 *
				 * */


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

	public void confirmOperation(){
		JOptionPane.showMessageDialog(null, "Operation was successful");
	}


}