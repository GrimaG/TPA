/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confusao;

/**
 *
 * @author gustavo
 */
public class Palavra {
    private int quantidade;
    private String palavra;

    public Palavra(String palavra, int quantidade) {
        this.quantidade = quantidade;
        this.palavra = palavra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }
    

}
