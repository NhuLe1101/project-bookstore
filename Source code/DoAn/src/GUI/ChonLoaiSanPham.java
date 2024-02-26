/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.QuanLyLoaiSanPhamBUS;
import DTO.LoaiSanPham;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangk
 */
public class ChonLoaiSanPham extends javax.swing.JFrame {

    JTextField tf;
    private DefaultTableModel mdtb1;
    private QuanLyLoaiSanPhamBUS qllspBUS = new QuanLyLoaiSanPhamBUS();
    /**
     * Creates new form ChonKhuyenMai
     */
    public ChonLoaiSanPham(JTextField tf) {
        initComponents();
        mdtb1 = (DefaultTableModel) tbLSP.getModel();
        setDataToTable(qllspBUS.getDslsp());
        this.tf = tf;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        tfTim.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                tfSearchOnChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tfSearchOnChange();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                tfSearchOnChange();
            }
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbTypeSearch = new javax.swing.JComboBox<>();
        tfTim = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setPreferredSize(new java.awt.Dimension(1249, 80));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm kiếm"));
        jPanel4.setPreferredSize(new java.awt.Dimension(280, 70));
        jPanel4.setLayout(null);

        cbTypeSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã loại", "Tên loại", "Mô tả" }));
        cbTypeSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeSearchActionPerformed(evt);
            }
        });
        jPanel4.add(cbTypeSearch);
        cbTypeSearch.setBounds(20, 30, 100, 20);

        tfTim.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tất cả"));
        tfTim.setPreferredSize(new java.awt.Dimension(130, 36));
        jPanel4.add(tfTim);
        tfTim.setBounds(130, 20, 140, 36);

        jPanel3.add(jPanel4);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_ok_30px.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8_cancel_30px_1.png"))); // NOI18N
        jButton2.setText("Thoát");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 370));

        tbLSP.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbLSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã thể loại", "Tên thể loại", "Mô tả"
            }
        ));
        tbLSP.setFillsViewportHeight(true);
        tbLSP.setRowHeight(40);
        tbLSP.setShowGrid(true);
        jScrollPane1.setViewportView(tbLSP);
        if (tbLSP.getColumnModel().getColumnCount() > 0) {
            tbLSP.getColumnModel().getColumn(0).setMaxWidth(80);
            tbLSP.getColumnModel().getColumn(1).setMaxWidth(120);
            tbLSP.getColumnModel().getColumn(2).setMaxWidth(400);
            tbLSP.getColumnModel().getColumn(3).setMaxWidth(400);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(8);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String malsp =(String) tbLSP.getValueAt(tbLSP.getSelectedRow(), 1);
            if (malsp != null) {
                tf.setText(malsp);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn loại sản phẩm nào!");
            }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbTypeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeSearchActionPerformed
        tfTim.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),cbTypeSearch.getSelectedItem().toString()));
        tfTim.requestFocus();
        if (!tfTim.getText().equals("")) {
            tfSearchOnChange();
        }
    }//GEN-LAST:event_cbTypeSearchActionPerformed

    private void setDataToTable(ArrayList<LoaiSanPham> data) {
        mdtb1.setRowCount(0); // xóa table hiện có 
        int stt = 1; // lưu số thứ tự dòng hiện tại
        for (LoaiSanPham lsp : data) {
            mdtb1.addRow(new String[]{String.valueOf(stt), lsp.getMaLSP(), lsp.getTenLSP(), lsp.getMoTa()});
            stt++;
        }
    }
    
    
    private void tfSearchOnChange() {
        setDataToTable(qllspBUS.search(tfTim.getText(), cbTypeSearch.getSelectedItem().toString()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbTypeSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbLSP;
    private javax.swing.JTextField tfTim;
    // End of variables declaration//GEN-END:variables
}
