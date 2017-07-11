package controllers;

import entities.Blog;
import entities.Post;
import entities.User;
import services.BlogService;
import services.PostService;
import services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
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
    private Instance<UserService> userService;
    @Inject
    private Instance<PostService> postService;

    public Blog getCurr_blog() {
        return curr_blog;
    }

    public void setCurr_blog(Blog curr_blog) {
        this.curr_blog = curr_blog;
    }

    private Blog curr_blog;

    public List<Blog> getListByUser()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session.getAttribute("user_id") != null) {
            int user_id = (int) session.getAttribute("user_id");
            User user = userService.get().getById(user_id);
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

    public List<Post> getListPost (Blog blog)
    {
        return postService.get().getListByBlogId(blog.getId());
    }

    public void archiveBlog(Blog blog) throws IOException {
        blogService.get().Archive(blog);
        curr_blog = null;
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/");
    }

    public List<Blog> getListAll()
    {
        return blogService.get().getList();
    }
}
