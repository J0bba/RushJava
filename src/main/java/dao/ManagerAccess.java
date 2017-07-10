package dao;


import entities.User;
import lombok.Data;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Data
@SessionScoped
@Any
public class ManagerAccess implements Serializable{
    @PersistenceContext(unitName = "blogster")
    protected EntityManager em;

    @Transactional
    public <T> T Add(T obj)
    {
        return em.merge(obj);
    }

    @Transactional
    public <T> boolean Delete(T obj)
    {
        try {
            em.remove(obj);
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

    @Transactional
    public <T> boolean Update(T obj)
    {
        try {
            obj = em.merge(obj);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    @Transactional
    public <T> List getList(Class<T> type)
    {
        return em.createQuery("select a from " + type.getSimpleName() + " a")
                .getResultList();
    }

    @Transactional
    public <T> T getById(Class<T> type, int id)
    {
        return em.find(type, id);
    }
}
