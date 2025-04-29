package library.catalog.infrastructure;

import library.catalog.domain.Copy;
import library.catalog.domain.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
}
