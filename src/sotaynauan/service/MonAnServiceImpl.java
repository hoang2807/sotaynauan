package sotaynauan.service;

import java.util.List;
import sotaynauan.dao.MonAnDAO;
import sotaynauan.dao.MonAnDAOImpl;
import sotaynauan.model.MonAn;

/**
 *
 * @author hoang
 */
public class MonAnServiceImpl implements MonAnService {

    private MonAnDAO monanDAO = null;

    public MonAnServiceImpl() {
        monanDAO = new MonAnDAOImpl();
    }

    @Override
    public List<MonAn> getList() {
        return monanDAO.getList();
    }

    @Override
    public int createOrUpdate(MonAn monan) {
        return monanDAO.createOrUpdate(monan);
    }

    @Override
    public int Edit(MonAn monan) {
        return monanDAO.Edit(monan);
    }

    @Override
    public int Delete(MonAn monan) {
        return monanDAO.Delete(monan);
    }

}
