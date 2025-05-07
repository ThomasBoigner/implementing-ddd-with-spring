package library.catalog.application;

import jakarta.transaction.Transactional;
import library.catalog.domain.Book;
import library.catalog.domain.BookRepository;
import library.catalog.domain.Isbn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
@Transactional
public class AddBookToCatalogUseCase {

    private final IsbnSearchService isbnSearchService;
    private final BookRepository bookRepository;

    public void execute(Isbn isbn) {
        BookInformation bookInformation = isbnSearchService.search(isbn);
        bookRepository.save(new Book(bookInformation.title(), isbn));
    }
}
