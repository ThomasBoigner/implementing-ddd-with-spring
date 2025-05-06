package library.catalog.domain;

import java.util.List;

public interface BookRepository {
    Book save(Book book);
    List<Book> findAll();
}
