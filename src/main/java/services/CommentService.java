package services;


import dao.CommentAccess;
import entities.Comment;
import entities.Post;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@SessionScoped
public class CommentService implements Serializable {
    @Inject
    private Instance<CommentAccess> managerAccess;

    /**
     * Ajoute un commentaire
     * @param comment : commentaire en question
     * @return le commentaire ajouté
     */
    public Comment Add(Comment comment)
    {
        return managerAccess.get().Add(comment);
    }


    /**
     * Supprime un commentaire
     * @param comment : commentaire en question
     * @return vrai si cest ok, faux sinon
     */
    public boolean Delete(Comment comment)
    {
        return managerAccess.get().Delete(comment);
    }


    /**
     * Met a jour un commentaire
     * @param comment : le commmentaire à mettre à jour
     * @return vrai si cest ok, faux sinon
     */
    public boolean Update(Comment comment)
    {
        return managerAccess.get().Update(comment);
    }


    /**
     * Retourne la list des commentaires
     * @return la liste en question
     */
    public List getList()
    {
        return managerAccess.get().getList(Comment.class);
    }


    /**
     * Retourne un commentaire en fonction de son id
     * @param id : id en question
     * @return commentaire en question
     */
    public Comment getById(int id)
    {
        return managerAccess.get().getById(Comment.class, id);
    }

    /**
     * Renvoie la liste des commentaire lié à un post
     * @param post : post en question
     * @return list en question
     */
    public List<Comment> getListByPost(Post post)
    {
        return managerAccess.get().getListByPost(post);
    }
}
