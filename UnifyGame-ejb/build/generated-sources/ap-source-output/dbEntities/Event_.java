package dbEntities;

import dbEntities.Team;
import dbEntities.Ticket;
import dbUtils.EventType;
import dbUtils.RoundType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-26T14:51:05")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Long> id;
    public static volatile SingularAttribute<Event, String> result;
    public static volatile SingularAttribute<Event, Date> dateTime;
    public static volatile SingularAttribute<Event, String> name;
    public static volatile SingularAttribute<Event, Team> winner;
    public static volatile SingularAttribute<Event, RoundType> round;
    public static volatile SingularAttribute<Event, String> venue;
    public static volatile SingularAttribute<Event, EventType> type;
    public static volatile SingularAttribute<Event, Team> team1;
    public static volatile ListAttribute<Event, Ticket> tickets;
    public static volatile SingularAttribute<Event, Team> team2;

}