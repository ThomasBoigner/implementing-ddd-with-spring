package library.lending.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;

@RequiredArgsConstructor
public class LoanService {
    private final LoanRepository loanRepository;

    public Loan rentBook(CopyId copyId, UserId userId) {
        Assert.isTrue(loanRepository.isAvailable(copyId), "copy with id = %s is not available".formatted(copyId));
        return loanRepository.save(new Loan(copyId, userId));
    }
}
