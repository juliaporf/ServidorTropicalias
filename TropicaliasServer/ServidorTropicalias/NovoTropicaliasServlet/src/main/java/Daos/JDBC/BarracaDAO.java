package Daos.JDBC;

import java.sql.*;

public class BarracaDAO {
    ConexaoDAO conexao = new ConexaoDAO();

    public boolean cadastrarBarraca(String nome, int fk_int_id_evento){
        try {
//            Abrindo conexão com o banco de dados
            conexao.conectar();
//            Comandos SQL
            PreparedStatement pstmt = conexao.getConn().prepareStatement("INSERT INTO tb_barraca (var_nome, fk_int_id_evento,createdAt) VALUES (?,?,current_date)");
//          Setando os parâmetros para fazer a inserção no banco de dados
            pstmt.setString(1, nome);
            pstmt.setInt(2, fk_int_id_evento);
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
            pstmt.execute();
            return true;
        }
//        Tratando exceção SQL
        catch (SQLException sqles) {
            sqles.printStackTrace();
            return false;
        }
//        Fechando conexão com o banco de dados
        finally {
            conexao.desconectar();
        }
    }

    public ResultSet buscarBarraca(){
        try{
            //abrindo conexão com o banco
            conexao.conectar();
            PreparedStatement pstmt= conexao.getConn().prepareStatement("SELECT * FROM tb_barraca ORDER BY pk_int_id_barraca");
            //executando o comando e guardando o resultset
            ResultSet rset = pstmt.executeQuery();
            return rset;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        }
        finally {
            conexao.desconectar();
        }

    }

    public boolean softDeleteBarraca(int idBarraca){
        try{
//            Conectando ao banco de dados
            conexao.conectar();
//            Comando SQl
            PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE tb_barraca SET deletedAt = current_date and updatedAt = current_date pk_int_id_barraca = ?");
//            Setando os parâmetros
            pstmt.setInt(1, idBarraca);
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
            pstmt.execute();
            return true;
        }
//       Tratando exceção
        catch(SQLException sqles){
            sqles.printStackTrace();
            return false;
        }
//        Fechando conexão com o banco de dados
        finally {
            conexao.conectar();
        }
    }
}

