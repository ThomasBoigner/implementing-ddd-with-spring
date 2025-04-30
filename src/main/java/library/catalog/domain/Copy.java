package library.catalog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
@AllArgsConstructor
public class Copy {
    private CopyId id;
    private BookId bookId;
    private BarCode barCode;
    private boolean available;

    public Copy(BookId bookId, BarCode barCode){
        Assert.notNull(bookId, "bookId must not be null");
        Assert.notNull(barCode, "barCode must not be null");
        this.id = new CopyId();
        this.bookId = bookId;
        this.barCode = barCode;
        this.available = true;
    }

    public void makeUnavailable() {
        this.available = false;
    }

    public void makeAvailable() {
        this.available = true;
    }
}
