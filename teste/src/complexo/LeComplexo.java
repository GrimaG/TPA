/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author gustavo
 */
public class LeComplexo {

    public static void main(String[] args) throws Exception {
        LeComplexo etc = new LeComplexo();
        etc.readMatrix("");
    }

    public void readMainDoc(String arquivo) throws Exception {
        Scanner scanner = new Scanner(new FileReader(arquivo)).useDelimiter("\\n");
        while (scanner.hasNext()) {
            String expressao = scanner.next().trim();
        }
    }

//    private TadMatrizComplexo processa(String expressao) {
//        String elem = "", operador = "";
//        TadMatrizComplexo matriz = new TadMatrizComplexo();
//        for (int index = 0; index < expressao.length(); index++) {
//            elem = expressao.substring(index, 1);
//            if (elem.equals("(")) {
//                int totem = 1;
//                String elemInterno, sub = "";
//                while (totem != 0) {
//                    index++;
//                    elemInterno = expressao.substring(index, 1);
//                    if (elemInterno.equals(")")) {
//                        totem--;
//                    }
//                    if (elemInterno.equals("(")) {
//                        totem++;
//                    }
//                    sub += elemInterno;
//                }
//                if (operador.equals("")) {
//                    matriz = processa(sub.substring(0, sub.length() - 1));
//                } else {
//
//                }
//            }
//        }
//    }
    
//    private TadMatrizComplexo processa(String expressao) {
//        LinkedList<String> pilha = new LinkedList<>();        
//        String elem = "";
//        int prioridadeOperador=0;
//        TadMatrizComplexo matriz = new TadMatrizComplexo();
//        for (int index = 0; index < expressao.length(); index++) {
//            elem = expressao.substring(index, 1);
//            if(isOperator(elem) && prioridadeDeOperador(elem)<prioridadeOperador){
//               for(int position = pilha.size()-1; position > 0; position --){
//                   if (isOperator(elem))
//               }
//                    //desempilha
//              
//            }
//            pilha.add(elem);
//            if (elem.equals("(")) {
//                int totem = 1;
//                String elemInterno, sub = "";
//                while (totem != 0) {
//                    index++;
//                    elemInterno = expressao.substring(index, 1);
//                    if (elemInterno.equals(")")) {
//                        totem--;
//                    }
//                    if (elemInterno.equals("(")) {
//                        totem++;
//                    }
//                    sub += elemInterno;
//                }
//                
//            }
//        }
//    }
    private boolean isOperator(String op){
        if (op.equals("+") || op.equals("*")){
            return true;
        }else return false;
    }
    private int prioridadeDeOperador(String op){
        if(op.equals("+")){
            return 1;
        }
        else{
            return 2;
        }
    }
    public void readMatrix(String arquivo) throws Exception {
        TadMatrizComplexo matriz = new TadMatrizComplexo(1, 1);
        //Scanner scanner = new Scanner(new FileReader(arquivo)).useDelimiter("\\n");
        Scanner scanner = new Scanner(new FileReader("E.txt")).useDelimiter("\\n");
        while (scanner.hasNext()) {
            String[] line = scanner.next().trim().replace("   ", " ").replace("  ", " ").split(" ");
            matriz.setColunas(line.length); // se colocasse um if aqui para so inserir uma vez provavel que seria mais custoso
            int auxCol = 0;
            for (String elemento : line) {
                matriz.set(matriz.getLinhas() - 1, auxCol, elemento);
                auxCol++;
            }
            matriz.setLinhas(matriz.getLinhas() + 1);
        }
        matriz.setLinhas(matriz.getLinhas() - 1);

    }
}
