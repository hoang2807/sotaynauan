package sotaynauan.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sotaynauan.model.MonAn;
import sotaynauan.service.MonAnService;
import sotaynauan.service.MonAnServiceImpl;

/**
 *
 * @author hoang
 */
public class monanController {

    private JButton btnSubmit;
    private JButton btnEdit;
    private JButton btnDelete;
    private JTextField jtfTenMon;
    private JTextArea jtaNguyenLieu;
    private JTextArea jtaCachLam;
    private JTextField jtfLoai;
    private JLabel jlbMSG;

    private MonAn monan = null;
    private MonAnService monanService = null;

    public monanController(JButton btnSubmit, JButton btnEdit, JButton btnDelete, JTextField jtfTenMon, JTextArea jtaNguyenLieu, JTextArea jtaCachLam, JTextField jtfLoai, JLabel jlbMSG) {
        this.btnSubmit = btnSubmit;
        this.btnEdit=btnEdit;
        this.btnDelete=btnDelete;
        this.jtfTenMon = jtfTenMon;
        this.jtaNguyenLieu = jtaNguyenLieu;
        this.jtaCachLam = jtaCachLam;
        this.jtfLoai = jtfLoai;
        this.jlbMSG = jlbMSG;

        this.monanService = new MonAnServiceImpl();
    }

    public void setView(MonAn monan) {
        this.monan = monan;
        jtfTenMon.setText(monan.getTenmon());
        jtaNguyenLieu.setText(monan.getNguyenLieu());
        jtaCachLam.setText(monan.getCachlam());
        jtfLoai.setText(monan.getLoai());
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (jtfTenMon.getText().length() == 0) {
                    jlbMSG.setText("Nhap ten mon la bat buoc");
                } else {
                    monan.setTenmon(jtfTenMon.getText());
                    monan.setNguyenLieu(jtaNguyenLieu.getText());
                    monan.setCachlam(jtaCachLam.getText());
                    monan.setLoai(jtfLoai.getText());
                    if (showDialog()) {
                        int result = monanService.createOrUpdate(monan);
                        if (result != 0) {
                            monan.setIDmon(result);
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
                monan.setTenmon(jtfTenMon.getText());
                monan.setNguyenLieu(jtaNguyenLieu.getText());
                monan.setCachlam(jtaCachLam.getText());
                monan.setLoai(jtfLoai.getText());
                 if (showDialog()) {
                        int result = monanService.Edit(monan);
                        
                    }
            }

        });
         btnDelete.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                monan.setTenmon(jtfTenMon.getText());
                if (showDialog()) {
                        int result = monanService.Delete(monan);
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
