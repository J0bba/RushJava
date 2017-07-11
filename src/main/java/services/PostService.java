package services;

import dao.ManagerAccess;
import dao.PostAccess;
import entities.Post;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
public class PostService {
    @Inject
    private Instance<PostAccess> managerAccess;

    public Post Add(Post post)
    {
        return managerAccess.get().Add(post);
    }

    public boolean Delete(Post post)
    {
        return managerAccess.get().Delete(post);
    }

    public boolean Update(Post post)
    {
        return managerAccess.get().Update(post);
    }

    public List getList()
    {
        return managerAccess.get().getList(Post.class);
    }

    public Post getById(int id)
    {
        return managerAccess.get().getById(Post.class, id);
    }
}
