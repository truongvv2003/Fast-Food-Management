package GUI.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.view.NhanVien.ManHinhChinh_NV;

public class SuKienlblX_MHC_NV  implements MouseListener{
	ManHinhChinh_NV manHinhChinh_NV;

		

		
	public SuKienlblX_MHC_NV(ManHinhChinh_NV manHinhChinh_NV) {
			
		this.manHinhChinh_NV = manHinhChinh_NV;
	}

	
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_NV.lblX) {
			this.manHinhChinh_NV.lblX.setForeground(Color.RED);
		}
		else if(e.getSource() == this.manHinhChinh_NV.lblX_1) {
			this.manHinhChinh_NV.lblX_1.setForeground(Color.RED);
		}
	}
	
	public void mouseExited(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_NV.lblX) {
			this.manHinhChinh_NV.lblX.setForeground(Color.WHITE);
		}	
		else if(e.getSource() == this.manHinhChinh_NV.lblX_1) {
			this.manHinhChinh_NV.lblX_1.setForeground(Color.WHITE);
		}

	}
	
	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
	
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == this.manHinhChinh_NV.lblX) {
			this.manHinhChinh_NV.suKienlblX();
		}
		else if(e.getSource() == this.manHinhChinh_NV.lblX_1) {
			this.manHinhChinh_NV.suKienlblMiniSize();
		}
	}
}
