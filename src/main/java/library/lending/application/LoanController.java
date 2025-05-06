package library.lending.application;

import library.lending.application.requests.RentBookRequest;
import library.lending.application.requests.ReturnBookRequest;
import library.lending.application.response.LoanResponse;
import library.lending.domain.CopyId;
import library.lending.domain.LoanId;
import library.lending.domain.LoanRepository;
import library.lending.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping(value = LoanController.BASE_URL)
public class LoanController {
    private final LoanRepository loanRepository;
    private final RentBookUseCase rentBookUseCase;
    private final ReturnBookUseCase returnBookUseCase;

    public static final String BASE_URL = "/api/loans";
    public static final String PATH_INDEX = "/";
    public static final String RENT_BOOK = "/rent";
    public static final String RETURN_BOOK = "/return";

    @GetMapping({"", PATH_INDEX})
    public HttpEntity<List<LoanResponse>> getAllLoans() {
        List<LoanResponse> loans = loanRepository.findAll().stream().map(LoanResponse::new).toList();
        return (loans.isEmpty())
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(loans);
    }

    @PostMapping(RENT_BOOK)
    public HttpEntity<Void> rentBook(@RequestBody RentBookRequest request){
        rentBookUseCase.execute(new CopyId(request.copyId()), new UserId(request.userId()));
        return ResponseEntity.ok().build();
    }

    @PostMapping(RETURN_BOOK)
    public HttpEntity<Void> returnBooK(@RequestBody ReturnBookRequest request) {
        returnBookUseCase.execute(new LoanId(request.loanId()));
        return ResponseEntity.ok().build();
    }
}
