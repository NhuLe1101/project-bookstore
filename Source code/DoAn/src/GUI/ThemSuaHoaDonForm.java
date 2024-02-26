package GUI;

import GUI.*;
import BUS.*;
import DTO.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThemSuaHoaDonForm extends JFrame {

    String type;
    QuanLyHoaDonBUS qlhdBUS = new QuanLyHoaDonBUS();
    HoaDon hdSua;

    JTextField txtMaHd = new JTextField(15);
    JTextField txtMaNv = new JTextField(15);
    JTextField txtMaKh = new JTextField(15);
    JTextField txtNgayLap = new JTextField(15);
    JTextField txtTongTien = new JTextField(15);

    MoreButton btnChonNhanVien = new MoreButton();
    MoreButton btnChonKhachHang = new MoreButton();
    MoreButton btnChonKhuyenMai = new MoreButton();

    JButton btnThem = new JButton("Thêm");
    JButton btnSua = new JButton("Sửa");
    JButton btnHuy = new JButton("Hủy");

    public ThemSuaHoaDonForm(String _type, String _mahd) {
        this.setLayout(new BorderLayout());
        this.setSize(550, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.type = _type;

        // inputs
        txtMaHd.setBorder(BorderFactory.createTitledBorder("Mã hóa đơn"));
        txtMaNv.setBorder(BorderFactory.createTitledBorder(" "));
        txtMaKh.setBorder(BorderFactory.createTitledBorder(" "));
        txtNgayLap.setBorder(BorderFactory.createTitledBorder("Ngày lập"));
        txtTongTien.setBorder(BorderFactory.createTitledBorder("Tổng tiền"));

        JPanel plChonNhanVien = new JPanel();
        plChonNhanVien.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        plChonNhanVien.add(txtMaNv);
        plChonNhanVien.add(btnChonNhanVien);

        JPanel plChonKhachHang = new JPanel();
        plChonKhachHang.setBorder(BorderFactory.createTitledBorder("Mã khách hàng"));
        plChonKhachHang.add(txtMaKh);
        plChonKhachHang.add(btnChonKhachHang);


        JPanel plInput = new JPanel();
        plInput.add(txtMaHd);
        plInput.add(plChonNhanVien);
        plInput.add(plChonKhachHang);
        plInput.add(txtNgayLap);


        // panel buttons
        JPanel plButton = new JPanel();

        // 2 case Thêm - Sửa
        if (this.type.equals("Thêm")) {
            this.setTitle("Thêm hóa đơn");
            txtMaHd.setText(qlhdBUS.getNextID());

            LocalDate ngayLap = java.time.LocalDate.now();

            this.txtNgayLap.setText(String.valueOf(ngayLap));


            btnThem.setIcon(new ImageIcon(this.getClass().getResource("/giaodienchuan/images/icons8_add_30px.png")));
            plButton.add(btnThem);

        } else {
            this.setTitle("Sửa hóa đơn");
            for (HoaDon hd : qlhdBUS.getDshd()) {
                if (hd.getMaHoaDon().equals(_mahd)) {
                    this.hdSua = hd;
                }
            }
            if (this.hdSua == null) {
                JOptionPane.showMessageDialog(null, "Lỗi, không tìm thấy hóa đơn");
                this.dispose();
            }

            txtMaHd.setText(this.hdSua.getMaHoaDon());
            txtMaNv.setText(this.hdSua.getMaNhanVien());
            txtMaKh.setText(this.hdSua.getMaKhachHang());
            txtNgayLap.setText(String.valueOf(this.hdSua.getNgayLap()));
            txtTongTien.setText(String.valueOf(this.hdSua.getTongTien()));

            txtMaHd.setEditable(false);

            plInput.add(txtTongTien);

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
        btnChonNhanVien.addActionListener((ActionEvent ae) -> {
            btnChonNhanVienMouseClicked();
        });
        btnChonKhachHang.addActionListener((ae) -> {
            btnChonKhachHangMouseClicked();
        });

        txtTongTien.setEditable(false);
        this.setVisible(true);
    }

    private void btnThemMouseClicked() {
        if (checkEmpty()) {
            String mahd = txtMaHd.getText();
            String manv = txtMaNv.getText();
            String makh = txtMaKh.getText();
            LocalDate ngayLap = LocalDate.now();
            float tongTien = 0;

            this.txtNgayLap.setText(String.valueOf(ngayLap));
            this.txtTongTien.setText(String.valueOf(tongTien));

            if (qlhdBUS.add(mahd, manv, makh, ngayLap, tongTien)) {
                JOptionPane.showMessageDialog(this, "Thêm hóa đơn " + mahd + " thành công!");
                this.dispose();
            }
        }
    }

    private void btnSuaMouseClicked() {
        if (checkEmpty()) {
            String mahd = txtMaHd.getText();
            String manv = txtMaNv.getText();
            String makh = txtMaKh.getText();
            LocalDate ngayLap = java.time.LocalDate.parse(txtNgayLap.getText());
            float tongTien = Float.parseFloat(txtTongTien.getText());

            if (qlhdBUS.update(mahd, manv, makh, ngayLap, tongTien)) {
                JOptionPane.showMessageDialog(this, "Sửa " + mahd + " thành công!");
                this.dispose();
            }
        }
    }

    private void btnChonNhanVienMouseClicked() {
        ChonNhanVien cnv = new ChonNhanVien(txtMaNv);
    }

    private void btnChonKhachHangMouseClicked() {
        ChonKhachHang ckh = new ChonKhachHang(txtMaKh);
    }

    private Boolean checkEmpty() {
        String mahd = txtMaHd.getText();
        String manv = txtMaNv.getText();
        String makh = txtMaKh.getText();
        String ngayLap = txtNgayLap.getText();

        if (mahd.trim().equals("")) {
            return showErrorTx(txtMaHd, "Mã hóa đơn không được để trống");

        } else if (manv.trim().equals("")) {
            return showErrorTx(txtMaNv, "Mã nhân viên không được để trống");

        } else if (makh.trim().equals("")) {
            return showErrorTx(txtMaKh, "Mã khách hàng không được để trống");

        } else if (ngayLap.trim().equals("")) {
            return showErrorTx(txtNgayLap, "Ngày lập không được để trống");


        } else {
            try {
                LocalDate ngay = java.time.LocalDate.parse(ngayLap);
            } catch (DateTimeParseException e) {
                return showErrorTx(txtNgayLap, "Ngày lập không hợp lệ yyyy-mm-dd ( ví dụ: 2018-12-31)");
            }
        }
        return true;
    }

    private Boolean showErrorTx(JTextField tx, String errorInfo) {
        JOptionPane.showMessageDialog(tx, errorInfo);
        tx.requestFocus();
        return false;
    }
}
