package services;

import dao.ManagerAccess;
import entities.Blog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
public class BlogService {
    @Inject
    private ManagerAccess managerAccess;

    public Blog Add(Blog blog)
    {
        return managerAccess.Add(blog);
    }

    public boolean Delete(Blog blog)
    {
        return managerAccess.Delete(blog);
    }

    public boolean Update(Blog blog)
    {
        return managerAccess.Update(blog);
    }

    public List getList()
    {
        return managerAccess.getList(new Blog());
    }
}
