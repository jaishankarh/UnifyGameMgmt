/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbUtils;

/**
 *
 * @author jaishankar
 */
public enum EventType {
    CRICKET,
    FOOTBALL,
    TABLE_TENNIS,
    BADMINTON,
    VOLLEYBALL,
    BASKETBALL,
    TENNIS;
    
    public static EventType get(int code) {
        
            switch (code) {
                case 0:
                    return CRICKET;
                case 1:
                    return FOOTBALL;
                case 2: 
                    return TABLE_TENNIS;
                case 3: 
                    return BADMINTON;
                case 4: 
                    return VOLLEYBALL;
                case 5: 
                    return BASKETBALL;
                case 6: 
                    return TENNIS;
                default:
                    return CRICKET;
                
            }
        
    }
}
