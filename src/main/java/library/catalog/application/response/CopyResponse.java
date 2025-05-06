package library.catalog.application.response;

import library.catalog.domain.Copy;

import java.util.UUID;

public record CopyResponse(UUID id, UUID bookId, String barCode, boolean available) {
    public CopyResponse(Copy copy) {
        this(copy.getId().id(), copy.getBookId().id(), copy.getBarCode().code(), copy.isAvailable());
    }
}
