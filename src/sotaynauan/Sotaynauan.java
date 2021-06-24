/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan;

import sotaynauan.view.LoginJDialog;
import sotaynauan.view.Main;
/**
 *
 * @author hoang
 */
public class Sotaynauan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        new Main().setVisible(true);
        LoginJDialog login=new LoginJDialog(null,true);
        login.setTitle("Dang nhap");
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        
    }
    
}
