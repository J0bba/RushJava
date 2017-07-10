package dao;


import lombok.Data;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Data
@ApplicationScoped
public class ManagerAccess {
    @PersistenceContext(unitName = "blogster")
    private EntityManager em;

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
    public <T> List getList(T type)
    {
        return em.createQuery("select a from " + type.getClass().getSimpleName() + " a")
                .getResultList();
    }
}
