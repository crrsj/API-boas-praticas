package br.com.exercicio.repositorio;

import br.com.exercicio.entidade.LoginProdutos;
import br.com.exercicio.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginProdutoRepositorio extends JpaRepository<LoginProdutos,Long> {
    UserDetails findByLogin(String login);
}
