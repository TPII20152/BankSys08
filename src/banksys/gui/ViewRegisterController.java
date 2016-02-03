package banksys.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ViewRegisterController {

	private ActionListener actionListener;
	private ViewRegister viewRegister;

	public ViewRegisterController(ViewRegister vc) {
		this.viewRegister = vc;
	}

	public void control() {

		actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/*[..............]*/
				
			}

		};

	}
	public void confirmOperation(){
		JOptionPane.showMessageDialog(null, "Operation was successful");
	}
	public void cancelOperation(){
		JOptionPane.showMessageDialog(null, "Canceled operation");
	}
	

}
