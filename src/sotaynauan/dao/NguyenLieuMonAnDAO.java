/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import sotaynauan.model.MonAn;
import sotaynauan.model.NguyenLieu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sotaynauan.model.ThanhPhan;

/**
 *
 * @author hoang
 */
public class NguyenLieuMonAnDAO {

    public static List<MonAn> getListMonAn() {
        Statement st = null;
        try {
            Connection con = DB.getConnection();

            String sql = "select IDmon,Tenmon,Cachlam,Loai from monan";
            List<MonAn> list = new ArrayList<>();
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MonAn monan = new MonAn();
                monan.setIDmon(rs.getInt("IDmon"));
                monan.setTenmon(rs.getString("Tenmon"));
                monan.setCachlam(rs.getString("Cachlam"));
                monan.setLoai(rs.getString("Loai"));
                list.add(monan);
            }

            st.close();
            rs.close();
            con.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static List<NguyenLieu> getListNguyenLieu() {
        Statement st = null;
        try {
            Connection con = DB.getConnection();

            String sql = "select IDnguyenlieu,Tennguyenlieu from nguyenlieu";

            List<NguyenLieu> list = new ArrayList<>();
            st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                NguyenLieu nguyenlieu = new NguyenLieu();
                nguyenlieu.setIDnguyenlieu(rs.getInt("IDnguyenlieu"));
                nguyenlieu.setTennguyenlieu(rs.getString("Tennguyenlieu"));
                list.add(nguyenlieu);
            }
            st.close();
            rs.close();
            con.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void nhapthanhphan(int IDmonan, int IDnguyenlieu) {
        try {
            PreparedStatement ps = null;
            Connection con = DB.getConnection();
            String sql = "insert into thanhphan(IDmonan,IDnguyenlieu) values(?,?)";

            ps = con.prepareCall(sql);
            ps.setInt(1, IDmonan);
            ps.setInt(2, IDnguyenlieu);
            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
