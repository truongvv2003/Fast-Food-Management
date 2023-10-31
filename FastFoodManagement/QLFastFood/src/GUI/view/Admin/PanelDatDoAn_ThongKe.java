package GUI.view.Admin;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import BLL.BillBLL;
import GUI.viewItem.MenuName;
import GUI.viewItem.ScrollBarCustom;
import GUI.viewItem.TableCuaTui;


@SuppressWarnings("serial")
public class PanelDatDoAn_ThongKe extends JPanel {

		public JScrollPane jScrollPane_Body;
		public JPanel jPanelBody;
		public JScrollPane jScrollPaneTable;
		public TableCuaTui tableCuaTui;
		public JPanel panelDau;
		public MenuName menuName;
		public DefaultTableModel model;

		public PanelDatDoAn_ThongKe() {


			caiDatPanelThongTin();
			
			tableCuaTui.fixTable(jScrollPaneTable);
	        setCustomScrollBar();

			
		}

		private void caiDatPanelThongTin() {

			
			this.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			this.setBounds(0, 0, 940, 579);
			this.setLayout(null);
	        this.setOpaque(false);
	        
	        JLabel lblTieuDe = new JLabel("THỐNG KÊ");
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
			this.model.addColumn("Số thứ tự");
			this.model.addColumn("Tên Nhân Viên");
			this.model.addColumn("Ngày bán hàng");
			this.model.addColumn("Tổng tiền");
			
//			this.addComponentListener(new SuKienPannelThongTin_LopHocPhan(this));
			tableCuaTui.setModel(model);
			tableCuaTui.getTableHeader().setReorderingAllowed(false);
			
//			tableCuaTui.addMouseListener(new SuKienPannelThongTin_LopHocPhan(this));
			
			
			jScrollPaneTable = new JScrollPane();
			jScrollPaneTable.setBounds(10, 61, 918, 507);
			jScrollPaneTable.setViewportView(tableCuaTui);
			

			
			jPanelBody = new JPanel();
			jPanelBody.setLayout(null);
			jPanelBody.setOpaque(true); // để không che khuất thằng phía sau
	        jPanelBody.add(panelTieuDe);  
			jPanelBody.add(jScrollPaneTable);
			
			jScrollPane_Body = new JScrollPane();
			jScrollPane_Body.setBounds(0, 0, 964, 701);
			jScrollPane_Body.setViewportView(jPanelBody);
			
//			this.addComponentListener(new SuKienPannelThongTin_LopHocPhan(this));
			this.add(jScrollPane_Body);
			
//			
			

		}
		public void bangThongKe() {
			ArrayList<ArrayList<String>> dsThongKeAdmin = BillBLL.getInstance().dsThongKeAdmin();
			model.setNumRows(0);
			for (int i = 0; i < dsThongKeAdmin.size(); i++) {
				Vector<Object> vec = new Vector<Object>();
				vec.add(i + 1);
				vec.add(dsThongKeAdmin.get(i).get(0));
				vec.add(dsThongKeAdmin.get(i).get(1));
				vec.add(dsThongKeAdmin.get(i).get(2));
				model.addRow(vec);
			}
			tableCuaTui.setModel(model);
		}

		private void setCustomScrollBar() {
	    	jScrollPane_Body.setViewportBorder(null);
	    	jScrollPane_Body.getViewport().setOpaque(false);
	    	jScrollPane_Body.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    	jScrollPane_Body.setVerticalScrollBar(new ScrollBarCustom());
	    	jScrollPane_Body.setHorizontalScrollBar(new ScrollBarCustom());
	    }
	}


