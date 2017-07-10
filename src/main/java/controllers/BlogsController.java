package controllers;

import dao.BlogAccess;
import entities.Blog;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Thiba on 10/07/2017.
 */
@ApplicationScoped
@Named
public class BlogsController {

    @Inject
    private BlogAccess managerAccess;
    public List<Blog> getListOfUser()
    {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        int user_id = (int)session.getAttribute("user_id");
        return managerAccess.getListByUserId(user_id);
    }
}
