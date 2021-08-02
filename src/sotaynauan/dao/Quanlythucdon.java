/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sotaynauan.model.MonAn;
import sotaynauan.model.ThucDon;

/**
 *
 * @author hoang
 */
public class Quanlythucdon {

    public static List<ThucDon> getListThucDon() {
        Statement st = null;
        try {
            Connection con = DB.getConnection();
            
            String sql = "select IDthucdon,Tenthucdon,Loai from thucdon";
            List<ThucDon> list = new ArrayList<>();
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                ThucDon thucdon = new ThucDon();
                thucdon.setIDthucdon(rs.getInt("IDthucdon"));
                thucdon.setTenthucdon(rs.getString("Tenthucdon"));
                thucdon.setLoai(rs.getString("Loai"));
                list.add(thucdon);
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
    
    public static List<MonAn> getListMonAn() {
        Statement st = null;
        try {
            Connection con = DB.getConnection();
            
            String sql = "select IDmon,Tenmon from monan";
            List<MonAn> list = new ArrayList<>();
            st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MonAn monan = new MonAn();
                monan.setIDmon(rs.getInt("IDmon"));
                monan.setTenmon(rs.getString("Tenmon"));
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
    public static void create(String Tenthucdon, String Loai){
        try {
            PreparedStatement ps = null;
            Connection con = DB.getConnection();
            String sql = "insert into thucdon(tenthucdon,Loai) values(?,?)";

            ps = con.prepareCall(sql);
            ps.setString(1, Tenthucdon);
            ps.setString(2, Loai);
            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void update(int IDthucdon, String Tenthucdon,String Loai){
        try {
            PreparedStatement ps = null;
            Connection con = DB.getConnection();
            String sql = "update thucdon set Tenthucdon=?,Loai=? where IDthucdon=?";

            ps = con.prepareCall(sql);
            ps.setString(1, Tenthucdon);
            ps.setString(2, Loai);
            ps.setInt(3, IDthucdon);
            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void delete(int IDthucdon){
        try {
            PreparedStatement ps = null;
            Connection con = DB.getConnection();
            String sql = "delete from thucdon where IDthucdon=?";

            ps = con.prepareCall(sql);
            ps.setInt(1, IDthucdon);
            
            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void taothucdon(int IDmonan, int IDthucdon, String Loai){
        try {
            PreparedStatement ps = null;
            Connection con = DB.getConnection();
            String sql = "insert into thucdonmonan(IDmonan,IDthucdon,Loai) values(?,?,?)";

            ps = con.prepareCall(sql);
            ps.setInt(1, IDmonan);
            ps.setInt(2, IDthucdon);
            ps.setString(3, Loai);
            ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
}
