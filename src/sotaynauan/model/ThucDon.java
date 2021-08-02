package sotaynauan.model;

import java.util.Date;

/**
 *
 * @author hoang
 */
public class ThucDon {

    private int IDthucdon;
    private String Tenthucdon;
    private String Loai;

    public void setIDthucdon(int IDthucdon) {
        this.IDthucdon = IDthucdon;
    }

    public void setTenthucdon(String Tenthucdon) {
        this.Tenthucdon = Tenthucdon;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public int getIDthucdon() {
        return IDthucdon;
    }

    public String getTenthucdon() {
        return Tenthucdon;
    }

}
