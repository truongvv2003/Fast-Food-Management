package GUI.view.Admin;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BLL.EmployeeBLL;
import BLL.FoodBLL;
import BLL.UserBLL;
import DTO.Employee;
import DTO.User;
import GUI.view.Admin.PanelAdmin.MyModel;

public class SuKienPanelAdmin implements MouseListener {
	
	private PanelAdmin panelAdmin;
	private static boolean checkThem = false;
	private static boolean checkSua = false;
	
	public SuKienPanelAdmin(PanelAdmin panelAdmin) {
		this.panelAdmin = panelAdmin;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelAdmin.tableCuaTui && SuKienPanelAdmin.checkSua == false && SuKienPanelAdmin.checkThem == false)
		{
	        int row = this.panelAdmin.tableCuaTui.rowAtPoint(e.getPoint()); // lấy chỉ số dòng của ô được chọn
	        ArrayList<String> thongTinNhanVien = EmployeeBLL.getInstance().getThongTienMotNhanVien((String) this.panelAdmin.tableCuaTui.getValueAt(row, 1));
	        this.panelAdmin.textField_MaNhanVien.setText(thongTinNhanVien.get(0));
	        this.panelAdmin.jTextField_HoVaTen.setText(thongTinNhanVien.get(1));
	        this.panelAdmin.textField_SoDienThoai.setText(thongTinNhanVien.get(2));
	        this.panelAdmin.GioiTinh.setSelectedIndex(Integer.parseInt(thongTinNhanVien.get(3)));
	        this.panelAdmin.jTextField_NgaySinh.setText(thongTinNhanVien.get(4));
	        this.panelAdmin.textField_TaiKhoan.setText(thongTinNhanVien.get(5));
	        this.panelAdmin.textField_MatKhau.setText(thongTinNhanVien.get(6));
	        this.panelAdmin.ChucVu.setSelectedIndex(Integer.parseInt(thongTinNhanVien.get(7)));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.panelAdmin.nutpanelSua && this.panelAdmin.tableCuaTui.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên để sửa !!!");
			return;
		}
		if(e.getSource() == this.panelAdmin.nutpanelXoa && this.panelAdmin.tableCuaTui.getSelectedRow() == -1)
		{
			JOptionPane.showMessageDialog(null, "Chưa chọn nhân viên để xóa !!!");
			return;
		}
		if(e.getSource() == this.panelAdmin.nutpanelXoa && this.panelAdmin.tableCuaTui.getSelectedRow() != -1)
		{
			//Xoa
			if(ManHinhChinh.taiKhoanAdmin.equals(this.panelAdmin.textField_TaiKhoan.getText()))
			{
				JOptionPane.showMessageDialog(null,"Không thể xóa tài khoản của chính mình!!!");
				return;
			}
			else {
				int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tài khoản này này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					String MaNhanVien = this.panelAdmin.textField_MaNhanVien.getText();
					UserBLL.getInstance().deleteUser(MaNhanVien);
					EmployeeBLL.getInstance().deleteEmployee(MaNhanVien);
					this.setTextFieldNull();
					this.panelAdmin.tableCuaTui.clearSelection();
					this.panelAdmin.model.renewData(EmployeeBLL.getInstance().getListThongTinNhanVien());
					this.panelAdmin.tableCuaTui.setModel(this.panelAdmin.model);
				}
			}
		}
		if(e.getSource() == this.panelAdmin.nutpanelThem)
		{
			this.setTextFieldNull();
			this.setEnableTextFieldThem();
			this.panelAdmin.textField_MaNhanVien.setText(Integer.toString(EmployeeBLL.getInstance().getIDMax()+1));
			//SuKienThem;
			SuKienPanelAdmin.checkThem = true;
			
		}
		if(e.getSource() == this.panelAdmin.nutpanelSua)
		{
			SuKienPanelAdmin.checkSua = true;
			
			this.setEnableTextFieldSua();
		}
		if(e.getSource() == this.panelAdmin.nutpanelXacNhan)
		{
			if(SuKienPanelAdmin.checkThem == true)
			{
				//SuKienThem
				if(checkThongTinChucNangThem() == false)
					JOptionPane.showMessageDialog(null,"Thông tin nhập bị lỗi hãy xem lại!!!");
				else
				{
					//Ham Them
					int MaNhanVien = Integer.parseInt(this.panelAdmin.textField_MaNhanVien.getText());
					String HoVaTen = this.panelAdmin.jTextField_HoVaTen.getText();
					String SoDienThoai = this.panelAdmin.textField_SoDienThoai.getText();
					String NgaySinh = this.panelAdmin.jTextField_NgaySinh.getText();
					String ChucVu = (String)this.panelAdmin.ChucVu.getSelectedItem();
					String GioiTinh = (String)this.panelAdmin.GioiTinh.getSelectedItem();
					String TaiKhoan = this.panelAdmin.textField_TaiKhoan.getText();
					String MatKhau = this.panelAdmin.textField_MatKhau.getText();
					DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDate DayofBirth = LocalDate.parse(NgaySinh, inputFormatter);
					String formattedDate = DayofBirth.format(outputFormatter);
					DayofBirth = LocalDate.parse(formattedDate,outputFormatter);
					Boolean Sex,Authority;
					if(GioiTinh.equals("Nam") == true)
						Sex = true;
					else Sex = false;
					if(ChucVu.equals("Nhân viên") == true)
						Authority = true;
					else Authority = false;
					Employee temp1 = new Employee(MaNhanVien, HoVaTen,SoDienThoai, DayofBirth, Sex);
					User temp2 = new User(MaNhanVien,TaiKhoan,MatKhau,Authority);
					EmployeeBLL.getInstance().addEmployee(temp1);
					UserBLL.getInstance().addUser(temp2);
					JOptionPane.showMessageDialog(null, "Đã thêm thành công!");
					SuKienPanelAdmin.checkThem = false;
					this.panelAdmin.nutpanelHuyChon.setVisible(false);
					this.panelAdmin.nutpanelXacNhan.setVisible(false);
					this.panelAdmin.nutpanelThem.setVisible(true);
					this.panelAdmin.nutpanelSua.setVisible(true);
					this.panelAdmin.nutpanelXoa.setVisible(true);
					this.setTextFieldNull();
					this.setDisableTextField();
					this.panelAdmin.model.renewData(EmployeeBLL.getInstance().getListThongTinNhanVien());
					this.panelAdmin.tableCuaTui.setModel(this.panelAdmin.model);
					this.panelAdmin.tableCuaTui.clearSelection();
				
				}
			}
			
			if(SuKienPanelAdmin.checkSua == true)
			{
				//SuKienSua
				if(checkThongTinChucNangSua() == false)
				{
					JOptionPane.showMessageDialog(null,"Thông tin nhập bị lỗi hãy xem lại!!!");
				}
				else
				{
					int MaNhanVien = Integer.parseInt(this.panelAdmin.textField_MaNhanVien.getText());
					String HoVaTen = this.panelAdmin.jTextField_HoVaTen.getText();
					String SoDienThoai = this.panelAdmin.textField_SoDienThoai.getText();
					String NgaySinh = this.panelAdmin.jTextField_NgaySinh.getText();
					String ChucVu = (String)this.panelAdmin.ChucVu.getSelectedItem();
					String GioiTinh = (String)this.panelAdmin.GioiTinh.getSelectedItem();
					String TaiKhoan = this.panelAdmin.textField_TaiKhoan.getText();
					String MatKhau = this.panelAdmin.textField_MatKhau.getText();
					DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDate DayofBirth = LocalDate.parse(NgaySinh, inputFormatter);
					String formattedDate = DayofBirth.format(outputFormatter);
					DayofBirth = LocalDate.parse(formattedDate,outputFormatter);
					Boolean Sex,Authority;
					if(GioiTinh.equals("Nam") == true)
						Sex = true;
					else Sex = false;
					if(ChucVu.equals("Nhân viên") == true)
						Authority = true;
					else Authority = false;
					//Update
					EmployeeBLL.getInstance().updateEmployee(new Employee(MaNhanVien, HoVaTen,SoDienThoai, DayofBirth, Sex));
					UserBLL.getInstance().updateUser(new User(MaNhanVien,TaiKhoan,MatKhau,Authority));
					JOptionPane.showMessageDialog(null, "Đã sửa thành công!");
					SuKienPanelAdmin.checkSua = false;
					this.panelAdmin.nutpanelHuyChon.setVisible(false);
					this.panelAdmin.nutpanelXacNhan.setVisible(false);
					this.panelAdmin.nutpanelThem.setVisible(true);
					this.panelAdmin.nutpanelSua.setVisible(true);
					this.panelAdmin.nutpanelXoa.setVisible(true);
					this.setTextFieldNull();
					this.setDisableTextField();
					this.panelAdmin.model.renewData(EmployeeBLL.getInstance().getListThongTinNhanVien());
					this.panelAdmin.tableCuaTui.setModel(this.panelAdmin.model);
					this.panelAdmin.tableCuaTui.clearSelection();	
				
				}
			}
		}
		if(e.getSource() == this.panelAdmin.nutpanelThem || e.getSource() == this.panelAdmin.nutpanelSua)
		{
			this.panelAdmin.nutpanelHuyChon.setVisible(true);
			this.panelAdmin.nutpanelXacNhan.setVisible(true);
			this.panelAdmin.nutpanelThem.setVisible(false);
			this.panelAdmin.nutpanelSua.setVisible(false);
			this.panelAdmin.nutpanelXoa.setVisible(false);
		}
		if(e.getSource() == this.panelAdmin.nutpanelHuyChon)
		{
			this.panelAdmin.nutpanelHuyChon.setVisible(false);
			this.panelAdmin.nutpanelXacNhan.setVisible(false);
			this.panelAdmin.nutpanelThem.setVisible(true);
			this.panelAdmin.nutpanelSua.setVisible(true);
			this.panelAdmin.nutpanelXoa.setVisible(true);
			this.setTextFieldNull();
			this.setDisableTextField();
			this.panelAdmin.tableCuaTui.clearSelection();
			SuKienPanelAdmin.checkSua = false;
			SuKienPanelAdmin.checkThem = false;
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
	
	void setTextFieldNull()
	{
		this.panelAdmin.GioiTinh.setSelectedIndex(2);
		this.panelAdmin.jTextField_HoVaTen.setText(null);
		this.panelAdmin.jTextField_NgaySinh.setText(null);
		this.panelAdmin.ChucVu.setSelectedIndex(2);
		this.panelAdmin.textField_SoDienThoai.setText(null);
		this.panelAdmin.textField_TaiKhoan.setText(null);
		this.panelAdmin.textField_MatKhau.setText(null);
		this.panelAdmin.textField_MaNhanVien.setText(null);
	}
	
	void setEnableTextFieldSua()
	{
		this.panelAdmin.GioiTinh.setEnabled(true);
		this.panelAdmin.jTextField_HoVaTen.setEnabled(true);
		this.panelAdmin.jTextField_NgaySinh.setEnabled(true);
		this.panelAdmin.textField_SoDienThoai.setEnabled(true);
		this.panelAdmin.textField_MatKhau.setEnabled(true);
	}
	
	void setEnableTextFieldThem()
	{
		this.panelAdmin.GioiTinh.setEnabled(true);
		this.panelAdmin.jTextField_HoVaTen.setEnabled(true);
		this.panelAdmin.jTextField_NgaySinh.setEnabled(true);
		this.panelAdmin.ChucVu.setEnabled(true);
		this.panelAdmin.textField_SoDienThoai.setEnabled(true);
		this.panelAdmin.textField_TaiKhoan.setEnabled(true);
		this.panelAdmin.textField_MatKhau.setEnabled(true);
	}
	
	void setDisableTextField()
	{
		this.panelAdmin.GioiTinh.setEnabled(false);
		this.panelAdmin.jTextField_HoVaTen.setEnabled(false);
		this.panelAdmin.jTextField_NgaySinh.setEnabled(false);
		this.panelAdmin.ChucVu.setEnabled(false);
		this.panelAdmin.textField_SoDienThoai.setEnabled(false);
		this.panelAdmin.textField_TaiKhoan.setEnabled(false);
		this.panelAdmin.textField_MatKhau.setEnabled(false);
		this.panelAdmin.textField_MaNhanVien.setEnabled(false);
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
	
	boolean checkThongTinChucNangThem()
	{
		//Lay gia tri trong text
		String HoVaTen = this.panelAdmin.jTextField_HoVaTen.getText();
		String SoDienThoai = this.panelAdmin.textField_SoDienThoai.getText();
		String NgaySinh = this.panelAdmin.jTextField_NgaySinh.getText();
		String ChucVu = (String)this.panelAdmin.ChucVu.getSelectedItem();
		String GioiTinh = (String)this.panelAdmin.GioiTinh.getSelectedItem();
		String TaiKhoan = this.panelAdmin.textField_TaiKhoan.getText();
		String MatKhau = this.panelAdmin.textField_MatKhau.getText();
		
		//check date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date testDate = null;
		try
		{
			testDate = sdf.parse(NgaySinh);
		}
		catch(ParseException e)
		{
			return false;
		}
		if(!sdf.format(testDate).equals(NgaySinh))
		{
			return false;
		}
		//check SDT
		if(SoDienThoai.length() != 10 || SoDienThoai.charAt(0) != '0' || isNumber(SoDienThoai) == false) 
			return false;
		
		//check HovaTen
		if(HoVaTen == null || HoVaTen.equals(""))
			return false;
		
		//check ChucVu
		if(ChucVu == null || ChucVu.equals(""))
			return false;
		
		//Check GioiTinh
		if(GioiTinh == null || GioiTinh.equals(""))
			return false;
		
		//Check TaiKhoan
		
		//Hamchecktaikhoan
		if(UserBLL.getInstance().checkTaiKhoanDaCo(TaiKhoan) == true)
			return false;
		//CheckMatKhau
		if(MatKhau == null || GioiTinh.equals(""))
			return false;
		return true;
	}
	
	boolean checkThongTinChucNangSua()
	{
		//Lay gia tri trong text
		String HoVaTen = this.panelAdmin.jTextField_HoVaTen.getText();
		String SoDienThoai = this.panelAdmin.textField_SoDienThoai.getText();
		String NgaySinh = this.panelAdmin.jTextField_NgaySinh.getText();
		String GioiTinh = (String)this.panelAdmin.GioiTinh.getSelectedItem();
		String MatKhau = this.panelAdmin.textField_MatKhau.getText();
		
		//check date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date testDate = null;
		try
		{
			testDate = sdf.parse(NgaySinh);
		}
		catch(ParseException e)
		{
			return false;
		}
		if(!sdf.format(testDate).equals(NgaySinh))
		{
			return false;
		}
		//check SDT
		if(SoDienThoai.length() != 10 || SoDienThoai.charAt(0) != '0' || isNumber(SoDienThoai) == false) 
			return false;
		
		//check HovaTen
		if(HoVaTen == null || HoVaTen.equals(""))
			return false;
		
		//Check GioiTinh
		if(GioiTinh == null || GioiTinh.equals(""))
			return false;

		//CheckMatKhau
		if(MatKhau == null || GioiTinh.equals(""))
			return false;
		return true;
	}
}
