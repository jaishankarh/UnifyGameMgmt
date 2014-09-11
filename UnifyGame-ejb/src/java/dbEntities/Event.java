/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbEntities;

import dbUtils.EventType;
import dbUtils.RoundType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author pranav
 */


@Entity
@NamedQueries({
    @NamedQuery(name = "findAllEvents", query="SELECT e FROM Event e"),
    @NamedQuery(name = "findEventById", query="SELECT e FROM Event e WHERE e.id=:eid"),
    
})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Team team1;
    
    private Team team2;
    
    private Team winner;
    
    private String venue;
    
    @Enumerated(EnumType.STRING)
    private EventType type;
    
    @Enumerated(EnumType.STRING)
    private RoundType round;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateTime;
    
    private String result;
    
    @OneToMany(mappedBy = "event")
    private List<Ticket> tickets;

    public RoundType getRound() {
        return round;
    }

    public void setRound(RoundType round) {
        this.round = round;
    }

    

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    
    

    

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    
    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }


        

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    
    

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }


    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dbEntities.Match[ id=" + id + " ]";
    }

    public Event() {
    }

    public Event(String name, Team team1, Team team2, String venue, EventType event,RoundType round, Date dateTime) {
        this.name = name;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.round = round;
        this.dateTime = dateTime;
        this.type = event;
    }
    
    
}
