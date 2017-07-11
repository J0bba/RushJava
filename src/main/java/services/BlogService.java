package services;

import dao.BlogAccess;
import entities.Blog;
import entities.User;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class BlogService implements Serializable {
    @Inject
    private Instance<BlogAccess> blogAccess;

    /**
     * Ajoute un blog en base de données
     * @param blog : blog à ajouter
     * @return blog ajouté
     */
    public Blog Add(Blog blog)
    {
        return blogAccess.get().Add(blog);
    }


    /**
     * Supprime un blog en base de données
     * @param blog : blog à supprimer
     * @return vrai si c'est ok, faux si erreur
     */
    public boolean Delete(Blog blog)
    {
        return blogAccess.get().Delete(blog);
    }


    /**
     * Met à jour le blog
     * @param blog : blog à update
     * @return vrai si ça a marché, faux si erreur
     */
    public boolean Update(Blog blog)
    {
        return blogAccess.get().Update(blog);
    }

    /**
     * retourne la liste des blogs
     * @return List<Blog>
     */
    public List getList()
    {
        return blogAccess.get().getList(Blog.class);
    }


    /**
     * Retourne un blog en fonction de son id
     * @param id : id du blog
     * @return le blog en question
     */
    public Blog getById(int id) {
        return blogAccess.get().getById(Blog.class, id);
    }


    /**
     * retourne la liste des blog en fonction du user
     * @param user : user en question
     * @return la liste des blogs
     */
    public List<Blog> getListByUserId(User user)
    {
        return blogAccess.get().getListByUser(user);
    }


    /**
     * Archive le blog, le rendant illisible sur le site
     * @param blog : blog en question
     */
    public void Archive(Blog blog)
    {
        blogAccess.get().Archive(blog);
    }
}
