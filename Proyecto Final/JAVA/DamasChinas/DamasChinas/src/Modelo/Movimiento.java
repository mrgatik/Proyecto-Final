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

public class Movimiento {
	private Fichas ficha;
	private int x, y;
	private Movimiento next,prev;
	
	public Movimiento(Fichas f,int x,int y){
		ficha = f;
		this.x = x;
		this.y = y;
		next = null;
		prev = null;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Fichas getFicha(){
		return ficha;
	}

	public void setNext(Movimiento next) {
		this.next = next; 
	}

	public void setPrev(Movimiento prev) {
		this.prev = prev; 
	}
	
	public void realizarMovimiento(){
		ficha.moverFicha(x,y);
	}

	public Movimiento getNext() {
		return (this.next); 
	}

	public Movimiento getPrev() {
		return (this.prev); 
	}
}