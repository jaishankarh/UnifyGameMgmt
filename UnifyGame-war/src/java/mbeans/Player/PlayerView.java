/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Player;

import dbEntities.Player;
import dbEntities.Statistics;
import dbEntities.Team;
import entitySessionBeans.PlayerSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@RequestScoped
public class PlayerView {
    @EJB
    private PlayerSessionBean playerSessionBean;

    private List<Player> players;
    
    private List<Statistics> statistics;
    
    private boolean statsRender =false;

    public boolean isStatsRender() {
        return statsRender;
    }

    public void setStatsRender(boolean statsRender) {
        this.statsRender = statsRender;
    }

    

    public List<Statistics> getStatistics(int id) {
        return this.players.get(id).getStatistics();
    }

    public void setStatistics(List<Statistics> statistics) {
        this.statistics = statistics;
    }

    public List<Player> getPlayers() {
        this.players = playerSessionBean.getAllPlayers();
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public PlayerView() {
    }
    public String getTeams(int id)
    {
        List<Team> teams = players.get(id).getTeams();
        String pl = "";
        for(Team t : teams )
        {
            pl = pl + t.getName() + ", ";
            
        }
        return pl;
    }
    
    public void showStats()
    {
        this.statsRender = true;
    }
    
//    public void setEdit(int id)
//    {
//        Player p = players.get(id);
//        plcreate.setName(p.getName());
//        plcreate.setHeight(p.getHeight());
//        plcreate.setWeight(p.getWeight());
//        
//    }
    
}
