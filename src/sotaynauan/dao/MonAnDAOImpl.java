
package sotaynauan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import sotaynauan.model.MonAn;

/**
 *
 * @author hoang
 */
public class MonAnDAOImpl implements MonAnDAO{

    @Override
    public List<MonAn> getList() {
        try {
        Connection con=DB.getConnection();
        String sql="select Tenmon,Cachlam,NguyenLieu,Loai from monan";
        List<MonAn> list=new ArrayList<>();
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            MonAn monan=new MonAn();
            //monan.setIDmon(rs.getInt("IDmon"));
            monan.setTenmon(rs.getNString("Tenmon"));
            monan.setCachlam(rs.getNString("Cachlam"));
            monan.setNguyenLieu(rs.getNString("NguyenLieu"));
            monan.setLoai(rs.getNString("Loai"));
            list.add(monan);
        }
        ps.close();
        rs.close();
        con.close();
        return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public int createOrUpdate(MonAn monan) {
        try {
            Connection cons = DB.getConnection();
            String sql = "INSERT INTO monan(TenMon, NguyenLieu, CachLam, Loai) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, monan.getTenmon());
            ps.setString(2,monan.getNguyenLieu());
            ps.setString(3,monan.getCachlam());
            ps.setString(4, monan.getLoai());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            rs.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Edit(MonAn monan) {
        try {
            Connection cons = DB.getConnection();
            String sql = "Update monan set NguyenLieu=?,CachLam=?,Loai=? where TenMon=?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, monan.getNguyenLieu());
            ps.setString(2,monan.getCachlam());
            ps.setString(3, monan.getLoai());
            ps.setString(4,monan.getTenmon());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            rs.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public int Delete(MonAn monan) {
        try {
            Connection cons = DB.getConnection();
            String sql = "Delete from monan where TenMon=?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,monan.getTenmon());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            rs.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    
    public static void main(String[] args){
        MonAnDAO monan=new MonAnDAOImpl();
        System.out.println(monan.getList());
    }
    
}
