/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author hoang
 */
public class changepass {

    public static boolean update(String password, String username) {
        try {
            PreparedStatement ps = null;
            Connection con = DB.getConnection();
            String sql = "update user set password=? where username=?";

            ps = con.prepareCall(sql);
            ps.setString(1, password);
            ps.setString(2, username);
//            boolean check=ps.execute();
            int i = ps.executeUpdate();
            if (i > 0) {
                return true;
            }
            ps.close();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
