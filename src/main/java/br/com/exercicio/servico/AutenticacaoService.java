package br.com.exercicio.servico;

import br.com.exercicio.repositorio.LoginProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {


    private final LoginProdutoRepositorio repositorio;

    public AutenticacaoService(LoginProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return repositorio.findByLogin(login);
    }
}
