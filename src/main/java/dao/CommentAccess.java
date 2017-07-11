package dao;

import entities.Comment;
import entities.Post;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiba on 11/07/2017.
 */
@ApplicationScoped
public class CommentAccess extends ManagerAccess {
    public List<Comment> getListByPost(Post post)
    {
        try {
            return (List<Comment>) em.createQuery("SELECT c FROM Comment c WHERE c.post = :post")
                    .setParameter("post", post)
                    .getResultList();
        }
        catch (NoResultException e)
        {
            return new ArrayList<>();
        }
    }
}
