package Daos.JDBC;

import java.sql.*;

public class EventoDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    ConexaoDAO conexao = new ConexaoDAO();

    public boolean cadastrarEvento (Date dt_inicio, Date dt_final, String nome, String local, Double precoTicket, int fk_int_id_usuario ){
        try {
//            Abrindo conexão com o banco
            conexao.conectar();

//           Comandos SQL
            pstmt = conexao.getConn().prepareStatement("INSERT INTO tb_evento (dt_inicio,dt_final,var_nome, var_local, num_preco_ticket, fk_int_id_usuario, updatedAt)\n" +
                    "VALUES(?,?,?,?,?,?,current_date)");
//            Setando os parâmetros para fazer a inserção no banco de dados
            pstmt.setDate(1,dt_inicio);
            pstmt.setDate(2,dt_final);
            pstmt.setString(3, nome);
            pstmt.setString(4, local);
            pstmt.setDouble(5, precoTicket);
            pstmt.setInt(6, fk_int_id_usuario);
//          Executando os comandos SQL no banco e se der certo retorna true, caso contrário será pego na exceçãp e irá retornar false
            pstmt.execute();
            return true;
        }
        //        Tratando exceção do Banco SQL
        catch (SQLException sqles) {
            sqles.printStackTrace();
            return false;
        }
        //        Desconectando do Banco de dados
        finally {
            conexao.desconectar();
        }
    }
    public ResultSet buscarEvento(){
        try{
            //abrindo conexão com o banco
            conexao.conectar();
            pstmt= conexao.getConn().prepareStatement("SELECT nome FROM tb_evento ORDER BY pk_int_id_evento");
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

    public boolean softDeleteEvento(int idEvento){
        try{
//            Conectando ao banco de dados
            conexao.conectar();
//            Comando SQl
            pstmt = conexao.getConn().prepareStatement("UPDATE tb_evento SET deletedAt = current_date and updatedAt = current_date WHERE pk_int_id_evento = ?");
//            Setando os parâmetros
            pstmt.setInt(1, idEvento);
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
            conexao.desconectar();
        }
    }
}
