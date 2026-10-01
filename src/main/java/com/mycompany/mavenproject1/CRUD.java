/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class CRUD extends javax.swing.JFrame {
    Connection conn;
    PreparedStatement pst;
    
    
    public CRUD() {
        initComponents();
        conn = InventoryConn.conn();
        setLocationRelativeTo(null);
        readProducts();
    }
    
    private void readProducts() {
    String sql = "SELECT * FROM product";

    try {
        pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        javax.swing.table.DefaultTableModel model =
                (javax.swing.table.DefaultTableModel) display.getModel();

        
        model.setRowCount(0);

        
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getObject(1),  
                rs.getObject(2),  
                rs.getObject(3),  
                rs.getObject(4)   
            });
        }

        rs.close();
        pst.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error reading products: " + e.getMessage());
    }
}
    private void updateProduct() {
    int selectedRow = display.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this,
                "Please select a product to update.");
        return;
    }

    String id = display.getValueAt(selectedRow, 0).toString();
    String name = JOptionPane.showInputDialog(this,
            "Enter new product name:",
            display.getValueAt(selectedRow, 1));

    String qty = JOptionPane.showInputDialog(this,
            "Enter new quantity:",
            display.getValueAt(selectedRow, 2));

    String price = JOptionPane.showInputDialog(this,
            "Enter new price:",
            display.getValueAt(selectedRow, 3));

    if (name == null || qty == null || price == null) {
        return;
    }

    String sql = "UPDATE product SET product_name = ?, qty = ?, price = ? WHERE ID = ?";

    try {
        pst = conn.prepareStatement(sql);

        pst.setString(1, name);
        pst.setInt(2, Integer.parseInt(qty));
        pst.setDouble(3, Double.parseDouble(price));
        pst.setInt(4, Integer.parseInt(id));

        int updated = pst.executeUpdate();

        if (updated > 0) {
            JOptionPane.showMessageDialog(this,
                    "Product updated successfully!");

            readProducts();
        }

        pst.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "QTY must be a whole number and Price must be a number.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error updating product: " + e.getMessage());
    }
}
    private void deleteProduct() {
    int selectedRow = display.getSelectedRow();

    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this,
                "Please select a product to delete.");
        return;
    }

    String id = display.getValueAt(selectedRow, 0).toString();

    int confirm = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to delete this product?",
            "Confirm Delete",
            JOptionPane.YES_NO_OPTION
    );

    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    String sql = "DELETE FROM product WHERE ID = ?";

    try {
        pst = conn.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(id));

        int deleted = pst.executeUpdate();

        if (deleted > 0) {
            JOptionPane.showMessageDialog(this,
                    "Product deleted successfully!");

       
            readProducts();
        }

        pst.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "Invalid product ID.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error deleting product: " + e.getMessage());
    }
}
    private void createProduct() {

    String name = JOptionPane.showInputDialog(
            this, "Enter product name:");

    if (name == null || name.trim().isEmpty()) {
        return;
    }

    String qty = JOptionPane.showInputDialog(
            this, "Enter quantity:");

    if (qty == null || qty.trim().isEmpty()) {
        return;
    }

    String price = JOptionPane.showInputDialog(
            this, "Enter price:");

    if (price == null || price.trim().isEmpty()) {
        return;
    }

    String sql = "INSERT INTO product (product_name, qty, price) VALUES (?, ?, ?)";

    try {
        pst = conn.prepareStatement(sql);

        pst.setString(1, name);
        pst.setInt(2, Integer.parseInt(qty));
        pst.setDouble(3, Double.parseDouble(price));

        int inserted = pst.executeUpdate();

        if (inserted > 0) {
            JOptionPane.showMessageDialog(this,
                    "Product added successfully!");

            // Refresh the table
            readProducts();
        }

        pst.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this,
                "QTY must be a whole number and Price must be a number.");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this,
                "Error adding product: " + e.getMessage());
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "QTY", "Price"
            }
        ));
        jScrollPane1.setViewportView(display);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 90, 40));

        jButton2.setText("Create");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 110, 40));

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 90, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        updateProduct();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        createProduct();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        deleteProduct();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    public static void main(String args[]) {
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable display;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
