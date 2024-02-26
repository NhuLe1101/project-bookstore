/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.QuanLyKhachHangBUS;
import DTO.KhachHang;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangk
 */
public class ChonSanPham extends javax.swing.JFrame {

    JTextField tf;
    private DefaultTableModel mdtb1;    
    private QuanLyKhachHangBUS qlkh = new QuanLyKhachHangBUS();
    /**
     * Creates new form ChonKhuyenMai
     */
    public ChonSanPham(JTextField tf) {
        initComponents();
        mdtb1 = (DefaultTableModel) tbKhachHang.getModel();
        setDataToTable(qlkh.getDskh());
        this.tf = tf;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setPreferredSize(new java.awt.Dimension(1249, 80));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm kiếm"));
        jPanel4.setPreferredSize(new java.awt.Dimension(280, 70));
        jPanel4.setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1);
        jComboBox1.setBounds(20, 30, 100, 20);

        jTextField1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tất cả"));
        jTextField1.setPreferredSize(new java.awt.Dimension(130, 36));
        jPanel4.add(jTextField1);
        jTextField1.setBounds(130, 20, 140, 36);

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

        tbKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại"
            }
        ));
        tbKhachHang.setFillsViewportHeight(true);
        tbKhachHang.setRowHeight(40);
        tbKhachHang.setShowGrid(true);
        jScrollPane1.setViewportView(tbKhachHang);
        if (tbKhachHang.getColumnModel().getColumnCount() > 0) {
            tbKhachHang.getColumnModel().getColumn(0).setMaxWidth(70);
            tbKhachHang.getColumnModel().getColumn(1).setMaxWidth(130);
            tbKhachHang.getColumnModel().getColumn(2).setMaxWidth(200);
            tbKhachHang.getColumnModel().getColumn(3).setMaxWidth(300);
            tbKhachHang.getColumnModel().getColumn(4).setMaxWidth(300);
        }

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(8);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String makh =(String) tbKhachHang.getValueAt(tbKhachHang.getSelectedRow(), 1);
            if (makh != null) {
                tf.setText(makh);
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng nào!");
            }     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void setDataToTable(ArrayList<KhachHang> data) {
        int stt = 1; // lưu số thứ tự dòng hiện tại
        for (KhachHang kh : data) {
                mdtb1.addRow(new String[]{
                    String.valueOf(stt),
                    kh.getMaKH(),
                    kh.getTenKH(),
                    kh.getDiaChi(),
                    kh.getSDT(),
                });
                stt++;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbKhachHang;
    // End of variables declaration//GEN-END:variables
}
