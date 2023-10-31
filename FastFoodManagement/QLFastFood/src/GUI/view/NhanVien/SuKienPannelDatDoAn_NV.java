package GUI.view.NhanVien;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class SuKienPannelDatDoAn_NV implements MouseListener{
	private PanelDatDoAn_NV panelDatDoAn_NV;
	
	
	public SuKienPannelDatDoAn_NV(PanelDatDoAn_NV panelDatDoAn_NV)
	{
		this.panelDatDoAn_NV = panelDatDoAn_NV;

	}
	
	public void form_DuocChon(JPanel panel) {
		panelDatDoAn_NV.panelDatDoAn_DatMon_NV.setVisible(false);
		panelDatDoAn_NV.panelDatDoAn_ThongKe_NV.setVisible(false);
		panel.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelDatDoAn_NV.nutpanelDatMon)
		{
			this.form_DuocChon(this.panelDatDoAn_NV.panelDatDoAn_DatMon_NV);
		}
		if(e.getSource() == this.panelDatDoAn_NV.nutpanelThongKe)
		{
			this.form_DuocChon(this.panelDatDoAn_NV.panelDatDoAn_ThongKe_NV);
			this.panelDatDoAn_NV.panelDatDoAn_ThongKe_NV.bangThongKe();
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

