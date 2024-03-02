package com.example.hibernate.HibernateCrashLearning.repository;// UserRepository.java

import com.example.hibernate.HibernateCrashLearning.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUserById(Long id) {
        return getCurrentSession().get(User.class, id);
    }

    public List<User> getAllUsers() {
        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);
        return getCurrentSession().createQuery(criteriaQuery).getResultList();
    }

    public void saveUser(User user) {
        getCurrentSession().saveOrUpdate(user);
    }

    public void deleteUser(Long id) {
        User user = getCurrentSession().load(User.class, id);
        getCurrentSession().delete(user);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
