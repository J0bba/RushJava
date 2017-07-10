package dao;

import entities.Blog;
import entities.User;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@SessionScoped
public class BlogAccess extends ManagerAccess  implements Serializable{
    public List<Blog> getListByUserId(int id)
    {
        try {
            return (List<Blog>) em.createQuery("SELECT b FROM Blog b WHERE b.user = :id")
                    .setParameter("id", id)
                    .getResultList();
        }
        catch (NoResultException e)
        {
            return new ArrayList<>();
        }
    }
}
