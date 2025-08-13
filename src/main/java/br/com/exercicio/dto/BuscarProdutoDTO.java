package br.com.exercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuscarProdutoDTO {
    private Long id;
    private String categoria;
    private String marca;
    private String modelo;
    private Double preco;
}
