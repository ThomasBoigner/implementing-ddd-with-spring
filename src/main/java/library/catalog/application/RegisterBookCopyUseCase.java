package library.catalog.application;

import library.catalog.domain.BarCode;
import library.catalog.domain.BookId;
import library.catalog.domain.Copy;
import library.catalog.domain.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor

@Service
@Transactional
public class RegisterBookCopyUseCase {
    private final CopyRepository copyRepository;

    public void execute(BookId bookId, BarCode barCode) {
        copyRepository.save(new Copy(bookId, barCode));
    }
}
