package library.lending.domain;

public interface LoanRepository {
    Loan save(Loan loan);
    boolean isAvailable(CopyId id);
    Loan findByIdOrThrow(LoanId loanId);
}
