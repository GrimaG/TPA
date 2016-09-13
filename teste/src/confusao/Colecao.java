/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confusao;

import java.util.LinkedList;
import teste.TadMatriz;

/**
 *
 * @author gustavo
 */
public class Colecao {
    String[] acervo;
    LinkedList<String> vocabulario;
    TadMatriz matrizConfusao;

    public Colecao(String[] acervo) {
        this.acervo = acervo;
        this.vocabulario = new LinkedList<String>();
        this.matrizConfusao = new TadMatriz();
    }
    public LinkedList<String> getVocab(){
        return this.vocabulario;
    }
    
    public TadMatriz getMatConf(){
        return this.matrizConfusao;
    }
}
