package br.com.exercicio.repositorio;

import br.com.exercicio.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepositorio extends JpaRepository<Produto,Long> {
}
