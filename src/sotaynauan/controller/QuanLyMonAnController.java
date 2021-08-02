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
import javax.swing.table.TableRowSorter;
import javax.swing.text.TableView;
import sotaynauan.model.MonAn;
import sotaynauan.service.MonAnService;
import sotaynauan.service.MonAnServiceImpl;
import sotaynauan.utility.ClassTableModelMonAn;
import sotaynauan.view.MonAnJFrame;
import sotaynauan.model.MonAn;
/**
 *
 * @author hoang
 */
public class QuanLyMonAnController {

    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;

    private MonAnService monanService = null;
    private String[] listColumn = {"STT", "Ten mon", "Cach lam", "Loai"};
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyMonAnController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;

        this.monanService = new MonAnServiceImpl();
    }

    public void setDateToTable() {
        List<MonAn> listItem = monanService.getList();
        DefaultTableModel model = new ClassTableModelMonAn().setTableMonAn(listItem, listColumn);
        JTable table = new JTable(model);

        rowSorter = new TableRowSorter<>(table.getModel());
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
        //table.getColumnModel().getColumn(0).setMaxWidth(80);
        //table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setMaxWidth(150);
        table.getColumnModel().getColumn(0).setMinWidth(150);
        table.getColumnModel().getColumn(1).setMaxWidth(300);
        table.getColumnModel().getColumn(1).setMinWidth(300);
        table.getColumnModel().getColumn(2).setMaxWidth(800);
        table.getColumnModel().getColumn(2).setMinWidth(800);
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
                    System.out.println(selectedRowIndex);

                    MonAn monan = new MonAn();
                    monan.setTenmon(model.getValueAt(selectedRowIndex, 1).toString());
//                    monan.setNguyenLieu(model.getValueAt(selectedRowIndex, 2) != null ? model.getValueAt(selectedRowIndex, 2).toString() : "");
                    monan.setCachlam(model.getValueAt(selectedRowIndex, 2) != null ? model.getValueAt(selectedRowIndex, 2).toString() : "");
                    monan.setLoai(model.getValueAt(selectedRowIndex, 3) != null ? model.getValueAt(selectedRowIndex, 3).toString() : "");
                    MonAnJFrame frame = new MonAnJFrame(monan);
                    frame.setTitle("Thong tin mon an");;
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
                MonAnJFrame frame=new MonAnJFrame(new MonAn());
                frame.setTitle("Thong tin mon an");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            
        });
        
    }
}
