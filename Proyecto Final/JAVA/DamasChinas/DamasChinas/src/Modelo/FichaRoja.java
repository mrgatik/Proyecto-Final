package Modelo;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

public class FichaRoja extends Fichas {
    private FichaRoja prev,next;
    
    FichaRoja(int x, int y){
        super(x,y);
        setIcon(ROJA_N);
        prev = next = null;
    }

    @Override
    public void coronar() {
        super.corona();
        super.setIcon(ROJA_RN);
    }

    public FichaRoja getNext() {
        return next;
    }

    public void setNext(FichaRoja next) {
        this.next = next;
    }

    public FichaRoja getPrev() {
        return prev;
    }

    public void setPrev(FichaRoja prev) {
        this.prev = prev;
    }

    @Override
    public void seleccionar() {
    	super.select(true);
        if(this.getCorona())
            super.setIcon(ROJA_RS);
        else
            super.setIcon(ROJA_S);
    }

    @Override
    public void deseleccionar() {
    	super.select(false);
        if(this.getCorona())
            super.setIcon(ROJA_RN);
        else
            super.setIcon(ROJA_N);
    }
    
    @Override
    public boolean esRoja() {
        return true;
    }

    @Override
    public FichasClonable clone() {
        throw new UnsupportedOperationException("Not supported yet."); //Para cambiar la estructura de los métodos generados, elija herramientas | En las plantillas.
    }

   
    
    
    
}

