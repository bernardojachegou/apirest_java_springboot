package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.produtos.apirest.models.Produto;

@RestController
@RequestMapping(value = "/api")
// Anotações do Swagger
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	// Método que lista todos os produtos
	@GetMapping("/produtos")
	// Método do Swagger
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	// Método que lista apenas um produto específico
	@GetMapping("/produto/{id}")
	// Método do Swagger
	@ApiOperation(value="Retorna um produto da lista")
	public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id);
	}

	// Método que salva um novo produto
	@PostMapping("/produto")
	// Método do Swagger
	@ApiOperation(value="Salva um produto na lista")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	// Método que atualiza um produto já existente;
	@PutMapping("/produto")
	// Método do Swagger
	@ApiOperation(value="Atualiza um produto da lista")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	// Método que deleta um produto
	@DeleteMapping("/produto")
	// Método do Swagger
	@ApiOperation(value="Deleta um produto da lista")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
}
