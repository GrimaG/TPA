/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

/**
 *
 * @author gustavo
 */
public abstract class Elemento {
    int col;
    int lin;
    public abstract int getCol();

    public abstract void setCol(int col);

    public abstract int getLin();

    public abstract void setLin(int lin);

    public abstract float getVal();

    public abstract void setVal(float val);
}
