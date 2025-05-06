package library.lending.application.response;

import library.lending.domain.Loan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record LoanResponse(UUID id, UUID copyId, UUID userId, LocalDateTime createdAt, LocalDate expectedReturnDate,
                           LocalDateTime returnedAt) {
    public LoanResponse(Loan loan) {
        this(loan.getId().id(),
                loan.getCopyId().id(),
                loan.getUserId().id(),
                loan.getCreatedAt(),
                loan.getExpectedReturnDate(),
                loan.getReturnedAt()
        );
    }
}
