package banksys.gui;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MyJLabelVersion extends JLabel{

	/*
	 * a class that extends label with difference that 
	 * receives the source along in its constructor, a
	 * way to use an element dynamically and more freedom to 
	 * use your settings, in this case as well as we can create 
	 * a label, choose a different font standard.
	 * 
	 * */
	
	public MyJLabelVersion(String text, Font fonte){
		setText(text);
		setFont(fonte);
	}
	
	
}
