/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Team;

import dbEntities.Player;
import dbEntities.Team;
import dbUtils.EventType;
import entitySessionBeans.PlayerFacade;
import entitySessionBeans.TeamFacade;
import entitySessionBeans.TeamSessionBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@RequestScoped
public class TeamCreate {
    @EJB
    private TeamSessionBean teamSessionBean;
    @EJB
    private PlayerFacade playerFacade;
    @EJB
    private TeamFacade teamFacade;
    
    private EventType eventType;

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    

    
    private String name;
    
    private List<String> selectedPlayers;  
  
    private List<Player> selPlayers;
    private List<Player> allPlayers;
    
    public List<String> getSelectedPlayers() {  
        return selectedPlayers;  
    }  
    
    public void setSelectedPlayers(List<String> players) {  
        this.selectedPlayers = players;  
    } 
    public List<Player> getUserSelectedPlayers()
    {
        List<Player> p = new ArrayList<>();
        for(String p1 : this.selectedPlayers)
        {
            String num = p1.substring(p1.indexOf(' ')+1);
            long id = Long.parseLong(num);
            for(Player p2: allPlayers)
            {
                if(p2.getId() == id)
                {
                    p.add(p2);
                    break;
                }
            }
        }
        
        return p;
    }
    
    public List<Player> getAllPlayers() {  
        allPlayers = playerFacade.getAllPlayers();
        return allPlayers;  
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TeamCreate() {
    }
    
    public String save()
    {
        this.selPlayers = getUserSelectedPlayers();
        
        if(teamSessionBean.createTeam(eventType,name,selPlayers))
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Team creation successful!!"));
            return null;
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("Team creation failed. Unexpected Server Error!!"));
        return null;
        
    }
}
