/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.service;

import java.util.List;
import sotaynauan.model.NguyenLieu;

/**
 *
 * @author hoang
 */
public interface NguyenLieuService {
    public List<NguyenLieu> getList();
    public int createOrUpdate(NguyenLieu nguyenlieu);
    public int Edit(NguyenLieu nguyenlieu);
    public int Delete(NguyenLieu nguyenlieu);
}
