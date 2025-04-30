package library.catalog.infrastructure;

import library.catalog.application.BookInformation;
import library.catalog.application.IsbnSearchService;
import library.catalog.domain.Isbn;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
class OpenLibraryBookSearchService implements IsbnSearchService {

    private final RestClient restClient;

    public OpenLibraryBookSearchService(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://openlibrary.org/")
                .build();
    }

    public BookInformation search(Isbn isbn) {
        OpenLibraryIsbnSearchResult result = restClient.get().uri("isbn/{isbn}.json", isbn.value())
                .retrieve()
                .body(OpenLibraryIsbnSearchResult.class);

        if (result == null) {
            return null;
        }

        return new BookInformation(result.title());
    }
}
