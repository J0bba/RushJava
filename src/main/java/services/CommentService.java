package services;


import dao.ManagerAccess;
import entities.Comment;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
public class CommentService {
    @Inject
    private Instance<ManagerAccess> managerAccess;

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
}
