/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author guraz
 */
public class Inventario extends javax.swing.JPanel {

    /**
     * Creates new form Inventario
     */
    public Inventario(JList<String> itemNames, ArrayList<Item> items) {
        InventList = itemNames;
        this.items = items;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        info = new JTextArea("Selecciona un elemento");
        infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(700, 300));
        infoPanel.add(info, BorderLayout.CENTER);
        bg = new javax.swing.JPanel();
        scrollLam = new JScrollPane(InventList);
        InventList.setPreferredSize(new Dimension(700, 300));
        listpanel = new JPanel();
        listpanel.add(scrollLam, BorderLayout.CENTER);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));

        InventList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                inventSelectionListener(e);
            }
            
        });
        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER).addComponent(listpanel))
            .addGap(0, 20, Short.MAX_VALUE).addComponent(infoPanel)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createSequentialGroup()
            .addGap(0, 20, Short.MAX_VALUE).addComponent(listpanel).addComponent(infoPanel)
        );
        // bg.add(listpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 420));
        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 420));
    }// </editor-fold>//GEN-END:initComponents
    
    private void inventSelectionListener(ListSelectionEvent e) {
        Item selecteditem = new Item("",0.0,"",0);
        String selectedValue = InventList.getSelectedValue();

        for(Item i: items) {
            if (i.name.equals(selectedValue)) {
                selecteditem = i; 
            }
        }

        String infoTable = "";
        infoTable += "Nombre: " + selecteditem.name + "\n"
            + "Precio: "  + selecteditem.price + "\n"
            + "Descripcion: " + selecteditem.desc + "\n"
            + "Diponibles: " + selecteditem.quantity;
        info.setText(infoTable);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private JScrollPane scrollLam;
    private JPanel listpanel;
    private JPanel infoPanel;
    private JTextArea info;
    private JList<String> InventList;
    private ArrayList<Item> items;
    // End of variables declaration//GEN-END:variables
}

