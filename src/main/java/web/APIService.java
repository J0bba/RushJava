package web;

import dao.BlogAccess;
import dao.PostAccess;
import entities.Blog;
import entities.Post;
import org.codehaus.jackson.map.ObjectMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.ws.rs.*;
import java.io.IOException;
import java.util.ArrayList;
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
    public String getBlogs() {
        ObjectMapper mapper = new ObjectMapper();
        List<Blog> blogs = blogAccess.get().getList(Blog.class);
        ArrayList res = new ArrayList();
        for (Blog blog : blogs)
            res.add(blog.getName());

        try {
            return mapper.writeValueAsString(res);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    @GET
    @Path("/blogs/{id}")
    public String getPosts(@PathParam("id") int id) {
        ObjectMapper mapper = new ObjectMapper();
        List<Post> posts = postAccess.get().getListByBlogId(id);
        ArrayList res = new ArrayList();
        for (Post post : posts)
            res.add(post.getName());

        try {
            return mapper.writeValueAsString(res);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }
}