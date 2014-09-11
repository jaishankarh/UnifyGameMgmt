/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.Ticket;

import dbEntities.Ticket;
import entitySessionBeans.TicketSessionBean;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import mbeans.Login;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@RequestScoped
public class TicketView {
    @EJB
    private TicketSessionBean ticketSessionBean;
    
    @ManagedProperty(value="#{login}")
    private Login login;

    public void setLogin(Login login) {
        this.login = login;
    }
    
    
    private List<Ticket> allTickets;

    public List<Ticket> getAllTickets() {
        allTickets = ticketSessionBean.findAllTicketsByUser(login.getUser());
        return allTickets;
    }

    public void setAllTickets(List<Ticket> allTickets) {
        this.allTickets = allTickets;
    }

    public TicketView() {
    }
    
}
