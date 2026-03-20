package com.heitor.mercadoApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heitor.mercadoApi.service.ProdutoService;
import com.heitor.mercadoApi.model.Produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService service;

    @PostMapping
    public void insertProduto(@RequestBody Produto produto) throws Exception{
        service.insertProduto(produto);
    }

    @GetMapping
    public List<Produto> selectProdutos() throws Exception{
        return service.selectProdutos();
    }

    @GetMapping(params = "id")
    public List<Produto> selectProdutoById(@RequestParam int id) throws Exception{
        return service.selectProdutoById(id);
    }

    @GetMapping(params = "nome")
    public List<Produto> selectProdutoByName(@RequestParam String nome) throws Exception{
        return service.selectProdutoByName(nome);
    }
}
