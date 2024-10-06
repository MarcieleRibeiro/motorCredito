package motorDeCredito.srv.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import motorDeCredito.srv.annotation.ValidCPF;

public record DecisaoDeCreditoRequestDTO(

        @ValidCPF
        @NotBlank(message = "Campo obrigatorio")
        String cpf,
        @NotBlank(message = "Campo obrigatorio")
        String nome,
        @NotNull(message = "Campo renda é obrigatório")
        Double renda,
        @NotNull(message = "Campo renda é obrigatório")
        Integer score

) {
}
