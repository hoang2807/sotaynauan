
package sotaynauan.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sotaynauan.model.NguyenLieu;
import sotaynauan.service.NguyenLieuService;
import sotaynauan.service.NguyenLieuServiceImpl;

/**
 *
 * @author hoang
 */
public class nguyenlieuController {
    private JButton btnSubmit;
    private JButton btnEdit;
    private JButton btnDelete;
    private JTextField jtfTenNguyenLieu;
    private JLabel jlbMSG;
    
    private NguyenLieu nguyenlieu=null;
    private NguyenLieuService nguyenlieuService = null;
    public nguyenlieuController(JButton btnSubmit, JButton btnEdit, JButton btnDelete,JTextField jtfTenNguyenLieu,JLabel jlbMSG) {
        this.btnSubmit = btnSubmit;
        this.btnEdit=btnEdit;
        this.btnDelete=btnDelete;
        this.jtfTenNguyenLieu = jtfTenNguyenLieu;
        this.jlbMSG=jlbMSG;
        
        this.nguyenlieuService=new NguyenLieuServiceImpl();
    }
    public void setView(NguyenLieu nguyenlieu){
        this.nguyenlieu=nguyenlieu;
        jtfTenNguyenLieu.setText(nguyenlieu.getTennguyenlieu());
    }
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfTenNguyenLieu.getText().length() == 0) {
                    jlbMSG.setText("Nhap ten mon la bat buoc");
                } else {
                    nguyenlieu.setTennguyenlieu(jtfTenNguyenLieu.getText());
                    if (showDialog()) {
                        int result = nguyenlieuService.createOrUpdate(nguyenlieu);
                        if (result != 0) {
                            nguyenlieu.setIDnguyenlieu(result);
                            jlbMSG.setText("Xử lý cập nhật dữ liệu thành công!");
                        } else {
                            jlbMSG.setText("Có lỗi xảy ra, vui lòng thử lại!");
                        }
                    }
                }
            }
        });
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nguyenlieu.setTennguyenlieu(jtfTenNguyenLieu.getText());
                
                 if (showDialog()) {
                        int result = nguyenlieuService.Edit(nguyenlieu);
                        
                    }
            }

        });
         btnDelete.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                nguyenlieu.setTennguyenlieu(jtfTenNguyenLieu.getText());
                if (showDialog()) {
                        int result = nguyenlieuService.Delete(nguyenlieu);
                    }
            }
            
        });
    }
   

    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}