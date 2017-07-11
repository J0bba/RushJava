package services;

import dao.PostAccess;
import entities.Post;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class PostService implements Serializable {
    @Inject
    private Instance<PostAccess> postAccess;

    /**
     * Ajoute un post
     * @param post : le post à ajouter
     * @return : le post ajouté
     */
    public Post Add(Post post)
    {
        return postAccess.get().Add(post);
    }

    /**
     * Supprime un post
     * @param post : le post à supprimer
     * @return : si l'action a réussi ou non
     */
    public boolean Delete(Post post)
    {
        return postAccess.get().Delete(post);
    }

    /**
     * Met à jour un post
     * @param post : le post à mettre à jour
     * @return : si l'action a réussi ou non
     */
    public boolean Update(Post post)
    {
        return postAccess.get().Update(post);
    }

    /**
     * Récupère la liste des posts
     * @return : la liste totale des posts
     */
    public List getList()
    {
        return postAccess.get().getList(Post.class);
    }

    /**
     * Récupère un post par un identifiant
     * @param id : l'identifiant du post
     * @return : le post à récupérer
     */
    public Post getById(int id)
    {
        return postAccess.get().getById(Post.class, id);
    }

    /**
     * Récupère la liste des posts relatifs à un blog
     * @param blog_id : l'id du blog
     * @return : la liste des posts à récupérer
     */
    public List<Post> getListByBlogId(int blog_id)
    {
        return postAccess.get().getListByBlogId(blog_id);
    }

    /**
     * Permet d'archiver un post
     * @param post : le post à archiver
     */
    public void Archive(Post post)
    {
        postAccess.get().Archive(post);
    }
}
