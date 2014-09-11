package dbEntities;

import dbEntities.Statistics;
import dbEntities.Team;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-26T14:51:05")
@StaticMetamodel(Player.class)
public class Player_ { 

    public static volatile SingularAttribute<Player, Long> id;
    public static volatile ListAttribute<Player, Team> teams;
    public static volatile SingularAttribute<Player, Float> height;
    public static volatile SingularAttribute<Player, Float> weight;
    public static volatile SingularAttribute<Player, String> name;
    public static volatile ListAttribute<Player, Statistics> statistics;

}