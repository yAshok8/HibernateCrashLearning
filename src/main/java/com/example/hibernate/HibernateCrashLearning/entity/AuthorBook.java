package com.example.hibernate.HibernateCrashLearning.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR_BOOK")
public class AuthorBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;
}
