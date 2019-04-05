/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author qphan
 */
public class JdbcConnectionProvider implements ConnectionProvider {

    private final ConfigurationProvider configurationProvider;

    public JdbcConnectionProvider() {
        this.configurationProvider = new ConfigurationProviderImpl();
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            final Properties prop = configurationProvider.getConfiguration();
            final String username = prop.getProperty("username");
            final String password = prop.getProperty("password");
            final String url = prop.getProperty("url");
            conn = DriverManager.getConnection(url, username, password);
            conn.setAutoCommit(false);
        } catch (Exception ex) {
            System.out.println("Can't find JDBC driver");
        }
        return conn;
    }

}
