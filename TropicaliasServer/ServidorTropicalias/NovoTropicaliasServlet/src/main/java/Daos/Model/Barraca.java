package Daos.Model;

public class Barraca {
    private String nome;
    private int fk_int_id_evento;

    public Barraca(String nome, int fk_int_id_evento){
        this.nome = nome;
        this.fk_int_id_evento = fk_int_id_evento;
    }

    public String getNome(){
        return this.nome;
    }

    public int getFk_int_id_evento(){
        return this.fk_int_id_evento;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public void setFk_int_id_evento(int novoFk_int_id_evento){
        this.fk_int_id_evento = novoFk_int_id_evento;
    }

    public String toString(){
        return "-->Nome: " + this.nome +"\nForeign Key: " + this.fk_int_id_evento;
    }
}
