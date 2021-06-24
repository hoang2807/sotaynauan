
package sotaynauan.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import sotaynauan.model.NguyenLieu;

/**
 *
 * @author hoang
 */
public class ClassTableModelNguyenLieu {
    public DefaultTableModel setTableNguyenLieu(List<NguyenLieu> listItem,String[] listColumn){
        DefaultTableModel dtm=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
        };
        dtm.setColumnIdentifiers(listColumn);
        int columns=listColumn.length;
        Object[] obj=null;
        int rows=listItem.size();
        if(rows>0){
            for(int i=0;i<rows;++i){
                NguyenLieu nguyenlieu=listItem.get(i);
                obj=new Object[columns];
                obj[0]=(i+1);
                obj[1]=nguyenlieu.getTennguyenlieu();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
