package library.catalog.application.response;

import library.catalog.domain.Book;

import java.util.UUID;

public record BookResponse(UUID id, String title, String isbn) {
    public BookResponse(Book book) {
        this(book.getId().id(), book.getTitle(), book.getIsbn().value());
    }
}
