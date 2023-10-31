package GUI.view.Admin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BLL.EmployeeBLL;
import BLL.FoodBLL;
import BLL.UserBLL;
import DAL.FoodDAL;
import DTO.Employee;
import DTO.Food;
import DTO.User;

public class SuKienPannelDanhSachMon implements MouseListener{
	private PanelDatDoAn_DanhSachMon panelDanhSachMon;
	private static boolean checkThem = false;
	private static boolean checkSua = false;
	public SuKienPannelDanhSachMon(PanelDatDoAn_DanhSachMon panelDanhSachMon) {
		// TODO Auto-generated constructor stub
		this.panelDanhSachMon = panelDanhSachMon;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelDanhSachMon.tableCuaTui && SuKienPannelDanhSachMon.checkThem == false && SuKienPannelDanhSachMon.checkSua == false)
		{
			int row = this.panelDanhSachMon.tableCuaTui.rowAtPoint(e.getPoint());
			ArrayList<String> thongTinDoAn = FoodBLL.getInstance().getOneFoodInfo((String) this.panelDanhSachMon.tableCuaTui.getValueAt(row, 1));
			this.panelDanhSachMon.jTextField_MaSanPham.setText(thongTinDoAn.get(0));
			this.panelDanhSachMon.jTextField_TenSanPham.setText(thongTinDoAn.get(1));
			this.panelDanhSachMon.LoaiSanPham.setSelectedIndex(Integer.parseInt(thongTinDoAn.get(2)));
			this.panelDanhSachMon.jTextField_DonGia.setText(thongTinDoAn.get(3));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelDanhSachMon.nutpanelSua && this.panelDanhSachMon.tableCuaTui.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(null, "Chưa chọn món để sửa !!!");
			return;
		}
		if(e.getSource() == this.panelDanhSachMon.nutpanelXoaMon && this.panelDanhSachMon.tableCuaTui.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(null, "Chưa chọn món để xóa !!!");
			return;
		}
		if(e.getSource() == this.panelDanhSachMon.nutpanelXoaMon && this.panelDanhSachMon.tableCuaTui.getSelectedRow() != -1)
		{
			//Xoa
			int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa món ăn này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION) {
				int maMonAn = Integer.parseInt(this.panelDanhSachMon.jTextField_MaSanPham.getText());
				FoodBLL.getInstance().deleteFood(maMonAn);
				this.setTextFieldNull();
				this.panelDanhSachMon.tableCuaTui.clearSelection();
				this.panelDanhSachMon.model.renewData(FoodBLL.getInstance().getListFoodTable());
				this.panelDanhSachMon.tableCuaTui.setModel(this.panelDanhSachMon.model);
			}
			
		}
		if(e.getSource() == this.panelDanhSachMon.nutpanelThemMon)
		{
			this.setTextFieldNull();
			this.setEnableTextField();
			this.panelDanhSachMon.jTextField_MaSanPham.setText(Integer.toString(FoodDAL.getInstance().getIDMax()+1));
			SuKienPannelDanhSachMon.checkThem = true;
			
		}
		if(e.getSource() == this.panelDanhSachMon.nutpanelSua)
		{
			SuKienPannelDanhSachMon.checkSua = true;
			
			this.setEnableTextField();
		}
		if(e.getSource() == this.panelDanhSachMon.nutpanelXacNhan)
		{
			if(SuKienPannelDanhSachMon.checkThem == true)
			{
				//SuKienThem
				if(checkThongTinChucNang() == false)
					JOptionPane.showMessageDialog(null,"Thông tin nhập bị lỗi hãy xem lại!!!");
				else
				{
					//Ham Them
					int MaDoAn = Integer.parseInt(this.panelDanhSachMon.jTextField_MaSanPham.getText());
					String TenDoAn = this.panelDanhSachMon.jTextField_TenSanPham.getText();
					Float Gia = Float.parseFloat(this.panelDanhSachMon.jTextField_DonGia.getText());
					int MaLoaiDoAn = this.panelDanhSachMon.LoaiSanPham.getSelectedIndex();
					Food food = new Food(MaDoAn,TenDoAn,MaLoaiDoAn,Gia);
					FoodBLL.getInstance().addFood(food);
					JOptionPane.showMessageDialog(null, "Đã thêm thành công!");
					SuKienPannelDanhSachMon.checkThem = false;
					this.panelDanhSachMon.nutpanelHuyChon.setVisible(false);
					this.panelDanhSachMon.nutpanelXacNhan.setVisible(false);
					this.panelDanhSachMon.nutpanelThemMon.setVisible(true);
					this.panelDanhSachMon.nutpanelSua.setVisible(true);
					this.panelDanhSachMon.nutpanelXoaMon.setVisible(true);
					this.setTextFieldNull();
					this.setDisableTextField();
					this.panelDanhSachMon.model.renewData(FoodBLL.getInstance().getListFoodTable());
					this.panelDanhSachMon.tableCuaTui.setModel(this.panelDanhSachMon.model);
					this.panelDanhSachMon.tableCuaTui.clearSelection();
				
				}
			}
			
			if(SuKienPannelDanhSachMon.checkSua == true)
			{
				//SuKienSua
				if(checkThongTinChucNang() == false)
				{
					JOptionPane.showMessageDialog(null,"Thông tin nhập bị lỗi hãy xem lại!!!");
				}
				else
				{
					int MaDoAn = Integer.parseInt(this.panelDanhSachMon.jTextField_MaSanPham.getText());
					String TenDoAn = this.panelDanhSachMon.jTextField_TenSanPham.getText();
					Float Gia = Float.parseFloat(this.panelDanhSachMon.jTextField_DonGia.getText());
					int MaLoaiDoAn = this.panelDanhSachMon.LoaiSanPham.getSelectedIndex();
					Food food = new Food(MaDoAn,TenDoAn,MaLoaiDoAn,Gia);
					FoodBLL.getInstance().updateFood(food);
					JOptionPane.showMessageDialog(null, "Đã sửa thành công!");
					SuKienPannelDanhSachMon.checkSua = false;
					this.panelDanhSachMon.nutpanelHuyChon.setVisible(false);
					this.panelDanhSachMon.nutpanelXacNhan.setVisible(false);
					this.panelDanhSachMon.nutpanelThemMon.setVisible(true); 
					this.panelDanhSachMon.nutpanelSua.setVisible(true);
					this.panelDanhSachMon.nutpanelXoaMon.setVisible(true);
					this.setTextFieldNull();
					this.setDisableTextField();
					this.panelDanhSachMon.model.renewData(FoodBLL.getInstance().getListFoodTable());
					this.panelDanhSachMon.tableCuaTui.setModel(this.panelDanhSachMon.model);
					this.panelDanhSachMon.tableCuaTui.clearSelection();	
				}
			}
		}
		if(e.getSource() == this.panelDanhSachMon.nutpanelThemMon || e.getSource() == this.panelDanhSachMon.nutpanelSua)
		{
			this.panelDanhSachMon.nutpanelHuyChon.setVisible(true);
			this.panelDanhSachMon.nutpanelXacNhan.setVisible(true);
			this.panelDanhSachMon.nutpanelThemMon.setVisible(false);
			this.panelDanhSachMon.nutpanelSua.setVisible(false);
			this.panelDanhSachMon.nutpanelXoaMon.setVisible(false);
		}
		if(e.getSource() == this.panelDanhSachMon.nutpanelHuyChon)
		{
			this.panelDanhSachMon.nutpanelHuyChon.setVisible(false);
			this.panelDanhSachMon.nutpanelXacNhan.setVisible(false);
			this.panelDanhSachMon.nutpanelThemMon.setVisible(true);
			this.panelDanhSachMon.nutpanelSua.setVisible(true);
			this.panelDanhSachMon.nutpanelXoaMon.setVisible(true);
			this.setTextFieldNull();
			this.setDisableTextField();
			this.panelDanhSachMon.tableCuaTui.clearSelection();
			SuKienPannelDanhSachMon.checkSua = false;
			SuKienPannelDanhSachMon.checkThem = false;
		}
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
	public void setTextFieldNull()
	{
		this.panelDanhSachMon.jTextField_MaSanPham.setText("");
		this.panelDanhSachMon.jTextField_TenSanPham.setText("");
		this.panelDanhSachMon.jTextField_DonGia.setText("");
		this.panelDanhSachMon.LoaiSanPham.setSelectedIndex(0);
	}
	
	public void setEnableTextField()
	{
		this.panelDanhSachMon.jTextField_TenSanPham.setEnabled(true);
		this.panelDanhSachMon.jTextField_DonGia.setEnabled(true);
		this.panelDanhSachMon.LoaiSanPham.setEnabled(true);
	}
	
	public void setDisableTextField()
	{
		this.panelDanhSachMon.jTextField_TenSanPham.setEnabled(false);
		this.panelDanhSachMon.jTextField_DonGia.setEnabled(false);
		this.panelDanhSachMon.LoaiSanPham.setEnabled(false);
	}
	
	public boolean isNumber(String str)
	{
	    if (str == null) {
	        return false;
	    }
	    try {
	        @SuppressWarnings("unused")
			int d = Integer.parseInt(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public boolean containsNumber(String s) {
	    boolean containsNumber = false;
	    for (int i = 0; i < s.length(); i++) {
	        if (Character.isDigit(s.charAt(i))) {
	            containsNumber = true;
	            break;
	        }
	    }
	    return containsNumber;
	}
	
	public boolean checkThongTinChucNang()
	{
		if(this.panelDanhSachMon.LoaiSanPham.getSelectedIndex() == 0 || this.panelDanhSachMon.LoaiSanPham.getSelectedIndex() == -1)
			return false;
		
		if(this.containsNumber(this.panelDanhSachMon.jTextField_TenSanPham.getText()) == true)
			return false;
		
		if(this.isNumber(this.panelDanhSachMon.jTextField_DonGia.getText()) == false)
			return false;
		
		if(this.panelDanhSachMon.jTextField_TenSanPham.equals("") && this.panelDanhSachMon.jTextField_TenSanPham == null)
			return false;
		
		if(this.panelDanhSachMon.jTextField_DonGia.equals("") ||this.panelDanhSachMon.jTextField_DonGia == null)
			return false;
		return true;
	}
}
