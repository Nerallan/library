package by.grsu.budko.library.service;

import by.grsu.budko.library.model.Book;

import javax.transaction.Transactional;
import java.util.List;

public interface BookService {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(int id);

    public Book getBookById(int id);

    public List<Book> listBooks();
}

