package controllers;

import entities.Comment;
import entities.Post;
import services.CommentService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;
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

    public List<Comment> getListComment(Post post)
    {
        return commentService.get().getListByPost(post);
    }
}
