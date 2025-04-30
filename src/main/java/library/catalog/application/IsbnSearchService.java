package library.catalog.application;

import library.catalog.domain.Isbn;

public interface IsbnSearchService {
    BookInformation search(Isbn isbn);
}
