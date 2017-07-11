package services;

import dao.PostAccess;
import entities.Post;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class PostService implements Serializable {
    @Inject
    private Instance<PostAccess> postAccess;

    public Post Add(Post post)
    {
        return postAccess.get().Add(post);
    }

    public boolean Delete(Post post)
    {
        return postAccess.get().Delete(post);
    }

    public boolean Update(Post post)
    {
        return postAccess.get().Update(post);
    }

    public List getList()
    {
        return postAccess.get().getList(Post.class);
    }

    public Post getById(int id)
    {
        return postAccess.get().getById(Post.class, id);
    }

    public List<Post> getListByBlogId(int blog_id)
    {
        return postAccess.get().getListByBlogId(blog_id);
    }

    public void Archive(Post post)
    {
        postAccess.get().Archive(post);
    }
}
