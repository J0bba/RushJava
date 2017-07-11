package dao;

import entities.Blog;
import entities.User;

import javax.enterprise.context.SessionScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class BlogAccess extends ManagerAccess implements Serializable {

    @Transactional
    public void Archive(Blog blog)
    {
        blog.setActive(false);
        this.Update(blog);
    }

    @Transactional
    public List<Blog> getListByUser(User user)
    {
        try {
            return (List<Blog>) em.createQuery("SELECT b FROM Blog b WHERE b.user = :user AND b.active = true")
                    .setParameter("user", user)
                    .getResultList();
        }
        catch (NoResultException e)
        {
            return new ArrayList<>();
        }
    }
}
