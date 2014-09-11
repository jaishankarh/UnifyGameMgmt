package dbEntities;

import dbEntities.Event;
import dbEntities.User;
import dbUtils.TicketType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-26T14:51:05")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Long> id;
    public static volatile SingularAttribute<Ticket, Date> dateTime;
    public static volatile SingularAttribute<Ticket, Event> event;
    public static volatile SingularAttribute<Ticket, TicketType> type;
    public static volatile SingularAttribute<Ticket, User> user;

}