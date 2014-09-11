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
public enum RoundType {
    QUALIFIERS,
    QUATERFINALS,
    SEMIFINALS,
    FINALS;
    
    public static RoundType get(int code) {
        
            switch (code) {
                case 0:
                    return QUALIFIERS;
                case 1:
                    return QUATERFINALS;
                case 2: 
                    return SEMIFINALS;
                case 3: 
                    return FINALS;
                
                default:
                    return QUALIFIERS;
                
            }
        
    }
    
}
