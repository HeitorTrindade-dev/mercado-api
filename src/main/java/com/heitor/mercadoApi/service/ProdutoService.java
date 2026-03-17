package com.heitor.mercadoApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.mercadoApi.repository.ProdutoRepository;
import com.heitor.mercadoApi.model.Produto;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void insertProduto(Produto produto) throws Exception{
        if(produto.getPreco() < 0){
            throw new RuntimeException("O produto precisa ter seu valor nulo ou positivo.");
        }
        produtoRepository.insertProduto(produto);
    }
}
