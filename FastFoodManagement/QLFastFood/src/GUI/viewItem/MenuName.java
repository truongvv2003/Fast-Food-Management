package GUI.viewItem;

import java.awt.Font;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuName extends javax.swing.JPanel {

    private JLabel label;
    private NhanName labelSplit1;
    private NhanName labelSplit2;
	
    public MenuName(String name) {
        this();
        label.setText(name);
    }
    
    public void setText(String text) {
        label.setText(text);
    }
    
    public MenuName() {
        initComponents();
        setOpaque(false);
    }

                        
    private void initComponents() {

        labelSplit1 = new NhanName();
        label = new JLabel();
        labelSplit2 = new NhanName();

        label.setFont(new java.awt.Font("Arial", Font.BOLD, 16)); // NOI18N
        label.setForeground(new java.awt.Color(0, 0, 0));
        label.setText("Name");

        labelSplit2.setText("labelSplit2");
        labelSplit2.setGradiet(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelSplit1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSplit2, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSplit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(labelSplit2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }                      


                  

                 
}