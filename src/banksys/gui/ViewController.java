package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ViewController {

	private View view;
	private ActionListener actionListener;


	public ViewController(View v){
		this.view=v;

	}

	public void control(){

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
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
