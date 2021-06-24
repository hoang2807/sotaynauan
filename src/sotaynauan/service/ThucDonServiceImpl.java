/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.service;

import java.util.List;
import sotaynauan.dao.ThucDonDAO;
import sotaynauan.dao.ThucDonDAOImpl;
import sotaynauan.model.ThucDon;

/**
 *
 * @author hoang
 */
public class ThucDonServiceImpl implements ThucDonService{

    private ThucDonDAO thucdonDAO = null;

    public ThucDonServiceImpl() {
        thucdonDAO = new ThucDonDAOImpl();
    }
    @Override
    public List<ThucDon> getList() {
        return thucdonDAO.getList();
    }

    @Override
    public int createOrUpdate(ThucDon thucdon) {
        return thucdonDAO.createOrUpdate(thucdon);
    }

    @Override
    public int Edit(ThucDon thucdon) {
        return thucdonDAO.Edit(thucdon);
    }

    @Override
    public int Delete(ThucDon thucdon) {
        return thucdonDAO.Delete(thucdon);
    }
    
}
