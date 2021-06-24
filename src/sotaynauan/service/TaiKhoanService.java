
package sotaynauan.service;

import sotaynauan.model.TaiKhoan;

/**
 *
 * @author hoang
 */
public interface TaiKhoanService {
    public TaiKhoan Login(String username, String password);
    public int logout(String username, String password);
}
