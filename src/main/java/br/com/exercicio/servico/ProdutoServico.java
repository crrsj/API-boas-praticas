package br.com.exercicio.servico;

import br.com.exercicio.dto.AtualizarProdutoDTO;
import br.com.exercicio.dto.BuscarProdutoDTO;
import br.com.exercicio.dto.CriarProdutoDTO;
import br.com.exercicio.dto.ListarProdutosDTO;
import br.com.exercicio.entidade.Produto;
import br.com.exercicio.erros.ProdutoNaoEncontrado;
import br.com.exercicio.repositorio.ProdutoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServico {

    @Autowired
    private ProdutoRepositorio produtoRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    public CriarProdutoDTO criarProduto(CriarProdutoDTO criarProdutoDTO){
       var criar = modelMapper.map(criarProdutoDTO, Produto.class) ;
       var produtoCriado = produtoRepositorio.save(criar);
       return modelMapper.map(produtoCroado, CriarProdutoDTO.class);
    }

    public AtualizarProdutoDTO atualizarProduto(Long id,AtualizarProdutoDTO atualizarProdutoDTO){
        var atualizar = produtoRepositorio.findById(id).orElseThrow(()->new ProdutoNaoEncontrado("Produto não encontrado com o id: " + id));
        modelMapper.map(atualizarProdutoDTO,atualizar);
        var produtoAtualizado = produtoRepositorio.save(atualizar);
        return modelMapper.map(produtoAtualizado, AtualizarProdutoDTO.class);

    }


    public BuscarProdutoDTO buscarPorId(Long id){
        var buscar = produtoRepositorio.findById(id).orElseThrow(()->new ProdutoNaoEncontrado("Produto não encontrado com o id: " + id));
        return modelMapper.map(buscar, BuscarProdutoDTO.class);
    }

    public List<ListarProdutosDTO>buscarProdutos(){
        return produtoRepositorio.findAll().stream().map(listar -> modelMapper.map(listar, ListarProdutosDTO.class)).toList();
    }

    public void excluirProduto(Long id){
     if(produtoRepositorio.existsById(id)){
         produtoRepositorio.deleteById(id);
     }else{
          throw new ProdutoNaoEncontrado("Produto não encontrado com o id: " + id);
       
    }
}
