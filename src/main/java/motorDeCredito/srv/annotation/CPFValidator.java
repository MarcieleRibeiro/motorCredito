package motorDeCredito.srv.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<ValidCPF, String> {

    @Override
    public void initialize(ValidCPF constraintAnnotation) {
        // Inicialização (se necessário)
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }

        // Remover caracteres especiais
        cpf = cpf.replaceAll("\\D", "");

        // Validação básica do CPF (tamanho correto)
        if (cpf.length() != 11) {
            return false;
        }

        // Implementar aqui a lógica para validar CPF (incluindo dígitos verificadores)
        return validarCPF(cpf);
    }

    // Método de validação do CPF (com base nos dígitos verificadores)
    private boolean validarCPF(String cpf) {
        // Lógica de validação do CPF
        // Esta é uma implementação básica que pode ser substituída por uma versão mais completa.

        // Verifica se todos os dígitos são iguais (caso especial)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo dos dígitos verificadores
        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * pesos[i];
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 > 9) ? 0 : digito1;

        pesos = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * pesos[i];
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 > 9) ? 0 : digito2;

        return cpf.endsWith(Integer.toString(digito1) + Integer.toString(digito2));
    }
}
