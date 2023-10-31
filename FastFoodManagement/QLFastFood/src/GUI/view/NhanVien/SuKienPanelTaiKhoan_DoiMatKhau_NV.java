package GUI.view.NhanVien;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import BLL.UserBLL;



public class SuKienPanelTaiKhoan_DoiMatKhau_NV implements MouseListener, KeyListener{
	PanelTaiKhoan_DoiMatKhau_NV panelTaiKhoan_DoiMatKhau_NV;
	public SuKienPanelTaiKhoan_DoiMatKhau_NV(PanelTaiKhoan_DoiMatKhau_NV PanelTaiKhoan_DoiMatKhau_NV)
	{
		this.panelTaiKhoan_DoiMatKhau_NV = PanelTaiKhoan_DoiMatKhau_NV;
	}
//	@SuppressWarnings("deprecation")
	public void suKienDoiMatKhau() {
		if(this.panelTaiKhoan_DoiMatKhau_NV.jTextField_MatKhauCu.getText().equals(ManHinhChinh_NV.matKhauNhanVien) == false) {
			JOptionPane.showMessageDialog(null, "Mật khẩu cũ bạn nhập vào không đúng");
		}
		else if(this.panelTaiKhoan_DoiMatKhau_NV.jTextField_MatKhauMoi.getText().replaceAll(" ", "").equals("") == true) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu mới");
		}
		else if(this.panelTaiKhoan_DoiMatKhau_NV.jTextField_MatKhauMoi.getText().equals(ManHinhChinh_NV.matKhauNhanVien) == true) {
			JOptionPane.showMessageDialog(null, "Mật khẩu bạn nhập trùng với mật khẩu cũ");
		}
		else if(this.panelTaiKhoan_DoiMatKhau_NV.jTextField_MatKhauMoi.getText().equals(this.panelTaiKhoan_DoiMatKhau_NV.jTextField_NhapLaiMatKhau.getText())== false) {
			JOptionPane.showMessageDialog(null, "Nhập lại mật khẩu không khớp");
		}
		
		else {
			UserBLL.getInstance().doiMatKhau(ManHinhChinh_NV.taiKhoanNhanVien, this.panelTaiKhoan_DoiMatKhau_NV.jTextField_MatKhauMoi.getText());
			JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
			this.panelTaiKhoan_DoiMatKhau_NV.jTextField_MatKhauCu.setText("");
			this.panelTaiKhoan_DoiMatKhau_NV.jTextField_MatKhauMoi.setText("");
			this.panelTaiKhoan_DoiMatKhau_NV.jTextField_NhapLaiMatKhau.setText("");
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelTaiKhoan_DoiMatKhau_NV.nutpanelLuu) {
			this.suKienDoiMatKhau();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.suKienDoiMatKhau();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
