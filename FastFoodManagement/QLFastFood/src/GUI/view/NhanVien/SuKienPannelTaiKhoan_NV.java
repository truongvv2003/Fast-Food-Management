package GUI.view.NhanVien;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SuKienPannelTaiKhoan_NV implements MouseListener{
	private PanelTaiKhoan_NV panelTaiKhoan_NV;

	
	public SuKienPannelTaiKhoan_NV(PanelTaiKhoan_NV panelTaiKhoan_NV)
	{
		this.panelTaiKhoan_NV = panelTaiKhoan_NV;

	}
	
	public void form_DuocChon(JPanel panel) {
		panelTaiKhoan_NV.panelTaiKhoan_ThongTin_NV.setVisible(false);
		panelTaiKhoan_NV.panelTaiKhoan_DoiMatKhau_NV.setVisible(false);
		panel.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelTaiKhoan_NV.nutpanelDoiMatKhau)
		{
			this.form_DuocChon(this.panelTaiKhoan_NV.panelTaiKhoan_DoiMatKhau_NV);
		}
		if(e.getSource() == this.panelTaiKhoan_NV.nutpanelThongTin)
		{
			this.form_DuocChon(this.panelTaiKhoan_NV.panelTaiKhoan_ThongTin_NV);
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
