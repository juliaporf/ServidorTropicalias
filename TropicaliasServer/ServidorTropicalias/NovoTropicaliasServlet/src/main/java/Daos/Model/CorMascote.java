package Daos.Model;

public class CorMascote {
    private String textoFundo;
    private String textoPri;
    private String textoSec;

    public CorMascote(String textoFundo, String textoPri,String textoSec){
        this.textoFundo = textoFundo;
        this.textoPri = textoPri;
        this.textoSec = textoSec;
    }

    public String getTextoFundo(){
        return this.textoFundo;
    }

    public String getTextoPri(){
        return this.textoPri;
    }

    public String getTextoSec(){
        return this.textoSec;
    }

    public void setTextoFundo(String novoTextoFundo){
        this.textoFundo = novoTextoFundo;
    }

    public void setTextoPri(String novoTextoPri){
        this.textoPri = novoTextoPri;
    }

    public void setTextoSec(String novoTextoSec){
        this.textoSec = novoTextoSec;
    }

    public String toString(){
        return "-->Texto do fundo: " + this.textoFundo + "\n-->Texto primário: " + this.textoPri +
                "\n-->Texto Secundário: " + this.textoSec;
    }
}
