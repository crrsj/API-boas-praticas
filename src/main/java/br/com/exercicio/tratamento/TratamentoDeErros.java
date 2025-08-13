package br.com.exercicio.tratamento;

import br.com.exercicio.erros.ProdutoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(ProdutoNaoEncontrado.class)
    public ResponseEntity<MensagemDeErro>produtoNaoEncontrado(){
        var msg = new MensagemDeErro(HttpStatus.NOT_FOUND,"Produto não encontrado !");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validarCampos(MethodArgumentNotValidException ex){
        var validar = ex.getFieldErrors();
        return ResponseEntity.status(HttpStatus.OK).body(validar.stream().map(ValidandoCampos::new).toList());
    }
}
