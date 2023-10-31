package GUI.view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PanelButtonMouseAdapter extends MouseAdapter{
	JPanel panel;
	
	public PanelButtonMouseAdapter(JPanel panel) {
		this.panel = panel;
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		panel.setBackground(new Color(112, 128, 144));
	}
	@Override
	public void mouseExited(MouseEvent e) {
		panel.setBackground(new Color(47, 79, 79));
	}
	@Override
	public void mousePressed(MouseEvent e) {
		panel.setBackground(new Color(60, 179, 133));
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		panel.setBackground(new Color(112, 128, 144));
	}
}