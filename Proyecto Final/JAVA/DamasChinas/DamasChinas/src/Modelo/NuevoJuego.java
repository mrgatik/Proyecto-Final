package Modelo;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

public class NuevoJuego extends JDialog implements ActionListener {
	private Tablero tab;
	private JLabel rojas, negras;
	private JButton aceptar, cancelar;
	private String[] modos;
	private JComboBox comboModos;
        
    public NuevoJuego(Tablero t){  
        this.modos = new String[]{"H vs H", "H vs PC", "PC vs H", "PC vs PC"};
	tab = t;
            this.setTitle("Nuevo Juego");
            this.setSize(300,100);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setLayout(new FlowLayout());
            this.setModal(true);
            
	modos = new String[] {
	    "H vs H",
	    "H vs PC",
	    "PC vs H",
	    "PC vs PC"
	};
        
	rojas = new JLabel("Rojas - ");
	negras = new JLabel(" - Negras");
	comboModos = new JComboBox(modos);
	aceptar = new JButton("Comenzar Juego");
	cancelar = new JButton("Cancelar");
		
	comboModos.setEditable(false);
            this.add(rojas);
            this.add(comboModos);
            this.add(negras);
            this.add(aceptar);
            this.add(cancelar);
	aceptar.addActionListener(this);
	cancelar.addActionListener(this);
        
	repaint();	
	}
        
        @Override
	public void actionPerformed(ActionEvent e){
	    if(e.getSource().equals(aceptar)){
		tab.comenzarPartida(comboModos.getSelectedIndex());
	    }
	comboModos.setSelectedIndex(0);
	    this.dispose();	
	}
}
