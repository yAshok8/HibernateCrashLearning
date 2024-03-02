package com.example.hibernate.HibernateCrashLearning.repository;

import com.example.hibernate.HibernateCrashLearning.entity.Author;

public interface CustomRepository {
//    public Author findAuthorByName(String authorName);
    public void deleteAuthorById(Long authorId);
}

