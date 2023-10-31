package GUI.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import BLL.UserBLL;
import GUI.view.Admin.ManHinhChinh;
import GUI.view.NhanVien.ManHinhChinh_NV;



public class SuKienLogin implements MouseListener, KeyListener, FocusListener {
	Login login;
	private ManHinhChinh manHinhChinh;
	private ManHinhChinh_NV manHinhChinh_NhanVien;
	public SuKienLogin(Login login) {
		this.login = login;
	}

//	@SuppressWarnings("deprecation")
	public void suKien_pnlBtnLogin_DangNhap() throws SQLException {
		if(UserBLL.getInstance().checkLogin(this.login.txtUsername.getText(), this.login.txtPassword.getText()) == 2)
		{
			this.manHinhChinh.taiKhoanAdmin = this.login.txtUsername.getText();
			this.manHinhChinh.matKhauAdmin = this.login.txtPassword.getText();
			this.manHinhChinh = new ManHinhChinh();
			this.manHinhChinh.setVisible(true);
			this.login.dispose();
		}
		else if(UserBLL.getInstance().checkLogin(this.login.txtUsername.getText(), this.login.txtPassword.getText()) == 1)
		{
			this.manHinhChinh_NhanVien.taiKhoanNhanVien = this.login.txtUsername.getText();
			this.manHinhChinh_NhanVien.matKhauNhanVien = this.login.txtPassword.getText();
			this.manHinhChinh_NhanVien = new ManHinhChinh_NV();
			this.manHinhChinh_NhanVien.setVisible(true);
			this.login.dispose();
		}
		else if (this.login.txtUsername.getText().equals("") || this.login.txtUsername.getText().equals("Username")
				|| this.login.txtPassword.getText().equals("") || this.login.txtPassword.getText().equals("Password")) {
			this.login.lblLoginMessage.setText("Xin vui lòng nhập tài khoản và mật khẩu!");
		} else {
			this.login.lblLoginMessage.setText("Bạn nhập sai tài khoản hoặc mật khẩu!");
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == this.login.lblX) {
			this.login.suKienlblX();
		} else if (e.getSource() == this.login.lblX_1) {
			this.login.suKienlblMiniSize();
		} else if (e.getSource() == this.login.pnlBtnLogin) {
			try {
				this.suKien_pnlBtnLogin_DangNhap();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() == this.login.pnlBtnLogin) {
			this.login.pnlBtnLogin.setBackground(new Color(60, 80, 80));
		}

	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource() == this.login.pnlBtnLogin) {
			this.login.pnlBtnLogin.setBackground(new Color(30, 60, 60));
		}

	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == this.login.lblX) {
			this.login.lblX.setForeground(Color.RED);
		} else if (e.getSource() == this.login.lblX_1) {
			this.login.lblX_1.setForeground(Color.RED);
		} else if (e.getSource() == this.login.pnlBtnLogin) {
			this.login.pnlBtnLogin.setBackground(new Color(30, 60, 60));
		}

	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource() == this.login.lblX) {
			this.login.lblX.setForeground(Color.WHITE);
		} else if (e.getSource() == this.login.lblX_1) {
			this.login.lblX_1.setForeground(Color.WHITE);
		} else if (e.getSource() == this.login.pnlBtnLogin) {
			this.login.pnlBtnLogin.setBackground(new Color(47, 79, 79));
		}

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				this.suKien_pnlBtnLogin_DangNhap();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.login.txtUsername) {
			if (this.login.txtUsername.getText().equals("Username")) {
				this.login.txtUsername.setText("");
			} else {
				this.login.txtUsername.selectAll();
			}
		} else {
			if (this.login.txtPassword.getText().equals("Password")) {
				this.login.txtPassword.setEchoChar('●');
				this.login.txtPassword.setText("");
			} else {
				this.login.txtPassword.selectAll();
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.login.txtUsername) {
			if (this.login.txtUsername.getText().equals("")) {
				this.login.txtUsername.setText("Username");
			}
		} else {
			if (this.login.txtPassword.getText().equals("")) {
				this.login.txtPassword.setText("Password");
				this.login.txtPassword.setEchoChar((char) 0);
			}
		}
	}

}
