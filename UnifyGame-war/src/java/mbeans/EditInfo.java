/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@SessionScoped
public class EditInfo implements Serializable {

    Long eventEdit;
    Long playerEdit;
    Long teamEdit;

    public Long getEventEdit() {
        return eventEdit;
    }

    public void setEventEdit(Long eventEdit) {
        this.eventEdit = eventEdit;
    }

    public Long getPlayerEdit() {
        return playerEdit;
    }

    public void setPlayerEdit(Long playerEdit) {
        this.playerEdit = playerEdit;
    }

    public Long getTeamEdit() {
        return teamEdit;
    }

    public void setTeamEdit(Long teamEdit) {
        this.teamEdit = teamEdit;
    }

    public EditInfo() {
    }
    
}
