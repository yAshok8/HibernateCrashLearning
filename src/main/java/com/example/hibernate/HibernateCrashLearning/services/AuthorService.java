package com.example.hibernate.HibernateCrashLearning.services;

import com.example.hibernate.HibernateCrashLearning.entity.Author;
import com.example.hibernate.HibernateCrashLearning.entity.Book;
import com.example.hibernate.HibernateCrashLearning.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            return author.get();
        }
        throw new EntityNotFoundException("Author with id " + id + " is not present in database.");
    }

    public Author getAuthorByName(String authorName) {
        return authorRepository.findAuthorByName(authorName);
    }

    public Author updateAuthor(Author author) {
        if (authorRepository.existsById(author.getAuthorId())) {
            return authorRepository.save(author);
        }
        throw new EntityNotFoundException("Author not found with ID: " + author.getAuthorId());
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteAuthorById(authorId);
    }

    public Set<Book> getAuthorBooks(Long authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get().getBooks();
        } else {
            // Handle the case where the author with the given ID is not found
            throw new EntityNotFoundException("Author not found with ID: " + authorId);
        }
    }
}
