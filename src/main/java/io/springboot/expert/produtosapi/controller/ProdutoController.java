package io.springboot.expert.produtosapi.controller;

import io.springboot.expert.produtosapi.model.Produto;
import io.springboot.expert.produtosapi.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Integer id) {
   return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void removerProduto(@PathVariable Integer id) {
        produtoRepository.deleteById(id);
    }

}
