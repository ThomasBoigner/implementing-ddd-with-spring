package library.lending.infrastructure.repository.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import library.lending.domain.CopyId;
import library.lending.domain.Loan;
import library.lending.domain.LoanId;
import library.lending.domain.UserId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class LoanEntity {
    @Id
    private UUID id;
    private UUID copyId;
    private UUID userId;
    private LocalDateTime createdAt;
    private LocalDate expectedReturnDate;
    private LocalDateTime returnedAt;

    public LoanEntity(Loan loan) {
        this.id = loan.getId().id();
        this.copyId = loan.getCopyId().id();
        this.userId = loan.getUserId().id();
        this.createdAt = loan.getCreatedAt();
        this.expectedReturnDate = loan.getExpectedReturnDate();
        this.returnedAt = loan.getReturnedAt();
    }

    public Loan toLoan() {
        return new Loan(
                new LoanId(this.id),
                new CopyId(this.copyId),
                new UserId(this.userId),
                createdAt,
                expectedReturnDate,
                returnedAt
        );
    }
}
