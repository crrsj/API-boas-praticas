package br.com.exercicio.controle;

import br.com.exercicio.dto.AtualizarProdutoDTO;
import br.com.exercicio.dto.BuscarProdutoDTO;
import br.com.exercicio.dto.CriarProdutoDTO;
import br.com.exercicio.dto.ListarProdutosDTO;
import br.com.exercicio.servico.ProdutoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoControle {

    @Autowired
    private ProdutoServico produtoServico;

    @PostMapping
    @Operation(summary = "Endpoint responsável pelo cadastro de produtos.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<CriarProdutoDTO>criarProdutos(@RequestBody @Valid CriarProdutoDTO criarProdutoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoServico.criarProduto(criarProdutoDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Endpoint responsável pela atualização de produtos pelo id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<AtualizarProdutoDTO>atualizarProduto(@PathVariable Long id,@RequestBody @Valid AtualizarProdutoDTO atualizarProdutoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(produtoServico.atualizarProduto(id,atualizarProdutoDTO));
    }

    @GetMapping
    @Operation(summary = "Endpoint responsável pela busca de todos os produtos.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<List<ListarProdutosDTO>>listarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoServico.buscarProdutos());
    }
    @GetMapping("/{id}")
    @Operation(summary = "Endpoint responsável pela busca de produtos pelo id.")
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<BuscarProdutoDTO>buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoServico.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint responsável por excluir produtos pelo id.")
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
            @Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })
    public ResponseEntity<Void>excluirProdutos(@PathVariable Long id){
        produtoServico.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
