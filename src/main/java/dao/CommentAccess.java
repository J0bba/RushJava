package dao;

import entities.Comment;
import entities.Post;

import javax.enterprise.context.SessionScoped;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
public class CommentAccess extends ManagerAccess implements Serializable {
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
