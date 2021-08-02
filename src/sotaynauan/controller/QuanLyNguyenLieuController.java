
package sotaynauan.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import sotaynauan.model.NguyenLieu;
import sotaynauan.service.NguyenLieuService;
import sotaynauan.service.NguyenLieuServiceImpl;
import sotaynauan.utility.ClassTableModelNguyenLieu;
import javax.swing.table.TableRowSorter;
import sotaynauan.model.MonAn;
import sotaynauan.view.NguyenLieuJFrame;
/**
 *
 * @author hoang
 */
public class QuanLyNguyenLieuController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private NguyenLieuService nguyenlieuService=null;
    private String[] listColumn={"STT","Ten Nguyen Lieu"};
    private TableRowSorter<TableModel> rowSorter = null;
    public QuanLyNguyenLieuController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.nguyenlieuService=new NguyenLieuServiceImpl();
    }
    public void setDataToTable(){
        List<NguyenLieu> listItem=nguyenlieuService.getList();
        DefaultTableModel model=new ClassTableModelNguyenLieu().setTableNguyenLieu(listItem, listColumn);
        JTable table=new JTable(model);
        
        rowSorter=new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
        table.getColumnModel().getColumn(0).setMaxWidth(150);
        table.getColumnModel().getColumn(0).setMinWidth(150);
        
        
        table.getTableHeader().setFont(new Font("Ubuntu", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectedRowIndex = table.getSelectedRow();
                    selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                    //System.out.println(selectedRowIndex);

                    NguyenLieu nguyenlieu = new NguyenLieu();
                    nguyenlieu.setTennguyenlieu(model.getValueAt(selectedRowIndex, 1).toString());
                    
                    NguyenLieuJFrame frame = new NguyenLieuJFrame(nguyenlieu);
                    frame.setTitle("Thong tin nguyen lieu");;
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            }

        });
        table.validate();
        table.repaint();

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().add(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));

        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane);
        jpnView.validate();
        jpnView.repaint();
    }
    public void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                NguyenLieuJFrame frame=new NguyenLieuJFrame(new NguyenLieu());
                frame.setTitle("Thong tin mon an");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            
        });
        
    }
}

