package banksys.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JToolTip;

@SuppressWarnings("serial")
public class MyJLabelVersion extends JLabel {

	private CustomTooltip m_tooltip;

	/*
	 * a class that extends label with difference that receives the source along
	 * in its constructor, a way to use an element dynamically and more freedom
	 * to use your settings, in this case as well as we can create a label,
	 * choose a different font standard.
	 *
	 */

	public MyJLabelVersion(String text, Font fonte) {
		super(text);
		setFont(fonte);
	}

	@Override
	public JToolTip createToolTip() {
		if (m_tooltip == null) {
			m_tooltip = new CustomTooltip();
			m_tooltip.setComponent(this);
		}
		return m_tooltip;
	}
}