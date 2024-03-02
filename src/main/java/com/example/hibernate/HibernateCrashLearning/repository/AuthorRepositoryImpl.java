package com.example.hibernate.HibernateCrashLearning.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepositoryImpl implements CustomRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void deleteAuthorById(Long authorId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            // Create a HQL query to delete the Author by name
            String hql = "DELETE FROM AuthorBook WHERE id = :authorId";
            Query deleteQuery = session.createQuery(hql);
            deleteQuery.setParameter("authorId", authorId);
            deleteQuery.executeUpdate();
            Query authorDeleteQuery = session.createQuery("DELETE FROM Author WHERE id = :id");
            authorDeleteQuery.setParameter("id", authorId);
            authorDeleteQuery.executeUpdate();
            // Commit the transaction
            transaction.commit();
        }
    }
}
