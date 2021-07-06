package sotaynauan.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sotaynauan.model.TaiKhoan;
import sotaynauan.service.TaiKhoanService;
import sotaynauan.service.TaiKhoanServiceImpl;
import sotaynauan.view.Main;

/**
 *
 * @author hoang
 */
public class TaiKhoanController {

    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField jtfusername;
    private JPasswordField jtfpassword;
    private JLabel jblMsg;

    private TaiKhoanService taikhoanService = null;

    public TaiKhoanController(JDialog dialog, JButton btnSubmit, JTextField jtfusername, JPasswordField jtfpassword, JLabel jblMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfusername = jtfusername;
        this.jtfpassword = (JPasswordField) jtfpassword;
        this.jblMsg = jblMsg;

        taikhoanService = new TaiKhoanServiceImpl();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfusername.getText().length() == 0 || jtfpassword.getText().length() == 0) {
                    jblMsg.setText("Nhap ten la bat buoc");
                } else {
                    TaiKhoan taikhoan = taikhoanService.Login(jtfusername.getText(), jtfpassword.getText());
                    if(taikhoan==null){
                        jblMsg.setText("Ten dang nhap hoac mat khau khong dung");
                    }else{
                        dialog.dispose();
                        Main frame=new Main();
                        frame.setTitle("So tay nau an");
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        frame.setVisible(true);
                    }
                }
            }

        });
    }
}
