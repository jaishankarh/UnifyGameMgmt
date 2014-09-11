/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@SessionScoped
public class Ajax implements Serializable {
    
    private boolean rendered = false;

    public boolean isRendered() {
        return rendered;
    }

    public void setRendered(boolean rendered) {
        this.rendered = rendered;
    }

    public void viewPanel(ActionEvent ae)
    {
        this.rendered = !this.rendered;
        System.out.println("I was here " + this.rendered);
        
    }

    /**
     * Creates a new instance of Ajax
     */
    public Ajax() {
    }
    
}
