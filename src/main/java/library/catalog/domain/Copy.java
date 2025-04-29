package library.catalog.domain;

import lombok.Getter;

@Getter
public class Copy {
    private CopyId id;
    private BookId bookId;
    private BarCode barCode;
    private boolean available;
}
