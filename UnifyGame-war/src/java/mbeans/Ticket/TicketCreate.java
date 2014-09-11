/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Ticket;

import dbEntities.Event;
import dbEntities.Ticket;
import entitySessionBeans.TicketSessionBean;
import java.sql.Timestamp;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mbeans.Login;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@ViewScoped
public class TicketCreate {
    @EJB
    private TicketSessionBean ticketSessionBean;
    
    
    private Ticket ticket;
    
    Event currEvent;
    
    @ManagedProperty(value="#{login}")
    Login login;

    public void setLogin(Login login) {
        this.login = login;
    }
    

    public Event getCurrEvent() {
        return currEvent;
    }

    public void setCurrEvent(Event currEvent) {
        this.currEvent = currEvent;
    }
    
    

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


    /**
     * Creates a new instance of TicketCreate
     */
    public TicketCreate() {
        
    }
    
    public void create()
    {
        
        Ticket t= new Ticket(new Timestamp(new Date().getTime()),login.getUser(),this.currEvent);
        System.out.println(t);
        if(ticketSessionBean.create(t))
        {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("Ticket booked successful!!"));
        }
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, new FacesMessage("Unknown Server Error occured!!"));
        
        
    }
    
}
