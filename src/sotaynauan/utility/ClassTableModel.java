/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import sotaynauan.model.MonAn;

/**
 *
 * @author hoang
 */
public class ClassTableModel {
    public DefaultTableModel setTableMonAn(List<MonAn> listItem, String[] listColumn){
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
                MonAn monan=listItem.get(i);
                obj=new Object[columns];
                //obj[0]=monan.getIDmon();
                obj[0]=(i+1);
                obj[1]=monan.getTenmon();
                obj[2]=monan.getNguyenLieu();
                obj[3]=monan.getCachlam();
                obj[4]=monan.getLoai();
                dtm.addRow(obj);
            }
        }
        return dtm;
    }
}
