package com.example.hibernate.HibernateCrashLearning.repository;

import com.example.hibernate.HibernateCrashLearning.entity.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>, CustomRepository {
    // You can add custom query methods here if needed

    @Query("select a from Author a where a.name = :authorName")
    Author findAuthorByName(String authorName);
}
