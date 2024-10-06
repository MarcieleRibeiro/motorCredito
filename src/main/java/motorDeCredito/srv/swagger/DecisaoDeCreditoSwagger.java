package motorDeCredito.srv.swagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import motorDeCredito.srv.request.DecisaoDeCreditoRequestDTO;
import motorDeCredito.srv.response.DecisaoDeCreditoResponseDTO;
import org.springframework.http.ResponseEntity;

public interface DecisaoDeCreditoSwagger {

    @Operation(summary = "Avaliar decisão de crédito", description = "Este endpoint avalia a decisão de crédito de um cliente com base em seu score e renda.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Avaliação de crédito concluída",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DecisaoDeCreditoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    ResponseEntity<DecisaoDeCreditoResponseDTO> resultadoDecisao(DecisaoDeCreditoRequestDTO decisaoDeCreditoRequestDTO);
}