package controllers;

import dao.BlogAccess;
import dao.UserAccess;
import entities.Blog;
import entities.User;
import services.BlogService;
import services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
@Named
public class AddBlogController {
    @Inject
    private Instance<BlogService> blogService;

    @Inject
    private Instance<UserService> userService;

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName)
    {
        this.blogName = blogName;
    }

    private String blogName;

    public void AddBlog()
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        User curr_user = userService.get().getById((Integer) session.getAttribute("user_id"));
        Blog newBlog = new Blog();
        newBlog.setName(blogName);
        newBlog.setUser(curr_user);
        newBlog.setActive(true);
        blogService.get().Add(newBlog);

        try {
            context.redirect(context.getRequestContextPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
