package library.catalog.domain;

import java.util.List;
import java.util.Optional;

public interface CopyRepository {
    Copy save(Copy copy);
    Optional<Copy> findById(CopyId id);
    List<Copy> findAll();
}
