package library.catalog.infrastructure;

import library.catalog.domain.Book;
import library.catalog.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
