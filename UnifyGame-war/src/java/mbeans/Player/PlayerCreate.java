/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Player;

import dbEntities.Player;
import dbEntities.Statistics;
import dbUtils.EventType;
import entitySessionBeans.PlayerFacade;
import entitySessionBeans.PlayerSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author jaishankar
 */
@ManagedBean(name = "playerCreate")
@RequestScoped
public class PlayerCreate {
    @EJB
    private PlayerSessionBean playerSessionBean;
    
//    @ManagedProperty(value="#{playerView}")
//    private PlayerView plview;
//    
    private String statType;

    private float statValue;

    

    private String name;
    
    private float weight;
    
    private float height;
    
    private EventType eventType;

//    public void setPlview(PlayerView plview) {
//        this.plview = plview;
//    }

    
    
    public float getStatValue() {
        return statValue;
    }

    public void setStatValue(float statValue) {
        this.statValue = statValue;
    }

    public String getStatType() {
        return statType;
    }

    public void setStatType(String statType) {
        this.statType = statType;
    }
    
//    public void statisticsSave(int id)
//    {
//        List<Player> pl = plview.getPlayers();
//        Player selectPlayer= new Player();
//        for(Player p: pl)
//        {
//            if(p.getId() == id)
//            {
//                selectPlayer = p;
//                break;
//            }
//        }
//        Statistics s = new Statistics(statType,statValue);
//        selectPlayer.getStatistics().add(s);
//        if(playerSessionBean.createPlayer(name,height, weight))
//        {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            fc.addMessage(null, new FacesMessage("Stats creation successful!!"));
//            
//        }
//        FacesContext fc = FacesContext.getCurrentInstance();
//        fc.addMessage(null, new FacesMessage("Stats creation failed. Unexpected Server Error!!"));
//        
//    }
//    
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
    
  


    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerCreate() {
    }
    
    public String save()
    {
        
        
        if(playerSessionBean.createPlayer(name,height, weight))
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Player creation successful!!"));
            return null;
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("Player creation failed. Unexpected Server Error!!"));
        return null;
        
    }
    
}
