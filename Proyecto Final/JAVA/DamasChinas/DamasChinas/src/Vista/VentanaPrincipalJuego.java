package Vista;

import Modelo.*;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

public class VentanaPrincipalJuego extends JFrame implements ActionListener {
    //Atributos de la clase 
    public Tablero mesa;
    public JMenuBar barraMenu;
    public JMenu mArchivo,mCambiarModo;
    public JMenuItem mNuevoJuego, mSalir, mHvH, mHvPC, mPCvH, mPCvPC;
    public NuevoJuego nuevo;
    public JButton play,cuenta,jugador,jugadores,guardar,eliminar,descargar,pregunta,compartir,colorear,pdf,estadisticaA, estadisticaB;
    public JToolBar barraTool, barraTool2;
    public boolean ban = true;
    Reproductor mi_reproductor;

    public VentanaPrincipalJuego(){
    	super(" **JUEGO DE DAMAS CHINAS - PROYECTO FINAL** ");
        
        mi_reproductor = new Reproductor();
        try {
        mi_reproductor.AbrirFichero("C:\\Users\\Estudiante\\Music\\Romeo.mp3");
        } catch (Exception ex) {
            System.out.println("error al leer archivo");
        }
     //------------------------------------------------------/
        this.setSize(492,678);
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
     
       	barraMenu = new JMenuBar();
        this.setJMenuBar(barraMenu);

            mArchivo = new JMenu("Archivo");
            barraMenu.add(mArchivo);

                    mNuevoJuego = new JMenuItem("Nuevo Juego");
                    mArchivo.add(mNuevoJuego);
                    mNuevoJuego.addActionListener(this);

                    mSalir = new JMenuItem("Salir");
                    mArchivo.add(mSalir);
                    mSalir.addActionListener(this);
        
            mCambiarModo = new JMenu("Cambiar Modo");
            barraMenu.add(mCambiarModo);
        
                    mHvH = new JMenuItem("H vs H");
                    mCambiarModo.add(mHvH);
                    mHvH.addActionListener(this);

                    mHvPC = new JMenuItem("H vs PC");
                    mCambiarModo.add(mHvPC);
                    mHvPC.addActionListener(this);

                    mPCvH = new JMenuItem("PC vs H");
                    mCambiarModo.add(mPCvH);
                    mPCvH.addActionListener(this);

                    mPCvPC = new JMenuItem("PC vs PC");
                    mCambiarModo.add(mPCvPC);
                    mPCvPC.addActionListener(this);
        
     
        this.setLayout(new BorderLayout());
        
        barraTool = new JToolBar();
        //-------------------------------------
        cuenta = new JButton(); 
        ImageIcon Icuenta = new ImageIcon("cuenta.png");
        cuenta.setIcon(Icuenta);
        cuenta.setBackground(Color.BLACK);
        cuenta.setBorderPainted(false);
        //--------------------------------------
        jugador = new JButton(); 
        ImageIcon Ijugador = new ImageIcon("jugador.png");
        jugador.setIcon(Ijugador);
        jugador.setBackground(Color.BLACK);
        jugador.setBorderPainted(false);
        //--------------------------------------
        jugadores = new JButton();
        ImageIcon Ijugadores = new ImageIcon("jugadores.png");
        jugadores.setIcon(Ijugadores);
        jugadores.setBackground(Color.BLACK);
        jugadores.setBorderPainted(false);
        //---------------------------------------
        guardar= new JButton();
        ImageIcon Iguardar = new ImageIcon("guardar.png");
        guardar.setIcon(Iguardar);
        guardar.setBackground(Color.BLACK);
        guardar.setBorderPainted(false);  
        //---------------------------------------
        colorear = new JButton(); 
        ImageIcon Icolorear =new ImageIcon("colorear.png");
        colorear.setIcon(Icolorear);
        colorear.setBackground(Color.BLACK);
        colorear.setBorderPainted(false);
        //---------------------------------------
        estadisticaA = new JButton(); 
        ImageIcon IA =new ImageIcon("estadistica1.png");
        estadisticaA.setIcon(IA);
        estadisticaA.setBackground(Color.BLACK);
        estadisticaA.setBorderPainted(false);
        //---------------------------------------
        estadisticaB = new JButton(); 
        ImageIcon IB =new ImageIcon("estadistica2.png");
        estadisticaB.setIcon(IB);
        estadisticaB.setBackground(Color.BLACK);
        estadisticaB.setBorderPainted(false);
        //---------------------------------------
       
        barraTool.add(cuenta);
        barraTool.add(jugador);
        barraTool.add(jugadores);
        barraTool.add(guardar);
        barraTool.add(colorear);
        barraTool.add(estadisticaA);
        barraTool.add(estadisticaB);
        
        barraTool.setBackground(Color.BLACK);
        add(barraTool,BorderLayout.NORTH);
        
        //<---------------------------------------------------------------->//
        barraTool2 = new JToolBar();
  
        pregunta = new JButton();
        ImageIcon Ipregunta = new ImageIcon("pregunta.png");
        pregunta.setIcon(Ipregunta);
        pregunta.setBackground(Color.BLACK);
        pregunta.setBorderPainted(false);
        
        pdf = new JButton();
        ImageIcon Ipdf = new ImageIcon("pdf.png");
        pdf.setIcon(Ipdf);
        pdf.setBackground(Color.BLACK);
        pdf.setBorderPainted(false);
        
        play = new JButton();
        ImageIcon pre=new ImageIcon("Play.png");
        play.setIcon(pre);
        play.setBackground(Color.BLACK);
        play.setBorderPainted(false);
        play.addActionListener(this);
        
        barraTool2.add(pregunta);
        barraTool2.add(pdf);
        barraTool2.add(play);
        
        barraTool2.setBackground(Color.BLACK);
        add(barraTool2,BorderLayout.SOUTH);
        
        //
        mesa = new Tablero();
        add(mesa,BorderLayout.CENTER);
        mesa.setSize(484,480);
        mesa.addMouseListener(mesa);

        nuevo = new NuevoJuego(mesa);
      
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
              System.exit(0);
            }
            
        });
        repaint(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==play){
        if(ban==true){
            try {
              
              mi_reproductor.Play();
              mi_reproductor.Continuar();
              ban=false;
                System.out.println("ejecutando");
            } catch (Exception ex) {
              System.out.println("Error: " + ex.getMessage());
            }
         }else{
        try {
            mi_reproductor.Pausa();
            ban=true;
            System.out.println("pausando");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        }
        }
        
        if(e.getSource().equals(mNuevoJuego)){
            nuevo.show();
        }else if(e.getSource().equals(mSalir)){
            this.dispose(); 
        }else if(e.getSource().equals(mHvH)){
        	if(mesa.getComenzado())
        	mesa.cambiarModo(mesa.MODO_HVH);
        }else if(e.getSource().equals(mHvPC)){
        	if(mesa.getComenzado())
        	mesa.cambiarModo(mesa.MODO_HVP);
        }else if(e.getSource().equals(mPCvH)){
        	if(mesa.getComenzado())
        	mesa.cambiarModo(mesa.MODO_PVH);
        }else if(e.getSource().equals(mPCvPC)){
        	if(mesa.getComenzado())
        	mesa.cambiarModo(mesa.MODO_PVP);
        }
    }
}
    
