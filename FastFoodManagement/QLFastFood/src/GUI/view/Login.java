package GUI.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel contentPane;
	public JTextField txtUsername;
	public JPasswordField txtPassword;
	public JLabel lblLoginMessage = new JLabel("");
	public JLabel lblX;
	public JPanel pnlBtnLogin;
	public JLabel lblX_1;

	public Login() {
		setUndecorated(true);
		this.caiDatGiaoDienLogin();
	}

	public void caiDatGiaoDienLogin() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//UIManager.put("Frame.needDefaultIcon", true); // ẩn thằng phóng to thu nhỏ
		this.setBounds(100, 100, 523, 301);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(133, 121, 250, 42);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new SuKienLogin(this));
		txtUsername.addFocusListener(new SuKienLogin(this));

		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUsername.setText("Username");
		txtUsername.setBounds(10, 10, 168, 22);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblIconUsername = new JLabel("");
		lblIconUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconUsername.setIcon(new ImageIcon(Login.class.getResource("/res/Administrator.png")));
		lblIconUsername.setBounds(205, 0, 45, 41);
		panel.add(lblIconUsername);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(133, 173, 250, 42);
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new SuKienLogin(this));
		txtPassword.addFocusListener(new SuKienLogin(this));

		
		txtPassword.setBorder(null);
		txtPassword.setEchoChar((char)0);
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPassword.setText("Password");
		txtPassword.setBounds(10, 11, 168, 21);
		panel_1.add(txtPassword);
		
		JLabel lblIconPassword = new JLabel("");
		lblIconPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPassword.setBounds(202, 0, 48, 42);
		panel_1.add(lblIconPassword);
		lblIconPassword.setIcon(new ImageIcon(Login.class.getResource("/res/Lock.png")));
		
		pnlBtnLogin = new JPanel();
		pnlBtnLogin.setFocusable(true);
		pnlBtnLogin.addKeyListener(new SuKienLogin(this));
		pnlBtnLogin.addMouseListener(new SuKienLogin(this));
		
		pnlBtnLogin.setBounds(133, 249, 250, 42);
		pnlBtnLogin.setBackground(new Color(47, 79, 79));
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOGIN");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setForeground(Color.WHITE);
		lblLogIn.setFont(new Font("Arial", Font.BOLD, 18));
		lblLogIn.setBounds(85, 0, 91, 42);
		pnlBtnLogin.add(lblLogIn);
		
		JLabel lblIconLogin = new JLabel("");
		lblIconLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogin.setIcon(new ImageIcon(Login.class.getResource("/res/Key.png")));
		lblIconLogin.setBounds(27, 0, 48, 42);
		pnlBtnLogin.add(lblIconLogin);
		
		lblX = new JLabel("X");
		lblX.setBounds(501, 0, 20, 20);
		lblX.addMouseListener(new SuKienLogin(this));
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblX);
		
		lblX_1 = new JLabel("―");
		lblX_1.addMouseListener(new SuKienLogin(this));
		lblX_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblX_1.setForeground(Color.WHITE);
		lblX_1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX_1.setBounds(474, 0, 20, 20);
		contentPane.add(lblX_1);
		
		setLocationRelativeTo(null);
		
		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setBounds(133, 0, 250, 128);
		lblIconLogo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblIconLogo);
		lblIconLogo.setIcon(new ImageIcon(Login.class.getResource("/res/Login.png")));
		
		lblLoginMessage.setForeground(Color.WHITE);
		lblLoginMessage.setFont(new Font("Arial", Font.BOLD, 12));
		lblLoginMessage.setBounds(154, 225, 250, 14);
		contentPane.add(lblLoginMessage);
		
		

	}

	public void suKienlblX() {
		if(JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát?", "Thoát chương trình", JOptionPane.YES_NO_OPTION) == 0) {
			Login.this.dispose();
		}
	}

	public void suKienlblMiniSize() {
		Login.this.setState(JFrame.ICONIFIED);
	}
}
