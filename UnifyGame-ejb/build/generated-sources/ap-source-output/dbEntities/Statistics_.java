package dbEntities;

import dbEntities.Player;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-03-26T14:51:05")
@StaticMetamodel(Statistics.class)
public class Statistics_ { 

    public static volatile SingularAttribute<Statistics, Long> id;
    public static volatile SingularAttribute<Statistics, Player> player;
    public static volatile SingularAttribute<Statistics, Float> value;
    public static volatile SingularAttribute<Statistics, String> type;

}