package controllers;

import entities.User;
import services.UserService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@Named
public class UsersController implements Serializable {
    @Inject
    private UserService userService;

    public List getList()
    {
        return userService.getList();
    }
}
