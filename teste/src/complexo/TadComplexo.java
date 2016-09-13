/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexo;

/**
 *
 * @author gustavo.campello
 */
public class TadComplexo {

    int col;
    int lin;
    float imaginario;
    float real;

    public TadComplexo(int lin, int col, String value){
        this.lin = lin;
        this.col = col;
        this.setVal(value);
    }
    public int getCol() {
        return this.col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getLin() {
        return this.lin;
    }

    public void setLin(int lin) {
        this.lin = lin;
    }

    public String getVal() {
       return String.valueOf(this.real) + String.valueOf(this.imaginario)+"i";
    }
// nao deu tempo
    private String[] processa(String val){
         String[] valores = new String[2];
        String tempVal = val.replace("+", "#+").replace("-", "#-");
        if(tempVal.substring(0, 1).equals("#")){
            tempVal = tempVal.substring(1);
        }
        valores = tempVal.split("#");
        if (valores[0].contains("i")) {
            valores[1] = valores[0];
            valores[0] = "0";
        }
        return valores;
    }

    public void setVal(String val) {
        String[] valores = processa(val);        
        this.real = Float.valueOf(valores[0]);
        valores[1] = valores[1].replace("i", "");
        if (valores[1].equals("") || valores[1].equals("+") || valores[1].equals("-")) {
            valores[1] = valores[1] + "1";
        }
        this.imaginario = Float.valueOf(valores[1]);
    }

    public void multCons(float num) {
        this.imaginario = this.imaginario * num;
        this.real = this.real * num;
    }

    public void multComplex(String num) {
        float realReal, imagImag, realImag;
        String[] valores = processa(num);
        float realTemp = Float.valueOf(valores[0]);
        float imaginarioTemp = Float.valueOf(valores[1]);
        realReal = this.real * realTemp;
        imagImag = -1 * (this.imaginario * imaginarioTemp);
        realImag = (this.real * imaginarioTemp) + (this.imaginario * realTemp);
        this.imaginario = realImag;
        this.real = realReal + imagImag;
    }

    public void soma(String num) {
        String[] valores = processa(num);
        float realTemp = Float.valueOf(valores[0]);
        float imaginarioTemp = Float.valueOf(valores[1]);

        this.imaginario += imaginarioTemp;
        this.real += realTemp;
    }

}
