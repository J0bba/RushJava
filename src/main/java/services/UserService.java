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
}
