package GUI.view.NhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import BLL.BillBLL;
import BLL.BillInforBLL;
import BLL.FoodBLL;
import BLL.FoodCategoryBLL;
import BLL.MenuBLL;
import BLL.UserBLL;
import DTO.Food;
import DTO.FoodCategory;
import DTO.Menu;
import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;


@SuppressWarnings("serial")
public class PanelDatDoAn_DatMon_NV extends JPanel {

	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public TableCuaTui tableCuaTui;
	public JPanel panelDau;
	public MenuName menuName;
	public DefaultTableModel model;
	public JTextField jTextField_TenKhachHang;
	public JTextField jTextField_SoDienThoaiKhachHang;
	public JSpinner GiamGia;
	public JTextField jTextField_TongTien;
	public JSpinner SoLuong;
	@SuppressWarnings("rawtypes")
	public JComboBox jComboBox_DanhMuc;
	@SuppressWarnings("rawtypes")
	public JComboBox jComboBox_ChonMon;
	public JPanel nutpanelThemMon;
	public JLabel lblThemMon;
	public JPanel nutpanelThanhToan;
	public JLabel lblThanhToan;
	
	
	public PanelDatDoAn_DatMon_NV() {

		caiDatPanelDatDoAn_DatMon_NV();

		tableCuaTui.fixTable(jScrollPaneTable);

		setCustomScrollBar();
		SelectedIndexCategoryID();

		btn_order_Click();
		 btn_ThanhToan() ;

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void caiDatPanelDatDoAn_DatMon_NV() {

		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 940, 579);
		this.setLayout(null);
		this.setOpaque(true);

		JLabel lblTieuDe = new JLabel("ĐẶT MÓN");
		lblTieuDe.setForeground(new Color(255, 255, 255));
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe.setBounds(237, 10, 478, 31);

		JPanel panelTieuDe = new JPanel();
		panelTieuDe.setLayout(null);
		panelTieuDe.setBackground(new Color(47, 79, 79));
		panelTieuDe.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTieuDe.setBounds(0, 0, 936, 51);
		panelTieuDe.add(lblTieuDe);

		tableCuaTui = new TableCuaTui();
		tableCuaTui.setFont(new Font("Arial", Font.PLAIN, 14));
		model = new DefaultTableModel();
		this.model.addColumn("STT");
		this.model.addColumn("Tên món");
		this.model.addColumn("Số lượng");
		this.model.addColumn("Đơn giá");
		this.model.addColumn("Thành tiền");

//			this.addComponentListener(new SuKienPannelThongTin_LopHocPhan(this));
		tableCuaTui.setModel(model);
		tableCuaTui.getTableHeader().setReorderingAllowed(false);

//			tableCuaTui.addMouseListener(new SuKienPannelThongTin_LopHocPhan(this));

		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 170, 916, 324);
		jScrollPaneTable.setViewportView(tableCuaTui);

		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(true); // để không che khuất thằng phía sau
		jPanelBody.add(panelTieuDe);
		jPanelBody.add(jScrollPaneTable);

		jScrollPane_Body = new JScrollPane();
		jScrollPane_Body.setBounds(0, 0, 940, 579);
		jScrollPane_Body.setViewportView(jPanelBody);

		JLabel lblChiTietHoaDon = new JLabel("Chi Tiết Hóa Đơn");
		lblChiTietHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietHoaDon.setFont(new Font("Arial", Font.BOLD, 16));
		lblChiTietHoaDon.setBounds(369, 143, 184, 28);
		jPanelBody.add(lblChiTietHoaDon);

		JLabel lblDanhMuc = new JLabel("Danh mục:");
		lblDanhMuc.setHorizontalAlignment(SwingConstants.LEFT);
		lblDanhMuc.setFont(new Font("Arial", Font.BOLD, 15));
		lblDanhMuc.setBounds(359, 72, 99, 24);
		jPanelBody.add(lblDanhMuc);

		JLabel lblChonMon = new JLabel("Chọn món:");
		lblChonMon.setHorizontalAlignment(SwingConstants.LEFT);
		lblChonMon.setFont(new Font("Arial", Font.BOLD, 15));
		lblChonMon.setBounds(359, 109, 99, 24);
		jPanelBody.add(lblChonMon);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoLuong.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoLuong.setBounds(665, 76, 99, 24);
		jPanelBody.add(lblSoLuong);

		JLabel lblGiamGia = new JLabel("Giảm Giá ( % )");
		lblGiamGia.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiamGia.setFont(new Font("Arial", Font.BOLD, 15));
		lblGiamGia.setBounds(81, 504, 150, 24);
		jPanelBody.add(lblGiamGia);

		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTien.setFont(new Font("Arial", Font.BOLD, 15));
		lblTongTien.setBounds(312, 504, 236, 24);
		jPanelBody.add(lblTongTien);

		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblTenKhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenKhachHang.setBounds(10, 72, 138, 24);
		jPanelBody.add(lblTenKhachHang);

		JLabel lblSoDienThoaiKhachHang = new JLabel("Số điện thoại:");
		lblSoDienThoaiKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoDienThoaiKhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		lblSoDienThoaiKhachHang.setBounds(10, 109, 138, 24);
		jPanelBody.add(lblSoDienThoaiKhachHang);

		jTextField_TenKhachHang = new JTextField();
		jTextField_TenKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		jTextField_TenKhachHang.setBounds(152, 72, 184, 24);
		jPanelBody.add(jTextField_TenKhachHang);

		jTextField_SoDienThoaiKhachHang = new JTextField();
		jTextField_SoDienThoaiKhachHang.setFont(new Font("Arial", Font.PLAIN, 14));
		jTextField_SoDienThoaiKhachHang.setBounds(152, 109, 183, 24);
		jPanelBody.add(jTextField_SoDienThoaiKhachHang);

		jComboBox_DanhMuc = new JComboBox();
		jComboBox_DanhMuc.setFont(new Font("Arial", Font.PLAIN, 14));
		jComboBox_DanhMuc.setBounds(468, 72, 184, 24);
		jPanelBody.add(jComboBox_DanhMuc);

		jComboBox_ChonMon = new JComboBox();
		jComboBox_ChonMon.setFont(new Font("Arial", Font.PLAIN, 14));
		jComboBox_ChonMon.setBounds(468, 109, 183, 24);
		jPanelBody.add(jComboBox_ChonMon);
		
		JPanel panel_SoLuong = new JPanel();
        panel_SoLuong.setBounds(675, 103, 79, 24);
		SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 10, 1);
		SoLuong = new JSpinner(spinnerModel);
		JFormattedTextField field = ((JSpinner.NumberEditor) SoLuong.getEditor()).getTextField();
		NumberFormatter formatter = (NumberFormatter) field.getFormatter();
		formatter.setAllowsInvalid(false);
		formatter.setMinimum(1);
		formatter.setMaximum(10);
		SoLuong.setFont(new Font("Arial", Font.PLAIN, 14));
		SoLuong.setBounds(10, 0, 56, 24);
		panel_SoLuong.setLayout(null);
        
        panel_SoLuong.add(SoLuong);
		
		jPanelBody.add(panel_SoLuong);
		
		
		JPanel panel_GiamGia = new JPanel();
        panel_GiamGia.setBounds(118, 528, 79, 24);
		SpinnerModel spinnerModel2 = new SpinnerNumberModel(0, 0, 100, 1);
		GiamGia = new JSpinner(spinnerModel2);
		JFormattedTextField field2 = ((JSpinner.NumberEditor) GiamGia.getEditor()).getTextField();
		NumberFormatter formatter2 = (NumberFormatter) field2.getFormatter();
		formatter2.setAllowsInvalid(false);
		formatter2.setMinimum(0);
		formatter2.setMaximum(100);
		GiamGia.setFont(new Font("Arial", Font.PLAIN, 14));
		GiamGia.setBounds(10, 0, 56, 24);
		panel_GiamGia.setLayout(null);
	    panel_GiamGia.add(GiamGia);
		
		jPanelBody.add(panel_GiamGia);

		jTextField_TongTien = new JTextField();
		jTextField_TongTien.setFont(new Font("Arial", Font.PLAIN, 14));
		jTextField_TongTien.setBounds(312, 528, 236, 24);
		jPanelBody.add(jTextField_TongTien);

		nutpanelThemMon = new JPanel();
		nutpanelThemMon.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelThemMon.addMouseListener(new PanelButtonMouseAdapter(nutpanelThemMon));
//			nutpanelThemMon.addMouseListener(new SuKienPannelDatDoAn_DatMon(this));
		nutpanelThemMon.setBackground(new Color(47, 79, 79));
		nutpanelThemMon.setBounds(774, 72, 152, 61);
		nutpanelThemMon.setLayout(null);

		lblThemMon = new JLabel("Thêm Món");
		lblThemMon.setForeground(new Color(255, 255, 255));
		lblThemMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblThemMon.setFont(new Font("Arial", Font.BOLD, 16));
		lblThemMon.setBounds(10, 10, 132, 41);
		nutpanelThemMon.add(lblThemMon);
		jPanelBody.add(nutpanelThemMon);

		nutpanelThanhToan = new JPanel();
		nutpanelThanhToan.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelThanhToan.addMouseListener(new PanelButtonMouseAdapter(nutpanelThanhToan));
		nutpanelThanhToan.setBackground(new Color(47, 79, 79));
		nutpanelThanhToan.setBounds(629, 504, 224, 61);
		nutpanelThanhToan.setLayout(null);

		lblThanhToan = new JLabel("Thanh Toán");
		lblThanhToan.setForeground(new Color(255, 255, 255));
		lblThanhToan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanhToan.setFont(new Font("Arial", Font.BOLD, 16));
		lblThanhToan.setBounds(10, 10, 204, 41);
		nutpanelThanhToan.add(lblThanhToan);
		jPanelBody.add(nutpanelThanhToan);

		ArrayList<FoodCategory> listFoodCategory = FoodCategoryBLL.getInstance().listFoodCategory();
		for (int i = 0; i < listFoodCategory.size(); i++) {
			jComboBox_DanhMuc.addItem(listFoodCategory.get(i));
		}
		this.add(jScrollPane_Body);
	}
	private void btn_ThanhToan() {
		nutpanelThanhToan.addMouseListener(new MouseListener() {
			
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
				int discount = (int)GiamGia.getValue();
				double totalPrice = Double.parseDouble(jTextField_TongTien.getText());
				double finalTotalPrice = totalPrice - (totalPrice / 100) * discount;
				int option = JOptionPane.showConfirmDialog(null, String.format("Bạn có chắc thanh toán cho đơn hàng với: \nTổng tiền - (Tổng tiền / 100) x Giảm giá\n=> %.2f - %.2f/100 x %d = %.2f", totalPrice, totalPrice, discount, finalTotalPrice));
				if(option == JOptionPane.YES_OPTION) {
					jTextField_TongTien.setText("");
					model.setRowCount(0);
					
					BillBLL.getInstance().updateDiscountandTotalPrice(discount, totalPrice, finalTotalPrice, BillBLL.getInstance().getIDMenu()+1);
					BillBLL.getInstance().updateStatusBill();
					
//					BillInforBLL.getInstance().deleteBillInfo();
//					BillBLL.getInstance().deleteBill();
				}
				
			}
		});
	}
	
	private void showMenu() {
		float tongTien = 0;
		ArrayList<Menu> lstMenu = MenuBLL.getInstance().getListMenu();
		model.setNumRows(0);
		for (int i = 0; i < lstMenu.size(); i++) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(i + 1);
			vec.add(lstMenu.get(i).getFoodName());
			vec.add(lstMenu.get(i).getCount());
			vec.add(lstMenu.get(i).getPrice());
			vec.add(lstMenu.get(i).getTotalPrice());
			tongTien += lstMenu.get(i).getTotalPrice();
			model.addRow(vec);
		}
		tableCuaTui.setModel(model);
		this.jTextField_TongTien.setText(tongTien + "");
	}

	private void btn_order_Click() {
		nutpanelThemMon.addMouseListener(new MouseListener() {

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
				int idUser = UserBLL.getInstance().getIdUser(ManHinhChinh_NV.taiKhoanNhanVien, ManHinhChinh_NV.matKhauNhanVien).getId();;
				int idFood = 0;
				Food selectedFood = (Food) jComboBox_ChonMon.getSelectedItem();
				idFood = selectedFood.getiD();
				int count = (int) SoLuong.getValue();
				BillBLL.getInstance().insertBill(idUser);
				BillInforBLL.getInstance().InsertBillInfor(BillBLL.getInstance().getMaxId(), idFood, count);
				showMenu();
			}

		});

	}

	@SuppressWarnings({ "unused", "unchecked" })
	private void loadFoodByIDFoodCategory(int id) {
		jComboBox_ChonMon.removeAllItems();
		ArrayList<Food> listFood = FoodBLL.getInstance().getListFoodByCateGoryID(id);
		for (int i = 0; i < listFood.size(); i++) {
			jComboBox_ChonMon.addItem(listFood.get(i));
		}
	}

	@SuppressWarnings("unused")
	private void SelectedIndexCategoryID() {
		jComboBox_DanhMuc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int id = 0;
				if (jComboBox_DanhMuc.getSelectedItem() == null) {
					return;
				}
				FoodCategory selectedCategory = (FoodCategory) jComboBox_DanhMuc.getSelectedItem();
				id = selectedCategory.getiDFoodCategory();
				loadFoodByIDFoodCategory(id);
			}
		});
	}

	private void setCustomScrollBar() {
		jScrollPane_Body.setViewportBorder(null);
		jScrollPane_Body.getViewport().setOpaque(false);
		jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
		jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
	}
}
