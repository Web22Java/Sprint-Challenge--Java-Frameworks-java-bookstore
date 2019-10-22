package com.lambdaschool.shelbysprintbookstore.services;

import com.lambdaschool.shelbysprintbookstore.models.Book;
import com.lambdaschool.shelbysprintbookstore.repository.AuthorRepository;
import com.lambdaschool.shelbysprintbookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Service(value = "bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository repo;

    @Autowired
    private AuthorRepository authorRepo;

    @Override
    public List<Book> findAll(Pageable pageable) {
        List<Book> list = new ArrayList<>();
        repo.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public Book updateBook(Book book, long id) {
        Book currentBook = repo.findById(id).orElseThrow(EntityNotFoundException::new);
        if (book.getBooktitle() != null) {
            currentBook.setBooktitle(book.getBooktitle());
        }
        if (book.getISBN() != null) {
            currentBook.setISBN(book.getISBN());
        }
        if (book.getAuthors() != null && book.getAuthors().size() > 0) {
            currentBook.setAuthors(book.getAuthors());
        }
        if (book.getCopy() < 0) {
            currentBook.setCopy(book.getCopy());
        }

        repo.save(currentBook);
        return currentBook;
    }

    @Override
    public void delete(long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }

    }

    @Transactional
    @Override
    public void assignAuthor(long bookid, long authorid) {
        Book currentBook = repo.findById(bookid).orElseThrow(EntityNotFoundException::new);
        currentBook.getAuthors().add(authorRepo.findById(authorid).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public void save(Book book) {
        repo.save(book);
    }
}