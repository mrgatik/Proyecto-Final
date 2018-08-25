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

public class FichaNegra extends Fichas {
    private FichaNegra prev,next;

    FichaNegra(int x, int y){
        super(x,y);
        setIcon(NEGRA_N);
        prev = next = null;
    }
    
    public FichaNegra getNext() {
        return next;
    }
    
    public void setNext(FichaNegra next) {
        this.next = next;
    }
    
    public FichaNegra getPrev() {
        return prev;
    }
    
    public void setPrev(FichaNegra prev) {
        this.prev = prev;
    }
    
    @Override
    public void coronar() {
        super.corona();
        super.setIcon(NEGRA_RN);
    }

    @Override
    public void seleccionar() {
    	super.select(true);
        if(this.getCorona())
            super.setIcon(NEGRA_RS);
        else
            super.setIcon(NEGRA_S);
    }

    @Override
    public void deseleccionar() {
    	super.select(false);
        if(this.getCorona())
            super.setIcon(NEGRA_RN);
        else
            super.setIcon(NEGRA_N);
    }
    
    @Override
    public boolean esRoja() {
        return false;
    }
    
    private void setIcon() {
    }
    
    public FichasClonable clone() {
        throw new UnsupportedOperationException("Not supported yet."); //Para cambiar la estructura de los métodos generados, elija herramientas | En las plantillas.
    }
}