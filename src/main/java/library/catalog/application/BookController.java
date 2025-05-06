package library.catalog.application;

import library.catalog.application.request.AddBookToCatalogRequest;
import library.catalog.application.response.BookResponse;
import library.catalog.domain.BookRepository;
import library.catalog.domain.Isbn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(value = BookController.BASE_URL)
public class BookController {

    private final BookRepository bookRepository;
    private final AddBookToCatalogUseCase addBookToCatalogUseCase;

    public static final String BASE_URL = "/api/books";
    public static final String PATH_INDEX = "/";

    @GetMapping({"", PATH_INDEX})
    public HttpEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> books = bookRepository.findAll().stream().map(BookResponse::new).toList();
        return (books.isEmpty())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(books);
    }

    @PostMapping({"", PATH_INDEX})
    public HttpEntity<Void> addBookToCatalog(@RequestBody AddBookToCatalogRequest request) {
        addBookToCatalogUseCase.execute(new Isbn(request.isbn()));
        return ResponseEntity.ok().build();
    }

}
