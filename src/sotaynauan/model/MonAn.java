package sotaynauan.model;

/**
 *
 * @author hoang
 */
public class MonAn {

    private int IDmon;

    private String Tenmon;
    private String Cachlam;
    private String NguyenLieu;
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

    public void setNguyenLieu(String NguyenLieu) {
        this.NguyenLieu = NguyenLieu;
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

    public String getNguyenLieu() {
        return NguyenLieu;
    }

    public String getLoai() {
        return Loai;
    }

}
