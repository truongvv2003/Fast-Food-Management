package GUI.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.view.Admin.ManHinhChinh;

public class SuKienlblX_MHC  implements MouseListener{
	ManHinhChinh manHinhChinh;

		

		
	public SuKienlblX_MHC(ManHinhChinh manHinhChinh) {
			
		this.manHinhChinh = manHinhChinh;
	}

	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh.lblX) {
			this.manHinhChinh.lblX.setForeground(Color.RED);
		}
		else if(e.getSource() == this.manHinhChinh.lblX_1) {
			this.manHinhChinh.lblX_1.setForeground(Color.RED);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh.lblX) {
			this.manHinhChinh.lblX.setForeground(Color.WHITE);
		}	
		else if(e.getSource() == this.manHinhChinh.lblX_1) {
			this.manHinhChinh.lblX_1.setForeground(Color.WHITE);
		}

	}
	
	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh.lblX) {
			this.manHinhChinh.suKienlblX();
		}
		else if(e.getSource() == this.manHinhChinh.lblX_1) {
			this.manHinhChinh.suKienlblMiniSize();
		}
	}
}
