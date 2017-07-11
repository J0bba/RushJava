package controllers;

import entities.User;
import org.primefaces.context.RequestContext;
import services.UserService;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class UsersController implements Serializable {
    @Inject
    private Instance<UserService> userService;

    public List getList()
    {
        return userService.get().getList();
    }

    private String username;

    private String password;

    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        boolean loggedIn = false;
        User user = userService.get().getByUsername(username);

        if (user == null)
        {
            session.setAttribute("error_message", "Username does not exists");
            loggedIn = false;
        }
        else
        {
            if (!user.getPassword().equals(password))
            {
                loggedIn = false;
                session.setAttribute("error_message", "Invalid Username/Password combination");
            }
            else
            {
                loggedIn = true;
                session.setAttribute("user_id", user.getId());
                session.setAttribute("username", user.getUsername());
                ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                try {
                    externalContext.redirect(externalContext.getRequestContextPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        context.addCallbackParam("loggedIn", loggedIn);
    }

    public void logout()
    {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        if (session.getAttribute("user_id") != null && session.getAttribute("username") != null)
        {
            session.removeAttribute("user_id");
            session.removeAttribute("username");
        }
    }

    public void register(ActionEvent event) throws IOException {
        User user = userService.get().getByUsername(username);

        if(user == null && username != null && password != null) {
            userService.get().Add(username, password);
            System.out.println("user created successfully");
        } else {
            System.out.println("user not created");
        }

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/login.xhtml");
    }
}
