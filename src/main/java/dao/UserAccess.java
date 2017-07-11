package dao;

import entities.User;

import javax.enterprise.context.SessionScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.io.Serializable;

@SessionScoped
public class UserAccess extends ManagerAccess implements Serializable {

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
