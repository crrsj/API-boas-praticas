package br.com.exercicio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CriarProdutoDTO {
    private Long id;
    @NotBlank(message = "não pode estar em branco !")
    private String categoria;
    @NotBlank(message = "não pode estar em branco !")
    private String marca;
    @NotBlank(message = "não pode estar em branco !")
    private String modelo;
    private Double preco;
}
