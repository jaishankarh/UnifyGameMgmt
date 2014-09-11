/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitySessionBeans;

import dbEntities.Ticket;
import dbEntities.User;
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
public class TicketSessionBean {
    @PersistenceContext(unitName = "UnifyGame-ejbPU")
    private EntityManager em;
    

    public boolean create(Ticket t)
    {
        return persist(t);
    }

    public boolean persist(Object object) {
        try
        {
            em.persist(object);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public List<Ticket> findAllTickets()
    {
        Query q = em.createQuery("SELECT t FROM Ticket t");
        return q.getResultList();
    }

    public List<Ticket> findAllTicketsByUser(User user) {
       Query q = em.createQuery("SELECT t FROM Ticket t WHERE t.user =:u");
       q.setParameter("u", user);
       return q.getResultList();
    }
}
