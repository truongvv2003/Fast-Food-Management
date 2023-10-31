package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;


@SuppressWarnings("serial")
public class PanelDatDoAn extends JPanel {

	
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public JPanel panelDau;
	public MenuName menuName;
	public JPanel nutpanelDatMon;
	public JPanel nutpanelDanhSachMon;
	public JPanel nutpanelThongKe;
	public JLabel lblDatMon;
	public JLabel lblDanhSachMon;
	public JLabel lblThongKe;
	public JPanel jPanelFromVao;
	public PanelDatDoAn_DatMon panelDatDoAn_DatMon;
	public PanelDatDoAn_DanhSachMon panelDatDoAn_DanhSachMon;
	public PanelDatDoAn_ThongKe panelDatDoAn_ThongKe;



	public PanelDatDoAn() {

		caiDatPanelThongTin();
		menuName.setText("ĐẶT ĐỒ ĂN");
        setCustomScrollBar();
        
	}

	private void caiDatPanelThongTin() {

		this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.setBounds(0, 0, 964, 701);
        this.setOpaque(false);
        setLayout(null);
//		
//		
		menuName = new MenuName();
		menuName.setBounds(0, 0, 964, 40);
//		
		panelDau = new JPanel();
		panelDau.setBounds(0, 0, 964, 40);
		panelDau.setLayout(null);
		panelDau.add(menuName);


//		//From dua vao
		jPanelFromVao = new JPanel();
		jPanelFromVao.setLayout(null);
		jPanelFromVao.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jPanelFromVao.setBounds(0, 0, 940, 579);
		
		
		panelDatDoAn_DatMon = new PanelDatDoAn_DatMon();
		panelDatDoAn_DatMon.jScrollPane_Body.setBounds(0, 0, 940, 579);
		panelDatDoAn_DatMon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelDatDoAn_DatMon.setBounds(0, 0, 940, 579);
		
		panelDatDoAn_DanhSachMon = new PanelDatDoAn_DanhSachMon();
		panelDatDoAn_DanhSachMon.jScrollPane_Body.setBounds(0, 0, 940, 579);
		panelDatDoAn_DanhSachMon.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelDatDoAn_DanhSachMon.setBounds(0, 0, 940, 579);
		
		panelDatDoAn_ThongKe = new PanelDatDoAn_ThongKe();
		panelDatDoAn_ThongKe.jScrollPane_Body.setBounds(0, 0, 940, 579);
		panelDatDoAn_ThongKe.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelDatDoAn_ThongKe.setBounds(0, 0, 940, 579);
		
		jPanelFromVao.add(panelDatDoAn_DatMon);
		jPanelFromVao.add(panelDatDoAn_DanhSachMon);
		jPanelFromVao.add(panelDatDoAn_ThongKe);
//
		jScrollPaneTable = new JScrollPane();
		jScrollPaneTable.setBounds(10, 108, 940, 579);
		jScrollPaneTable.setViewportView(jPanelFromVao);
//
//		
//		
//		
		nutpanelDatMon = new JPanel();
		nutpanelDatMon.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelDatMon.addMouseListener(new PanelButtonMouseAdapter(nutpanelDatMon));
		nutpanelDatMon.addMouseListener(new SuKienPannelDatDoAn(this));
		nutpanelDatMon.setBackground(new Color(47, 79, 79));
		nutpanelDatMon.setBounds(71, 50, 225, 46);
		nutpanelDatMon.setLayout(null);
		
		lblDatMon = new JLabel("Đặt món");
		lblDatMon.setForeground(new Color(255, 255, 255));
		lblDatMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatMon.setFont(new Font("Arial", Font.BOLD, 16));
		lblDatMon.setBounds(41, 10, 146, 26);
		nutpanelDatMon.add(lblDatMon);
		
		nutpanelDanhSachMon = new JPanel();
		nutpanelDanhSachMon.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelDanhSachMon.addMouseListener(new PanelButtonMouseAdapter(nutpanelDanhSachMon));
		nutpanelDanhSachMon.addMouseListener(new SuKienPannelDatDoAn(this));
		nutpanelDanhSachMon.setBackground(new Color(47, 79, 79));
		nutpanelDanhSachMon.setBounds(367, 50, 225, 46);
		nutpanelDanhSachMon.setLayout(null);
		
		lblDanhSachMon = new JLabel("Danh sách món");
		lblDanhSachMon.setForeground(new Color(255, 255, 255));
		lblDanhSachMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSachMon.setFont(new Font("Arial", Font.BOLD, 16));
		lblDanhSachMon.setBounds(47, 10, 140, 26);
		nutpanelDanhSachMon.add(lblDanhSachMon);
		
		nutpanelThongKe = new JPanel();
		nutpanelThongKe.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelThongKe.addMouseListener(new PanelButtonMouseAdapter(nutpanelThongKe));
		nutpanelThongKe.addMouseListener(new SuKienPannelDatDoAn(this));
		nutpanelThongKe.setBackground(new Color(47, 79, 79));
		nutpanelThongKe.setBounds(663, 50, 225, 46);
		nutpanelThongKe.setLayout(null);
		
		lblThongKe = new JLabel("Thống kê");
		lblThongKe.setForeground(new Color(255, 255, 255));
		lblThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThongKe.setFont(new Font("Arial", Font.BOLD, 16));
		lblThongKe.setBounds(47, 10, 140, 26);
		nutpanelThongKe.add(lblThongKe);
		
//		
//		
		jPanelBody = new JPanel();
		jPanelBody.setLayout(null);
		jPanelBody.setOpaque(false); // để không che khuất thằng phía sau
		jPanelBody.add(panelDau);
		jPanelBody.add(jScrollPaneTable);
		jPanelBody.add(nutpanelDatMon);
		jPanelBody.add(nutpanelDanhSachMon);
		jPanelBody.add(nutpanelThongKe);
//		
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


