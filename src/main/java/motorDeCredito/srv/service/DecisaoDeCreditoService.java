package motorDeCredito.srv.service;

import motorDeCredito.srv.model.DecisaoDeCredito;
import motorDeCredito.srv.request.DecisaoDeCreditoRequestDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DecisaoDeCreditoService {

    public DecisaoDeCredito calculoDeCredito(DecisaoDeCreditoRequestDTO decisaoDeCreditoRequestDTO) {

        if (decisaoDeCreditoRequestDTO.score() > 700 && decisaoDeCreditoRequestDTO.renda() > 2000) {
            return new DecisaoDeCredito("Aprovado", LocalDate.now());
        }

        else if (decisaoDeCreditoRequestDTO.score() > 499 && decisaoDeCreditoRequestDTO.score() < 701) {
            return new DecisaoDeCredito("Revisão Manual", LocalDate.now());
        }

        else if (decisaoDeCreditoRequestDTO.score() < 500 || decisaoDeCreditoRequestDTO.renda() < 1999) {
            return new DecisaoDeCredito("Reprovado", LocalDate.now());
        }

        return new DecisaoDeCredito("Erro na aplicacao", null);
    }
}
