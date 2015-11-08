package domain;

import com.mycompany.model.HelthCard;
import com.mycompany.model.Index;
import com.mycompany.model.User;
import com.mycompany.model.UserToInstruction;
import com.mycompany.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author yevgen
 */
public class DAO {

    protected static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public List<User> list() {
        List<User> objects = new ArrayList<>();
        Session session  = sessionFactory.openSession();
        Query query = session.createQuery("from User");
        objects = query.list();
        session.close();
        return objects;
    }
    
     public User user(int id) {
        User object = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User p where p.id = :ID");
        query.setParameter("ID", id);
        object = (User) query.uniqueResult();
        session.close();
        return object;
    }
     
     public void create(User user) {
        Session session =  sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.persist(new Index(0, 0, 0, 0, user));
        session.close();
    }
     
     public User checkUsernamePassword(String username, String password){
        Session session  = sessionFactory.openSession();
        Query query = session.createQuery("from User p where p.username=:username and p.password=:password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        session.close();
        return user;
    }
     
     public HelthCard card(int id){
         Session session  = sessionFactory.openSession();
        Query query = session.createQuery("from HelthCard p where p.user.id=:id");
        query.setParameter("id", id);
        HelthCard card = (HelthCard) query.uniqueResult();
        session.close();
        return card;
     }
     
     public void write(int type_id, double value, int user_id){
        Session session  = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Index p where p.user.id=:id and p.indexType=:type");
        query.setParameter("id", user_id);
        query.setParameter("type", type_id);
        Index old = (Index) query.uniqueResult();
        old.setCount(old.getCount() + 1);
        old.setValue(old.getValue() + value);
        session.merge(old);
        session.getTransaction().commit();
        session.close();
     }
     
     public List<UserToInstruction> getInstruct(int id){
         List<UserToInstruction> object = new ArrayList<>();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from UserToInstruction p where p.user.id = :ID");
        query.setParameter("ID", id);
        object = (List<UserToInstruction>) query.list();
        session.close();
        return object;
     }
     
     public Index readIndex(int id, int type){
         Index object = null;
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Index p where p.user.id = :ID and p.indexType = :TYPE");
        query.setParameter("ID", id);
        query.setParameter("TYPE", type);
        object = (Index) query.uniqueResult();
        session.close();
        return object;
     }
}
