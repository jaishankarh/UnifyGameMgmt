/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.User;

import dbEntities.User;
import dbUtils.EventType;
import dbUtils.RoleType;
import entitySessionBeans.UserBean;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@SessionScoped
public class UserView implements Serializable{
    @EJB
    private UserBean userBean;
    
    private String name="";

    private List<User> allUsers;

    public List<User> getAllUsers() {
        allUsers = userBean.findAll();
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public UserView() {
    }
    
    public SelectItem[] getRoleTypes()
    {
        SelectItem [] items = new SelectItem[RoleType.values().length];
        
        int i=0;
        for (RoleType e: RoleType.values())
        {
            items[i++] = new SelectItem(e, e.name());
        }
        return items;
    
    }
    public void edit(ActionEvent abe)
    {
        name= "jaishankars";
        System.out.println("I was here!!");
    }
}
