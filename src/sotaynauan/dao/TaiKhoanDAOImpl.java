/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sotaynauan.model.TaiKhoan;

/**
 *
 * @author hoang
 */
public class TaiKhoanDAOImpl implements TaiKhoanDAO{

    @Override
    public TaiKhoan login(String username, String password) {
        Connection con = DB.getConnection();
        String sql = "SELECT * FROM user WHERE Username LIKE ?  AND Password LIKE ?";
        TaiKhoan taiKhoan = null;
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new TaiKhoan();
                taiKhoan.setPassword(rs.getString("Password"));
                taiKhoan.setUsername(rs.getString("Username"));
            }
            ps.close();
            con.close();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int logout(String username, String password) {
        Connection con = DB.getConnection();
        String sql = "update user set Password = ? where Username=?";
        try{
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, username);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            rs.close();
            con.close();
            return generatedKey;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
}
