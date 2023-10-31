package GUI.viewItem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class TableCuaTui extends JTable {

    private MyTableHeader header;
    private MyTableCell cell;

    public TableCuaTui() {
        header = new MyTableHeader();
        cell = new MyTableCell();
        getTableHeader().setDefaultRenderer(header);
        getTableHeader().setPreferredSize(new Dimension(0, 35));
        setDefaultRenderer(Object.class, cell);
        setRowHeight(30);
    }

    public void setColumnAlignment(int column, int align) {
        header.setAlignment(column, align);
    }

    public void setCellAlignment(int column, int align) {
        cell.setAlignment(column, align);
    }

    public void setColumnWidth(int column, int width) {
        getColumnModel().getColumn(column).setPreferredWidth(width);
        getColumnModel().getColumn(column).setMinWidth(width);
        getColumnModel().getColumn(column).setMaxWidth(width);
        getColumnModel().getColumn(column).setMinWidth(10);
        getColumnModel().getColumn(column).setMaxWidth(10000);
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setVerticalScrollBar(new ScrollBarCustom());
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel);
        scroll.getViewport().setBackground(Color.WHITE);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
    }

	private class MyTableHeader extends DefaultTableCellRenderer {

        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            com.setBackground(new Color(47, 79, 79));
            com.setForeground(Color.WHITE);
            com.setFont(com.getFont().deriveFont(Font.BOLD, 14));
            if (alignment.containsKey(column)) {
                setHorizontalAlignment(alignment.get(column));
            } else {
                setHorizontalAlignment(JLabel.CENTER);
            }
            return com;
        }
    }

	private class MyTableCell extends DefaultTableCellRenderer {

        private Map<Integer, Integer> alignment = new HashMap<>();

        public void setAlignment(int column, int align) {
            alignment.put(column, align);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//            if (isCellSelected(row, column)) {
//                if (row % 2 == 0) {
//                    com.setBackground(new Color(33, 103, 153));
//                } else {
//                    com.setBackground(new Color(29, 86, 127));
//                }
//            } else {
//                if (row % 2 == 0) {
//                    com.setBackground(new Color(50, 50, 50));
//                } else {
//                    com.setBackground(new Color(30, 30, 30));
//                }
//            }
            com.setForeground(Color.BLACK);
            setBorder(new EmptyBorder(0, 5, 0, 5));
            if (alignment.containsKey(column)) {
                setHorizontalAlignment(alignment.get(column));
            } else {
                setHorizontalAlignment(JLabel.CENTER);
            }
            return com;
        }
    }
}