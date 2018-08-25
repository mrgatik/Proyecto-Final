package Modelo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

public abstract class Fichas extends JLabel implements FichasClonable {
    
   ImageIcon ROJA_N = new ImageIcon("fichaRojaNatural.png");

   ImageIcon NEGRA_N = new ImageIcon("fichaNegraNatural.png");

   ImageIcon ROJA_S = new ImageIcon("fichaRojaSombreada.png");

   ImageIcon NEGRA_S = new ImageIcon("fichaNegraSombreada.png");

   ImageIcon ROJA_RN = new ImageIcon("fichaRojaReinaNatural.png");

   ImageIcon NEGRA_RN = new ImageIcon("fichaNegraReinaNatural.png");

   ImageIcon ROJA_RS = new ImageIcon("fichaRojaReinaSombreada.png");

   ImageIcon NEGRA_RS = new ImageIcon("fichaNegraReinaSombreada.png");
            
    private int x,y;

    private boolean corona;
    
    private boolean selec;

    Fichas(int x,int y){
        this.x = x;
        this.y = y;
        corona = false;
    }
    
    public int getXp(){
        return this.x;
    }

    public int getYp(){
        return this.y;
    }
    
    public boolean isSelect(){
    	return selec;
    }
    
    protected void select(boolean b){
    	selec = b;
    }

    public void moverFicha(int x,int y){
        this.x = x;
        this.y = y;
    }

    protected void corona(){
        this.corona = true;
    }

    protected boolean getCorona(){
        return corona;
    }

    public abstract void coronar();

    public abstract void seleccionar();

    public abstract void deseleccionar();

    public abstract boolean esRoja();
    
    public abstract FichasClonable clone();
            
}
