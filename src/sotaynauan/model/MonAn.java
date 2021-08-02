package sotaynauan.model;

/**
 *
 * @author hoang
 */
public class MonAn {

    private int IDmon;

    private String Tenmon;
    private String Cachlam;

    private String Loai;

    @Override
    public String toString() {
        return Tenmon + ", cachlam=" + Cachlam;
    }

    public void setIDmon(int IDmon) {
        this.IDmon = IDmon;
    }

    public void setTenmon(String Tenmon) {
        this.Tenmon = Tenmon;
    }

    public void setCachlam(String Cachlam) {
        this.Cachlam = Cachlam;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public int getIDmon() {
        return IDmon;
    }

    public String getTenmon() {
        return Tenmon;
    }

    public String getCachlam() {
        return Cachlam;
    }

    public String getLoai() {
        return Loai;
    }

}
