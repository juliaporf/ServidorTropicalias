package Daos.JDBC;

import java.sql.*;

public class ConexaoDAO {
    private Connection conn;
    public Connection getConn(){
        return this.conn;
    }
    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    System.getenv("DB_HOST"), System.getenv("DB_USER") , System.getenv("DB_PASSWORD"));
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    //    metodo para fechar conexão com o banco de dados
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException sqles) {
            sqles.printStackTrace();
        }
    }
}
