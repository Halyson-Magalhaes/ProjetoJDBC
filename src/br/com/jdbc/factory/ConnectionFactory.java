package br.com.jdbc.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3307/loja_virtual?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("H@lyson1");

        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;

    }

    public Connection recuperarConexao() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
