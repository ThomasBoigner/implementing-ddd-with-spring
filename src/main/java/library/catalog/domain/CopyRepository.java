package library.catalog.domain;

import java.util.Optional;

public interface CopyRepository {
    Copy save(Copy copy);
    Optional<Copy> findById(CopyId id);
}
