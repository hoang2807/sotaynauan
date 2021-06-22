
package sotaynauan.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author hoang
 */
public class DB {
    public static Connection getConnection(){
        try{
            Connection con=null;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sotaynauan", "root", "thuvienmysql");
            return con;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws SQLException{
        Connection c=getConnection();
        System.err.println(c.toString());
        c.close();
    }
}
