package services;


import dao.CommentAccess;
import entities.Comment;
import entities.Post;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class CommentService implements Serializable {
    @Inject
    private Instance<CommentAccess> managerAccess;

    public Comment Add(Comment comment)
    {
        return managerAccess.get().Add(comment);
    }

    public boolean Delete(Comment comment)
    {
        return managerAccess.get().Delete(comment);
    }

    public boolean Update(Comment comment)
    {
        return managerAccess.get().Update(comment);
    }

    public List getList()
    {
        return managerAccess.get().getList(Comment.class);
    }

    public Comment getById(int id)
    {
        return managerAccess.get().getById(Comment.class, id);
    }

    public List<Comment> getListByPost(Post post)
    {
        return managerAccess.get().getListByPost(post);
    }
}
