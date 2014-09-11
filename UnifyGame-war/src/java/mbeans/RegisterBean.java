/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mbeans;

import dbUtils.RoleType;
import entitySessionBeans.UserBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import static utils.md5Hashing.md5;

/**
 *
 * @author pranav
 */
@ManagedBean
@RequestScoped
public class RegisterBean {
    @EJB
    private UserBean userBean;

    
    private String username;
    
    private String password;
    
    private String email;

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }


   /**
     * Get the value of password
     *
     * @return the value of password
     */
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
     * Creates a new instance of registerBean
     */
    public RegisterBean() {
    }
    public String validate()
    {
//        if(!usernameUnique())
//        {
//            FacesContext fcontext = FacesContext.getCurrentInstance();
//            fcontext.addMessage("username_id",new FacesMessage(FacesMessage.SEVERITY_FATAL,"Username exists. Please Choose another username!",null));
//            return null;
//        }
        String pass = md5(password);
        if(userBean.createUser(username, pass, email, RoleType.USER))
        {
              FacesContext fcontext = FacesContext.getCurrentInstance();
            fcontext.addMessage("username_id",new FacesMessage("Successfully Registered! Please Login!"));
            return "success";
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
