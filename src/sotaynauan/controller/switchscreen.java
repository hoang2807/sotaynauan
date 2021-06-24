
package sotaynauan.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.JLabel;
import sotaynauan.bean.DanhMucBean;
import sotaynauan.view.QuanLyMonAn;
import sotaynauan.view.QuanLyNguyenLieu;
import sotaynauan.view.QuanLyTaiKhoan;
import sotaynauan.view.ThucDonForm;

/**
 *
 * @author hoang
 */
public class switchscreen {
    private JPanel root;
    private String kindSelecter="";
    
    private List <DanhMucBean> listItem=null;
    public switchscreen(JPanel root){
        this.root=root;
    }
    public void setView(JPanel jpnItem,JLabel jblItem){
        kindSelecter="QuanLyMonAn";
        jpnItem.setBackground(new Color(96,100,191));
        jblItem.setBackground(new Color(96,100,191));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new QuanLyMonAn());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List <DanhMucBean> listItem){
        this.listItem=listItem;
        for(DanhMucBean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(),item.getJpn(),item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind){
                case "QuanLyMonAn":
                    node =new QuanLyMonAn();
                    break;
                case "QuanLyNguyenLieu":
                    node=new QuanLyNguyenLieu();
                    break;
                case "ThucDon":
                    node= new ThucDonForm();
                    break;
                case "TaiKhoan":
                    node =new QuanLyTaiKhoan();
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelecter=kind;
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
             
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelecter.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(76,175,80));
                jlbItem.setBackground(new Color(76,175,80));
            }
        }
        
    }
    private void setChangeBackground(String kind){
        for(DanhMucBean item:listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
            }else{
                item.getJpn().setBackground(new Color(76,175,80));
                item.getJlb().setBackground(new Color(76,175,80));
            }
        }
    }
}
