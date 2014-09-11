/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbEntities;

import dbUtils.TicketType;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author jaishankar
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findAllTickets", query="SELECT t FROM Ticket t"),
    @NamedQuery(name = "findAllTicketsByUser", query="SELECT t FROM Ticket t WHERE t.user = :u ")
})
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private TicketType type;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTime;
    
    @ManyToOne
    private Event event;
    
    private User user;

    public Ticket() {
    }

    public Ticket(Timestamp timestamp, User user, Event currEvent) {
        this.dateTime = timestamp;
        this.user = user;
        this.event = currEvent;
    }

    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }


    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }


    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbEntities.Ticket[ id=" + id + " ]";
    }
    
}
