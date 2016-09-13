/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confusao;

import java.util.LinkedList;

/**
 *
 * @author gustavo
 */
public class Documento {
    String conteudo;
    LinkedList<String> vocabulario;
    LinkedList<Integer> frequencia;
    String origem;

    public Documento(String origem) {
        this.vocabulario = new LinkedList<String> ();
        this.frequencia = new LinkedList<Integer> ();
        this.origem = origem;
    }
    public LinkedList<String> getVocab(){
        return this.vocabulario;
    }
    public int getTotalPal(){
        return this.vocabulario.size();
    }
    public LinkedList<String> getVetDoc(){
        LinkedList<String> vetDoc = new LinkedList<String> ();
        int index = 0;
        for(String palavra: this.vocabulario){
            vetDoc.add(palavra + "," + this.frequencia.get(index));
            index++;
        }
        return vetDoc;
    }
}
