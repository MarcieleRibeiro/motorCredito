package motorDeCredito.srv.controller;

import jakarta.validation.Valid;
import motorDeCredito.srv.model.DecisaoDeCredito;
import motorDeCredito.srv.request.DecisaoDeCreditoRequestDTO;
import motorDeCredito.srv.response.DecisaoDeCreditoResponseDTO;
import motorDeCredito.srv.service.DecisaoDeCreditoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@Validated
public class DecisaoDeCreditoController  {

    private final DecisaoDeCreditoService service;

    public DecisaoDeCreditoController(DecisaoDeCreditoService service) {
        this.service = service;
    }

    @PostMapping("/credito/avaliar")
    public ResponseEntity<DecisaoDeCreditoResponseDTO> resultadoDecisao(
            @Valid @RequestBody DecisaoDeCreditoRequestDTO decisaoDeCreditoRequestDTO) {

        DecisaoDeCredito decisaoDeCredito = service.calculoDeCredito(decisaoDeCreditoRequestDTO);
        DecisaoDeCreditoResponseDTO responseDTO = new DecisaoDeCreditoResponseDTO(
                decisaoDeCredito.resultado(), LocalDate.now()
        );
        return ResponseEntity.ok(responseDTO);
    }
}