package dao;

import entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * Created by Thiba on 10/07/2017.
 */
@SessionScoped
public class UserAccess extends ManagerAccess implements Serializable{

    @Transactional
    public User getByUsername(String username)
    {
        try {
            return (User) em.createQuery("SELECT u FROM User u WHERE u.username = :username")
                    .setParameter("username", username)
                    .getSingleResult();
        }
        catch (NoResultException e)
        {
            return null;
        }
    }
}
