package dao;

import entities.Post;

import javax.enterprise.context.SessionScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class PostAccess extends ManagerAccess implements Serializable {

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
