package library.lending.application;

import library.lending.domain.CopyId;
import library.lending.domain.LoanService;
import library.lending.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class RentBookUseCase {
    private final LoanService loanService;

    public void execute(CopyId copyId, UserId userId) {
        loanService.rentBook(copyId, userId);
    }
}
