package GUI.viewItem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Phong extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JRadioButton rdBtn;
	public Phong(String soPhong)
	{
		this.setBorder((Border) new LineBorder(new Color(100, 100, 100), 1));
		this.setPreferredSize(new Dimension(183,58));
		this.setLayout(null);
		
		this.rdBtn = new JRadioButton(soPhong);
		this.rdBtn.setBounds(10, 10, 163, 43);
		this.rdBtn.setFont(new Font("Arial", Font.BOLD, 16));
		
		this.add(rdBtn);
	}
}
