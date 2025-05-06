package library.catalog.application.request;

import java.util.UUID;

public record RegisterBookCopyRequest(UUID bookId, String barCode) {
}
