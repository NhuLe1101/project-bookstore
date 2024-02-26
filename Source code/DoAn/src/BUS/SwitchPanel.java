
package BUS;

import DTO.DanhMuc;
import GUI.BanHangPanel;
import GUI.HoaDonPanel;
import GUI.KhachHangPanel;
import GUI.NXBPanel;
import GUI.NhaCungCapPanel;
import GUI.NhanVienPanel;
import GUI.NhapHangPanel;
import GUI.PhieuNhapPanel;
import GUI.SanPhamPanel;
import GUI.TacGiaPanel;
import GUI.TaiKhoanPanel;
import GUI.TheLoaiPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;
import static org.apache.poi.ss.usermodel.FormulaError.NULL;
import org.w3c.dom.events.MouseEvent;


public class SwitchPanel {
    JPanel home;
    String kindSelected="";
    ArrayList<DanhMuc> list;

    public SwitchPanel(JPanel home) {
        this.home = home;
    }   
    
    public void setView (JPanel pn, JLabel lb ){
        
        pn.setBackground(Color.ORANGE);
        
        home.removeAll();
        home.setLayout(new BorderLayout());
        home.add(new SanPhamPanel());
        home.validate();
        home.repaint();
        
    }
    
    public void setEvent (ArrayList<DanhMuc> list){
        this.list = list;
        
        for (DanhMuc dm : list){
            dm.getLb().addMouseListener(new labelEvent(dm.getKind(),dm.getPn(),dm.getLb()));
        }
            
        
    }
    
    
    class labelEvent implements MouseListener {
        private JPanel pnContent = null;
        
        private String kind;
        private JPanel pn;
        private JLabel lb;

        public labelEvent(String kind, JPanel pn, JLabel lb) {
            this.kind = kind;
            this.pn = pn;
            this.lb = lb;
        }

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            
            switch(kind){
                case "Bán hàng":
                    pnContent = new BanHangPanel();
                    break;
                case "Nhập hàng":
                    pnContent = new NhapHangPanel();
                    break;
                case "Sản phẩm":
                    pnContent = new SanPhamPanel();
                    break;
                case "Thể loại":
                    pnContent = new TheLoaiPanel();
                    break;
                case "Tác giả":
                    pnContent = new TacGiaPanel();
                    break;
                case "Nhà xuất bản":
                    pnContent = new NXBPanel();
                    break;
                case "Hóa đơn":
                    pnContent = new HoaDonPanel();
                    break;
                case "Phiếu nhập":
                    pnContent = new PhieuNhapPanel();
                    break;
                case "Nhân viên":
                    pnContent = new NhanVienPanel();
                    break;
                case "Khách hàng":
                    pnContent = new KhachHangPanel();
                    break;
                case "Nhà cung cấp":
                    pnContent = new NhaCungCapPanel();
                    break;
                case "Tài khoản":
                    pnContent = new TaiKhoanPanel();
                    break;
                default:
                    break;

            }
                kindSelected = kind;
                pn.setBackground(Color.ORANGE);
                setBG(kind);
                home.removeAll();
                home.setLayout(new BorderLayout());
                home.add(pnContent);
                home.validate();
                home.repaint();

        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
//            kindSelected = kind;
//            pn.setBackground(Color.ORANGE);
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            pn.setBackground(Color.ORANGE);
            lb.setForeground(Color.BLACK);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            if(!kindSelected.equals(kind)){
                pn.setBackground(new Color(46,134,222));
                lb.setForeground(new Color(255,255,255));
            }
        }
    }
    private void setBG (String kind){
        for(DanhMuc dm: list){
            if(dm.getKind().equals(kind)){
               dm.getPn().setBackground(Color.ORANGE);
               dm.getLb().setForeground(Color.BLACK);
            }
            else{
               dm.getPn().setBackground(new Color(46,134,222));
               dm.getLb().setForeground(new Color(255,255,255));
            }
        }
    }
}


