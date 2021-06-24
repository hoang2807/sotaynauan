
package sotaynauan.service;

import java.util.List;
import sotaynauan.dao.NguyenLieuDAO;
import sotaynauan.dao.NguyenLieuDAOImpl;
import sotaynauan.model.NguyenLieu;

/**
 *
 * @author hoang
 */
public class NguyenLieuServiceImpl implements NguyenLieuService{
    private NguyenLieuDAO nguyenlieuDAO=null;
    
    public NguyenLieuServiceImpl(){
        nguyenlieuDAO=new NguyenLieuDAOImpl();
    }
    
    @Override
    public List<NguyenLieu> getList() {
        return nguyenlieuDAO.getList();
    }

    @Override
    public int createOrUpdate(NguyenLieu nguyenlieu) {
        return nguyenlieuDAO.createOrUpdate(nguyenlieu);
    }

    @Override
    public int Edit(NguyenLieu nguyenlieu) {
        return nguyenlieuDAO.Edit(nguyenlieu);
    }

    @Override
    public int Delete(NguyenLieu nguyenlieu) {
        return nguyenlieuDAO.Delete(nguyenlieu);
    }
    
}
