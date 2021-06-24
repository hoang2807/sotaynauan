/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.service;

import sotaynauan.dao.TaiKhoanDAO;
import sotaynauan.dao.TaiKhoanDAOImpl;
import sotaynauan.model.TaiKhoan;

/**
 *
 * @author hoang
 */
public class TaiKhoanServiceImpl implements TaiKhoanService{
    private TaiKhoanDAO taikhoanDAO=null;
    public TaiKhoanServiceImpl(){
        taikhoanDAO=new TaiKhoanDAOImpl();
    }
    @Override
    public TaiKhoan Login(String username, String password) {
        return taikhoanDAO.login(username, password);
    }

    @Override
    public int logout(String username, String password) {
        return taikhoanDAO.logout(username, password);
    }
    
}
