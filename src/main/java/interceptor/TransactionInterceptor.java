package interceptor;

import org.hibernate.HibernateException;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Interceptor @Transaction
public class TransactionInterceptor {
    @PersistenceContext(unitName = "blogster")
    EntityManager em;

    @AroundInvoke
    public Object invoke(InvocationContext context) throws Exception {
        try {
            em.getTransaction().begin();
            final Object result = context.proceed();
            em.getTransaction().commit();
            return result;
        } catch (HibernateException e)
        {
            return null;
        }
    }
}
