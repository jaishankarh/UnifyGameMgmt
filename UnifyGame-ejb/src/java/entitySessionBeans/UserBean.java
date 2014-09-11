/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entitySessionBeans;

import dbEntities.User;
import dbUtils.RoleType;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author pranav
 */
@Stateless
@LocalBean
public class UserBean {
    @PersistenceContext(unitName = "UnifyGame-ejbPU")
    private EntityManager em;

    public boolean persist(Object object) {
        try{
            em.persist(object);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public boolean findUniqueUser(String username) {
        Query query = em.createNamedQuery("findUsername");
        query.setParameter("username", username);
        try
        {
            User u = (User)query.getSingleResult();
        }
        catch(NonUniqueResultException nue)
        {
            return false;
        }
        catch(NoResultException ne)
        {
            return true;
        }
        return false;
    }
    
    public User findUserLogin(String username,String password)
    {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.username=:user AND u.password=:pass");
        query.setParameter("user", username);
        query.setParameter("pass", password);
        try
        {
            User u = (User)query.getSingleResult();
            return u;
        }
        catch(Exception e)
        {
            return null;
        }
    }
    
    public boolean createUser(String username, String password, String email, RoleType role) {
        User u = new User(username, password,email, role);
        if(persist(u))
        {
            return true;
        }
        return false;
    }
    public boolean validateUser(String username, String password) {
        Query query = em.createNamedQuery("findUsername");
        query.setParameter("username", username);
        try
        {
            User u = (User) query.getSingleResult();
            if(u.getPassword().equals(password))
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }

    public List<User> findAll() {
        Query q  = em.createNamedQuery("findAllUsers");
        return q.getResultList();
    }
    

}
