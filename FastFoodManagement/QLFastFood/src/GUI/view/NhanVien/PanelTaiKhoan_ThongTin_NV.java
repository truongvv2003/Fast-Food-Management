package GUI.view.NhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import BLL.EmployeeBLL;
import GUI.view.PanelButtonMouseAdapter;



@SuppressWarnings("serial")
public class PanelTaiKhoan_ThongTin_NV extends JPanel {


	public JPanel nutpanelLuu;
	public JLabel lblLuu;
	public JTextField jTextField_HoVaTen;
	public JTextField jTextField_NgaySinh;
	public JTextField jTextField_GioiTinh;
	public JTextField textField_MaNhanVien;
	public JTextField textField_ChucVu;
	public JTextField textField_SoDienThoai;

	public PanelTaiKhoan_ThongTin_NV() {
		caiDatPanelXepLichThi_ThoiGianThi();
		docDuLieu();
		luuGV();
	}

	private void caiDatPanelXepLichThi_ThoiGianThi() {
		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 940, 423);
		this.setLayout(null);
        this.setOpaque(false);
		this.setVisible(true);
        

        JLabel lblTieuDe = new JLabel("THÔNG TIN TÀI KHOẢN");
        lblTieuDe.setForeground(new Color(255, 255, 255));
        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
        lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblTieuDe.setBounds(237, 10, 478, 31);
  
        
        JPanel panelTieuDe = new JPanel();
        panelTieuDe.setBackground(new Color(47, 79, 79));
        panelTieuDe.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelTieuDe.setBounds(0, 0, 936, 51);
        panelTieuDe.add(lblTieuDe);
        
        
        JPanel jPanelBody = new JPanel();
        jPanelBody.add(panelTieuDe);        
        panelTieuDe.setLayout(null);
        
        
        JScrollPane jScrollPaneBody = new JScrollPane(); 
        jScrollPaneBody.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        jScrollPaneBody.setBounds(0, 0, 940, 423);
        jScrollPaneBody.setViewportView(jPanelBody);
        jPanelBody.setLayout(null);
        
        JLabel lblHoVaTen = new JLabel("Họ và tên:");
        lblHoVaTen.setFont(new Font("Arial", Font.BOLD, 15));
        lblHoVaTen.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHoVaTen.setBounds(53, 104, 105, 24);
        jPanelBody.add(lblHoVaTen);
        
        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
        lblNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNgaySinh.setFont(new Font("Arial", Font.BOLD, 15));
        lblNgaySinh.setBounds(53, 148, 105, 24);
        jPanelBody.add(lblNgaySinh);
        
        
        JLabel lblGioiTinh = new JLabel("Giới tính:");
        lblGioiTinh.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 15));
        lblGioiTinh.setBounds(53, 187, 105, 24);
        jPanelBody.add(lblGioiTinh);
        
        
        jTextField_HoVaTen = new JTextField();
        jTextField_HoVaTen.setFont(new Font("Arial", Font.BOLD, 14));
        jTextField_HoVaTen.setBounds(211, 104, 210, 24);
        jTextField_HoVaTen.setEnabled(false);
        jPanelBody.add(jTextField_HoVaTen);
        
        jTextField_NgaySinh = new JTextField();
        jTextField_NgaySinh.setFont(new Font("Arial", Font.BOLD, 14));
        jTextField_NgaySinh.setBounds(211, 148, 210, 24);
        jTextField_NgaySinh.setEnabled(false);
        jPanelBody.add(jTextField_NgaySinh);
        
        
        jTextField_GioiTinh = new JTextField();
        jTextField_GioiTinh.setFont(new Font("Arial", Font.PLAIN, 14));
        jTextField_GioiTinh.setBounds(211, 187, 210, 24);
        jTextField_GioiTinh.setEnabled(false);
        jPanelBody.add(jTextField_GioiTinh);
		
		
		nutpanelLuu = new JPanel();
		nutpanelLuu.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelLuu.addMouseListener(new PanelButtonMouseAdapter(nutpanelLuu));

		nutpanelLuu.setBackground(new Color(47, 79, 79));
		nutpanelLuu.setBounds(355, 309, 243, 46);
		nutpanelLuu.setLayout(null);
		
		lblLuu = new JLabel("Lưu thông tin cá nhân");
		lblLuu.setForeground(new Color(255, 255, 255));
		lblLuu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuu.setFont(new Font("Arial", Font.BOLD, 16));
		lblLuu.setBounds(10, 10, 223, 26);
		nutpanelLuu.add(lblLuu);
		jPanelBody.add(nutpanelLuu);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
		lblMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaNhanVien.setFont(new Font("Arial", Font.BOLD, 15));
		lblMaNhanVien.setBounds(459, 104, 139, 24);
		jPanelBody.add(lblMaNhanVien);
		
		textField_MaNhanVien = new JTextField();
		textField_MaNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
		textField_MaNhanVien.setBounds(651, 104, 210, 24);
		textField_MaNhanVien.setEnabled(false);
		jPanelBody.add(textField_MaNhanVien);
		
		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChucVu.setFont(new Font("Arial", Font.BOLD, 15));
		lblChucVu.setBounds(493, 148, 105, 24);
		jPanelBody.add(lblChucVu);
		
		textField_ChucVu = new JTextField();
		textField_ChucVu.setFont(new Font("Arial", Font.BOLD, 14));
		textField_ChucVu.setBounds(651, 148, 210, 24);
		textField_ChucVu.setEnabled(false);
		jPanelBody.add(textField_ChucVu);
		
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoDienThoai.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoDienThoai.setBounds(493, 187, 105, 24);
		jPanelBody.add(lblSoDienThoai);
		
		textField_SoDienThoai = new JTextField();
		textField_SoDienThoai.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_SoDienThoai.setBounds(651, 187, 210, 24);
		jPanelBody.add(textField_SoDienThoai);
        
//		ArrayList<String> listTinh = UserBLL.getInstance().getTinh();
//		for (int i = 0; i < listTinh.size(); i++) {
//			NoiSinh.addItem(listTinh.get(i));
//		}
		
        this.add(jScrollPaneBody);
		
	}
	
	private void docDuLieu() {
		
		jTextField_HoVaTen.setText(EmployeeBLL.getInstance().dsNhanVien(ManHinhChinh_NV.taiKhoanNhanVien, ManHinhChinh_NV.matKhauNhanVien).get(1));
			jTextField_GioiTinh.setText(EmployeeBLL.getInstance().dsNhanVien(ManHinhChinh_NV.taiKhoanNhanVien, ManHinhChinh_NV.matKhauNhanVien).get(3));
		
		jTextField_NgaySinh.setText(EmployeeBLL.getInstance().dsNhanVien(ManHinhChinh_NV.taiKhoanNhanVien, ManHinhChinh_NV.matKhauNhanVien).get(4));
		textField_MaNhanVien.setText(EmployeeBLL.getInstance().dsNhanVien(ManHinhChinh_NV.taiKhoanNhanVien, ManHinhChinh_NV.matKhauNhanVien).get(0));
		textField_ChucVu.setText(EmployeeBLL.getInstance().dsNhanVien(ManHinhChinh_NV.taiKhoanNhanVien, ManHinhChinh_NV.matKhauNhanVien).get(7));
		textField_SoDienThoai.setText(EmployeeBLL.getInstance().dsNhanVien(ManHinhChinh_NV.taiKhoanNhanVien, ManHinhChinh_NV.matKhauNhanVien).get(2));

	}
	private void luuGV() {
		this.nutpanelLuu.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(textField_SoDienThoai.getText().replaceAll(" ", "").equals("") == true) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại của bạn");
				}
				else{
					EmployeeBLL.getInstance().UpdateNhanVien(Integer.parseInt(EmployeeBLL.getInstance().dsNhanVien(ManHinhChinh_NV.taiKhoanNhanVien, ManHinhChinh_NV.matKhauNhanVien).get(0)) , textField_SoDienThoai.getText());
					JOptionPane.showMessageDialog(null, "Lưu thông tin thành công");
				}
			}
		});
	}
	
}
