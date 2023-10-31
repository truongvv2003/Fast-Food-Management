package GUI.view.NhanVien;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelTaiKhoan_NV extends JPanel {

	
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public JPanel panelDau;
	public MenuName menuName;
	public JPanel jPanelFromVao;
	public PanelTaiKhoan_ThongTin_NV panelTaiKhoan_ThongTin_NV;
	public PanelTaiKhoan_DoiMatKhau_NV panelTaiKhoan_DoiMatKhau_NV;
	public JPanel nutpanelThongTin;
	public JLabel lblThongTin;
	public JPanel nutpanelDoiMatKhau;
	public JLabel lblDoiMatKhau;



	public PanelTaiKhoan_NV() {

		caiDatPanelXepLichThi();
		menuName.setText("Tài Khoản");
        setCustomScrollBar();
        
	}

	private void caiDatPanelXepLichThi() {

		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 964, 701);
		this.setLayout(null);
        this.setOpaque(false);
		
		
		menuName = new MenuName();
		menuName.setBounds(0, 0, 964, 40);
		
		panelDau = new JPanel();
		panelDau.setBounds(0, 0, 964, 40);
		panelDau.setLayout(null);
		panelDau.add(menuName);

		//From dua vao
		jPanelFromVao = new JPanel();
		jPanelFromVao.setLayout(null);
		jPanelFromVao.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jPanelFromVao.setBounds(0, 0, 940, 579);
		
		
		panelTaiKhoan_ThongTin_NV = new PanelTaiKhoan_ThongTin_NV();
		panelTaiKhoan_ThongTin_NV.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTaiKhoan_ThongTin_NV.setBounds(0, 0, 940, 421);
		
		panelTaiKhoan_DoiMatKhau_NV = new PanelTaiKhoan_DoiMatKhau_NV();
		panelTaiKhoan_DoiMatKhau_NV.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTaiKhoan_DoiMatKhau_NV.setBounds(0, 0, 940, 421);
		
		jPanelFromVao.add(panelTaiKhoan_ThongTin_NV);
		jPanelFromVao.add(panelTaiKhoan_DoiMatKhau_NV);

		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 108, 940, 423);
		jScrollPaneTable.setViewportView(jPanelFromVao);

		
		nutpanelThongTin = new JPanel();
		nutpanelThongTin.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelThongTin.addMouseListener(new PanelButtonMouseAdapter(nutpanelThongTin));
		nutpanelThongTin.addMouseListener(new SuKienPannelTaiKhoan_NV(this));
		nutpanelThongTin.setBackground(new Color(47, 79, 79));
		nutpanelThongTin.setBounds(170, 50, 225, 46);
		nutpanelThongTin.setLayout(null);
		
		lblThongTin = new JLabel("Thông tin tài khoản");
		lblThongTin.setForeground(new Color(255, 255, 255));
		lblThongTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongTin.setFont(new Font("Arial", Font.BOLD, 16));
		lblThongTin.setBounds(10, 10, 209, 26);
		nutpanelThongTin.add(lblThongTin);
		
		
		nutpanelDoiMatKhau = new JPanel();
		nutpanelDoiMatKhau.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelDoiMatKhau.addMouseListener(new PanelButtonMouseAdapter(nutpanelDoiMatKhau));
		nutpanelDoiMatKhau.addMouseListener(new SuKienPannelTaiKhoan_NV(this));
		nutpanelDoiMatKhau.setBackground(new Color(47, 79, 79));
		nutpanelDoiMatKhau.setBounds(548, 50, 225, 46);
		nutpanelDoiMatKhau.setLayout(null);
		
		lblDoiMatKhau = new JLabel("Đổi mật khẩu");
		lblDoiMatKhau.setForeground(new Color(255, 255, 255));
		lblDoiMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoiMatKhau.setFont(new Font("Arial", Font.BOLD, 16));
		lblDoiMatKhau.setBounds(10, 10, 189, 26);
		nutpanelDoiMatKhau.add(lblDoiMatKhau);
		
		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
		jPanelBody.add(panelDau);
		jPanelBody.add(jScrollPaneTable);
		jPanelBody.add(nutpanelThongTin);
		jPanelBody.add(nutpanelDoiMatKhau);
		
		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 964, 701);
		jScrollPane_Body.setViewportView(jPanelBody);

		this.add(jScrollPane_Body);
	}
	

	private void setCustomScrollBar() {
    	jScrollPane_Body.setViewportBorder(null);
    	jScrollPane_Body.getViewport().setOpaque(false);
    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
    }
}


