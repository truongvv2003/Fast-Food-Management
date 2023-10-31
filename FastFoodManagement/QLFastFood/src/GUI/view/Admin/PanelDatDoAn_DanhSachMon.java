package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import BLL.FoodBLL;
import BLL.FoodCategoryBLL;
import DTO.FoodCategory;
import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;



@SuppressWarnings("serial")
public class PanelDatDoAn_DanhSachMon extends JPanel {

		public JScrollPane jScrollPane_Body;
		public JPanel jPanelBody;
		public JScrollPane jScrollPaneTable;
		public TableCuaTui tableCuaTui;
		public JPanel panelDau;
		public MenuName menuName;
		public JTextField jTextField_MaSanPham;
		public JTextField jTextField_TenSanPham;
		public JTextField jTextField_DonGia;
		public MyModel model;
		//private JTextField jTextField_LoaiSanPham;
		public JComboBox<String> LoaiSanPham;
		public JPanel nutpanelThemMon;
		private JLabel lblThemMon;
		public JPanel nutpanelXoaMon;
		private JLabel lblXoaMon;
		public JPanel nutpanelSua;
		private JLabel lblSua;
		public JPanel nutpanelXacNhan;
		private JLabel lblXacNhan;
		public JPanel nutpanelHuyChon;
		private JLabel lblHuyChon;
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
	        		return "Mã Món Ăn";
	        	case 2:
	    			return "Tên Món Ăn";
	        	case 3:
	        		return "Loại Thức Ăn";
	        	case 4:
	        		return "Đơn Giá";
	        	}
				return "";
	        }
	        @Override
	        public int getColumnCount() {
	            return 5;
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
		public PanelDatDoAn_DanhSachMon() {


			caiDatPanelThongTin();
			
			tableCuaTui.fixTable(jScrollPaneTable);

	        setCustomScrollBar();

			
		}

		private void caiDatPanelThongTin() {

			
			this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			this.setBounds(0, 0, 940, 579);
			this.setLayout(null);
	        this.setOpaque(false);
	        
	        JLabel lblTieuDe = new JLabel("DANH SÁCH MÓN");
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
			model = new MyModel(FoodBLL.getInstance().getListFoodTable());
			tableCuaTui.setModel(model);
			tableCuaTui.getTableHeader().setReorderingAllowed(false);
			
			tableCuaTui.addMouseListener(new SuKienPannelDanhSachMon(this));
			
			
			jScrollPaneTable = new JScrollPane();
			jScrollPaneTable.setBounds(10, 157, 916, 334);
			jScrollPaneTable.setViewportView(tableCuaTui);
			
			
			
			jPanelBody = new JPanel();
			jPanelBody.setLayout(null);
			jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
	        jPanelBody.add(panelTieuDe);  
			jPanelBody.add(jScrollPaneTable);
			
			jScrollPane_Body = new JScrollPane();
			jScrollPane_Body.setBounds(0, 0, 940, 579);
			jScrollPane_Body.setViewportView(jPanelBody);
			
			
			
			JLabel lblMaSanPham = new JLabel("Mã sản phẩm:");
			lblMaSanPham.setHorizontalAlignment(SwingConstants.LEFT);
			lblMaSanPham.setFont(new Font("Arial", Font.BOLD, 16));
			lblMaSanPham.setBounds(11, 69, 135, 28);
			jPanelBody.add(lblMaSanPham);
			
			JLabel lblDonGia = new JLabel("Đơn giá:");
			lblDonGia.setHorizontalAlignment(SwingConstants.LEFT);
			lblDonGia.setFont(new Font("Arial", Font.BOLD, 16));
			lblDonGia.setBounds(457, 69, 135, 28);
			jPanelBody.add(lblDonGia);
			
			JLabel lblTenSanPham = new JLabel("Tên sản phẩm:");
			lblTenSanPham.setHorizontalAlignment(SwingConstants.LEFT);
			lblTenSanPham.setFont(new Font("Arial", Font.BOLD, 16));
			lblTenSanPham.setBounds(11, 110, 135, 28);
			jPanelBody.add(lblTenSanPham);
			
			JLabel lblLoaiSanPham = new JLabel("Loại sản phẩm:");
			lblLoaiSanPham.setHorizontalAlignment(SwingConstants.LEFT);
			lblLoaiSanPham.setFont(new Font("Arial", Font.BOLD, 16));
			lblLoaiSanPham.setBounds(457, 110, 135, 28);
			jPanelBody.add(lblLoaiSanPham);
			
		
	        jTextField_MaSanPham = new JTextField();
	        jTextField_MaSanPham.setFont(new Font("Arial", Font.PLAIN, 14));
	        jTextField_MaSanPham.setBounds(157, 71, 229, 28);
	        jTextField_MaSanPham.setEnabled(false);
	        jPanelBody.add(jTextField_MaSanPham);
	        
	        jTextField_TenSanPham = new JTextField();
	        jTextField_TenSanPham.setFont(new Font("Arial", Font.PLAIN, 14));
	        jTextField_TenSanPham.setBounds(157, 112, 229, 28);
	        jTextField_TenSanPham.setEnabled(false);
	        jPanelBody.add(jTextField_TenSanPham);

	        jTextField_DonGia = new JTextField();
	        jTextField_DonGia.setFont(new Font("Arial", Font.PLAIN, 14));
	        jTextField_DonGia.setBounds(603, 71, 229, 28);
	        jTextField_DonGia.setEnabled(false);
	        jPanelBody.add(jTextField_DonGia);
	        
	        LoaiSanPham = new JComboBox<String>();
	        LoaiSanPham.addItem("");
	        ArrayList<String> dataCategory = FoodCategoryBLL.getInstance().listNameOfCategory();
	        for(int i = 0 ; i < dataCategory.size(); i++)
	        {
	        	LoaiSanPham.addItem(dataCategory.get(i));
	        }
	        LoaiSanPham.setFont(new Font("Arial", Font.PLAIN, 14));
	        LoaiSanPham.setBounds(603, 112, 229, 28);
	        LoaiSanPham.setEnabled(false);
	        jPanelBody.add(LoaiSanPham);

			nutpanelXacNhan = new JPanel();
			nutpanelXacNhan.setLayout(null);
			nutpanelXacNhan.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelXacNhan.addMouseListener(new PanelButtonMouseAdapter(nutpanelXacNhan));
			nutpanelXacNhan.setBackground(new Color(47, 79, 79));
			nutpanelXacNhan.setBounds(863, 70, 68, 26);
			jPanelBody.add(nutpanelXacNhan);
			
			lblXacNhan = new JLabel("Xác nhận");
			lblXacNhan.setHorizontalAlignment(SwingConstants.CENTER);
			lblXacNhan.setForeground(Color.WHITE);
			lblXacNhan.setFont(new Font("Arial", Font.BOLD, 12));
			lblXacNhan.setBounds(0, 0, 68, 26);
			nutpanelXacNhan.add(lblXacNhan);
			nutpanelXacNhan.addMouseListener(new SuKienPannelDanhSachMon(this));
			nutpanelXacNhan.setVisible(false);
			
			nutpanelHuyChon = new JPanel();
			nutpanelHuyChon.setLayout(null);
			nutpanelHuyChon.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelHuyChon.addMouseListener(new PanelButtonMouseAdapter(nutpanelHuyChon));
			nutpanelHuyChon.setBackground(new Color(47, 79, 79));
			nutpanelHuyChon.setBounds(863, 110, 68, 26);
			jPanelBody.add(nutpanelHuyChon);
			
			lblHuyChon = new JLabel("Hủy");
			lblHuyChon.setHorizontalAlignment(SwingConstants.CENTER);
			lblHuyChon.setForeground(Color.WHITE);
			lblHuyChon.setFont(new Font("Arial", Font.BOLD, 12));
			lblHuyChon.setBounds(0, 0, 68, 26);
			nutpanelHuyChon.add(lblHuyChon);
			nutpanelHuyChon.addMouseListener(new SuKienPannelDanhSachMon(this));
			nutpanelHuyChon.setVisible(false);
	        
			nutpanelThemMon = new JPanel();
			nutpanelThemMon.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelThemMon.addMouseListener(new PanelButtonMouseAdapter(nutpanelThemMon));
			nutpanelThemMon.addMouseListener(new SuKienPannelDanhSachMon(this));;
			nutpanelThemMon.setBackground(new Color(47, 79, 79));
			nutpanelThemMon.setBounds(89, 501, 193, 46);
			nutpanelThemMon.setLayout(null);
			
			lblThemMon = new JLabel("Thêm");
			lblThemMon.setForeground(new Color(255, 255, 255));
			lblThemMon.setHorizontalAlignment(SwingConstants.CENTER);
			lblThemMon.setFont(new Font("Arial", Font.BOLD, 16));
			lblThemMon.setBounds(10, 10, 177, 26);
			nutpanelThemMon.add(lblThemMon);
	        jPanelBody.add(nutpanelThemMon);
	        
			nutpanelXoaMon = new JPanel();
			nutpanelXoaMon.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelXoaMon.addMouseListener(new PanelButtonMouseAdapter(nutpanelXoaMon));
			nutpanelXoaMon.addMouseListener(new SuKienPannelDanhSachMon(this));
			nutpanelXoaMon.setBackground(new Color(47, 79, 79));
			nutpanelXoaMon.setBounds(653, 501, 193, 46);
			nutpanelXoaMon.setLayout(null);
			
			lblXoaMon = new JLabel("Xóa");
			lblXoaMon.setForeground(new Color(255, 255, 255));
			lblXoaMon.setHorizontalAlignment(SwingConstants.CENTER);
			lblXoaMon.setFont(new Font("Arial", Font.BOLD, 16));
			lblXoaMon.setBounds(10, 10, 177, 26);
			nutpanelXoaMon.add(lblXoaMon);
	        jPanelBody.add(nutpanelXoaMon);
	        
			nutpanelSua = new JPanel();
			nutpanelSua.setBorder(new LineBorder(new Color(0, 0, 0)));
			nutpanelSua.addMouseListener(new PanelButtonMouseAdapter(nutpanelSua));
			nutpanelSua.addMouseListener(new SuKienPannelDanhSachMon(this));
			nutpanelSua.setBackground(new Color(47, 79, 79));
			nutpanelSua.setBounds(371, 501, 193, 46);
			nutpanelSua.setLayout(null);
			
			lblSua = new JLabel("Sửa");
			lblSua.setForeground(new Color(255, 255, 255));
			lblSua.setHorizontalAlignment(SwingConstants.CENTER);
			lblSua.setFont(new Font("Arial", Font.BOLD, 16));
			lblSua.setBounds(10, 10, 177, 26);
			nutpanelSua.add(lblSua);
	        jPanelBody.add(nutpanelSua);
			this.add(jScrollPane_Body);
			this.setVisible(false);
					
		}
		

		private void setCustomScrollBar() {
	    	jScrollPane_Body.setViewportBorder(null);
	    	jScrollPane_Body.getViewport().setOpaque(false);
	    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
	    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
	    }
	}


