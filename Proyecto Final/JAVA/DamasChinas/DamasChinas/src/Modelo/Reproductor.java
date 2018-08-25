package Modelo;

import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;
import javax.swing.JButton;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

public class Reproductor {
    
        private BasicPlayer player;
        private JButton pausa;
        public Reproductor(){
        player = new BasicPlayer();
         }

        public void Play() throws Exception {
        player.play();
        }

        public void AbrirFichero(String ruta) throws Exception {
        player.open(new File(ruta));
        }

        public void Pausa() throws Exception {
        player.pause();
        }

        public void Continuar() throws Exception {
        player.resume();
        }

        public void Stop() throws Exception {
        player.stop();
        }
    
    }
