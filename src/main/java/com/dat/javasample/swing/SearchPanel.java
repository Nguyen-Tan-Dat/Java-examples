package com.dat.javasample.swing;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {

    JButton btnSearchID = new JButton("Tìm theo Mã");
    JButton btnSearchName = new JButton("Tìm theo Tên");
    JTextField txSearch = new JTextField(15);
    
    GridBagConstraints gbc = new GridBagConstraints();

    public SearchPanel() {
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder("Tìm kiếm :"));
        
        // style components
        txSearch.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnSearchID.setBackground(Color.white);
        btnSearchName.setBackground(Color.white);
        
        // add component
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnSearchID, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(btnSearchName, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txSearch, gbc);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        SearchPanel s = new SearchPanel();
        
        f.setTitle("Giao dien chuan");
        f.setLayout(new GridBagLayout());
        
        f.add(s);
        
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
