package com.heitor.mercadoApi.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.heitor.mercadoApi.model.Produto;


@Repository
public class ProdutoRepository {
    public void insertProduto(Produto produto) throws SQLException{
        String scriptSql = "INSERT INTO produtos(nome,preco,quantdade) VALUES (?,?,?)";

        Connection connection = DataSource.getConne

    }
}
