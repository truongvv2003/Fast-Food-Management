package GUI.view.Admin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SuKienPannelDatDoAn implements MouseListener{
	private PanelDatDoAn panelDatDoAn;

	
	public SuKienPannelDatDoAn(PanelDatDoAn panelDatDoAn)
	{
		this.panelDatDoAn = panelDatDoAn;

	}
	
	public void form_DuocChon(JPanel panel) {
		panelDatDoAn.panelDatDoAn_DatMon.setVisible(false);
		panelDatDoAn.panelDatDoAn_DanhSachMon.setVisible(false);
		panelDatDoAn.panelDatDoAn_ThongKe.setVisible(false);
		panel.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelDatDoAn.nutpanelDatMon)
		{
			this.form_DuocChon(this.panelDatDoAn.panelDatDoAn_DatMon);
		}
		if(e.getSource() == this.panelDatDoAn.nutpanelDanhSachMon)
		{
			this.form_DuocChon(this.panelDatDoAn.panelDatDoAn_DanhSachMon);
		}
		if(e.getSource() == this.panelDatDoAn.nutpanelThongKe)
		{
			this.form_DuocChon(this.panelDatDoAn.panelDatDoAn_ThongKe);
		}
		this.panelDatDoAn.panelDatDoAn_ThongKe.bangThongKe();
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

