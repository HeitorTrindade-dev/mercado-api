package com.heitor.mercadoApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.heitor.mercadoApi.service.ProdutoService;
import com.heitor.mercadoApi.model.Produto;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoService service;


    @PostMapping("/produto")
    public void insertProduto(@RequestBody Produto produto) throws Exception{
        service.insertProduto(produto);
    }
}
