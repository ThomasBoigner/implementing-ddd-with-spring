package library.lending.infrastructure.repository.jpa;

import library.lending.domain.CopyId;
import library.lending.domain.Loan;
import library.lending.domain.LoanId;
import library.lending.domain.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Repository
public class JpaLoanRepository implements LoanRepository {
    private final LoanEntityRepository loanEntityRepository;

    @Override
    public Loan save(Loan loan) {
        loanEntityRepository.save(new LoanEntity(loan));
        return loan;
    }

    @Override
    public boolean isAvailable(CopyId id) {
        return loanEntityRepository.isAvailable(id.id());
    }

    @Override
    public Loan findByIdOrThrow(LoanId loanId) {
        return loanEntityRepository.findById(loanId.id()).orElseThrow().toLoan();
    }

    @Override
    public List<Loan> findAll() {
        return loanEntityRepository.findAll().stream().map(LoanEntity::toLoan).toList();
    }
}
