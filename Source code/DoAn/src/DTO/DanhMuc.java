
package DTO;

import javax.swing.*;

public class DanhMuc {
    private String kind;
    private JPanel pn;
    private JLabel lb;

    public DanhMuc(String kind, JPanel pn, JLabel lb) {
        this.kind = kind;
        this.pn = pn;
        this.lb = lb;
    }

    public DanhMuc() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getPn() {
        return pn;
    }

    public void setPn(JPanel pn) {
        this.pn = pn;
    }

    public JLabel getLb() {
        return lb;
    }

    public void setLb(JLabel lb) {
        this.lb = lb;
    }
    
}
