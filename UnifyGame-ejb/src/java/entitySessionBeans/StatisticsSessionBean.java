/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitySessionBeans;

import dbEntities.Player;
import dbEntities.Statistics;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jaishankar
 */
@Stateless
@LocalBean
public class StatisticsSessionBean {
    @PersistenceContext(unitName = "UnifyGame-ejbPU")
    private EntityManager em;
    
   

    public boolean persist(Object object) {
        try
        {
            em.persist(object);
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createStatistic(Statistics s) {
        return persist(s);
    }
}
