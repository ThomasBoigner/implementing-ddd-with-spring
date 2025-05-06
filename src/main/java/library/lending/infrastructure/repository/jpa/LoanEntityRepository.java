package library.lending.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface LoanEntityRepository extends JpaRepository<LoanEntity, UUID> {
    @Query("select count(*) = 0 from LoanEntity where copyId = :id and returnedAt is null")
    boolean isAvailable(UUID id);
}
