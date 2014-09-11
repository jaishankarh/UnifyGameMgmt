/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitySessionBeans;

import dbEntities.Player;
import dbEntities.Statistics;
import dbUtils.EventType;
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
public class PlayerSessionBean {
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

    public List<Player> getAllPlayers()
    {
        Query q = em.createNamedQuery("findAllPlayers");
        return q.getResultList();
    }
    
    public boolean createPlayer(String name, float height, float weight) {
        Player p = new Player(name, height, weight);
        return persist(p);
    }
     

   
}
