package library.catalog.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import library.catalog.domain.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class BookEntity {
    @Id
    private UUID id;
    private String title;
    private String isbn;

    public BookEntity(Book book) {
        this.id = book.getId().id();
        this.title = book.getTitle();
        this.isbn = book.getIsbn().value();
    }
}
