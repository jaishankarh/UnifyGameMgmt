/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Team;

import dbEntities.Player;
import dbEntities.Team;
import entitySessionBeans.EventSessionBean;
import entitySessionBeans.TeamSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@RequestScoped
public class TeamView {
    @EJB
    private TeamSessionBean teamSessionBean;
   
    
    private List<Team> allTeams;

    public List<Team> getAllTeams() {
        allTeams = teamSessionBean.getAllTeams();
        return allTeams;
    }
    
    public String getPlayers(int id)
    {
        List<Player> players = allTeams.get(id).getPlayers();
        String pl = "";
        for(Player p : players )
        {
            pl = pl + p.getName() + ", ";
        }
        return pl;
    }

    public void setAllTeams(List<Team> allTeams) {
        this.allTeams = allTeams;
    }

    public TeamView() {
    }
    
}
