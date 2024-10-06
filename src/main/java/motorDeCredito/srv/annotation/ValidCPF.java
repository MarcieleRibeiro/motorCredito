package motorDeCredito.srv.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CPFValidator.class) // Ligação com o validador
@Target({ ElementType.FIELD, ElementType.PARAMETER }) // Pode ser usada em atributos de classe e parâmetros de método
@Retention(RetentionPolicy.RUNTIME) // Retida em tempo de execução
public @interface ValidCPF {

    String message() default "CPF inválido"; // Mensagem padrão de erro

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
