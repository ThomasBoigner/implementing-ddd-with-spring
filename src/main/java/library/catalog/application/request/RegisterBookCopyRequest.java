package library.catalog.application.request;

import library.catalog.domain.BarCode;

import java.util.UUID;

public record RegisterBookCopyRequest(UUID bookId, String barCode) {
}
