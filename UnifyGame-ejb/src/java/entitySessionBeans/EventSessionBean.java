/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitySessionBeans;

import dbEntities.Event;
import dbEntities.Player;
import dbEntities.Team;
import dbUtils.EventType;
import dbUtils.RoundType;
import java.sql.Timestamp;
import java.util.Date;
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
public class EventSessionBean {
    @PersistenceContext(unitName = "UnifyGame-ejbPU")
    private EntityManager em;
    
    public boolean createEvent(String name, Team team1, Team team2, String venue, EventType event, RoundType round, Date dateTime) {
            System.out.println();
            Event e = new Event(name,team1, team2, venue,event, round,dateTime);
            return persist(e);
        }

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
    public List<Event> getAllEvents()
    {
        Query q = em.createNamedQuery("findAllEvents");
        return q.getResultList();
    }
    public Event findById(Long id)
    {
        
        return (Event)em.find(Event.class, id);
    }
    public Event findByNameDate(String name, Date d)
    {
        Query q = em.createQuery("SELECT e FROM Event e WHERE e.name=:ename AND e.dateTime=:dateTime");
        q.setParameter("ename", name);
        q.setParameter("dateTime", d);
        return (Event)q.getSingleResult();
    }
    
    public List<Event> getUpcomingEvents()
    {
        Query q = em.createQuery("SELECT e FROM Event e WHERE e.dateTime >= :datetime");
        q.setParameter("datetime", new Timestamp(new Date().getTime()));
        return q.getResultList();
    }
}
