/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author gustavo.campello
 */
public class TadElemento extends Elemento{
    
    float val;

    public TadElemento( int lin, int col, float val) {
        this.col = col;
        this.lin = lin;
        this.val = val;
    }
    @Override
    public int getCol() {
        return col;
    }
    @Override
    public void setCol(int col) {
        this.col = col;
    }
    @Override
    public int getLin() {
        return lin;
    }
    @Override
    public void setLin(int lin) {
        this.lin = lin;
    }
    @Override
    public float getVal() {
        return val;
    }
    @Override
    public void setVal(float val) {
        this.val = val;
    }
    
   
}
