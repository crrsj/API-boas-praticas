package br.com.exercicio.tratamento;

import org.springframework.validation.FieldError;

public record ValidandoCampos(String campos, String mensagem) {
    public ValidandoCampos(FieldError erros){
        this(erros.getField(), erros.getDefaultMessage());
    }
}
