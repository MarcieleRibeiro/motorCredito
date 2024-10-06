package motorDeCredito.srv.response;

import java.time.LocalDate;

public record DecisaoDeCreditoResponseDTO(
        String resultado,
        LocalDate dataDecisao
) {
}
