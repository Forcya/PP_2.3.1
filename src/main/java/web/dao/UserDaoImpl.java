package web.dao;

import web.entity.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //специальная аннотация, как контроллер - @Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> allUser = entityManager.createQuery("from User", User.class).getResultList();
        return allUser;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser (int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }



    @Override
    public void updateUser(User user) {
        User updatedUser = getUser(user.getId());
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setAge(user.getAge());
        updatedUser.setEmail(user.getEmail());
    }
}

