package library.lending.domain;

import java.util.List;

public interface LoanRepository {
    Loan save(Loan loan);
    boolean isAvailable(CopyId id);
    Loan findByIdOrThrow(LoanId loanId);
    List<Loan> findAll();
}
