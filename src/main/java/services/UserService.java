package services;

import dao.ManagerAccess;
import entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class UserService  {
    @Inject
    private ManagerAccess managerAccess;

    public List getList() {
        return managerAccess.getList(new User());
    }

    public User Add(User user)
    {
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
}
