package br.com.exercicio.config;

import br.com.exercicio.entidade.LoginProdutos;
import br.com.exercicio.repositorio.LoginProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DadosTeste implements CommandLineRunner {
    @Autowired
    private LoginProdutoRepositorio repositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (repositorio.count() == 0) {
            LoginProdutos usuario = new LoginProdutos();
            usuario.setLogin("admin");
            usuario.setSenha(passwordEncoder.encode("123456"));
            repositorio.save(usuario);
        }
    }
}
