package library.catalog.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CopyEntityRepository extends JpaRepository<CopyEntity, UUID> {
}
