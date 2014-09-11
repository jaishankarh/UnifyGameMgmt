/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitySessionBeans;

import dbEntities.Player;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jaishankar
 */
@Stateless
public class PlayerFacade extends AbstractFacade<Player> {
    @PersistenceContext(unitName = "UnifyGame-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlayerFacade() {
        super(Player.class);
    }
   
    public List<Player> getAllPlayers()
    {
        Query q = em.createNamedQuery("findAllPlayers");
        return q.getResultList();
    }
    
}
