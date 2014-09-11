/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Event;

import dbEntities.Event;
import dbUtils.EventType;
import dbUtils.RoundType;
import entitySessionBeans.EventSessionBean;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import mbeans.EditInfo;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@SessionScoped
public class EventView implements Serializable {
    @EJB
    private EventSessionBean eventSessionBean;
    
    private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    
    private int currEdit;
    
    private List<Event> upcomingEvents;

    public List<Event> getUpcomingEvents() {
        upcomingEvents = eventSessionBean.getUpcomingEvents();
        return upcomingEvents;
    }

    public void setUpcomingEvents(List<Event> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }
    
    

    public int getCurrEdit() {
        return currEdit;
    }

    public void setCurrEdit(int currEdit) {
        this.currEdit = currEdit;
    }


    private List<Event> allEvents; 
    
    @ManagedProperty(value="#{editInfo}")
    private EditInfo editInfo;

    public void setEditInfo(EditInfo editInfo) {
        this.editInfo = editInfo;
    }
    
    
    
    
    

    public List<Event> getAllEvents() {
        this.allEvents = eventSessionBean.getAllEvents();
        return allEvents;
    }

    public void setAllEvents(List<Event> events) {
        this.allEvents = events;
    }

    public SelectItem[] getEventTypes()
    {
        SelectItem [] items = new SelectItem[EventType.values().length];
        
        int i=0;
        for (EventType e: EventType.values())
        {
            items[i++] = new SelectItem(e, e.name());
        }
        return items;
    
    }
    
    public SelectItem[] getRoundTypes()
    {
        SelectItem [] items = new SelectItem[RoundType.values().length];
        
        int i=0;
        for (RoundType e: RoundType.values())
        {
            items[i++] = new SelectItem(e, e.name());
        }
        return items;
    
    }
    
    public EventView() {
    }
    public void setEdit(ActionEvent ae)
    {   
        Logger logger = Logger.getLogger("myLogger");
        logger.log(Level.INFO, Integer.toString(currEdit));
         System.out.println(this.currEdit);
        this.editInfo.setEventEdit(this.allEvents.get(currEdit).getId());
        
    }
    
}
