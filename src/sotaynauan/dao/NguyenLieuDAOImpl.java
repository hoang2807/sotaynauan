package sotaynauan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sotaynauan.model.NguyenLieu;
import sotaynauan.dao.DB;

/**
 *
 * @author hoang
 */
public class NguyenLieuDAOImpl implements NguyenLieuDAO {

    @Override
    public List<NguyenLieu> getList() {
        try {
            Connection con = DB.getConnection();
            String sql = "select Tennguyenlieu from nguyenlieu";
            List<NguyenLieu> list = new ArrayList<>();
            PreparedStatement ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NguyenLieu nguyenlieu = new NguyenLieu();
                nguyenlieu.setTennguyenlieu(rs.getString("Tennguyenlieu"));
                list.add(nguyenlieu);
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
    public int createOrUpdate(NguyenLieu nguyenlieu) {
        try {
            Connection cons = DB.getConnection();
            String sql = "INSERT INTO nguyenlieu(Tennguyenlieu) VALUES(?)";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, nguyenlieu.getTennguyenlieu());
            
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
    public int Edit(NguyenLieu nguyenlieu) {
        try {
            Connection cons = DB.getConnection();
            String sql = "Update nguyenlieu set Tennguyenlieu=? where Tennguyenlieu=?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, nguyenlieu.getTennguyenlieu());
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
    public int Delete(NguyenLieu nguyenlieu) {
        try {
            Connection cons = DB.getConnection();
            String sql = "Delete from nguyenlieu where Tennguyenlieu=?";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1,nguyenlieu.getTennguyenlieu());
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
    
    
}

