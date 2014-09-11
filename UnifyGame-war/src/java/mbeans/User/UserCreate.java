/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans.User;

import dbUtils.RoleType;
import entitySessionBeans.UserBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import static utils.md5Hashing.md5;

/**
 *
 * @author jaishankar
 */
@ManagedBean
@RequestScoped
public class UserCreate {
    @EJB
    private UserBean userBean;

    
    private String username;
    
    private String password;
    
    private String password1;

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    
    private String email;
    
        private RoleType role;

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public UserCreate() {
    }
    public String save()
    {
        if(!usernameUnique())
        {
            FacesContext fcontext = FacesContext.getCurrentInstance();
            fcontext.addMessage("username_id",new FacesMessage(FacesMessage.SEVERITY_FATAL,"Username exists. Please Choose another username!",null));
            return null;
        }
        String pass = md5(password);
        if(userBean.createUser(username, pass, email, role))
        {
            FacesContext fcontext = FacesContext.getCurrentInstance();
            fcontext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"User Creation Successful!!",null));
            return null;    
        }
        else
        {
            FacesContext fcontext = FacesContext.getCurrentInstance();
            fcontext.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_FATAL,"Unexpected Server Error! Cannot create user! Please try again after some time.",null));
            return null;
        }
    }
    public boolean usernameUnique()
    {
        if(userBean.findUniqueUser(username))
        {
            return true;
        }
        return false;
    }
}
