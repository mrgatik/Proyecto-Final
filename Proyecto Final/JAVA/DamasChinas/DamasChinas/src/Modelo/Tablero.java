package Modelo;

import javax.swing.*;
import java.awt.event.*;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

public class Tablero extends JPanel implements MouseListener {
    private GestorFichas fichas;
    private JLabel fondo;
    private boolean comenzado;
    public static final int MODO_HVH = 0, 
                            MODO_PVH = 2, 
                            MODO_HVP = 1, 
                            MODO_PVP = 3;
    
    public Tablero(){
        this.setSize(484,480);
        this.setLayout(null);
        this.setVisible(true);
        this.setOpaque(false);
        comenzado = false;
        fondo = new JLabel();
        fondo.setIcon(new ImageIcon("TableroJAN.png"));
        this.add(fondo);
        
        fondo.setSize(484,480);
        
    }

        public void cambiarModo(int modo){
            fichas.setMode(modo);
        }
	
        public void comenzarPartida(int modo){
            fichas = new GestorFichas();
            fichas.setTurnoR(true);
            fichas.setMode(modo);
	    comenzado = true;
        pintar();
        repaint();
  	}
    
        public void definirGanador(){
	    if(fichas.getFichasR() == fichas.getFichasN()){
	        if(fichas.fichasNR()==fichas.fichasRR()){
		   JOptionPane.showMessageDialog(this,"Empate!!!");
		}else if(fichas.fichasNR()<fichas.fichasRR())
		   JOptionPane.showMessageDialog(this,"Rojas Ganan!");
		   else
		    JOptionPane.showMessageDialog(this,"Negras Ganan!");	
		}else if(fichas.getFichasN()<fichas.getFichasR()){
		     JOptionPane.showMessageDialog(this,"Rojas Ganan!");
		}else
                      JOptionPane.showMessageDialog(this,"Negras Ganan!");
		comenzado = false;
	}
   
	public void pintar(){
	    Fichas[] f = fichas.getFichas();
	    removeAll();
	    for(int i= 0; i<f.length; i++){
                add(f[i]);
	        f[i].setBounds((f[i].getXp()-1)*60,(8-f[i].getYp())*60,60,60);
	    }
            add(fondo);
	}
	
    @Override
	public void mouseClicked(MouseEvent e) {	
	}

    @Override
	public void mousePressed(MouseEvent e) {	
	if(comenzado){
	    if(fichas.getMode() == MODO_HVH){
	        if(fichas.consumirTurno(e.getX(),e.getY()))
	    {
	     pintar();
		if(!fichas.hayMovimiento()){
		   definirGanador();
		    }
		    return;
			}
	    }
		
        if(fichas.getMode() == MODO_HVP){
	    if(fichas.getTurnoR())
		if(fichas.consumirTurno(e.getX(),e.getY()))
		    {
	             pintar();
			if(!fichas.hayMovimiento()){
			   definirGanador();
			}
			return;
	            }
                        if(!fichas.getTurnoR()){
                            fichas.moverNegrasPC();
                            pintar();
                                   if(!fichas.hayMovimiento())
                                       this.definirGanador();
                                       return;
                                }
                            }
		
        if(fichas.getMode() == this.MODO_PVH){
	    if(!fichas.getTurnoR())
		if(fichas.consumirTurno(e.getX(),e.getY()))
		    {
		      pintar();
			if(!fichas.hayMovimiento()){
			    definirGanador();
			    }
			     return;
		    }
			if(fichas.getTurnoR()){
	                    fichas.moverRojasPC();
	                    pintar();
	                    if(!fichas.hayMovimiento())
	                        this.definirGanador();
	                    return;
			}	
		}
		
	if(fichas.getMode() == this.MODO_PVP){
	   if(fichas.getTurnoR()){
	        fichas.moverRojasPC();
	        pintar();
	            if(!fichas.hayMovimiento())
	                this.definirGanador();
	                return;
	        }
                        if(!fichas.getTurnoR()){
                                fichas.moverNegrasPC();
                            pintar();
                            if(!fichas.hayMovimiento())
                                this.definirGanador();
                                return;
	                 }
	    }
	  }
	}	
    @Override
	public void mouseReleased(MouseEvent e) {
	}
    @Override
	public void mouseEntered(MouseEvent e) {	
	}
    @Override
	public void mouseExited(MouseEvent e) {	
	}
        
	public boolean getComenzado() {
	    return (this.comenzado); 
	}
}
