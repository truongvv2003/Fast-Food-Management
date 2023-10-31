package GUI.view.Admin;

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
import GUI.view.SuKienDoiHoatAnhTrenMenu;
import GUI.view.SuKienlblX_MHC;

@SuppressWarnings("serial")
public class ManHinhChinh extends JFrame {

	public ManHinhChinh manHinhChinh_Admin;
	private JPanel jPanel_Chinh;
	public PanelAdmin panelAdmin;
	public PanelDatDoAn panelDatDoAn;
	public PanelTaiKhoan panelTaiKhoan;
	
	public JPanel paneSignOut;
	public JPanel paneAdmin;
	public JPanel paneDatDoAn;
	public JPanel paneTaiKhoan;
	
	public JLabel lblAdmin;
	public JLabel lblIconAdmin;
	public JLabel lblDatDoAn;
	public JLabel lblIconDatDoAn;
	public JLabel lblTaiKhoan;
	public JLabel lblIconTaiKhoan;
	public JLabel lblSignOut;
	public JLabel lblIconSigOut;
	public JLabel lblX;
	public JLabel lblX_1;

	public static String taiKhoanAdmin;
	public static String matKhauAdmin;
	
	public ManHinhChinh() {
		setUndecorated(true);
		setResizable(false);
		caiDatGiaoDien();

	}
	
	
	public void caiDatGiaoDien() {
		
		// set thằng màn hình chính
		this.setBackground(new Color(47, 79, 79));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new SuKienDoiHoatAnhTrenMenu(this));
		UIManager.put("Frame.needDefaultIcon", true); // ẩn thằng phóng to thu nhỏ
		setBounds(100, 100, 1292, 746);
		setLocationRelativeTo(null); // đặt màn hình ở giữa
		// cần set layout cho jPanel chính
		jPanel_Chinh = new JPanel();
		jPanel_Chinh.setBackground(new Color(0, 128, 128));
		jPanel_Chinh.setBorder(new LineBorder(new Color(0, 0, 128), 2)); // độ dày của viền là 2 pixel
		
		setContentPane(jPanel_Chinh); // nó sẽ là nội dung chính hiển thị trên của sổ
		jPanel_Chinh.setLayout(null);
		
		
		panelAdmin = new PanelAdmin();
		panelAdmin.setBounds(0, 0, 964, 701);

		panelDatDoAn = new PanelDatDoAn();
		panelDatDoAn.setBounds(0, 0, 964, 701);

		panelTaiKhoan = new PanelTaiKhoan();
		panelTaiKhoan.setBounds(0, 0, 964, 701);
		
		

		
		JPanel paneMenu = new JPanel();
		paneMenu.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		paneMenu.setBackground(new Color(47, 79, 79));
		paneMenu.setBounds(0, 0, 308, 746);
		paneMenu.setLayout(null);
		jPanel_Chinh.add(paneMenu);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBackground(new Color(47, 79, 79));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/LogoManHinhChinh.png")));
		lblIconLogo.setBounds(23, 25, 264, 271);
		paneMenu.add(lblIconLogo);
		
		// sự kiện đổi hoạt ảnh trên menu
		
		paneAdmin = new JPanel();
		paneAdmin.addMouseListener(new SuKienDoiHoatAnhTrenMenu(this, paneAdmin));
		
		paneAdmin.setBackground(new Color(47, 79, 79));
		paneAdmin.setBounds(10, 306, 288, 76);
		paneMenu.add(paneAdmin);
		paneAdmin.setLayout(null);
		
		lblAdmin = new JLabel("ADMIN");
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdmin.setBounds(79, 10, 203, 44);
		paneAdmin.add(lblAdmin);
		
		lblIconAdmin = new JLabel("");
		lblIconAdmin.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/Admin.png")));
		lblIconAdmin.setBounds(10, -2, 76, 76);
		paneAdmin.add(lblIconAdmin);
		
		
		paneDatDoAn = new JPanel();
		paneDatDoAn.addMouseListener(new SuKienDoiHoatAnhTrenMenu(this, paneDatDoAn));
		
		paneDatDoAn.setBackground(new Color(47, 79, 79));
		paneDatDoAn.setBounds(10, 382, 288, 76);
		paneMenu.add(paneDatDoAn);
		paneDatDoAn.setLayout(null);
		
		lblDatDoAn = new JLabel("ĐẶT ĐỒ ĂN");
		lblDatDoAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatDoAn.setForeground(Color.WHITE);
		lblDatDoAn.setFont(new Font("Dialog", Font.BOLD, 20));
		lblDatDoAn.setBounds(78, 10, 204, 44);
		paneDatDoAn.add(lblDatDoAn);
		
		lblIconDatDoAn = new JLabel("");
		lblIconDatDoAn.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/DatDoAn.png")));
		lblIconDatDoAn.setBounds(10, 0, 76, 76);
		paneDatDoAn.add(lblIconDatDoAn);
		
		paneTaiKhoan = new JPanel();
		paneTaiKhoan.addMouseListener(new SuKienDoiHoatAnhTrenMenu(this, paneTaiKhoan));
		
		paneTaiKhoan.setBackground(new Color(47, 79, 79));
		paneTaiKhoan.setBounds(10, 456, 288, 76);
		paneMenu.add(paneTaiKhoan);
		paneTaiKhoan.setLayout(null);
		
		lblTaiKhoan = new JLabel("TÀI KHOẢN");
		lblTaiKhoan.addMouseListener(new SuKienDoiHoatAnhTrenMenu(this, paneTaiKhoan));
		lblTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiKhoan.setForeground(Color.WHITE);
		lblTaiKhoan.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTaiKhoan.setBounds(79, 10, 203, 44);
		paneTaiKhoan.add(lblTaiKhoan);
		
		lblIconTaiKhoan = new JLabel("");
		lblIconTaiKhoan.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/TaiKhoan.png")));
		lblIconTaiKhoan.setBounds(10, 0, 76, 76);
		paneTaiKhoan.add(lblIconTaiKhoan);
		
		paneSignOut = new JPanel();
		paneSignOut.addMouseListener(new SuKienDoiHoatAnhTrenMenu(this, paneSignOut));
		
		paneSignOut.setBackground(new Color(47, 79, 79));
		paneSignOut.setBounds(10, 530, 288, 76);
		paneMenu.add(paneSignOut);
		paneSignOut.setLayout(null);
		
		lblSignOut = new JLabel("ĐĂNG XUẤT");
		lblSignOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignOut.setForeground(Color.WHITE);
		lblSignOut.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSignOut.setBounds(80, 10, 202, 44);
		paneSignOut.add(lblSignOut);
		
		lblIconSigOut = new JLabel("");
		lblIconSigOut.setIcon(new ImageIcon(ManHinhChinh.class.getResource("/res/exit.png")));
		lblIconSigOut.setBounds(10, 0, 76, 76);
		paneSignOut.add(lblIconSigOut);
		
		lblX = new JLabel("X");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX.addMouseListener(new SuKienlblX_MHC(this));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setBounds(1264, 0, 25, 25);
		jPanel_Chinh.add(lblX);
		
		lblX_1 = new JLabel("―");
		lblX_1.setForeground(new Color(255, 255, 255));
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblX_1.addMouseListener(new SuKienlblX_MHC(this));
		lblX_1.setBounds(1229, 0, 25, 25);
		jPanel_Chinh.add(lblX_1);
	
		
		JPanel jPanel_FormDuaVao = new JPanel();
		jPanel_FormDuaVao.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		jPanel_FormDuaVao.setBounds(318, 35, 964, 701);
		
		jPanel_Chinh.add(jPanel_FormDuaVao);
		
		jPanel_FormDuaVao.setLayout(null);
		jPanel_FormDuaVao.add(panelAdmin);
		jPanel_FormDuaVao.add(panelDatDoAn);
		jPanel_FormDuaVao.add(panelTaiKhoan);
		
		form_DuocChon(panelAdmin);
	}

	public void form_DuocChon(JPanel panel) {
		panelAdmin.setVisible(false);
		panelDatDoAn.setVisible(false);
		panelTaiKhoan.setVisible(false);
		
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
			ManHinhChinh.this.dispose();
		}
	}
	
	public void suKienlblMiniSize() {
		ManHinhChinh.this.setState(JFrame.ICONIFIED);
	}
}
