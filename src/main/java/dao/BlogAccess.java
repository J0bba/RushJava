package dao;

import entities.Blog;
import entities.User;

import javax.annotation.Priority;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@SessionScoped
public class BlogAccess extends ManagerAccess  implements Serializable{
    public List<Blog> getListByUser(User user)
    {
        try {
            return (List<Blog>) em.createQuery("SELECT b FROM Blog b WHERE b.user = :user")
                    .setParameter("user", user)
                    .getResultList();
        }
        catch (NoResultException e)
        {
            return new ArrayList<>();
        }
    }
}
