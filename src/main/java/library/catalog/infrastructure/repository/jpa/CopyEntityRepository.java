package library.catalog.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CopyEntityRepository extends JpaRepository<CopyEntity, UUID> {
}
