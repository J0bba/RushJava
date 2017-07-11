package controllers;

import entities.Blog;
import entities.Comment;
import entities.Post;
import services.CommentService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Thiba on 11/07/2017.
 */
@ApplicationScoped
@Named
public class PostsController {

    @Inject
    private Instance<CommentService> commentService;

    private Post curr_post;

    public Post getCurr_post() {
        return curr_post;
    }

    public void setCurr_post(Post curr_post) {
        this.curr_post = curr_post;
    }

    public Blog getCurr_blog() {
        return curr_blog;
    }

    public void setCurr_blog(Blog curr_blog) {
        this.curr_blog = curr_blog;
    }

    private Blog curr_blog;

    public List<Comment> getListComment(Post post)
    {
        return commentService.get().getListByPost(post);
    }


    public void goToPostPage(Blog curr_blog, Post post) throws IOException {
        this.curr_blog = curr_blog;
        this.curr_post = post;

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/post.xhtml");
    }

    public void removeComment(Comment comment)
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        commentService.get().Delete(comment);
        try {
            context.redirect(((HttpServletRequest) context.getRequest()).getRequestURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
