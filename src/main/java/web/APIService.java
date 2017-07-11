package web;

import dao.BlogAccess;
import dao.PostAccess;
import entities.Blog;
import entities.Post;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

@WebService
@Path("/")
@Produces("application/json; charset=UTF-8")
@ApplicationScoped
public class APIService {
    @Inject
    private Instance<BlogAccess> blogAccess;

    @Inject
    private Instance<PostAccess> postAccess;

    @GET
    @Path("/blogs")
    public List getBlogs() {
        return blogAccess.get().getList(Blog.class);
    }

    @GET
    @Path("/blogs/{id}")
    public List<Post> getPosts(@PathParam("id") int id) {
        return postAccess.get().getListByBlogId(id);
    }
}