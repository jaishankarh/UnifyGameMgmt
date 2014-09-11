/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitySessionBeans;

import dbEntities.Player;
import dbEntities.Team;
import dbUtils.EventType;
import java.util.ArrayList;
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
public class TeamSessionBean {
    @PersistenceContext(unitName = "UnifyGame-ejbPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public boolean createTeam(EventType e, String name,List<Player> players)
    {
        Team t = new Team();
        t.setName(name);
        t.setGameType(e);
        t.setPlayers(players);
        //Query q = em.createQuery("UPDATE Player p SET p.team=:teamid WHERE p.id=:pid");
//        List<Player> players = q.getResultList();
//        System.out.println(players);
        
        persist(t);
//        System.out.println("I was here!!");
//        for(Player p : players)
//        {
//            q.setParameter("teamid", t);
//            q.setParameter("pid", p.getId());
//            q.executeUpdate();
//           
//        }
        return true;
        
    }
    public List<Team> getAllTeams()
    {
        Query q = em.createNamedQuery("findAllTeams");
        return q.getResultList();
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

    public boolean createTeam() {
       Team t1 = new Team();
       t1.setName("Tennis Team");
       t1.setGameType(EventType.CRICKET);
//       Player p = new Player();
//       p.setHeight(172.5f);
//       p.setName("Pranav");
//       p.setWeight(73.5f);
//       Player p1 = new Player();
//       p1.setHeight(1723.5f);
//       p1.setName("Pranavsdf");
//       p1.setWeight(73.52f);
//       t1.getPlayers().add(p1);
       Query q = em.createNamedQuery("findAllPlayers");
       List<Player> pl = q.getResultList();
//       for(Player p: pl)
//       {
//           p.setTeam(t1);
//       }
       t1.setPlayers(pl);
       
       return persist(t1);
    }
}
