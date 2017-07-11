package services;

import dao.BlogAccess;
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
    private Instance<BlogAccess> blogAccess;

    public Blog Add(Blog blog)
    {
        return blogAccess.get().Add(blog);
    }

    public boolean Delete(Blog blog)
    {
        return blogAccess.get().Delete(blog);
    }

    public boolean Update(Blog blog)
    {
        return blogAccess.get().Update(blog);
    }

    public List getList()
    {
        return blogAccess.get().getList(Blog.class);
    }

    public Blog getById(int id) {
        return blogAccess.get().getById(Blog.class, id);
    }

    public List<Blog> getListByUserId(User user)
    {
        return blogAccess.get().getListByUser(user);
    }

    public void Archive(Blog blog)
    {
        blogAccess.get().Archive(blog);
    }
}
