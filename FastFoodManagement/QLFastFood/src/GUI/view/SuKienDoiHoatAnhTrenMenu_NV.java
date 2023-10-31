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

import GUI.view.NhanVien.ManHinhChinh_NV;

public class SuKienDoiHoatAnhTrenMenu_NV extends WindowAdapter implements MouseListener, MouseMotionListener{
	ManHinhChinh_NV manHinhChinh_NV;
	
	JPanel panel;
	JLabel jLabel;
	

	
	public SuKienDoiHoatAnhTrenMenu_NV(ManHinhChinh_NV manHinh_Chinh_NV) {
		
		this.manHinhChinh_NV = manHinh_Chinh_NV;
	}
	
	public SuKienDoiHoatAnhTrenMenu_NV(ManHinhChinh_NV manHinh_Chinh_NV , JPanel panel) {
		
		this.manHinhChinh_NV = manHinh_Chinh_NV;
		this.panel = panel;
	}
	
	public SuKienDoiHoatAnhTrenMenu_NV(ManHinhChinh_NV manHinh_Chinh_NV , JLabel jLabel) {
		
		this.manHinhChinh_NV = manHinh_Chinh_NV;
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
		if(e.getSource() == this.manHinhChinh_NV.paneSignOut) {
			this.manHinhChinh_NV.suKien_paneSignOut();
		}
		
		if(e.getSource() == this.manHinhChinh_NV.lblSignOut) {
			this.manHinhChinh_NV.suKien_paneSignOut();
		}
		
		if(e.getSource() == this.manHinhChinh_NV.lblIconSigOut) {
			this.manHinhChinh_NV.suKien_paneSignOut();
		}
		
		//panel
		
		
		if(e.getSource() == this.manHinhChinh_NV.paneDatDoAn) {
			this.manHinhChinh_NV.form_DuocChon(this.manHinhChinh_NV.panelDatDoAn_NV);
		}
		
		if(e.getSource() == this.manHinhChinh_NV.paneTaiKhoan) {
			this.manHinhChinh_NV.form_DuocChon(this.manHinhChinh_NV.panelTaiKhoan_NV);
		}
		//lbl text
		
		
		if(e.getSource() == this.manHinhChinh_NV.lblDatDoAn) {
			this.manHinhChinh_NV.form_DuocChon(this.manHinhChinh_NV.panelDatDoAn_NV);
		}
		
		if(e.getSource() == this.manHinhChinh_NV.lblTaiKhoan) {
			this.manHinhChinh_NV.form_DuocChon(this.manHinhChinh_NV.panelTaiKhoan_NV);
		}
		//lbl icon

		
		if(e.getSource() == this.manHinhChinh_NV.lblIconDatDoAn) {
			this.manHinhChinh_NV.form_DuocChon(this.manHinhChinh_NV.panelDatDoAn_NV);
		}
		
		if(e.getSource() == this.manHinhChinh_NV.lblIconTaiKhoan) {
			this.manHinhChinh_NV.form_DuocChon(this.manHinhChinh_NV.panelTaiKhoan_NV);
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
	        this.manHinhChinh_NV.dispose();
	    }

	}
	


}
