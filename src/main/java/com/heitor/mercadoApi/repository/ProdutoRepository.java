package com.heitor.mercadoApi.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heitor.mercadoApi.model.Produto;


@Repository
public class ProdutoRepository {

    @Autowired
    private DataSource dataSource;

    public void insertProduto(Produto produto) throws SQLException{
        String scriptSql = "INSERT INTO produtos(nome,preco,quantidade) VALUES (?,?,?)";

        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement(scriptSql);

        statement.setString(1,produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());


        statement.executeUpdate();

    }

    public List<Produto> selectProdutos() throws SQLException{
        List<Produto> lista = new ArrayList<>();
        String scriptSql = "SELECT * FROM produtos";

        Connection connection = dataSource.getConnection();

        PreparedStatement statement = connection.prepareStatement(scriptSql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Produto produto = new Produto();
            produto.setId(resultSet.getInt("id"));
            produto.setNome(resultSet.getString("nome"));
            produto.setPreco(resultSet.getDouble("preco"));
            produto.setQuantidade(resultSet.getInt("quantiade"));

            lista.add(produto);
        }
        return lista;
    }
}
