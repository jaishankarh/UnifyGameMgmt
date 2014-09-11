/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Event;   

import com.sun.jndi.toolkit.dir.SearchFilter;
import dbEntities.Team;
import dbUtils.EventType;
import dbUtils.RoundType;
import entitySessionBeans.EventSessionBean;
import entitySessionBeans.TeamSessionBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@ViewScoped
public class EventCreate implements Serializable{
    @EJB
    private EventSessionBean eventSessionBean;
    @EJB
    private TeamSessionBean teamSessionBean;
    

    private String name;
    
    private String team1;
    
    private String team2;

    private String venue;

    private RoundType round;
    
    private EventType eventType;
    
    private Date dateTime;
    
    private List<Team> allTeams;
    
    private List<Team> allTeams1;
    
    private List<Team> allTeams2;

    public List<Team> getAllTeams2() {
        return allTeams2;
    }

    public void setAllTeams2(List<Team> allTeams2) {
        this.allTeams2 = allTeams2;
    }

    


    public List<Team> getAllTeams1() {
        return allTeams1;
    }

    public void setAllTeams1(List<Team> allTeams1) {
        this.allTeams1 = allTeams1;
    }
    
    public List<Team> getAllTeams() {
        return allTeams;
    }

    @PostConstruct
    public void getTeams() {
        allTeams = teamSessionBean.getAllTeams();
        int s = allTeams.size();
        int s1 = (int) Math.floor((double)s/2);
        
        
        allTeams1 = allTeams.subList(0, s1);
        allTeams2 = allTeams.subList(s1, s);
        
    }

    public void setAllTeams(List<Team> allTeams) {
        this.allTeams = allTeams;
    }


    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public RoundType getRound() {
        return round;
    }

    public void setRound(RoundType round) {
        this.round = round;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }



    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }


    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventCreate() {
    }
    
    public Team getSelectedTeam(String team)
    {
        for(Team t : allTeams)
        {
            if(t.getName().equals(team))
            {
                return t;
            }
        }
        return null;
    }
    
    public void save()
    {
        Team t1 = getSelectedTeam(team1);
        Team t2 = getSelectedTeam(team2);
        System.out.println(t1);
        System.out.println(t2);
        if(eventSessionBean.createEvent(name, t1, t2, venue, eventType, round,dateTime))
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Event creation successful!!"));
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("Event creation failed. Unexpected Server Error!!"));
        
    }
    
}
