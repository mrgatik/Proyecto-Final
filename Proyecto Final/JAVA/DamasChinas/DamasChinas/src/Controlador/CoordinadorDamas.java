package Controlador;

import Vista.VentanaInicio;
import Vista.VentanaPrincipalJuego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

public class CoordinadorDamas implements ActionListener{
    private VentanaPrincipalJuego VJuego;
    private VentanaInicio VInicio;
        public CoordinadorDamas() {
        //Pantalla - GUI
        VJuego = new VentanaPrincipalJuego();
        VJuego.setVisible(true);
        VInicio = new VentanaInicio();   
        //Configurar a donde enviar la acción
        //Botones
        VJuego.cuenta.addActionListener(this);
        VJuego.jugador.addActionListener(this);
        VJuego.jugadores.addActionListener(this);
        VJuego.guardar.addActionListener(this);
        VJuego.eliminar.addActionListener(this);
        VJuego.descargar.addActionListener(this);
        VJuego.pregunta.addActionListener(this);
        VJuego.compartir.addActionListener(this);
        VJuego.estadisticaA.addActionListener(this);
        VJuego.estadisticaB.addActionListener(this);
        VJuego.play.addActionListener(this);
        //Menu
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==VJuego.cuenta){
          JOptionPane.showMessageDialog(VJuego,"SU CUENTA");
       }
     
         if(e.getSource()==VJuego.guardar){
          JOptionPane.showMessageDialog(VJuego,"SU JUEGO SE GUARDO");
       }  
    }
}
    
