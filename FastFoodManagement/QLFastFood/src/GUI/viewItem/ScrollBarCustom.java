package GUI.viewItem;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

@SuppressWarnings("serial")
public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setForeground(new Color(115, 115, 115));
        setOpaque(false);
        setUnitIncrement(30);
    }
}