package com.mycompany.matrixmultiplier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class MenuGrids extends JFrame {

    public MenuGrids(int[][] value1, int[][] value2, int[][] value3) {

        this.setTitle("Nuevo JFrame");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel currentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JPanel gridPanel1 = DynamicGrid.draw(value1);
        JPanel gridPanel2 = DynamicGrid.draw(value2);
        JPanel gridPanel3 = DynamicGrid.draw(value3, true);

        JScrollPane scrollPane = new JScrollPane(currentPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        setLayout(new BorderLayout());

        JRadioButton radio1 = new JRadioButton("Panel 1");
        JRadioButton radio2 = new JRadioButton("Panel 2");
        JRadioButton radio3 = new JRadioButton("Panel 3");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);

        radio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.removeAll();
                currentPanel.add(gridPanel1, BorderLayout.CENTER); // Add the new panel to the center
                currentPanel.setBackground(Color.RED);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        radio2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.removeAll();
                currentPanel.add(gridPanel2, BorderLayout.CENTER); // Add the new panel to the center
                currentPanel.setBackground(Color.GREEN);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        radio3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPanel.removeAll();
                currentPanel.add(gridPanel3, BorderLayout.CENTER); // Add the new panel to the center
                currentPanel.setBackground(Color.ORANGE);
                currentPanel.revalidate();
                currentPanel.repaint();
            }
        });

        getContentPane().add(scrollPane);
        JPanel radioPanel = new JPanel();
        radioPanel.add(radio1);
        radioPanel.add(radio2);
        radioPanel.add(radio3);
        add(radioPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}