package io.springboot.expert.produtosapi.controller;

import io.springboot.expert.produtosapi.model.Produto;
import io.springboot.expert.produtosapi.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private ProdutoRepository produtoRepository;


    @PostMapping
    public ResponseEntity salvarProduto(@RequestBody Produto produto) {
        produtoRepository.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping
    public List<Produto> buscarProdutos( ) {
        return produtoRepository.findAll();
    }

    @GetMapping("/nome")
    public List<Produto> buscarProdutosPorNome(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public void atualizarProduto(@PathVariable ("id")Integer id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }



@DeleteMapping("/{id}")
public void removerProduto(@PathVariable Integer id) {
    produtoRepository.deleteById(id);
}



}
