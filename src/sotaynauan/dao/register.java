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
public class register {
    public static void create(String username, String password){
        try {
            PreparedStatement ps = null;
            Connection con = DB.getConnection();
            String sql = "insert into user(Username,Password) values(?,?)";

            ps = con.prepareCall(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
