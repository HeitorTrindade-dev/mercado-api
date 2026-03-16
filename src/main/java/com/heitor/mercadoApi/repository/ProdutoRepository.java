package com.heitor.mercadoApi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.heitor.mercadoApi.model.Produto;


@Repository
public class ProdutoRepository {

    @Autowired
    private DataSource dataSource;

    public void insertProduto(Produto produto) throws SQLException{
        String scriptSql = "INSERT INTO produtos(nome,preco,quantdade) VALUES (?,?,?)";

        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement(scriptSql);

        statement.setString(1,produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());


        statement.executeUpdate();

    }
}
