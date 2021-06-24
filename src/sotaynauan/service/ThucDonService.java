/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sotaynauan.service;

import java.util.List;
import sotaynauan.model.ThucDon;

/**
 *
 * @author hoang
 */
public interface ThucDonService {
    public List<ThucDon> getList();
    public int createOrUpdate(ThucDon thucdon);
    public int Edit(ThucDon thucdon);
    public int Delete(ThucDon thucdon);
}
