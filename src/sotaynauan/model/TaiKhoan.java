package sotaynauan.model;

/**
 *
 * @author hoang
 */
public class TaiKhoan {

    private int idUser;
    private String Username;
    private String password;
 
    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
