package library.catalog.infrastructure.repository.jpa;

import library.catalog.domain.Book;
import library.catalog.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor

@Repository
public class JpaBookRepository implements BookRepository {
    private final BookEntityRepository bookEntityRepository;

    @Override
    public Book save(Book book) {
        BookEntity entity = new BookEntity(book);
        bookEntityRepository.save(entity);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return bookEntityRepository.findAll().stream().map(BookEntity::toBook).toList();
    }
}
