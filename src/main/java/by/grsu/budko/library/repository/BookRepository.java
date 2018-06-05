package by.grsu.budko.library.repository;

import by.grsu.budko.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// get all crud methods in our interface
public interface BookRepository extends CrudRepository<Book, Long> {
    //List<Book> findByTitle(String bookTitle);
}
