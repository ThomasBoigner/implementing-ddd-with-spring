package library.lending.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Loan {
    private LoanId id;
    private CopyId copyId;
    private UserId userId;
    private LocalDateTime createdAt;
    private LocalDate expectedReturnDate;
    private LocalDateTime returnedAt;
    private List<LoanCreated> loanCreatedDomainEvents;
    private List<LoanClosed> loanClosedDomainEvents;

    Loan(CopyId copyId, UserId userId) {
        Assert.notNull(copyId, "copyId must not be null");
        Assert.notNull(userId, "userId must not be null");
        this.id = new LoanId();
        this.copyId = copyId;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
        this.expectedReturnDate = LocalDate.now().plusDays(30);
        this.loanCreatedDomainEvents = new ArrayList<>();
        this.loanClosedDomainEvents = new ArrayList<>();
        this.loanCreatedDomainEvents.add(new LoanCreated(this.copyId));
    }

    public Loan(LoanId id, CopyId copyId, UserId userId, LocalDateTime createdAt, LocalDate expectedReturnDate, LocalDateTime returnedAt) {
        this.id = id;
        this.copyId = copyId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.expectedReturnDate = expectedReturnDate;
        this.returnedAt = returnedAt;
        this.loanCreatedDomainEvents = new ArrayList<>();
        this.loanClosedDomainEvents = new ArrayList<>();
    }

    public void returned() {
        this.returnedAt = LocalDateTime.now();
        if (this.returnedAt.isAfter(expectedReturnDate.atStartOfDay())) {
            // calculate fee
        }
        this.loanClosedDomainEvents.add(new LoanClosed(this.copyId));
    }
}
