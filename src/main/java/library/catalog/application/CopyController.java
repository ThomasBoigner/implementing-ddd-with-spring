package library.catalog.application;


import library.catalog.application.request.RegisterBookCopyRequest;
import library.catalog.application.response.CopyResponse;
import library.catalog.domain.BarCode;
import library.catalog.domain.BookId;
import library.catalog.domain.Copy;
import library.catalog.domain.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@RestController
@RequestMapping(value = CopyController.BASE_URL)
public class CopyController {

    private final CopyRepository copyRepository;
    private final RegisterBookCopyUseCase registerBookCopyUseCase;

    public static final String BASE_URL = "/api/copies";
    public static final String PATH_INDEX = "/";

    @GetMapping({"", PATH_INDEX})
    public HttpEntity<List<CopyResponse>> getAllCopies(){
        List<CopyResponse> copies = copyRepository.findAll().stream().map(CopyResponse::new).toList();
        return (copies.isEmpty())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(copies);
    }

    @PostMapping
    public HttpEntity<Void> registerBookCopy(@RequestBody RegisterBookCopyRequest request) {
        registerBookCopyUseCase.execute(new BookId(request.bookId()), new BarCode(request.barCode()));
        return ResponseEntity.ok().build();
    }
}
