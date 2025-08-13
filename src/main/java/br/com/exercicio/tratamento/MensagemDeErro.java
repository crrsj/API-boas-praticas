package br.com.exercicio.tratamento;

import org.springframework.http.HttpStatus;

public record MensagemDeErro(HttpStatus status,String mensagem) {

}