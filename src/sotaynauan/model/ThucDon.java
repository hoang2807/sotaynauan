
package sotaynauan.model;

import java.util.Date;

/**
 *
 * @author hoang
 */
public class ThucDon {
    private int IDthucdon;
    private String Tenthucdon;
    private Date Ngaytaothucdon;
    private String Creator;

    public void setIDthucdon(int IDthucdon) {
        this.IDthucdon = IDthucdon;
    }

    public void setTenthucdon(String Tenthucdon) {
        this.Tenthucdon = Tenthucdon;
    }

    public void setNgaytaothucdon(Date Ngaytaothucdon) {
        this.Ngaytaothucdon = Ngaytaothucdon;
    }

    public void setCreator(String Creator) {
        this.Creator = Creator;
    }

    public int getIDthucdon() {
        return IDthucdon;
    }

    public String getTenthucdon() {
        return Tenthucdon;
    }

    public Date getNgaytaothucdon() {
        return Ngaytaothucdon;
    }

    public String getCreator() {
        return Creator;
    }
}
