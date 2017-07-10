package services;

import dao.ManagerAccess;
import entities.Post;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
public class PostService {
    @Inject
    private ManagerAccess managerAccess;

    public Post Add(Post post)
    {
        return managerAccess.Add(post);
    }

    public boolean Delete(Post post)
    {
        return managerAccess.Delete(post);
    }

    public boolean Update(Post post)
    {
        return managerAccess.Update(post);
    }

    public List getList()
    {
        return managerAccess.getList(Post.class);
    }

    public Post getById(int id)
    {
        return managerAccess.getById(Post.class, id);
    }
}
