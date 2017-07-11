package services;

import dao.UserAccess;
import entities.User;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class UserService implements Serializable {
    @Inject
    private Instance<UserAccess> managerAccess;

    public List getList() {
        return managerAccess.get().getList(User.class);
    }


    public User Add(String username, String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return managerAccess.get().Add(user);
    }

    public boolean Update(User user)
    {
        return managerAccess.get().Update(user);
    }

    public boolean Delete(User user)
    {
        return managerAccess.get().Delete(user);
    }

    public User getById(int id)
    {
        return managerAccess.get().getById(User.class, id);
    }

    public User getByUsername(String username)
    {
        return managerAccess.get().getByUsername(username);
    }
}
