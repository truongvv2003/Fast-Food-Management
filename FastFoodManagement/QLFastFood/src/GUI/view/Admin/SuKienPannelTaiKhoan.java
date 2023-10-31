package GUI.view.Admin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SuKienPannelTaiKhoan implements MouseListener{
	private PanelTaiKhoan panelTaiKhoan;

	
	public SuKienPannelTaiKhoan(PanelTaiKhoan panelTaiKhoan)
	{
		this.panelTaiKhoan = panelTaiKhoan;

	}
	
	public void form_DuocChon(JPanel panel) {
		panelTaiKhoan.panelTaiKhoan_ThongTin.setVisible(false);
		panelTaiKhoan.panelTaiKhoan_DoiMatKhau.setVisible(false);
		panel.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelTaiKhoan.nutpanelDoiMatKhau)
		{
			this.form_DuocChon(this.panelTaiKhoan.panelTaiKhoan_DoiMatKhau);
		}
		if(e.getSource() == this.panelTaiKhoan.nutpanelThongTin)
		{
			this.form_DuocChon(this.panelTaiKhoan.panelTaiKhoan_ThongTin);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




}
