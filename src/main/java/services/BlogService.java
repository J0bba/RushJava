package services;

import dao.BlogAccess;
import dao.ManagerAccess;
import entities.Blog;
import entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
public class BlogService {
    @Inject
    private Instance<BlogAccess> managerAccess;

    public Blog Add(Blog blog)
    {
        return managerAccess.get().Add(blog);
    }

    public boolean Delete(Blog blog)
    {
        return managerAccess.get().Delete(blog);
    }

    public boolean Update(Blog blog)
    {
        return managerAccess.get().Update(blog);
    }

    public List getList()
    {
        return managerAccess.get().getList(Blog.class);
    }

    public Blog getById(int id) {
        return managerAccess.get().getById(Blog.class, id);
    }

    public List<Blog> getListByUserId(User user)
    {
        return managerAccess.get().getListByUser(user);
    }
}
