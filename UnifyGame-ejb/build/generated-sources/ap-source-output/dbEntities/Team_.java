package dbEntities;

import dbEntities.Player;
import dbUtils.EventType;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-26T14:51:05")
@StaticMetamodel(Team.class)
public class Team_ { 

    public static volatile SingularAttribute<Team, Long> id;
    public static volatile SingularAttribute<Team, EventType> gameType;
    public static volatile SingularAttribute<Team, String> name;
    public static volatile ListAttribute<Team, Player> players;

}