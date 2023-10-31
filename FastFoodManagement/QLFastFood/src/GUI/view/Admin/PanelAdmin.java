package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import BLL.EmployeeBLL;
import DAL.EmployeeDAL;
import DAL.connectSQL;
import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;



@SuppressWarnings("serial")
public class PanelAdmin extends JPanel {

	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public TableCuaTui tableCuaTui;
	public JPanel panelDau;
	public MenuName menuName;
	public JPanel nutpanelThem;
	private JLabel lblThem;
	public JPanel nutpanelXoa;
	private JLabel lblXoa;
	public JPanel nutpanelSua;
	private JLabel lblSua;
	public JTextField jTextField_HoVaTen;
	public JTextField jTextField_NgaySinh;
	public JComboBox<String> GioiTinh;
	public JTextField textField_MaNhanVien;
	public JTextField textField_Khoa;
	public JComboBox<String> ChucVu;
	public JTextField textField_SoDienThoai;
	public JTextField textField_TaiKhoan;
	public JTextField textField_MatKhau;
	public JPanel nutpanelXacNhan;
	private JLabel lblXacNhan;
	public JPanel nutpanelHuyChon;
	public MyModel model;
	private JLabel lblHuyChon;

		//@SuppressWarnings("unused")
		public class MyModel extends AbstractTableModel {
	        String[][] list;
	        public MyModel(String[][] list) {
	            this.list = list;
	        }
	        public void setMyModel(String[][] list)
	        {
	        	this.list = list;
	        }
	        @Override
	        public String getColumnName(int column) {
	        	switch(column)
	        	{
	        	case 0:
	        		return "Số Thứ Tự";
	        	case 1:
	        		return "Mã Nhân Viên";
	        	case 2:
	    			return "Tên Nhân Viên";
	        	case 3:
	        		return "Số Điện Thoại";
	        	case 4:
	        		return "Giới Tính";
	        	case 5:
	        		return "Ngày Tháng Năm Sinh";
	        	}
				return "";
	        }
	        @Override
	        public int getColumnCount() {
	            return 6;
	        }
	        @Override
	        public int getRowCount() {
	            return list.length;
	        }
	        @Override
	        public Object getValueAt(int rowIndex, int columnIndex) {
	        	if(columnIndex == 0)
	        	{
	        		return Integer.toString(rowIndex+1);
	        	}
	        	if(list[rowIndex][columnIndex] == null)
	        		return "";
	        	return list[rowIndex][columnIndex];
	        }

	        @Override
	        public boolean isCellEditable(int rowIndex, int columnIndex) {
	            return false;
	        }
	        
	        public void clearData()
	        {
	        	list = null;
	        	fireTableDataChanged();
	        }
	        
	        public void renewData(String[][] list)
	        {
	        	this.list = list;
	        	fireTableDataChanged();
	        }
	    }
		
		public PanelAdmin() {


			caiDatPanelThongTin();
			
			tableCuaTui.fixTable(jScrollPaneTable);

	        setCustomScrollBar();

			
		}

		private void caiDatPanelThongTin() {
			
			this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			this.setBounds(0, 0, 964, 701);
			this.setLayout(null);
	        this.setOpaque(false);
	        
	        JLabel lblTieuDe = new JLabel("THÔNG TIN NHÂN VIÊN");
	        lblTieuDe.setForeground(new Color(255, 255, 255));
	        lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
	        lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
	        lblTieuDe.setBounds(237, 10, 478, 31);
	  
	        
	        JPanel panelTieuDe = new JPanel();
	        panelTieuDe.setLayout(null);
	        panelTieuDe.setBackground(new Color(47, 79, 79));
	        panelTieuDe.setBorder(new LineBorder(new Color(0, 0, 0)));
	        panelTieuDe.setBounds(0, 0, 960, 51);
	        panelTieuDe.add(lblTieuDe);

			
//			this.addComponentListener(new SuKienPannelThongTin_LopHocPhan(this));
	        tableCuaTui = new TableCuaTui();
			String[][] data = EmployeeBLL.getInstance().getListThongTinNhanVien();
			model = new MyModel(data);
			tableCuaTui.setModel(model);
			tableCuaTui.getTableHeader().setReorderingAllowed(false);
			tableCuaTui.addMouseListener(new SuKienPanelAdmin(this));
			
//			tableCuaTui.addMouseListener(new SuKienPannelThongTin_LopHocPhan(this));
			
			
			jScrollPaneTable = new JScrollPane();
			jScrollPaneTable.setBounds(10, 220, 940, 404);
			jScrollPaneTable.setViewportView(tableCuaTui);
	        
			jPanelBody = new JPanel();
			jPanelBody.setLayout(null);
			jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
	        jPanelBody.add(panelTieuDe);  
			jPanelBody.add(jScrollPaneTable);
			
			jScrollPane_Body = new JScrollPane();
			jScrollPane_Body.setBounds(0, 0, 964, 701);
			jScrollPane_Body.setViewportView(jPanelBody);
	               
	        jTextField_HoVaTen = new JTextField();
	        jTextField_HoVaTen.setFont(new Font("Arial", Font.BOLD, 14));
	        jTextField_HoVaTen.setBounds(214, 73, 210, 24);
	        jTextField_HoVaTen.setEnabled(false);
	        jPanelBody.add(jTextField_HoVaTen);
	        
	        jTextField_NgaySinh = new JTextField();
	        jTextField_NgaySinh.setFont(new Font("Arial", Font.BOLD, 14));
	        jTextField_NgaySinh.setBounds(214, 107, 210, 24);
	        jTextField_NgaySinh.setEnabled(false);
	        jPanelBody.add(jTextField_NgaySinh);
	        
	        GioiTinh = new JComboBox<String>();
	        GioiTinh.addItem("Nam");
	        GioiTinh.addItem("Nữ");
	        GioiTinh.addItem("");
	        GioiTinh.setSelectedItem(2);
	        GioiTinh.setFont(new Font("Arial", Font.PLAIN, 14));
	        GioiTinh.setBounds(214, 141, 210, 24);
	        GioiTinh.setEnabled(false);
	        jPanelBody.add(GioiTinh);
			
	        JLabel lblHoVaTen = new JLabel("Họ và tên:");
	        lblHoVaTen.setFont(new Font("Arial", Font.BOLD, 15));
	        lblHoVaTen.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblHoVaTen.setBounds(56, 73, 105, 24);
	        jPanelBody.add(lblHoVaTen);
	        
	        JLabel lblNgaySinh = new JLabel("Ngày sinh:");
	        lblNgaySinh.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblNgaySinh.setFont(new Font("Arial", Font.BOLD, 15));
	        lblNgaySinh.setBounds(56, 107, 105, 24);
	        jPanelBody.add(lblNgaySinh);
	        
	        
	        JLabel lblGioiTinh = new JLabel("Giới tính:");
	        lblGioiTinh.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 15));
	        lblGioiTinh.setBounds(56, 141, 105, 24);
	        jPanelBody.add(lblGioiTinh);
			
			JLabel lblMaNhanVien = new JLabel("Mã nhân viên:");
			lblMaNhanVien.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMaNhanVien.setFont(new Font("Arial", Font.BOLD, 15));
			lblMaNhanVien.setBounds(462, 73, 139, 24);
			jPanelBody.add(lblMaNhanVien);
			
			textField_MaNhanVien = new JTextField();
			textField_MaNhanVien.setFont(new Font("Arial", Font.BOLD, 14));
			textField_MaNhanVien.setBounds(654, 73, 210, 24);
			textField_MaNhanVien.setEnabled(false);
			jPanelBody.add(textField_MaNhanVien);
			
			JLabel lblChucVu = new JLabel("Chức vụ:");
			lblChucVu.setHorizontalAlignment(SwingConstants.RIGHT);
			lblChucVu.setFont(new Font("Arial", Font.BOLD, 15));
			lblChucVu.setBounds(496, 107, 105, 24);
			jPanelBody.add(lblChucVu);
			
			ChucVu = new JComboBox<>();
			ChucVu.addItem("Nhân viên");
			ChucVu.addItem("Quản Lý");
			ChucVu.addItem("");
			ChucVu.setSelectedIndex(2);
			ChucVu.setFont(new Font("Arial", Font.BOLD, 14));
			ChucVu.setBounds(654, 107, 210, 24);
			ChucVu.setEnabled(false);
			jPanelBody.add(ChucVu);
			
			
			JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
			lblSoDienThoai.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSoDienThoai.setFont(new Font("Arial", Font.BOLD, 15));
			lblSoDienThoai.setBounds(496, 141, 105, 24);
			jPanelBody.add(lblSoDienThoai);
			
			textField_SoDienThoai = new JTextField();
			textField_SoDienThoai.setFont(new Font("Arial", Font.PLAIN, 14));
			textField_SoDienThoai.setBounds(654, 141, 210, 24);
			textField_SoDienThoai.setEnabled(false);
			jPanelBody.add(textField_SoDienThoai);
	        
			
			JLabel lblTaiKhoan = new JLabel("Tài khoản:");
			lblTaiKhoan.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTaiKhoan.setFont(new Font("Arial", Font.BOLD, 15));
			lblTaiKhoan.setBounds(56, 175, 105, 24);
			jPanelBody.add(lblTaiKhoan);
			
			textField_TaiKhoan = new JTextField();
			textField_TaiKhoan.setFont(new Font("Arial", Font.PLAIN, 14));
			textField_TaiKhoan.setEnabled(false);
			textField_TaiKhoan.setBounds(214, 175, 210, 24);
			jPanelBody.add(textField_TaiKhoan);
			
			JLabel lblMatKhau = new JLabel("Mật khẩu:");
			lblMatKhau.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMatKhau.setFont(new Font("Arial", Font.BOLD, 15));
			lblMatKhau.setBounds(496, 175, 105, 24);
			jPanelBody.add(lblMatKhau);
			
			textField_MatKhau = new JTextField();
			textField_MatKhau.setFont(new Font("Arial", Font.PLAIN, 14));
			textField_MatKhau.setBounds(654, 175, 210, 24);
			textField_MatKhau.setEnabled(false);
			jPanelBody.add(textField_MatKhau);

			nutpanelXacNhan = new JPanel();
			nutpanelXacNhan.setLayout(null);
			nutpanelXacNhan.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelXacNhan.addMouseListener(new PanelButtonMouseAdapter(nutpanelXacNhan));
			nutpanelXacNhan.setBackground(new Color(47, 79, 79));
			nutpanelXacNhan.setBounds(882, 139, 68, 26);
			jPanelBody.add(nutpanelXacNhan);
			
			lblXacNhan = new JLabel("Xác nhận");
			lblXacNhan.setHorizontalAlignment(SwingConstants.CENTER);
			lblXacNhan.setForeground(Color.WHITE);
			lblXacNhan.setFont(new Font("Arial", Font.BOLD, 12));
			lblXacNhan.setBounds(0, 0, 68, 26);
			nutpanelXacNhan.add(lblXacNhan);
			nutpanelXacNhan.addMouseListener(new SuKienPanelAdmin(this));
			nutpanelXacNhan.setVisible(false);
			
			nutpanelHuyChon = new JPanel();
			nutpanelHuyChon.setLayout(null);
			nutpanelHuyChon.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelHuyChon.addMouseListener(new PanelButtonMouseAdapter(nutpanelHuyChon));
			nutpanelHuyChon.setBackground(new Color(47, 79, 79));
			nutpanelHuyChon.setBounds(882, 173, 68, 26);
			jPanelBody.add(nutpanelHuyChon);
			
			lblHuyChon = new JLabel("Hủy");
			lblHuyChon.setHorizontalAlignment(SwingConstants.CENTER);
			lblHuyChon.setForeground(Color.WHITE);
			lblHuyChon.setFont(new Font("Arial", Font.BOLD, 12));
			lblHuyChon.setBounds(0, 0, 68, 26);
			nutpanelHuyChon.add(lblHuyChon);
			nutpanelHuyChon.addMouseListener(new SuKienPanelAdmin(this));
			nutpanelHuyChon.setVisible(false);
			
			nutpanelThem = new JPanel();
			nutpanelThem.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelThem.addMouseListener(new PanelButtonMouseAdapter(nutpanelThem));
//			nutpanelThem.addMouseListener(new SuKienPannelDatDoAn_DatMon(this));
			nutpanelThem.setBackground(new Color(47, 79, 79));
			nutpanelThem.setBounds(95, 641, 193, 46);
			nutpanelThem.setLayout(null);
			
			lblThem = new JLabel("Thêm");
			lblThem.setForeground(new Color(255, 255, 255));
			lblThem.setHorizontalAlignment(SwingConstants.CENTER);
			lblThem.setFont(new Font("Arial", Font.BOLD, 16));
			lblThem.setBounds(10, 10, 177, 26);
			nutpanelThem.add(lblThem);
			nutpanelThem.addMouseListener(new SuKienPanelAdmin(this));
	        jPanelBody.add(nutpanelThem);
	        
			nutpanelXoa = new JPanel();
			nutpanelXoa.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelXoa.addMouseListener(new PanelButtonMouseAdapter(nutpanelXoa));
//			nutpanelXoa.addMouseListener(new SuKienPannelDatDoAn_DatMon(this));
			nutpanelXoa.setBackground(new Color(47, 79, 79));
			nutpanelXoa.setBounds(671, 641, 193, 46);
			nutpanelXoa.setLayout(null);
			
			lblXoa = new JLabel("Xóa");
			lblXoa.setForeground(new Color(255, 255, 255));
			lblXoa.setHorizontalAlignment(SwingConstants.CENTER);
			lblXoa.setFont(new Font("Arial", Font.BOLD, 16));
			lblXoa.setBounds(10, 10, 177, 26);
			nutpanelXoa.add(lblXoa);
			nutpanelXoa.addMouseListener(new SuKienPanelAdmin(this));
	        jPanelBody.add(nutpanelXoa);
	        
			nutpanelSua = new JPanel();
			nutpanelSua.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelSua.addMouseListener(new PanelButtonMouseAdapter(nutpanelSua));
//			nutpanelSua.addMouseListener(new SuKienPannelDatDoAn_DatMon(this));
			nutpanelSua.setBackground(new Color(47, 79, 79));
			nutpanelSua.setBounds(383, 641, 193, 46);
			nutpanelSua.setLayout(null);
			
			lblSua = new JLabel("Sửa");
			lblSua.setForeground(new Color(255, 255, 255));
			lblSua.setHorizontalAlignment(SwingConstants.CENTER);
			lblSua.setFont(new Font("Arial", Font.BOLD, 16));
			lblSua.setBounds(10, 10, 177, 26);
			nutpanelSua.add(lblSua);
			nutpanelSua.addMouseListener(new SuKienPanelAdmin(this));
	        jPanelBody.add(nutpanelSua);

//			this.addComponentListener(new SuKienPannelThongTin_LopHocPhan(this));
			this.add(jScrollPane_Body);
			this.setVisible(false);
//	

		}
		

		private void setCustomScrollBar() {
	    	jScrollPane_Body.setViewportBorder(null);
	    	jScrollPane_Body.getViewport().setOpaque(false);
	    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
	    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
	    }
	}


