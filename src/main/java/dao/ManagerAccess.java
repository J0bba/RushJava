package dao;


import lombok.Data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Data
public class ManagerAccess {
    @PersistenceContext(unitName = "blogster")
    private EntityManager em;

    public <T> T Add(T obj)
    {
        return em.merge(obj);
    }

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
}
