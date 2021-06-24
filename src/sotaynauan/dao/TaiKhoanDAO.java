
package sotaynauan.dao;

import sotaynauan.model.TaiKhoan;



/**
 *
 * @author hoang
 */
public interface TaiKhoanDAO {
    public TaiKhoan login(String username,String password);
    public int logout(String username,String password);
}
