package BUS;

import DTO.*;
import java.awt.FileDialog;
import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author Admin
 */
public class XuatExcel {

    FileDialog fd = new FileDialog(new JFrame(), "Xuất excel", FileDialog.SAVE);

    private String getFile() {
//        fd.setFile("*.xlsx");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile()+".xls";
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }

    // Xuất file Excel Nhà cung cấp    
    public void xuatFileExcelNhaCungCap() {
        fd.setTitle("Xuất dữ liệu nhà cung cấp ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhà cung cấp");

            QuanLyNhaCungCapBUS qlnccBUS = new QuanLyNhaCungCapBUS();
            ArrayList<NhaCungCap> list = qlnccBUS.getDsncc();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã nhà cung cấp");
            row.createCell(2, CellType.STRING).setCellValue("Tên nhà cung cấp");
            row.createCell(3, CellType.STRING).setCellValue("Địa chỉ");
            row.createCell(4, CellType.STRING).setCellValue("Số điện thoại");
            row.createCell(5, CellType.STRING).setCellValue("Fax");

            for (NhaCungCap ncc : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(ncc.getMaNCC());
                row.createCell(2, CellType.STRING).setCellValue(ncc.getTenNCC());
                row.createCell(3, CellType.STRING).setCellValue(ncc.getDiaChi());
                row.createCell(4, CellType.STRING).setCellValue(ncc.getSDT());
                row.createCell(5, CellType.STRING).setCellValue(ncc.getFax());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Xuất file Excel Nhà xuất bản    
    public void xuatFileExcelNhaXuatBan() {
        fd.setTitle("Xuất dữ liệu nhà xuất bản ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhà xuất bản");

            QuanLyNhaXuatBanBUS qlnxbBUS = new QuanLyNhaXuatBanBUS();
            ArrayList<NhaXuatBan> list = qlnxbBUS.getDsnxb();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã nhà xuất bản");
            row.createCell(2, CellType.STRING).setCellValue("Tên nhà xuất bản");
            row.createCell(3, CellType.STRING).setCellValue("Địa chỉ");

            for (NhaXuatBan nxb : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(nxb.getMaNXB());
                row.createCell(2, CellType.STRING).setCellValue(nxb.getTenNXB());
                row.createCell(3, CellType.STRING).setCellValue(nxb.getDiaChi());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Xuất file Excel Nhân viên
    public void xuatFileExcelNhanVien() {
        fd.setTitle("Xuất dữ liệu nhân viên ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Nhân viên");

            QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
            ArrayList<NhanVien> list = qlnvBUS.getDsnv();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(2, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(3, CellType.STRING).setCellValue("Ngày sinh");
            row.createCell(4, CellType.STRING).setCellValue("Địa chỉ");
            row.createCell(5, CellType.STRING).setCellValue("Số điện thoại");

            for (NhanVien nv : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(nv.getMaNV());
                row.createCell(2, CellType.STRING).setCellValue(nv.getTenNV());
                row.createCell(3, CellType.STRING).setCellValue(String.valueOf(nv.getNgaySinh()));
                row.createCell(4, CellType.STRING).setCellValue(nv.getDiaChi());
                row.createCell(5, CellType.STRING).setCellValue(nv.getSDT());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Xuất file Excel Khách hàng
    public void xuatFileExcelKhachHang() {
        fd.setTitle("Xuất dữ liệu khách hàng ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Khách hàng");

            QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
            ArrayList<KhachHang> list = qlkhBUS.getDskh();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã khách hàng");
            row.createCell(2, CellType.STRING).setCellValue("Tên khách hàng");
            row.createCell(3, CellType.STRING).setCellValue("Địa chỉ");
            row.createCell(4, CellType.STRING).setCellValue("Số điện thoại");

            for (KhachHang kh : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(kh.getMaKH());
                row.createCell(2, CellType.STRING).setCellValue(kh.getTenKH());
                row.createCell(3, CellType.STRING).setCellValue(kh.getDiaChi());
                row.createCell(4, CellType.STRING).setCellValue(kh.getSDT());

            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Xuất file Excel Tài khoản
    public void xuatFileExcelTaiKhoan() {
        fd.setTitle("Xuất dữ liệu tài khoản ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Tài khoản");

            QuanLyTaiKhoanBUS qltkBUS = new QuanLyTaiKhoanBUS();
            QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
            ArrayList<TaiKhoan> list = qltkBUS.getDstk();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Tên tài khoản");
            row.createCell(2, CellType.STRING).setCellValue("Mật khẩu");
            row.createCell(3, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(4, CellType.STRING).setCellValue("Loại quyền");

            for (TaiKhoan tk : list) {
                rownum++;
                row = sheet.createRow(rownum);

                String manv = tk.getMaNV();
                String loaiq = tk.getLoaiQuyen();

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(tk.getUsername());
                row.createCell(2, CellType.STRING).setCellValue(tk.getPassword());
                row.createCell(3, CellType.STRING).setCellValue(manv + " - " + qlnvBUS.getNhanVien(manv).getTenNV());
                row.createCell(4, CellType.STRING).setCellValue(loaiq);
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    // Xuất file Excel Sản phẩm
    public void xuatFileExcelSanPham() {
        fd.setTitle("Xuất dữ liệu sản phẩm ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Sản phẩm");

            QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
            QuanLyLoaiSanPhamBUS qllsp = new QuanLyLoaiSanPhamBUS();
            QuanLyTacGiaBUS qltg = new QuanLyTacGiaBUS();
            QuanLyNhaXuatBanBUS qlnxb = new QuanLyNhaXuatBanBUS();
            ArrayList<SanPham> list = qlspBUS.getDssp();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã sản phẩm");
            row.createCell(2, CellType.STRING).setCellValue("Loại sản phẩm");
            row.createCell(3, CellType.STRING).setCellValue("Tên");
            row.createCell(4, CellType.NUMERIC).setCellValue("Đơn giá");
            row.createCell(5, CellType.NUMERIC).setCellValue("Số lượng");
            row.createCell(6, CellType.STRING).setCellValue("Hình ảnh");
            row.createCell(7, CellType.STRING).setCellValue("Tác giả");
            row.createCell(8, CellType.STRING).setCellValue("Nhà xuất bản");

            for (SanPham sp : list) {
                rownum++;
                row = sheet.createRow(rownum);

                String maloai = sp.getMaLSP();
                String matg = sp.getMaTG();
                String manxb = sp.getMaNXB();

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(sp.getMaSP());
                row.createCell(2, CellType.STRING).setCellValue(maloai + " - " + qllsp.getLoaiSanPham(maloai).getTenLSP());
                row.createCell(3, CellType.STRING).setCellValue(sp.getTenSP());
                row.createCell(4, CellType.NUMERIC).setCellValue(sp.getDonGia());
                row.createCell(5, CellType.NUMERIC).setCellValue(sp.getSoLuong());
                row.createCell(6, CellType.STRING).setCellValue(String.valueOf(sp.getFileNameHinhAnh()));
                row.createCell(7, CellType.STRING).setCellValue(matg + " - " + qltg.getTacGia(matg).getTenTG());
                row.createCell(8, CellType.STRING).setCellValue(manxb + " - " + qlnxb.getNhaXuatBan(manxb).getTenNXB());

            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Xuất file Excel Loại sản phẩm
    public void xuatFileExcelLoaiSanPham() {
        fd.setTitle("Xuất dữ liệu loại sản phẩm ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Loại sản phẩm");

            QuanLyLoaiSanPhamBUS qllspBUS = new QuanLyLoaiSanPhamBUS();
            ArrayList<LoaiSanPham> list = qllspBUS.getDslsp();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã Loại");
            row.createCell(2, CellType.STRING).setCellValue("Tên loại");
            row.createCell(3, CellType.STRING).setCellValue("Mô tả");

            for (LoaiSanPham lsp : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(lsp.getMaLSP());
                row.createCell(2, CellType.STRING).setCellValue(lsp.getTenLSP());
                row.createCell(3, CellType.STRING).setCellValue(lsp.getMoTa());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    // Xuất file Excel Tác giả
    public void xuatFileExcelTacGia() {
        fd.setTitle("Xuất dữ liệu tác giả ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Tác giả");

            QuanLyTacGiaBUS qltgBUS = new QuanLyTacGiaBUS();
            ArrayList<TacGia> list = qltgBUS.getDstg();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã tác giả");
            row.createCell(2, CellType.STRING).setCellValue("Tên tác giả");
            row.createCell(3, CellType.STRING).setCellValue("Mô tả");

            for (TacGia tg : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(tg.getMaTG());
                row.createCell(2, CellType.STRING).setCellValue(tg.getTenTG());
                row.createCell(3, CellType.STRING).setCellValue(tg.getMoTa());
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

 
    // Xuất file Excel Hóa đơn
    public void xuatFileExcelHoaDon() {
        fd.setTitle("Xuất dữ liệu hóa đơn ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Hóa đơn");

            QuanLyHoaDonBUS qlhdBUS = new QuanLyHoaDonBUS();
            QuanLyChiTietHoaDonBUS qlcthdBUS = new QuanLyChiTietHoaDonBUS();
            QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
            QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
            QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
            ArrayList<HoaDon> list = qlhdBUS.getDshd();

            int rownum = 0;
            int sttHoaDon = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã hóa đơn");
            row.createCell(2, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(3, CellType.STRING).setCellValue("Mã khách hàng");
            row.createCell(4, CellType.STRING).setCellValue("Ngày lập");
            row.createCell(5, CellType.STRING).setCellValue("Tổng tiền");

            row.createCell(6, CellType.STRING).setCellValue("Sản phẩm");
            row.createCell(7, CellType.STRING).setCellValue("Số lượng");
            row.createCell(8, CellType.STRING).setCellValue("Đơn giá");
            row.createCell(9, CellType.STRING).setCellValue("Thành tiền");

            for (HoaDon hd : list) {
                rownum++;
                sttHoaDon++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(sttHoaDon);
                row.createCell(1, CellType.STRING).setCellValue(hd.getMaHoaDon());
                row.createCell(2, CellType.STRING).setCellValue(hd.getMaNhanVien() + " - " + qlnvBUS.getNhanVien(hd.getMaNhanVien()).getTenNV());
                row.createCell(3, CellType.STRING).setCellValue(hd.getMaKhachHang() + " - " + qlkhBUS.getKhachHang(hd.getMaKhachHang()).getTenKH());
                row.createCell(4, CellType.STRING).setCellValue(String.valueOf(hd.getNgayLap()));
                row.createCell(5, CellType.NUMERIC).setCellValue(hd.getTongTien());

                for (ChiTietHoaDon cthd : qlcthdBUS.getAllChiTiet(hd.getMaHoaDon())) {
                    rownum++;
                    row = sheet.createRow(rownum);

                    String masp = cthd.getMaSanPham();

                    row.createCell(6, CellType.STRING).setCellValue(masp + " - " + qlspBUS.getSanPham(masp).getTenSP());
                    row.createCell(7, CellType.NUMERIC).setCellValue(cthd.getSoLuong());
                    row.createCell(8, CellType.NUMERIC).setCellValue(cthd.getDonGia());
                    row.createCell(9, CellType.NUMERIC).setCellValue(cthd.getDonGia() * cthd.getSoLuong());
                }
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Xuất file Excel Phiếu nhập
    public void xuatFileExcelPhieuNhap() {
        fd.setTitle("Xuất dữ liệu phiếu nhập ra excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileOutputStream outFile = null;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Hóa đơn");

            QuanLyPhieuNhapBUS qlpnBUS = new QuanLyPhieuNhapBUS();
            QuanLyChiTietPhieuNhapBUS qlctpnBUS = new QuanLyChiTietPhieuNhapBUS();
            QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
            QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
            QuanLyNhaCungCapBUS qlnccBUS = new QuanLyNhaCungCapBUS();
            ArrayList<PhieuNhap> list = qlpnBUS.getDspn();

            int rownum = 0;
            Row row = sheet.createRow(rownum);

            row.createCell(0, CellType.NUMERIC).setCellValue("STT");
            row.createCell(1, CellType.STRING).setCellValue("Mã phiếu nhập");
            row.createCell(2, CellType.STRING).setCellValue("Mã nhà cung cấp");
            row.createCell(3, CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(4, CellType.STRING).setCellValue("Ngày lập");
            row.createCell(5, CellType.STRING).setCellValue("Tổng tiền");
            row.createCell(6, CellType.STRING).setCellValue("Sản phẩm");
            row.createCell(7, CellType.STRING).setCellValue("Số lượng");
            row.createCell(8, CellType.STRING).setCellValue("Đơn giá");
            row.createCell(9, CellType.STRING).setCellValue("Thành tiền");

            for (PhieuNhap pn : list) {
                rownum++;
                row = sheet.createRow(rownum);

                row.createCell(0, CellType.NUMERIC).setCellValue(rownum);
                row.createCell(1, CellType.STRING).setCellValue(pn.getMaPN());
                row.createCell(2, CellType.STRING).setCellValue(pn.getMaNCC() + " - " + qlnccBUS.getNhaCungCap(pn.getMaNCC()).getTenNCC());
                row.createCell(3, CellType.STRING).setCellValue(pn.getMaNV() + " - " + qlnvBUS.getNhanVien(pn.getMaNV()).getTenNV());
                row.createCell(4, CellType.STRING).setCellValue(String.valueOf(pn.getNgayNhap()));
                row.createCell(5, CellType.NUMERIC).setCellValue(pn.getTongTien());

                for (ChiTietPhieuNhap ctpn : qlctpnBUS.getAllChiTiet(pn.getMaPN())) {
                    rownum++;
                    row = sheet.createRow(rownum);

                    String masp = ctpn.getMaSP();

                    row.createCell(6, CellType.STRING).setCellValue(masp + " - " + qlspBUS.getSanPham(masp).getTenSP());
                    row.createCell(7, CellType.NUMERIC).setCellValue(ctpn.getSoLuong());
                    row.createCell(8, CellType.NUMERIC).setCellValue(ctpn.getDonGia());
                    row.createCell(9, CellType.NUMERIC).setCellValue(ctpn.getDonGia() * ctpn.getSoLuong());
                }
            }
            for (int i = 0; i < rownum; i++) {
                sheet.autoSizeColumn(i);
            }

            File file = new File(url);
            file.getParentFile().mkdirs();
            outFile = new FileOutputStream(file);
            workbook.write(outFile);

            JOptionPane.showMessageDialog(null, "Ghi file thành công: " + file.getAbsolutePath());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outFile != null) {
                    outFile.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private String getTime() {
        return new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
    }
}
