
package sotaynauan.dao;

import java.util.List;

import sotaynauan.model.NguyenLieu;

/**
 *
 * @author hoang
 */
public interface NguyenLieuDAO {
    public List<NguyenLieu> getList();
    public int createOrUpdate(NguyenLieu nguyenlieu);
    public int Edit(NguyenLieu nguyenlieu);
    public int Delete(NguyenLieu nguyenlieu);
}
