/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.LinkedList;

/**
 *
 * @author gustavo.campello
 */
public class TadMatriz {
    private int linhas, colunas;
    LinkedList<Elemento> conteudo;

    public TadMatriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.conteudo = new LinkedList<>();
    }

    public TadMatriz() {
    }
    
    public float get(int linha, int coluna) throws Exception{
        if((linha<0 || linha>=this.linhas) || (coluna<0 || coluna>=this.colunas)){
             throw new IndexOutOfBoundsException();
        }
        for (Elemento elem: this.conteudo){
            if (elem.getCol() == coluna && elem.getLin() == linha){
                return elem.getVal();
            }
        }
        return 0;
    }
    public void set(int linha, int coluna, float value) throws Exception{
         if((linha<0 || linha>=linhas) || (coluna<0 || coluna>=colunas)){
             throw new IndexOutOfBoundsException();
        }
         try{
             float valor = this.get(linha, coluna);
             Elemento elem = new TadElemento(linha, coluna, value);
             if (valor == 0){
                this.conteudo.add(elem);
             }else{
                 int index = 0;
                 for (Elemento item: this.conteudo){
                     if (item.getCol() == coluna && item.getLin() == linha){
                         this.conteudo.remove(item);
                         this.conteudo.add(elem);
                        }
                    index ++;
                }
            }
        
        }catch(Exception e){
            throw new ArrayIndexOutOfBoundsException();
        }
    }
    public boolean verificaIndex(int lin, int col){
        if(!((lin<0 || lin>=linhas) || (col<0 || col>=colunas))){
            return true;
        }else return false;
    }
    public TadMatriz somar(TadMatriz elem) throws Exception{
        int colNova, linNova;
        if (this.colunas > elem.getColunas()){
            colNova = this.colunas;
        }else {
            colNova = elem.colunas;
        }
        if(this.linhas > elem.linhas){
            linNova = this.linhas;
        }else {
            linNova = elem.getLinhas();
        }
        TadMatriz nova = new TadMatriz(linNova, colNova);
        for (int lin=0; lin<linNova; lin ++){
            for (int col = 0; col < colNova; col++){
                if (this.verificaIndex(lin, col)){
                    if(elem.verificaIndex(lin, col)){
                        nova.set(lin, col, elem.get(lin, col) + this.get(lin, col));
                    }else {
                        nova.set(lin, col, this.get(lin, col));
                    }
                }else {
                    if(elem.verificaIndex(lin, col)){
                        nova.set(lin, col, elem.get(lin, col));
                    }
                }
            }
        }
        return nova;
    };
     
    public TadMatriz multiplicar(TadMatriz elem) throws Exception{
        int colNova, linNova;
        if (this.colunas > elem.getColunas()){
            colNova = this.colunas;
        }else {
            colNova = elem.colunas;
        }
        if(this.linhas > elem.linhas){
            linNova = this.linhas;
        }else {
            linNova = elem.getLinhas();
        }
        TadMatriz nova = new TadMatriz(linNova, colNova);
        for (int lin=0; lin<linNova; lin ++){
            for (int col = 0; col < colNova; col++){
                if (this.verificaIndex(lin, col)){
                    if(elem.verificaIndex(lin, col)){
                        nova.set(lin, col, elem.get(lin, col) * this.get(lin, col));
                    }else {
                        nova.set(lin, col, this.get(lin, col));
                    }
                }else {
                    if(elem.verificaIndex(lin, col)){
                        nova.set(lin, col, elem.get(lin, col));
                    }
                }
            }
        }
        return nova;
        
    };
     
    public TadMatriz multiplicarPorConstante(float elem) throws Exception{
        int colNova, linNova;
        colNova = this.colunas;
        linNova = this.linhas;
        
        TadMatriz nova = new TadMatriz(linNova, colNova);
        for (int lin=0; lin<linNova; lin ++){
            for (int col = 0; col < colNova; col++){
                nova.set(lin, col, this.get(lin, col) * elem);   
            }
        }
        return nova;
        
    };
     
    public LinkedList<Float> diagD() throws Exception{
        LinkedList<Float> diagonal = new LinkedList<>();
        for (int lin=0; lin<this.linhas; lin ++){
            if (lin<=this.colunas){
                diagonal.add(this.get(lin, lin)); 
            }else{
                return diagonal;
            }
            
        }
        return diagonal;
    };
     
    public LinkedList<Float> diagSecundaria() throws Exception{
        LinkedList<Float> diagonal = new LinkedList<>();
        int col = this.linhas;
        for (int lin=0; lin<this.linhas; lin ++){
            if (col<this.colunas && col >= 0){
                diagonal.add(this.get(lin, col)); 
            }
            col--;
        }
        return diagonal;
    };

    public int getLinhas() {
        return linhas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public LinkedList<Elemento> getConteudo() {
        return conteudo;
    }

    public void setConteudo(LinkedList<Elemento> conteudo) {
        this.conteudo = conteudo;
    }
    
}
