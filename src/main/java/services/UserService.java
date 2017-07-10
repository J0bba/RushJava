package services;

import dao.ManagerAccess;
import dao.UserAccess;
import entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class UserService implements Serializable{
    @Inject
    private UserAccess managerAccess;

    public List getList() {
        return managerAccess.getList(User.class);
    }


    public User Add(String username, String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return managerAccess.Add(user);
    }

    public boolean Update(User user)
    {
        return managerAccess.Update(user);
    }

    public boolean Delete(User user)
    {
        return managerAccess.Delete(user);
    }

    public User getById(int id)
    {
        return managerAccess.getById(User.class, id);
    }

    public User getByUsername(String username)
    {
        return managerAccess.getByUsername(username);
    }
}
