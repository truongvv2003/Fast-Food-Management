package GUI.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.view.Admin.ManHinhChinh;

public class SuKienDoiHoatAnhTrenMenu extends WindowAdapter implements MouseListener, MouseMotionListener{
	ManHinhChinh manHinhChinh;
	
	JPanel panel;
	JLabel jLabel;
	

	
	public SuKienDoiHoatAnhTrenMenu(ManHinhChinh manHinh_Chinh) {
		
		this.manHinhChinh = manHinh_Chinh;
	}
	
	public SuKienDoiHoatAnhTrenMenu(ManHinhChinh manHinh_Chinh , JPanel panel) {
		
		this.manHinhChinh = manHinh_Chinh;
		this.panel = panel;
	}
	
	public SuKienDoiHoatAnhTrenMenu(ManHinhChinh manHinh_Chinh , JLabel jLabel) {
		
		this.manHinhChinh = manHinh_Chinh;
		this.jLabel = jLabel;
	}
	
	

	
	public void mouseEntered(MouseEvent e) {
		panel.setBackground(new Color(112, 128, 144));
	}
	
	public void mouseExited(MouseEvent e) {
		panel.setBackground(new Color(47, 79, 79));
	}
	
	public void mousePressed(MouseEvent e) {
		panel.setBackground(new Color(60, 179, 133));
	}

	public void mouseReleased(MouseEvent e) {
		panel.setBackground(new Color(112, 128, 144));
	}
	
	public void mouseClicked(MouseEvent e) {
		// Sig Out
		if(e.getSource() == this.manHinhChinh.paneSignOut) {
			this.manHinhChinh.suKien_paneSignOut();
		}
		
		if(e.getSource() == this.manHinhChinh.lblSignOut) {
			this.manHinhChinh.suKien_paneSignOut();
		}
		
		if(e.getSource() == this.manHinhChinh.lblIconSigOut) {
			this.manHinhChinh.suKien_paneSignOut();
		}
		
		//panel
		
		if(e.getSource() == this.manHinhChinh.paneAdmin) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelAdmin);
		}
		
		if(e.getSource() == this.manHinhChinh.paneDatDoAn) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelDatDoAn);
		}
		
		if(e.getSource() == this.manHinhChinh.paneTaiKhoan) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelTaiKhoan);
		}
		//lbl text
		
		if(e.getSource() == this.manHinhChinh.lblAdmin) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelAdmin);
		}
		
		if(e.getSource() == this.manHinhChinh.lblDatDoAn) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelDatDoAn);
		}
		
		if(e.getSource() == this.manHinhChinh.lblTaiKhoan) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelTaiKhoan);
		}
		//lbl icon

	
		if(e.getSource() == this.manHinhChinh.lblIconAdmin) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelAdmin);
		}
		
		if(e.getSource() == this.manHinhChinh.lblIconDatDoAn) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelDatDoAn);
		}
		
		if(e.getSource() == this.manHinhChinh.lblIconTaiKhoan) {
			this.manHinhChinh.form_DuocChon(this.manHinhChinh.panelTaiKhoan);
		}

		
	}

	
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
	    int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát khỏi ứng dụng?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
	    if (option == JOptionPane.YES_OPTION) {
	        this.manHinhChinh.dispose();
	    }

	}
	


}
