/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexo;

import teste.*;
import java.util.LinkedList;

/**
 *
 * @author gustavo.campello
 */
public class TadMatrizComplexo {
    private int linhas, colunas;
    LinkedList<TadComplexo> conteudo;

    public TadMatrizComplexo(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.conteudo = new LinkedList<>();
    }

    public TadMatrizComplexo() {
    }
    
    public String get(int linha, int coluna) throws Exception{
        if((linha<0 || linha>=this.linhas) || (coluna<0 || coluna>=this.colunas)){
             throw new IndexOutOfBoundsException();
        }
        for (TadComplexo elem: this.conteudo){
            if (elem.getCol() == coluna && elem.getLin() == linha){
                return elem.getVal();
            }
        }
        return "0";
    }
    public void set(int linha, int coluna, String value) throws Exception{
         if((linha<0 || linha>=linhas) || (coluna<0 || coluna>=colunas)){
             throw new IndexOutOfBoundsException();
        }
         try{
             String valor = this.get(linha, coluna);
             TadComplexo elem = new TadComplexo(linha, coluna, value);
             if (valor.equals("0")){
                this.conteudo.add(elem);
             }else{
                 int index = 0;
                 for (TadComplexo item: this.conteudo){
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
    public TadMatrizComplexo somar(TadMatrizComplexo elem) throws Exception{
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
        TadMatrizComplexo nova = new TadMatrizComplexo(linNova, colNova);
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
     
    public TadMatrizComplexo multiplicar(TadMatrizComplexo elem) throws Exception{
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
        TadMatrizComplexo nova = new TadMatrizComplexo(linNova, colNova);
        for (int lin=0; lin<linNova; lin ++){
            for (int col = 0; col < colNova; col++){
                if (this.verificaIndex(lin, col)){
                    if(elem.verificaIndex(lin, col)){
                        TadComplexo temp = new TadComplexo(lin, col, this.get(lin, col));
                        temp.multComplex(elem.get(lin, col));
                        nova.set(lin, col, temp.getVal());
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
     
    public TadMatrizComplexo multiplicarPorConstante(float elem) throws Exception{
        int colNova, linNova;
        colNova = this.colunas;
        linNova = this.linhas;
        
        TadMatrizComplexo nova = new TadMatrizComplexo(linNova, colNova);
        for (int lin=0; lin<linNova; lin ++){
            for (int col = 0; col < colNova; col++){
                TadComplexo temp = new TadComplexo(lin, col, this.get(lin, col));
                temp.multCons(elem);
                nova.set(lin, col, temp.getVal());   
            }
        }
        return nova;
        
    };
     
    public LinkedList<String> diagD() throws Exception{
        LinkedList<String> diagonal = new LinkedList<>();
        for (int lin=0; lin<this.linhas; lin ++){
            if (lin<=this.colunas){
                diagonal.add(this.get(lin, lin)); 
            }else{
                return diagonal;
            }
            
        }
        return diagonal;
    };
     
    public LinkedList<String> diagSecundaria() throws Exception{
        LinkedList<String> diagonal = new LinkedList<>();
        int col = this.linhas;
        for (int lin=0; lin<this.linhas; lin ++){
            if (col<this.colunas && col >= 0){
                diagonal.add(this.get(lin, col)); 
            }
            col--;
        }
        return diagonal;
    };
    
    public void transposta(){
        for(int index = 0; index<this.conteudo.size(); index ++){
            int col = this.conteudo.get(index).getCol();
            this.conteudo.get(index).setCol(this.conteudo.get(index).getLin());
            this.conteudo.get(index).setLin(col);
        }
    }

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

    public LinkedList<TadComplexo> getConteudo() {
        return conteudo;
    }

    public void setConteudo(LinkedList<TadComplexo> conteudo) {
        this.conteudo = conteudo;
    }
    
}
