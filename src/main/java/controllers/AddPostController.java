package controllers;

import dao.PostAccess;
import dao.UserAccess;
import entities.Blog;
import entities.Post;
import entities.User;
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
import java.util.Date;

/**
 * Created by Thiba on 11/07/2017.
 */
@ApplicationScoped
@Named
public class AddPostController {
    @Inject
    private Instance<PostService> postService;

    @Inject
    private Instance<UserService> userService;

    private String postName;
    private String data;


    public void AddPost(Blog curr_blog)
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        User curr_user = userService.get().getById((Integer)session.getAttribute("user_id"));
        Post post = new Post();
        post.setActive(true);
        post.setBlog(curr_blog);
        post.setData(data);
        post.setName(postName);
        post.setDate(new java.sql.Date(new Date().getTime()));
        post.setUser(curr_user);

        postService.get().Add(post);
        try {
            context.redirect(context.getRequestContextPath() + "/blog.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
