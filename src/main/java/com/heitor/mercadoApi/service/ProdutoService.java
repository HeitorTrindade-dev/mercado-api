package com.heitor.mercadoApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.mercadoApi.model.Produto;
import com.heitor.mercadoApi.repository.ProdutoRepository;

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

    public List<Produto> selectProdutos() throws Exception{
        List<Produto> lista = new ArrayList<>();
        lista = produtoRepository.selectProdutos();

        return lista;
    }


    public List<Produto> selectProdutoById(int id) throws Exception{
        List<Produto> lista = new ArrayList<>();
        lista = produtoRepository.selectProdutoById(id);

        return lista;
    }

    public List<Produto> selectProdutoByName(String nome) throws Exception{
        List<Produto> lista = new ArrayList<>();
        lista = produtoRepository.selectProdutoByName(nome);

        return lista;
    }
    
}
