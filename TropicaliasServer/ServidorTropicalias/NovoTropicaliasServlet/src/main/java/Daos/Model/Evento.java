package Daos.Model;

public class Evento {
    private String nome;
    private String local;
    private double precoTicket;
    private int fk_int_id_usuario;

    public Evento(String nome, String local, double preco_ticket, int fk_int_id_usuario){
        this.nome = nome;
        this.local = local;
        this.precoTicket = precoTicket;
        this.fk_int_id_usuario = fk_int_id_usuario;
    }

    public String getNome(){
        return this.nome;
    }

    public String getLocal(){
        return this.local;
    }

    public double getPrecoTicket(){
        return this.precoTicket;
    }

    public int getFk_int_id_usuario(){
        return this.fk_int_id_usuario;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public void setLocal(String novoLocal){
        this.local = novoLocal;
    }

    public void setPrecoTicket(double novoPrecoTicket){
        this.precoTicket = novoPrecoTicket;
    }

    public void setTextoSec(int novoFk_int_id_usuario){
        this.fk_int_id_usuario = novoFk_int_id_usuario;
    }

    public String toString(){
        return "-->Nome: " + this.nome + "\n-->Local: "+ this.local +"\n-->Preço do ticket: "+ this.precoTicket +
                "\n-->Foreign key do usuário: "+ this.fk_int_id_usuario;
    }
}

