/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package confusao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author gustavo
 */
public class Documento {

    String conteudo;
    LinkedList<String> vocabulario;
    LinkedList<Integer> frequencia;
    String origem;
    String palavraTemp;

 
    public Documento(String origem) throws FileNotFoundException {
        this.vocabulario = new LinkedList<String>();
        this.frequencia = new LinkedList<Integer>();
        this.origem = origem;
        this.carregaDoc();
    }

    private void carregaDoc() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(this.origem)).useDelimiter(" ");
        while (scanner.hasNext()) {
            String palavra = scanner.next();
            setVocabulario(palavra);
            this.conteudo += palavra + " ";
        }
    }

    private void setVocabulario(String palavra) {
        this.palavraTemp = palavra.replace("\n", "");
        if (isAlpha(palavraTemp)) {
            boolean achou = false;
            String lowercase = palavraTemp.toLowerCase();
            for (int index = 0; index < vocabulario.size() && achou == false; index++) {
                if (vocabulario.get(index).equals(lowercase)) {
                    frequencia.add(index, frequencia.get(index) + 1);
                    frequencia.remove(index+1);
                    achou = true;
                }
            }

            if (!achou) {
                vocabulario.add(lowercase);
                frequencia.add(1);
            }
        }
    }

    private boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        Character[] tokens = {'"','\'','\\','/', '[', '(', ')', '+', '-', ':', ';', '.', ',', '?', '!', '@', '#', '$', '%', '¨', '&', '*', '{', '}', '[', ']'};

        String localpalavra = "";
        for (Character c : chars) {
            if (Character.isDigit(c)) {
                return false;
            } else {
                boolean parada = false;
                for (int index = 0; index < tokens.length && parada == false; index++) {
                    if (c.equals(tokens[index])) {
                        parada = true;
                    }
                }
                if (parada == false) {
                    localpalavra += c.toString();
                }
            }
        }
        this.palavraTemp = localpalavra;
        if (this.palavraTemp.equals("") || this.palavraTemp.isEmpty()){
            return false;
        }
        return true;
    }

    public LinkedList<String> getVocab() {
        return this.vocabulario;
    }

    public int getTotalPal() {
        return this.vocabulario.size();
    }

    public LinkedList<Palavra> getVetDoc() {
        LinkedList<Palavra> vetDoc = new LinkedList<Palavra>();
        int index = 0;
        for (String palavra : this.vocabulario) {
            vetDoc.add(new Palavra(palavra, this.frequencia.get(index)));
            index++;
        }
        return vetDoc;
    }
}
