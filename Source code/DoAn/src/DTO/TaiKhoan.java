package DTO;

public class TaiKhoan {
    String username, password, maNV, loaiQuyen;
    
    public TaiKhoan(String username, String password, String maNV, String loaiQuyen) {
        this.username = username;
        this.password = password;
        this.maNV = maNV;
        this.loaiQuyen = loaiQuyen;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoaiQuyen() {
        return loaiQuyen;
    }

    public void setLoaiQuyen(String loaiQuyen) {
        this.loaiQuyen = loaiQuyen;
    }
    
}
