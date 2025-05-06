package library.catalog.infrastructure.repository.jpa;

import library.catalog.domain.Copy;
import library.catalog.domain.CopyId;
import library.catalog.domain.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor

@Repository
public class JpaCopyRepository implements CopyRepository {
    private final CopyEntityRepository copyEntityRepository;

    @Override
    public Copy save(Copy copy) {
        CopyEntity copyEntity = new CopyEntity(copy);
        copyEntityRepository.save(copyEntity);
        return copy;
    }

    @Override
    public Optional<Copy> findById(CopyId id) {
        return copyEntityRepository.findById(id.id()).map(CopyEntity::toCopy);
    }
}
