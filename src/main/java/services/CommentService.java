package services;


import dao.ManagerAccess;
import entities.Comment;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
public class CommentService {
    @Inject
    private ManagerAccess managerAccess;

    public Comment Add(Comment comment)
    {
        return managerAccess.Add(comment);
    }

    public boolean Delete(Comment comment)
    {
        return managerAccess.Delete(comment);
    }

    public boolean Update(Comment comment)
    {
        return managerAccess.Update(comment);
    }

    public List getList()
    {
        return managerAccess.getList(new Comment());
    }
}
