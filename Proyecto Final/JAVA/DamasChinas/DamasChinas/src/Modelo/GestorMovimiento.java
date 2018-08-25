package Modelo;

import java.util.ArrayList;

/**Proyecto damas chinas:
 * Miguel Diaz PN-004-3355
 * Roger Silva 8-951-948
 * Julio Gatica PE-10-585
 * Luis Bonilla 8-878-842
 * Adonis Amaya 8-928-639
 * Jorge Urbano 8-923-139
 * Luis Villarreal 8-800-1974
 */

public class GestorMovimiento {
    
    private Movimiento inicio;
    private int n;
	
	public GestorMovimiento(GestorFichas gf, Fichas[] f){
	    Movimiento[] m;
	    n=0;
            for(int i=0; i<f.length; i++){
	        m = this.movFicha(gf,f[i]);
		    for(int j=0;j<m.length;j++)
		        agregarMovimiento(m[j]);	
		}		
	}
	
	public void agregarMovimiento(Movimiento a){
	    a.setNext(inicio);
		if(inicio != null){
		   inicio.setPrev(a);
		}
		inicio = a;
		n++;
	}
	
	public static Movimiento[] movFicha(GestorFichas gf,Fichas f){
		ArrayList<Movimiento> m = new ArrayList<>();
		Movimiento[] mov;
		if(f.esRoja()){
	
		if(!gf.puedeComer(f)){
			if(gf.buscarFicha(f.getXp()+1,f.getYp()+1)==null&&f.getXp()!=8&&
				f.getYp()!=8)
				m.add(new Movimiento(f,f.getXp()+1,f.getYp()+1));
				
			if(gf.buscarFicha(f.getXp()-1,f.getYp()+1)==null&&f.getXp()>1&&f.getYp()<8)
				m.add(new Movimiento(f,f.getXp()-1,f.getYp()+1));
				
			if(gf.buscarFicha(f.getXp()+1,f.getYp()-1)==null&&f.getCorona()&&f.getXp()<8&&f.getYp()>1)
				m.add(new Movimiento(f,f.getXp()+1,f.getYp()-1));
				
			if(gf.buscarFicha(f.getXp()-1,f.getYp()-1)==null&&f.getCorona()&&f.getXp()>1&&f.getYp()>1)
				m.add(new Movimiento(f,f.getXp()-1,f.getYp()-1));
				
		}else
		{
			if(gf.buscarFicha(f.getXp()+1,f.getYp()+1)!=null&&
				gf.buscarFicha(f.getXp()+1,f.getYp()+1).esRoja()!=f.esRoja()&&
					gf.buscarFicha(f.getXp()+2,f.getYp()+2)==null&&f.getXp()<7&&f.getYp()<7)
						m.add(new Movimiento(f,f.getXp()+2,f.getYp()+2));
				
			if(gf.buscarFicha(f.getXp()-1,f.getYp()+1)!=null&&
				gf.buscarFicha(f.getXp()-1,f.getYp()+1).esRoja()!=f.esRoja()&&
					gf.buscarFicha(f.getXp()-2,f.getYp()+2)==null&&f.getXp()>2&&f.getYp()<7)
						m.add(new Movimiento(f,f.getXp()-2,f.getYp()+2));
						
			if(gf.buscarFicha(f.getXp()+1,f.getYp()-1)!=null&&
				gf.buscarFicha(f.getXp()+1,f.getYp()-1).esRoja()!=f.esRoja()&&
					gf.buscarFicha(f.getXp()+2,f.getYp()-2)==null&&
						f.getCorona()&&f.getXp()<7&&f.getYp()>2)
						m.add(new Movimiento(f,f.getXp()+2,f.getYp()-2));
			
			if(gf.buscarFicha(f.getXp()-1,f.getYp()-1)!=null&&
				gf.buscarFicha(f.getXp()-1,f.getYp()-1).esRoja()!=f.esRoja()&&
					gf.buscarFicha(f.getXp()-2,f.getYp()-2)==null&&
						f.getCorona()&&f.getXp()>2&&f.getYp()>2)
						m.add(new Movimiento(f,f.getXp()-2,f.getYp()-2));
		}
		}else{
			if(!gf.puedeComer(f)){
			if(gf.buscarFicha(f.getXp()+1,f.getYp()-1)==null&&f.getXp()<8&&f.getYp()>1)
				m.add(new Movimiento(f,f.getXp()+1,f.getYp()-1));
				
			if(gf.buscarFicha(f.getXp()-1,f.getYp()-1)==null&&f.getXp()>1&&f.getYp()>1)
				m.add(new Movimiento(f,f.getXp()-1,f.getYp()-1));
				
			if(gf.buscarFicha(f.getXp()+1,f.getYp()+1)==null&&f.getCorona()&&f.getXp()!=8&&
				f.getYp()!=8)
				m.add(new Movimiento(f,f.getXp()+1,f.getYp()+1));
				
			if(gf.buscarFicha(f.getXp()-1,f.getYp()+1)==null&&f.getCorona()&&f.getXp()>1&&f.getYp()<8)
				m.add(new Movimiento(f,f.getXp()-1,f.getYp()+1));
				
		}else
		{
			if(gf.buscarFicha(f.getXp()+1,f.getYp()-1)!=null&&
				gf.buscarFicha(f.getXp()+1,f.getYp()-1).esRoja()!=f.esRoja()&&
					gf.buscarFicha(f.getXp()+2,f.getYp()-2)==null&&f.getXp()<7&&f.getYp()>2)
						m.add(new Movimiento(f,f.getXp()+2,f.getYp()-2));
				
			if(gf.buscarFicha(f.getXp()-1,f.getYp()-1)!=null&&
				gf.buscarFicha(f.getXp()-1,f.getYp()-1).esRoja()!=f.esRoja()&&
					gf.buscarFicha(f.getXp()-2,f.getYp()-2)==null&&f.getXp()>2&&f.getYp()>2)
						m.add(new Movimiento(f,f.getXp()-2,f.getYp()-2));
						
			if(gf.buscarFicha(f.getXp()+1,f.getYp()+1)!=null&&
				gf.buscarFicha(f.getXp()+1,f.getYp()+1).esRoja()!=f.esRoja()&&
					gf.buscarFicha(f.getXp()+2,f.getYp()+2)==null&&
						f.getCorona()&&f.getXp()<7&&f.getYp()<7)
						m.add(new Movimiento(f,f.getXp()+2,f.getYp()+2));
			
			if(gf.buscarFicha(f.getXp()-1,f.getYp()+1)!=null&&
				gf.buscarFicha(f.getXp()-1,f.getYp()+1).esRoja()!=f.esRoja()&&
					gf.buscarFicha(f.getXp()-2,f.getYp()+2)==null&&
						f.getCorona()&&f.getXp()>2&&f.getYp()<7)
						m.add(new Movimiento(f,f.getXp()-2,f.getYp()+2));
		}
		}
		
		mov = new Movimiento[m.size()];
		for(int i=0; i<mov.length; i++)
			mov[i] = m.get(i);	
		return mov;
	}
	
	public Movimiento[] getMovimientos(){
	    Movimiento[] m = new Movimiento[n];
	    Movimiento temp = inicio;
		int i = 0;
		while(temp!=null){
		      m[i++] = temp;
		      temp = temp.getNext();
		}
		return m;
	}	
}