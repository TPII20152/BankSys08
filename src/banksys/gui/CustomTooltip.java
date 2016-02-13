package banksys.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JToolTip;
	/*
	 * 	MY TOOLTIP VERSION...
	 * 
	 * 
	 * */



@SuppressWarnings("serial")
public class CustomTooltip extends JToolTip {

	private Font mainFont = new Font("monospace", Font.BOLD, 15);
	
	public CustomTooltip() {
		super();
		this.setBackground(new Color(255,255,102));
		this.setFont(mainFont);
		this.setForeground(Color.BLACK);
		
		
	}
	
}
