
package sotaynauan.service;

import java.util.List;
import sotaynauan.model.MonAn;

/**
 *
 * @author hoang
 */
public interface MonAnService {
    public List<MonAn> getList();
    public int createOrUpdate(MonAn monan);
    public int Edit(MonAn monan);
    public int Delete(MonAn monan);
}
