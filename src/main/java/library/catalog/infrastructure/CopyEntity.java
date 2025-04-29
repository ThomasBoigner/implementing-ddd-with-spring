package library.catalog.infrastructure;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import library.catalog.domain.Copy;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class CopyEntity {
    @Id
    private UUID id;
    private UUID bookId;
    private String barCode;
    private boolean available;

    public CopyEntity(Copy copy) {
        this.id = copy.getId().id();
        this.bookId = copy.getBookId().id();
        this.barCode = copy.getBarCode().code();
        this.available = copy.isAvailable();
    }
}
