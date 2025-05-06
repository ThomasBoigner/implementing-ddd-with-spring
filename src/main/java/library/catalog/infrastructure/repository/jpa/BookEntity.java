package library.catalog.infrastructure.repository.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import library.catalog.domain.Book;
import library.catalog.domain.BookId;
import library.catalog.domain.Isbn;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public Book toBook() {
        return new Book(new BookId(this.id), title, new Isbn(this.isbn));
    }
}
