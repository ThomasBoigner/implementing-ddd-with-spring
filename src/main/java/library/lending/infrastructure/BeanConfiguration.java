package library.lending.infrastructure;

import library.lending.domain.LoanRepository;
import library.lending.domain.LoanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    LoanService loanService(LoanRepository loanRepository) {
        return new LoanService(loanRepository);
    }
}
