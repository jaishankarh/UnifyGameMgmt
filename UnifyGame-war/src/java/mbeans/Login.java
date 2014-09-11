/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans;

import dbEntities.User;
import dbUtils.RoleType;
import entitySessionBeans.UserBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import static utils.md5Hashing.md5;
/**
 *
 * @author pranav
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {
    @EJB
    private UserBean userBean;
    
    User user;
    
    
    private String username;
    
    private String password;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }


    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
   
    public String loginUser()
    {
         String pass = md5(password);
         FacesContext fcontext = FacesContext.getCurrentInstance();
        this.user = userBean.findUserLogin(username, pass);
        if(user!=null)
        {
            if(user.getRole().equals(RoleType.ADMINISTRATOR))
            {
                fcontext.getExternalContext().getSessionMap().put("user", user);
                return "admin";
            }
            fcontext.getExternalContext().getSessionMap().put("user", user);
            return "user";
        }
        
        fcontext.getExternalContext().getSessionMap().put("user", null);
        fcontext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Username and passwords don't match!!",null));
        return null;
    }
    public String logout()
    {
        System.out.println("I was here!!");
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().invalidateSession();
        return "logout";
        
    }
}
