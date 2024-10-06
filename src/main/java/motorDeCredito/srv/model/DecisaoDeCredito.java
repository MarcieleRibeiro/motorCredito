package motorDeCredito.srv.model;

import java.time.LocalDate;

public record DecisaoDeCredito(
        String resultado,
        LocalDate dataDecisao
) {
}
