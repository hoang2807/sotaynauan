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
public class ThanhPhan {
    private int IDthanhphan;
    private int IDmonan;
    private int IDnguyenlieu;

    public ThanhPhan(int IDthanhphan, int IDmonan, int IDnguyenlieu) {
        this.IDthanhphan = IDthanhphan;
        this.IDmonan = IDmonan;
        this.IDnguyenlieu = IDnguyenlieu;
    }

    public int getIDthanhphan() {
        return IDthanhphan;
    }

    public int getIDmonan() {
        return IDmonan;
    }

    public int getIDnguyenlieu() {
        return IDnguyenlieu;
    }

    public void setIDthanhphan(int IDthanhphan) {
        this.IDthanhphan = IDthanhphan;
    }

    public void setIDmonan(int IDmonan) {
        this.IDmonan = IDmonan;
    }

    public void setIDnguyenlieu(int IDnguyenlieu) {
        this.IDnguyenlieu = IDnguyenlieu;
    }
    
   
}
