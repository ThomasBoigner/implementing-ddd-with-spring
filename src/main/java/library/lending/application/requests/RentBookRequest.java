package library.lending.application.requests;

import java.util.UUID;

public record RentBookRequest(UUID copyId, UUID userId) {
}
