package banksys.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class ViewRegister extends JFrame{

	
	private JButton OrdinaryButton;
	private JButton TaxButton;
	private JButton SavingButton;
	private JButton SpecialButton;
	private JButton MainMenuButton;
	
	
	private static Font mainFont = new Font("Serif", Font.BOLD, 15);

	public ViewRegister(){
		
		super("Bank System");
		Container container = getContentPane();
		
		JPanel centro = new JPanel();
		JPanel east = new JPanel();
		
		east = getBotoesCadastro();
		centro = getMainScream();
		

		container.setLayout(new BorderLayout());
		container.add(BorderLayout.CENTER, centro);
		container.add(BorderLayout.EAST, east);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public JPanel getBotoesCadastro(){
		
		JPanel cadastro = new JPanel();
		cadastro.setLayout(new GridLayout(5, 1));
		
		OrdinaryButton = new JButton("Ordinary");
		OrdinaryButton.setFont(mainFont);
		TaxButton = new JButton("Tax");
		TaxButton.setFont(mainFont);
		SpecialButton = new JButton("Special");
		SpecialButton.setFont(mainFont);
		SavingButton = new JButton("Savings");
		SavingButton.setFont(mainFont);
		MainMenuButton = new JButton("<<");
		MainMenuButton.setFont(mainFont);
		
		
		cadastro.add(OrdinaryButton);
		cadastro.add(SpecialButton);
		cadastro.add(SavingButton);
		cadastro.add(TaxButton);
		cadastro.add(MainMenuButton);
		return cadastro;
	}

	public JPanel getMainScream() {

		String text = "********************************";
		String line = "Add New OrdinaryAccount";
		String line1 = " [1] Ordinary";
		String line2 = " [2] Special";
		String line3 = " [3] Savings";
		String line4 = " [4] Tax";
		String line11 = "Press your desired option: ";

		JPanel mainScream = new JPanel();

		mainScream.setLayout(new GridLayout(11, 1, 0, 0));
		mainScream.add(new MyJLabelVersion(text, mainFont));
		mainScream.add(new MyJLabelVersion(line, mainFont));
		mainScream.add(new MyJLabelVersion(text, mainFont));
		mainScream.add(new MyJLabelVersion(line1, mainFont));
		mainScream.add(new MyJLabelVersion(line2, mainFont));
		mainScream.add(new MyJLabelVersion(line3, mainFont));
		mainScream.add(new MyJLabelVersion(line4, mainFont));
		mainScream.add(new MyJLabelVersion(text, mainFont));
		mainScream.add(new MyJLabelVersion(line11, mainFont));
		mainScream.add(new MyJLabelVersion("Your security is guaranteed using our Bank!", mainFont));
			
		return mainScream;
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
	/*
	 * test....
	public static void main(String[]args){
		new ViewRegister();
	}*/
	
}




