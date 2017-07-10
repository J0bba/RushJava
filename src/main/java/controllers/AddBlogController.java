package controllers;

import dao.BlogAccess;
import dao.UserAccess;
import entities.Blog;
import entities.User;

import javax.enterprise.context.ApplicationScoped;
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
    private BlogAccess managerAccess;

    @Inject
    private UserAccess userAccess;

    public String getBlogName() {
        return blogName;
    }

    private String blogName;

    public void AddBlog()
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        User curr_user = userAccess.getById(User.class, (Integer) session.getAttribute("user_id"));
        Blog newBlog = new Blog();
        newBlog.setName(blogName);
        newBlog.setUser(curr_user);
        managerAccess.Add(newBlog);

        try {
            context.redirect(context.getRequestContextPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
