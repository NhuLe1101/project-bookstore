package GUI;

import GUI.*;
import BUS.*;
import DTO.*;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThemSuaTaiKhoanForm extends JFrame {

    String type;
    QuanLyTaiKhoanBUS qltkBUS = new QuanLyTaiKhoanBUS();
    TaiKhoan tkSua;

    JTextField txUsername = new JTextField(15);
    JTextField txPassword = new JTextField(15);
    JTextField txMaNV = new JTextField(15);
    JTextField txLoaiQuyen = new JTextField(15);

    MoreButton btnChonNhanVien = new MoreButton();

    JButton btnThem = new JButton("Thêm");
    JButton btnSua = new JButton("Sửa");
    JButton btnHuy = new JButton("Hủy");

    public ThemSuaTaiKhoanForm(String _type, String _username) {
        this.setLayout(new BorderLayout());
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.type = _type;

        // inputs
        txUsername.setBorder(BorderFactory.createTitledBorder("Tên tài khoản"));
        txPassword.setBorder(BorderFactory.createTitledBorder("Mật khẩu"));
        txMaNV.setBorder(BorderFactory.createTitledBorder(" "));
        txLoaiQuyen.setBorder(BorderFactory.createTitledBorder(" "));

        JPanel plChonNhanVien = new JPanel();
        plChonNhanVien.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        plChonNhanVien.add(txMaNV);
        plChonNhanVien.add(btnChonNhanVien);

        JPanel plChonQuyen = new JPanel();
        plChonQuyen.setBorder(BorderFactory.createTitledBorder("Loại quyền"));
        plChonQuyen.add(txLoaiQuyen);

        JPanel plInput = new JPanel();
        plInput.add(txUsername);
        plInput.add(txPassword);
        plInput.add(plChonNhanVien);
        plInput.add(plChonQuyen);

        // panel buttons
        JPanel plButton = new JPanel();

        // 2 case Thêm - Sửa
        if (this.type.equals("Thêm")) {
            this.setTitle("Thêm tài khoản");

            btnThem.setIcon(new ImageIcon(this.getClass().getResource("/giaodienchuan/images/icons8_add_30px.png")));
            plButton.add(btnThem);

        } else {
            this.setTitle("Sửa tài khoản");
            for (TaiKhoan tk : qltkBUS.getDstk()) {
                if (tk.getUsername().equals(_username)) {
                    this.tkSua = tk;
                }
            }
            if (this.tkSua == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy tài khoản");
                this.dispose();
            }

            txUsername.setText(this.tkSua.getUsername());
            txUsername.setEditable(false);
            txPassword.setText(this.tkSua.getPassword());
            txMaNV.setText(this.tkSua.getMaNV());
            txLoaiQuyen.setText(this.tkSua.getLoaiQuyen());

            btnSua.setIcon(new ImageIcon(this.getClass().getResource("/giaodienchuan/images/icons8_support_30px.png")));
            plButton.add(btnSua);
        }
        
        btnHuy.setIcon(new ImageIcon(this.getClass().getResource("/giaodienchuan/images/icons8_cancel_30px_1.png")));
        plButton.add(btnHuy);

        this.add(plInput, BorderLayout.CENTER);
        this.add(plButton, BorderLayout.SOUTH);

        // mouse listener
        btnThem.addActionListener((ae) -> {
            btnThemMouseClicked();
        });
        btnSua.addActionListener((ae) -> {
            btnSuaMouseClicked();
        });
        btnHuy.addActionListener((ae) -> {
            this.dispose();
        });
        btnChonNhanVien.addActionListener((ae) -> {
            ChonNhanVien cnv = new ChonNhanVien(txMaNV);
        });


        this.setVisible(true);
    }

    private void btnThemMouseClicked() {
        if (checkEmpty()) {
            String username = txUsername.getText();
            String pass = txPassword.getText();
            String manv = txMaNV.getText();
            String maquyen = txLoaiQuyen.getText();

            if (qltkBUS.add(username, pass, manv, maquyen)) {
                JOptionPane.showMessageDialog(this, "Thêm " + username + " thành công!");
                this.dispose();
            }
        }
    }

    private void btnSuaMouseClicked() {
        if (checkEmpty()) {
            String username = txUsername.getText();
            String pass = txPassword.getText();
            String manv = txMaNV.getText();
            String loaiquyen = txLoaiQuyen.getText();

            if (qltkBUS.update(username, pass, manv, loaiquyen)) {
                JOptionPane.showMessageDialog(this, "Sửa " + username + " thành công!");
                this.dispose();
            }
        }
    }

    private Boolean checkEmpty() {
        String username = txUsername.getText();
        String pass = txPassword.getText();
        String manv = txMaNV.getText();
        String loaiquyen = txLoaiQuyen.getText();

        if (username.trim().equals("")) {
            return showErrorTx(txUsername, "Tên đăng nhập không được để trống");

        } else if (pass.equals("")) {
            return showErrorTx(txPassword, "Mật khẩu không được để trống");

        } else if (manv.trim().equals("")) {
            return showErrorTx(txMaNV, "Mã nhân viên không được để trống");

        } else if (loaiquyen.trim().equals("")) {
            return showErrorTx(txLoaiQuyen, "Mã quyền không được để trống");
        }

        return true;
    }

    private Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
