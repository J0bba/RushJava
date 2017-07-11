package dao;

import javax.enterprise.context.ApplicationScoped;
import entities.Post;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiba on 11/07/2017.
 */
@ApplicationScoped
public class PostAccess  extends ManagerAccess{

    @Transactional
    public void Archive(Post post)
    {
        post.setActive(false);
        this.Update(post);
    }

    @Transactional
    public List<Post> getListByBlogId(int blog_id)
    {
        try {
            return (List<Post>) em.createQuery("SELECT p FROM Post p WHERE p.blog.id = :blog_id AND p.active = true")
                    .setParameter("blog_id", blog_id)
                    .getResultList();
        }
        catch (NoResultException e)
        {
            return new ArrayList<>();
        }
    }
}
