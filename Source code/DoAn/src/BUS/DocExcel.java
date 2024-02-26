package BUS;

import DTO.*;
import GUI.MyTable;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class DocExcel {

    FileDialog fd = new FileDialog(new JFrame(), "Đọc excel", FileDialog.LOAD);

    public DocExcel() {

    }

    private String getFile() {
        fd.setFile("*.xls");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("nullnull")) {
            return null;
        }
        return url;
    }

    //Đọc file excel Nhà cung cấp
    public void docFileExcelNhaCungCap() {
        fd.setTitle("Nhập dữ liệu nhà cung cấp từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String ma = cellIterator.next().getStringCellValue();
                    String ten = cellIterator.next().getStringCellValue();
                    String diachi = cellIterator.next().getStringCellValue();
                    String sdt = cellIterator.next().getStringCellValue();
                    String fax = cellIterator.next().getStringCellValue();

                    QuanLyNhaCungCapBUS qlnccBUS = new QuanLyNhaCungCapBUS();

                    NhaCungCap nccOld = qlnccBUS.getNhaCungCap(ma);
                    if (nccOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Mã", "Tên", "Địa chỉ", "SDT", "Fax"});
                            mtb.addRow(new String[]{
                                "Cũ:", nccOld.getMaNCC(),
                                nccOld.getTenNCC(),
                                nccOld.getDiaChi(),
                                nccOld.getSDT(),
                                nccOld.getFax()
                            });
                            mtb.addRow(new String[]{
                                "Mới:", ma, ten, diachi, sdt, fax
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            qlnccBUS.update(ma, ten, diachi, sdt, fax);
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }
                    } else {
                        NhaCungCap ncc = new NhaCungCap(ma, ten, diachi, sdt, fax);
                        qlnccBUS.add(ncc);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }
    
    //Đọc file excel Nhà xuất bản
    public void docFileExcelNhaXuatBan() {
        fd.setTitle("Nhập dữ liệu nhà xuất bản từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String ma = cellIterator.next().getStringCellValue();
                    String ten = cellIterator.next().getStringCellValue();
                    String diachi = cellIterator.next().getStringCellValue();

                    QuanLyNhaXuatBanBUS qlnxbBUS = new QuanLyNhaXuatBanBUS();

                    NhaXuatBan nxbOld = qlnxbBUS.getNhaXuatBan(ma);
                    if (nxbOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Mã", "Tên", "Địa chỉ"});
                            mtb.addRow(new String[]{
                                "Cũ:", nxbOld.getMaNXB(),
                                nxbOld.getTenNXB(),
                                nxbOld.getDiaChi()
                                
                            });
                            mtb.addRow(new String[]{
                                "Mới:", ma, ten, diachi
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            qlnxbBUS.update(ma, ten, diachi);
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }
                    } else {
                        NhaXuatBan nxb = new NhaXuatBan(ma, ten, diachi);
                        qlnxbBUS.add(nxb);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }


    //Đọc file excel Tài khoản
    public void docFileExcelTaiKhoan() {
        fd.setTitle("Nhập dữ liệu tài khoản từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String taikhoan = cellIterator.next().getStringCellValue();
                    String matkhau = cellIterator.next().getStringCellValue();
                    String manv = cellIterator.next().getStringCellValue().split(" - ")[0];
                    String loaiquyen = cellIterator.next().getStringCellValue();

                    QuanLyTaiKhoanBUS qltkBUS = new QuanLyTaiKhoanBUS();
                    TaiKhoan tkOld = qltkBUS.getTaiKhoan(taikhoan);

                    if (tkOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Tên tài khoản", "Mật khẩu", "Mã nhân viên", "Loại quyền"});
                            mtb.addRow(new String[]{
                                "Cũ:", tkOld.getUsername(),
                                tkOld.getPassword(),
                                tkOld.getMaNV(),
                                tkOld.getLoaiQuyen(),});
                            mtb.addRow(new String[]{
                                "Mới:", taikhoan, matkhau, manv, loaiquyen
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            qltkBUS.update(taikhoan, matkhau, manv, loaiquyen);
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }
                    } else {
                        TaiKhoan tk = new TaiKhoan(taikhoan, matkhau, manv, loaiquyen);
                        qltkBUS.add(tk);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }

    //Đọc file excel Khách hàng
    public void docFileExcelKhachhang() {
        fd.setTitle("Nhập dữ liệu khách hàng từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String ma = cellIterator.next().getStringCellValue();
                    String ten = cellIterator.next().getStringCellValue();
                    String diachi = cellIterator.next().getStringCellValue();
                    String sdt = cellIterator.next().getStringCellValue();

                    QuanLyKhachHangBUS qlkhBUS = new QuanLyKhachHangBUS();
                    KhachHang khOLD = qlkhBUS.getKhachHang(ma);

                    if (khOLD != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Mã", "Tên", "Địa chỉ", "SDT"});
                            mtb.addRow(new String[]{
                                "Cũ:", khOLD.getMaKH(),
                                khOLD.getTenKH(),
                                khOLD.getDiaChi(),
                                khOLD.getSDT(),

                            });
                            mtb.addRow(new String[]{
                                "Mới:", ma, ten, diachi, sdt, 
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            qlkhBUS.update(ma, ten, diachi, sdt);
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }
                    } else {
                        KhachHang kh = new KhachHang(ma, ten, diachi, sdt);
                        qlkhBUS.add(kh);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }

    //Đọc file excel Nhân viên
    public void docFileExcelNhanVien() {
        fd.setTitle("Nhập dữ liệu nhân viên từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String ma = cellIterator.next().getStringCellValue();
                    String ten = cellIterator.next().getStringCellValue();
                    LocalDate ngaysinh = LocalDate.parse(cellIterator.next().getStringCellValue());
                    String diachi = cellIterator.next().getStringCellValue();
                    String sdt = cellIterator.next().getStringCellValue();

                    QuanLyNhanVienBUS qlnvBUS = new QuanLyNhanVienBUS();
                    NhanVien nvOld = qlnvBUS.getNhanVien(ma);

                    if (nvOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Mã", "Tên", "Ngày sinh", "Địa chỉ", "SDT"});
                            mtb.addRow(new String[]{
                                "Cũ:", nvOld.getMaNV(),
                                nvOld.getTenNV(),
                                String.valueOf(nvOld.getNgaySinh()),
                                nvOld.getDiaChi(),
                                nvOld.getSDT(),
                            });
                            mtb.addRow(new String[]{
                                "Mới:", ma, ten, String.valueOf(ngaysinh), diachi, sdt, 
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            qlnvBUS.update(ma, ten, ngaysinh, diachi, sdt);
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }
                    } else {
                        NhanVien nv = new NhanVien(ma, ten, ngaysinh, diachi, sdt);
                        qlnvBUS.add(nv);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }


    //Đọc file excel Sản phẩm
    public void docFileExcelSanPham() {
        fd.setTitle("Nhập dữ liệu sản phẩm từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();
            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String masp = cellIterator.next().getStringCellValue();
                    String maloai = cellIterator.next().getStringCellValue().split(" - ")[0];
                    String tensp = cellIterator.next().getStringCellValue();
                    float dongia = (float) cellIterator.next().getNumericCellValue();
                    int soluong = (int) cellIterator.next().getNumericCellValue();
                    String hinhanh = cellIterator.next().getStringCellValue();
                    String matg = cellIterator.next().getStringCellValue().split(" - ")[0];
                    String manxb = cellIterator.next().getStringCellValue().split(" - ")[0];

                    QuanLySanPhamBUS qlspBUS = new QuanLySanPhamBUS();
                    SanPham spOld = qlspBUS.getSanPham(masp);
                    if (spOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Mã SP", "Mã LSP", "Tên SP", "Đơn giá", "Số lượng", "Hình ảnh", "Mã TG", "Mã NXB"});
                            mtb.addRow(new String[]{
                                "Cũ:", spOld.getMaSP(),
                                spOld.getMaLSP(),
                                spOld.getTenSP(),
                                String.valueOf(spOld.getDonGia()),
                                String.valueOf(spOld.getSoLuong()),
                                spOld.getFileNameHinhAnh(),
                                spOld.getMaTG(),
                                spOld.getMaNXB()
                            });
                            mtb.addRow(new String[]{
                                "Mới:", masp, maloai, tensp, String.valueOf(dongia), String.valueOf(soluong), hinhanh, matg, manxb
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            qlspBUS.update(masp, maloai, tensp, dongia, soluong, hinhanh, matg, manxb);
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }
                    } else {
                        SanPham sp = new SanPham(masp, maloai, tensp, dongia, soluong, hinhanh, matg, manxb);
                        qlspBUS.add(sp);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }

    //Đọc file excel Loại sản phẩm
    public void docFileExcelLoaiSanPham() {
        fd.setTitle("Nhập dữ liệu loại sản phẩm từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String ma = cellIterator.next().getStringCellValue();
                    String ten = cellIterator.next().getStringCellValue();
                    String mota = cellIterator.next().getStringCellValue();

                    QuanLyLoaiSanPhamBUS qllspBUS = new QuanLyLoaiSanPhamBUS();
                    LoaiSanPham lspOld = qllspBUS.getLoaiSanPham(ma);

                    if (lspOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Mã", "Tên", "Mô tả"});
                            mtb.addRow(new String[]{
                                "Cũ:", lspOld.getMaLSP(),
                                lspOld.getTenLSP(),
                                lspOld.getMoTa(),});
                            mtb.addRow(new String[]{
                                "Mới:", ma, ten, mota
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            qllspBUS.update(ma, ten, mota);
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }
                    } else {
                        LoaiSanPham lsp = new LoaiSanPham(ma, ten, mota);
                        qllspBUS.add(lsp);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }
    
    // Đọc file excel Tác giả
    public void docFileExcelTacGia() {
        fd.setTitle("Nhập dữ liệu tác giả từ excel");
        String url = getFile();
        if (url == null) {
            return;
        }

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(url));

            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            Row row1 = rowIterator.next();

            String hanhDongKhiTrung = "";
            int countThem = 0;
            int countGhiDe = 0;
            int countBoQua = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    int stt = (int) cellIterator.next().getNumericCellValue();
                    String ma = cellIterator.next().getStringCellValue();
                    String ten = cellIterator.next().getStringCellValue();
                    String mota = cellIterator.next().getStringCellValue();

                    QuanLyTacGiaBUS qltgBUS = new QuanLyTacGiaBUS();
                    TacGia tgOld = qltgBUS.getTacGia(ma);

                    if (tgOld != null) {
                        if (!hanhDongKhiTrung.contains("tất cả")) {
                            MyTable mtb = new MyTable();
                            mtb.setHeaders(new String[]{"", "Mã", "Tên", "Mô tả"});
                            mtb.addRow(new String[]{
                                "Cũ:", tgOld.getMaTG(),
                                tgOld.getTenTG(),
                                tgOld.getMoTa(),});
                            mtb.addRow(new String[]{
                                "Mới:", ma, ten, mota
                            });

                            MyJOptionPane mop = new MyJOptionPane(mtb, hanhDongKhiTrung);
                            hanhDongKhiTrung = mop.getAnswer();
                        }
                        if (hanhDongKhiTrung.contains("Ghi đè")) {
                            qltgBUS.update(ma, ten, mota);
                            countGhiDe++;
                        } else {
                            countBoQua++;
                        }
                    } else {
                        TacGia tg = new TacGia(ma, ten, mota);
                        qltgBUS.add(tg);
                        countThem++;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Đọc thành công, "
                    + "Thêm " + countThem
                    + "; Ghi đè " + countGhiDe
                    + "; Bỏ qua " + countBoQua
                    + ". Vui lòng làm mới để thấy kết quả");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nhập dữ liệu từ file: " + ex.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi khi đóng inputstream: " + ex.getMessage());
            }
        }
    }
}
