/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.model;

/**
 *
 * @author hoang
 */
public class ThucDonMonAn {
    private int IDthucdonmonan;
    private int IDmonan;
    private int IDthucdon;
    private String loai;

    public int getIDthucdonmonan() {
        return IDthucdonmonan;
    }

    public int getIDmonan() {
        return IDmonan;
    }

    public int getIDthucdon() {
        return IDthucdon;
    }

    public String getLoai() {
        return loai;
    }

    public void setIDthucdonmonan(int IDthucdonmonan) {
        this.IDthucdonmonan = IDthucdonmonan;
    }

    public void setIDmonan(int IDmonan) {
        this.IDmonan = IDmonan;
    }

    public void setIDthucdon(int IDthucdon) {
        this.IDthucdon = IDthucdon;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }
    
    
}
