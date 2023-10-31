package GUI.view.NhanVien;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import GUI.view.Login;
import GUI.view.SuKienDoiHoatAnhTrenMenu_NV;
import GUI.view.SuKienlblX_MHC_NV;

@SuppressWarnings("serial")
public class ManHinhChinh_NV extends JFrame {

	public static ManHinhChinh_NV manHinhChinh_NV;
	private JPanel jPanel_Chinh;
	public PanelDatDoAn_NV panelDatDoAn_NV;
	public PanelTaiKhoan_NV panelTaiKhoan_NV;
	
	public JPanel paneSignOut;
	public JPanel paneDatDoAn;
	public JPanel paneTaiKhoan;
	
	public JLabel lblDatDoAn;
	public JLabel lblIconDatDoAn;
	public JLabel lblTaiKhoan;
	public JLabel lblIconTaiKhoan;
	public JLabel lblSignOut;
	public JLabel lblIconSigOut;
	public JLabel lblX;
	public JLabel lblX_1;

	public static String taiKhoanNhanVien;
	public static String matKhauNhanVien;
	
	public ManHinhChinh_NV() {
		setUndecorated(true);
		setResizable(false);
		caiDatGiaoDien();

	}
	
	
	public void caiDatGiaoDien() {
		
		// set thằng màn hình chính
		this.setBackground(new Color(47, 79, 79));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new SuKienDoiHoatAnhTrenMenu_NV(this));
		UIManager.put("Frame.needDefaultIcon", true); // ẩn thằng phóng to thu nhỏ
		setBounds(100, 100, 1292, 746);
		setLocationRelativeTo(null); // đặt màn hình ở giữa
		// cần set layout cho jPanel chính
		jPanel_Chinh = new JPanel();
		jPanel_Chinh.setBackground(new Color(0, 128, 128));
		jPanel_Chinh.setBorder(new LineBorder(new Color(0, 0, 128), 2)); // độ dày của viền là 2 pixel
		
		setContentPane(jPanel_Chinh); // nó sẽ là nội dung chính hiển thị trên của sổ
		jPanel_Chinh.setLayout(null);
		
		


		panelDatDoAn_NV = new PanelDatDoAn_NV();
		panelDatDoAn_NV.setBounds(0, 0, 964, 701);

		panelTaiKhoan_NV = new PanelTaiKhoan_NV();
		panelTaiKhoan_NV.setBounds(0, 0, 964, 701);
		
		

		
		JPanel paneMenu = new JPanel();
		paneMenu.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		paneMenu.setBackground(new Color(47, 79, 79));
		paneMenu.setBounds(0, 0, 308, 746);
		paneMenu.setLayout(null);
		jPanel_Chinh.add(paneMenu);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBackground(new Color(47, 79, 79));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setIcon(new ImageIcon(ManHinhChinh_NV.class.getResource("/res/LogoManHinhChinh.png")));
		lblIconLogo.setBounds(23, 25, 264, 271);
		paneMenu.add(lblIconLogo);
		
		// sự kiện đổi hoạt ảnh trên menu
		
		paneDatDoAn = new JPanel();
		paneDatDoAn.addMouseListener(new SuKienDoiHoatAnhTrenMenu_NV(this, paneDatDoAn));
		
		paneDatDoAn.setBackground(new Color(47, 79, 79));
		paneDatDoAn.setBounds(10, 306, 288, 76);
		paneMenu.add(paneDatDoAn);
		paneDatDoAn.setLayout(null);
		
		lblDatDoAn = new JLabel("ĐẶT ĐỒ ĂN");
		lblDatDoAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatDoAn.setForeground(Color.WHITE);
		lblDatDoAn.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDatDoAn.setBounds(78, 10, 204, 44);
		paneDatDoAn.add(lblDatDoAn);
		
		lblIconDatDoAn = new JLabel("");
		lblIconDatDoAn.setIcon(new ImageIcon(ManHinhChinh_NV.class.getResource("/res/DatDoAn.png")));
		lblIconDatDoAn.setBounds(10, 0, 76, 76);
		paneDatDoAn.add(lblIconDatDoAn);
		
		paneTaiKhoan = new JPanel();
		paneTaiKhoan.addMouseListener(new SuKienDoiHoatAnhTrenMenu_NV(this, paneTaiKhoan));
		
		paneTaiKhoan.setBackground(new Color(47, 79, 79));
		paneTaiKhoan.setBounds(10, 380, 288, 76);
		paneMenu.add(paneTaiKhoan);
		paneTaiKhoan.setLayout(null);
		
		lblTaiKhoan = new JLabel("TÀI KHOẢN");
		lblTaiKhoan.addMouseListener(new SuKienDoiHoatAnhTrenMenu_NV(this, paneTaiKhoan));
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setForeground(Color.WHITE);
		lblTaiKhoan.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTaiKhoan.setBounds(79, 10, 203, 44);
		paneTaiKhoan.add(lblTaiKhoan);
		
		lblIconTaiKhoan = new JLabel("");
		lblIconTaiKhoan.setIcon(new ImageIcon(ManHinhChinh_NV.class.getResource("/res/TaiKhoan.png")));
		lblIconTaiKhoan.setBounds(10, 0, 76, 76);
		paneTaiKhoan.add(lblIconTaiKhoan);
		
		paneSignOut = new JPanel();
		paneSignOut.addMouseListener(new SuKienDoiHoatAnhTrenMenu_NV(this, paneSignOut));
		
		paneSignOut.setBackground(new Color(47, 79, 79));
		paneSignOut.setBounds(10, 454, 288, 76);
		paneMenu.add(paneSignOut);
		paneSignOut.setLayout(null);
		
		lblSignOut = new JLabel("ĐĂNG XUẤT");
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSignOut.setBounds(80, 10, 202, 44);
		paneSignOut.add(lblSignOut);
		
		lblIconSigOut = new JLabel("");
		lblIconSigOut.setIcon(new ImageIcon(ManHinhChinh_NV.class.getResource("/res/exit.png")));
		lblIconSigOut.setBounds(10, 0, 76, 76);
		paneSignOut.add(lblIconSigOut);
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX.addMouseListener(new SuKienlblX_MHC_NV(this));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(1264, 0, 25, 25);
		jPanel_Chinh.add(lblX);
		
		lblX_1 = new JLabel("―");
		lblX_1.setForeground(new Color(255, 255, 255));
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX_1.addMouseListener(new SuKienlblX_MHC_NV(this));
		lblX_1.setBounds(1229, 0, 25, 25);
		jPanel_Chinh.add(lblX_1);
	
		
		JPanel jPanel_FormDuaVao = new JPanel();
		jPanel_FormDuaVao.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		jPanel_FormDuaVao.setBounds(318, 35, 964, 701);
		
		jPanel_Chinh.add(jPanel_FormDuaVao);
		
		jPanel_FormDuaVao.setLayout(null);
		jPanel_FormDuaVao.add(panelDatDoAn_NV);
		jPanel_FormDuaVao.add(panelTaiKhoan_NV);
		
		form_DuocChon(panelDatDoAn_NV);
	}

	public void form_DuocChon(JPanel panel) {
		panelDatDoAn_NV.setVisible(false);
		panelTaiKhoan_NV.setVisible(false);
		
		panel.setVisible(true);
	}

	public void suKien_paneSignOut() {
		if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", 
				"Thoát chương trình", JOptionPane.YES_NO_OPTION) == 0) {
			Login login = new Login();
			login.setVisible(true);
			this.dispose();
		}
		
	}
	
	public void suKienlblX() {
		if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", "Thoát chương trình", JOptionPane.YES_NO_OPTION) == 0) {
			ManHinhChinh_NV.this.dispose();
		}
	}
	
	public void suKienlblMiniSize() {
		ManHinhChinh_NV.this.setState(JFrame.ICONIFIED);
	}
}
