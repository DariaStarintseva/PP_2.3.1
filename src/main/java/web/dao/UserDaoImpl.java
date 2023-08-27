package web.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    List<User> users = new ArrayList<>();
    public List<User> getAllUsers() {
        String HQL = "from User";
        users = entityManager.createQuery(HQL, User.class).getResultList();
        return users;
    }

    public void save(User user) {
        entityManager.persist(user);

    }
}

