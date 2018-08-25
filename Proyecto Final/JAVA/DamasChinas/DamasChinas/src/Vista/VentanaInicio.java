package Vista;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaInicio extends JFrame{
    private JPanel panelInferior,inicio,panelCentral;
    private JLabel logo,uss,cargando;
    
    public VentanaInicio(){
        JFrame frame = new JFrame();
        frame.setTitle(" **INICIO** ");
        
  //-------------------------------------------/
        frame.setBackground(Color.WHITE);
        inicio = new JPanel();
        inicio.setBackground(Color.WHITE);
        logo = new JLabel();
        ImageIcon jan = new ImageIcon("logo03.jpg");
        logo.setIcon(jan);
        inicio.add(logo);
     //-------------------------------------------/   
        panelCentral = new JPanel();
        panelCentral.setBackground(Color.WHITE);
        //panelCentral.setBounds(200,20,40,20 );
        cargando = new JLabel();
        ImageIcon cargar = new ImageIcon("cargar1.gif");
        cargando.setBounds(200, 20, 40, 20);
        cargando.setIcon(cargar);
        panelCentral.add(cargando);
    //-------------------------------------------/    
        panelInferior = new JPanel();
        panelInferior.setBackground(Color.WHITE);
        uss = new JLabel();
        ImageIcon logo3 = new ImageIcon("USS.png");
        uss.setIcon(logo3);
        panelInferior.add(uss);
    //-------------------------------------------/ 
        frame.add(inicio, BorderLayout.NORTH);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.add(panelInferior, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setSize(492,678);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //-------------------------------------------/
    }
}

