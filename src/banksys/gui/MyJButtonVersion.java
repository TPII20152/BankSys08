package banksys.gui;

import javax.swing.JButton;
import javax.swing.JToolTip;

	/*
	 * 	ONLY THIS WAY I CAN PRODUCE A NEW KIND OF TOOLTIP....
	 * 
	 * 
	 * */



@SuppressWarnings("serial")
public class MyJButtonVersion extends JButton{
	private CustomTooltip m_tooltip;
	
	public MyJButtonVersion(String text){
		super(text);
		setBorderPainted(false); // FUCK the borders...
		setContentAreaFilled(false);
	}
	public MyJButtonVersion(){};
	
	@Override
	public JToolTip createToolTip() {
		if (m_tooltip == null) {
			m_tooltip = new CustomTooltip();
			m_tooltip.setComponent(this);
		}
		return m_tooltip;
	}
}
