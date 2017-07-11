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

    /**
     *
     * @return : la liste des utilisateurs
     */
    public List getList() {
        return managerAccess.get().getList(User.class);
    }

    /**
     * Ajoute un utilisateur
     * @param username : le pseudo de l'utilisateur
     * @param password : le mot de passe de l'utilisateur
     * @return : l'utilisateur ajouté
     */
    public User Add(String username, String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return managerAccess.get().Add(user);
    }

    /**
     * Met à jour un utilisateur
     * @param user : l'utilisateur à mettre à jour
     * @return : si l'action a réussi ou non
     */
    public boolean Update(User user)
    {
        return managerAccess.get().Update(user);
    }

    /**
     * Supprime un utilisateur
     * @param user : l'utilisateur à supprimer
     * @return : si l'action a réussi ou non
     */
    public boolean Delete(User user)
    {
        return managerAccess.get().Delete(user);
    }

    /**
     * Récupère un utilisateur par son identifiant
     * @param id : l'identifiant de l'utilisateur
     * @return : l'utilisateur à retourner
     */
    public User getById(int id)
    {
        return managerAccess.get().getById(User.class, id);
    }

    /**
     * Récupère un utilisateur par son pseudo
     * @param username : le pseudo de l'utilisateur
     * @return : l'utilisateur à retourner
     */
    public User getByUsername(String username)
    {
        return managerAccess.get().getByUsername(username);
    }
}
