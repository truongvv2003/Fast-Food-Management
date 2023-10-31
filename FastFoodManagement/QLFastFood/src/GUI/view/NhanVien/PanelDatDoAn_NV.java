package GUI.view.NhanVien;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import GUI.view.PanelButtonMouseAdapter;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;


@SuppressWarnings("serial")
public class PanelDatDoAn_NV extends JPanel {

	
	public JScrollPane jScrollPane_Body;
	public JPanel jPanelBody;
	public JScrollPane jScrollPaneTable;
	public JPanel panelDau;
	public MenuName menuName;
	public JPanel nutpanelDatMon;
	public JPanel nutpanelThongKe;
	public JLabel lblDatMon;
	public JLabel lblThongKe;
	public JPanel jPanelFromVao;
	public PanelDatDoAn_DatMon_NV panelDatDoAn_DatMon_NV;
	public PanelDatDoAn_ThongKe_NV panelDatDoAn_ThongKe_NV;



	public PanelDatDoAn_NV() {

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
		
		
		panelDatDoAn_DatMon_NV = new PanelDatDoAn_DatMon_NV();
		panelDatDoAn_DatMon_NV.jScrollPane_Body.setBounds(0, 0, 940, 579);
		panelDatDoAn_DatMon_NV.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelDatDoAn_DatMon_NV.setBounds(0, 0, 940, 579);
		
		
		panelDatDoAn_ThongKe_NV = new PanelDatDoAn_ThongKe_NV();
		panelDatDoAn_ThongKe_NV.jScrollPane_Body.setBounds(0, 0, 940, 579);
		panelDatDoAn_ThongKe_NV.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelDatDoAn_ThongKe_NV.setBounds(0, 0, 940, 579);
		
		jPanelFromVao.add(panelDatDoAn_DatMon_NV);
		jPanelFromVao.add(panelDatDoAn_ThongKe_NV);
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
		nutpanelDatMon.addMouseListener(new SuKienPannelDatDoAn_NV(this));
		nutpanelDatMon.setBackground(new Color(47, 79, 79));
		nutpanelDatMon.setBounds(170, 50, 225, 46);
		nutpanelDatMon.setLayout(null);
		
		lblDatMon = new JLabel("Đặt món");
		lblDatMon.setForeground(new Color(255, 255, 255));
		lblDatMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatMon.setFont(new Font("Arial", Font.BOLD, 16));
		lblDatMon.setBounds(41, 10, 146, 26);
		nutpanelDatMon.add(lblDatMon);
		
		nutpanelThongKe = new JPanel();
		nutpanelThongKe.setBorder(new LineBorder(new Color(0, 0, 0)));
		nutpanelThongKe.addMouseListener(new PanelButtonMouseAdapter(nutpanelThongKe));
		nutpanelThongKe.addMouseListener(new SuKienPannelDatDoAn_NV(this));
		nutpanelThongKe.setBackground(new Color(47, 79, 79));
		nutpanelThongKe.setBounds(565, 50, 225, 46);
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


