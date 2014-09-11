/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Event;

import dbEntities.Event;
import dbEntities.Team;
import dbUtils.EventType;
import dbUtils.RoundType;
import entitySessionBeans.EventSessionBean;
import entitySessionBeans.TeamSessionBean;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import mbeans.Ticket.TicketCreate;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@ViewScoped
public class TicketController {
    @EJB
    private EventSessionBean eventSessionBean;
    
    @EJB
    private TeamSessionBean teamSessionBean;
    
    
    private List<Event> allEvents; 
  
    private ScheduleModel eventModel;  
    
    private List<Team> allTeams;
    
    private List<Team> allTeams1;
    
    private List<Team> allTeams2;
    
    private String team1;
    
    private String team2;
      
    private ScheduleEvent event = new DefaultScheduleEvent();  
   
    private Event myEvent;

    @ManagedProperty(value="#{eventCreate}")
    private EventCreate ev;

    public void setEv(EventCreate ev) {
        this.ev = ev;
    }
    
    @ManagedProperty(value="#{eventView}")
    private EventView eview;

    public void setEview(EventView eview) {
        this.eview = eview;
    }
    
    @ManagedProperty(value="#{ticketCreate}")
    private TicketCreate tcreate;

    public void setTcreate(TicketCreate tcreate) {
        this.tcreate = tcreate;
    }
    
    
    public Event getMyEvent() {
        return myEvent;
    }

    public void setMyEvent(Event myEvent) {
        this.myEvent = myEvent;
    }

    
  
    public TicketController() {  
        
      
    }  
    @PostConstruct
    public void getEvents()
    {
        eventModel = new DefaultScheduleModel();  
         allEvents = this.allEvents = eventSessionBean.getAllEvents();
         
         for(Event e : allEvents)
         {
             eventModel.addEvent(new DefaultScheduleEvent(e.getName(), e.getDateTime(),e.getDateTime()));
         }
    }
      
    
    public List<Event> getAllEvents() {
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
            items[i++] = new SelectItem(e.ordinal(), e.name());
        }
        return items;
    
    }
    
    public SelectItem[] getRoundTypes()
    {
        SelectItem [] items = new SelectItem[RoundType.values().length];
        
        int i=0;
        for (RoundType e: RoundType.values())
        {
            items[i++] = new SelectItem(e.ordinal(), e.name());
        }
        return items;
    
    }
    
    public void getTeams(AjaxBehaviorEvent abe) {
        allTeams = teamSessionBean.getAllTeams();
        int s = allTeams.size();
        int s1 = (int) Math.floor((double)s/2);
        
        
        allTeams1 = allTeams.subList(0, s1);
        allTeams2 = allTeams.subList(s1, s);
        
    }
    
    public Date getRandomDate(Date base) {  
        Calendar date = Calendar.getInstance();  
        date.setTime(base);  
        date.add(Calendar.DATE, ((int) (Math.random()*30)) + 1);    //set random day of month  
          
        return date.getTime();  
    }  
      
    public Date getInitialDate() {  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(calendar.get(Calendar.YEAR), Calendar.FEBRUARY, calendar.get(Calendar.DATE), 0, 0, 0);  
          
        return calendar.getTime();  
    }  
      
    public ScheduleModel getEventModel() {  
        return eventModel;  
    }  
      
    private Calendar today() {  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);  
  
        return calendar;  
    }  
      
      
    public ScheduleEvent getEvent() {  
        return event;  
    }  
  
    public void setEvent(ScheduleEvent event) {  
        this.event = event;  
    }  
      
    public void addEvent(ActionEvent actionEvent) {  
        if(event.getId() == null)  
            eventModel.addEvent(event);  
        else  
            eventModel.updateEvent(event);  
          
        event = new DefaultScheduleEvent();  
    }  
      
    public void onEventSelect(SelectEvent selectEvent) {  
        event = (ScheduleEvent) selectEvent.getObject();
        String e = event.getTitle();
        Date d = event.getStartDate();
        myEvent = eventSessionBean.findByNameDate(e, d);
        eview.setEvent(myEvent);
        tcreate.setCurrEvent(myEvent);
        ev.setDateTime(myEvent.getDateTime());
        ev.setName(myEvent.getName());
        ev.setEventType(myEvent.getType());
        ev.setVenue(myEvent.getVenue());
        ev.setTeam1(myEvent.getTeam1().getName());
        ev.setTeam2(myEvent.getTeam2().getName());
        
    }  
  
    public void onDateSelect(SelectEvent selectEvent) {  
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());  
        ev.setDateTime((Date)selectEvent.getObject());
    }  
      
    public void onEventMove(ScheduleEntryMoveEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());  
          
        addMessage(message);  
    }  
      
    public void onEventResize(ScheduleEntryResizeEvent event) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());  
          
        addMessage(message);  
    }  
      
    private void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
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
        if(eventSessionBean.createEvent(myEvent.getName(), t1, t2, myEvent.getVenue(), myEvent.getType(), myEvent.getRound(),myEvent.getDateTime()))
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Event creation successful!!"));
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("Event creation failed. Unexpected Server Error!!"));
        
    }
    
    
} 
    

