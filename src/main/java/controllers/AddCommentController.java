package controllers;

import entities.Comment;
import entities.Post;
import entities.User;
import services.CommentService;
import services.UserService;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

@SessionScoped
@Named
public class AddCommentController implements Serializable {
    @Inject
    private Instance<CommentService> commentService;

    @Inject
    private Instance<UserService> userService;

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    private String commentText;

    public void AddComment(Post curr_post)
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession)context.getSession(false);
        User user = userService.get().getById((Integer) session.getAttribute("user_id"));
        Comment comment = new Comment();
        comment.setData(commentText);
        comment.setPost(curr_post);
        comment.setDate(new java.sql.Date(new Date().getTime()));
        comment.setUser(user);

        commentService.get().Add(comment);
        try {
            context.redirect(((HttpServletRequest) context.getRequest()).getRequestURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
