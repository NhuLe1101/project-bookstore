/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.DocExcel;
import BUS.QuanLyNhaXuatBanBUS;
import BUS.XuatExcel;
import DTO.NhaXuatBan;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dangk
 */
public class NXBPanel extends javax.swing.JPanel {
    private DefaultTableModel mdtb1;
    private QuanLyNhaXuatBanBUS qlnxbBUS = new QuanLyNhaXuatBanBUS();

    /**
     * Creates new form SanPhamPanel
     */
    public NXBPanel() {
        initComponents();
        mdtb1 = (DefaultTableModel) tbNXB.getModel();
        setDataToTable(qlnxbBUS.getDsnxb());
        
        
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXuatExcel = new javax.swing.JButton();
        btnNhapExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbTypeSearch = new javax.swing.JComboBox<>();
        tfTim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbNXB = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1110, 800));
        setPreferredSize(new java.awt.Dimension(1110, 800));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(46, 134, 222));
        jPanel2.setPreferredSize(new java.awt.Dimension(1120, 55));

        btnThem.setBackground(new java.awt.Color(255, 255, 255));
        btnThem.setForeground(new java.awt.Color(0, 255, 0));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8-add-property-30.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setFocusable(false);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);

        btnXoa.setBackground(new java.awt.Color(255, 255, 255));
        btnXoa.setForeground(new java.awt.Color(255, 0, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8-delete-bin-30.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setFocusable(false);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa);

        btnSua.setBackground(new java.awt.Color(255, 255, 255));
        btnSua.setForeground(new java.awt.Color(0, 0, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8-support-30.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setFocusable(false);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua);

        btnXuatExcel.setBackground(new java.awt.Color(255, 255, 255));
        btnXuatExcel.setForeground(new java.awt.Color(0, 255, 0));
        btnXuatExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8-microsoft-excel-30.png"))); // NOI18N
        btnXuatExcel.setText("Xuất Excel");
        btnXuatExcel.setFocusable(false);
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });
        jPanel2.add(btnXuatExcel);

        btnNhapExcel.setBackground(new java.awt.Color(255, 255, 255));
        btnNhapExcel.setForeground(new java.awt.Color(0, 255, 0));
        btnNhapExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/giaodienchuan/images/icons8-microsoft-excel-30.png"))); // NOI18N
        btnNhapExcel.setText("Nhập Excel");
        btnNhapExcel.setFocusable(false);
        btnNhapExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapExcelActionPerformed(evt);
            }
        });
        jPanel2.add(btnNhapExcel);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(1249, 80));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Tìm kiếm"));
        jPanel4.setPreferredSize(new java.awt.Dimension(280, 70));
        jPanel4.setLayout(null);

        cbTypeSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã nhà xuất bản", "Tên nhà xuất bản", "Địa chỉ" }));
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

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 370));

        tbNXB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbNXB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã nhà xuất bản", "Tên nhà xuất bản", "Địa chỉ"
            }
        ));
        tbNXB.setFillsViewportHeight(true);
        tbNXB.setRowHeight(40);
        tbNXB.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tbNXB.setShowGrid(true);
        jScrollPane1.setViewportView(tbNXB);
        if (tbNXB.getColumnModel().getColumnCount() > 0) {
            tbNXB.getColumnModel().getColumn(0).setMaxWidth(80);
            tbNXB.getColumnModel().getColumn(1).setMaxWidth(250);
            tbNXB.getColumnModel().getColumn(2).setMaxWidth(500);
            tbNXB.getColumnModel().getColumn(3).setMaxWidth(500);
        }

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(8);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTypeSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeSearchActionPerformed
        tfTim.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),cbTypeSearch.getSelectedItem().toString()));
            tfTim.requestFocus();
            if (!tfTim.getText().equals("")) {
                tfSearchOnChange();
            }
    }//GEN-LAST:event_cbTypeSearchActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ThemSuaNhaXuatBanForm themnxb = new ThemSuaNhaXuatBanForm("Thêm", "");

        themnxb.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                qlnxbBUS.readDB();
                setDataToTable(qlnxbBUS.getDsnxb()); //refresh
            }
        });
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            String manxb = (String) tbNXB.getValueAt(tbNXB.getSelectedRow(), 1);
            if (manxb != null) {
                ThemSuaNhaXuatBanForm suanxb = new ThemSuaNhaXuatBanForm("Sửa", manxb);

                // https://stackoverflow.com/questions/4154780/jframe-catch-dispose-event
                suanxb.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        qlnxbBUS.readDB();
                        setDataToTable(qlnxbBUS.getDsnxb()); //refresh
                    }
                });
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chưa chọn nhà xuất bản nào để sửa");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            String manxb = (String) tbNXB.getValueAt(tbNXB.getSelectedRow(), 1);
            if (manxb != null) {
                if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa nhà xuất bản " + manxb + " ?", "Chú ý", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                    new QuanLyNhaXuatBanBUS().delete(manxb);
                    qlnxbBUS.readDB();
                    setDataToTable(qlnxbBUS.getDsnxb()); //refresh
                }
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Chưa chọn nhà xuất bản nào để xóa");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        new XuatExcel().xuatFileExcelNhaXuatBan();
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void btnNhapExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapExcelActionPerformed
        new DocExcel().docFileExcelNhaXuatBan();
    }//GEN-LAST:event_btnNhapExcelActionPerformed


    private void setDataToTable(ArrayList<NhaXuatBan> data) {
        mdtb1.setRowCount(0); // xóa table hiện có
        int stt = 1; // lưu số thứ tự dòng hiện tại
        for (NhaXuatBan nxb : data) {
            mdtb1.addRow(new String[]{String.valueOf(stt), nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi()});
            stt++;
        }
    }
    
    private void tfSearchOnChange() {
        setDataToTable(qlnxbBUS.search(tfTim.getText(), cbTypeSearch.getSelectedItem().toString()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapExcel;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JComboBox<String> cbTypeSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbNXB;
    private javax.swing.JTextField tfTim;
    // End of variables declaration//GEN-END:variables
}