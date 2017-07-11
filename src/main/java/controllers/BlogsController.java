package controllers;

import dao.BlogAccess;
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
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
@Named
public class BlogsController {

    @Inject
    private Instance<BlogService> blogService;
    @Inject
    private Instance<UserService> userServices;

    public Blog getCurr_blog() {
        return curr_blog;
    }

    public void setCurr_blog(Blog curr_blog) {
        this.curr_blog = curr_blog;
    }

    private Blog curr_blog;

    public List<Blog> getListOfUser()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session.getAttribute("user_id") != null) {
            int user_id = (int) session.getAttribute("user_id");
            User user = userServices.get().getById(user_id);
            return blogService.get().getListByUserId(user);
        }
        else
        {
            return new ArrayList<>();
        }
    }

    public void goToBlogPage(Blog blog) throws IOException {
        this.curr_blog = blog;

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/blog.xhtml");
    }
}
