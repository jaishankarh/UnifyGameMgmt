/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbUtils;



public enum RoleType {
    ADMINISTRATOR,
    USER;
    public static RoleType get(int code) {
        
            switch (code) {
                case 0:
                    return ADMINISTRATOR;
                case 1:
                    return USER;
                
                
            }
        return null;
        
    }
    
    
}
