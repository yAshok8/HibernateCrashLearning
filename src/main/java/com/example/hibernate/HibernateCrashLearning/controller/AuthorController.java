package com.example.hibernate.HibernateCrashLearning.controller;

import com.example.hibernate.HibernateCrashLearning.entity.Author;
import com.example.hibernate.HibernateCrashLearning.entity.Book;
import com.example.hibernate.HibernateCrashLearning.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@Transactional
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<?> createAuthor(@RequestBody Author author) {
        try {
            // Validate the input data (you can add your own validation logic)
            if (author == null || author.getName() == null || author.getName().isEmpty()) {
                return new ResponseEntity<>("Invalid author data", HttpStatus.BAD_REQUEST);
            }

            // Create a new Author entity from the request data
            Author newAuthor = new Author();
            newAuthor.setName(author.getName());

            // Save the new author using the AuthorService (assumed to be implemented)
            Author savedAuthor = authorService.createAuthor(newAuthor);

            // Return the created author with a 201 Created status
            return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>("Failed to create author: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable("id") Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @GetMapping
    public Author getAuthorByName(@RequestParam(name = "name") String authorName) {
        return authorService.getAuthorByName(authorName);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        try {
            if (author == null || author.getName() == null || author.getName().isEmpty()) {
                return new ResponseEntity<>("Invalid author data", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(authorService.updateAuthor(author), HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle exceptions and return an appropriate response
            return new ResponseEntity<>("Failed to create author: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return new ResponseEntity<>("Author has been deleted successfully.", HttpStatus.OK);
    }

    @GetMapping("/byAuthor")
    public List<Book> getBooksByAuthor(@RequestParam(name = "authorId") Long authorId) {
        Set<Book> authorBooks = authorService.getAuthorBooks(authorId);
        List<Book> books;
        if (!authorBooks.isEmpty()) {
            books = new ArrayList<>(authorBooks);
        } else {
            return Collections.emptyList();
        }
        return books;
    }

}
