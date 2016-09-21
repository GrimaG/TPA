/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashConflict;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;
import confusao.Documento;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author gustavo
 */
public class hash {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String> vocabulario;
        LinkedList<String> palavrasA = new LinkedList<>();
        LinkedList<String> palavrasB = new LinkedList<>();
        hash hashclass = new hash();
        LinkedList<Long> hashA = new LinkedList<Long>();
        LinkedList<Long> hashB = new LinkedList<Long>();
        Scanner scanner = new Scanner(new FileReader("ibge-da-georef-100k.txt")).useDelimiter("\\s|\\n");
        while (scanner.hasNext()) {
            long palavra = Float.floatToIntBits(scanner.nextLong());
            long a = hashclass.hashingA(palavra);
            long b = hashclass.hashingB(palavra, 37);
            if(hashclass.addConflito(palavrasA, hashA, palavra, a)){
                hashA.add(a);
                palavrasA.add(palavra);
            }
            if(hashclass.addConflito(palavrasB, hashB, palavra, b)){    
                hashB.add(b);
                palavrasB.add(palavra);
            }
            //System.out.println("nome = " +palavra +"   " +a + " -- " +b);
        }
        
        
    }
    
    public boolean addConflito(LinkedList<String> palavras, LinkedList<Long> hashValue, String palavra, long hash){
        if(!palavras.contains(palavra)){
            if (hashValue.size() == 0){
                return true;
            }
            for(int index = 0; index<hashValue.size(); index ++){
                if(hashValue.get(index) == hash){
                    System.out.println("Hash " + hash + "Conflito com a palavra: " + palavras.get(index) + " e a palavra: " + palavra);
                    return false;
                }else {
                    return true;
                }
            }   
        }
        return false;
    }
    public int hashingA(String word){
        int value=0;
        for(int index = 0; index <word.length(); index ++){
            value += (int) word.charAt(index);
        }
        
    return value;
    }
    // n = tamanho da string
    // a = 33,37,39,41
    // x = caractere em asc
    public long hashingB(String word, int cons){
        long value=0;
        int tamanho= word.length();
        for(int index = 0; index <tamanho; index ++){
            value += (long) word.charAt(index) * (Math.pow(cons, (tamanho - (index+1))));
        }
        
    return value;
    }
}
