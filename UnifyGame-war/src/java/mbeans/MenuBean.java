/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@RequestScoped
public class MenuBean {

    /**
     * Creates a new instance of MenuBean
     */
    public String createPlayer()
    {
        return "createPlayer";
    }
    public MenuBean() {
    }
    
}
