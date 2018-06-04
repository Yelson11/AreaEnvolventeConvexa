package aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import interfaz.*;

public class Controlador {
	
	private VentanaPrincipal ventanaPrincipal;
	private VentanaSalida ventanaSalida;
	private CalculadorArea calculador;
	private GeneradorPuntos generador;
	private ArrayList<Punto> listaPuntos;
	static Controlador controlador;
	
	private Controlador(int pCantidad) {
		calculador = new CalculadorArea();
		generador = new GeneradorPuntos();
		listaPuntos = generarPuntos(pCantidad);
	}
	
	public static Controlador getInstance(int pCantidad) {
		if(controlador == null) {
			return new Controlador(pCantidad);
		}
		else {
			return controlador;
		}
	}
	//Genera los puntos aleatoriamente
	public ArrayList<Punto> generarPuntos(int pCantidad) {
		ArrayList<Punto> temp = new ArrayList<>();
		ArrayList<Punto> posiblesPuntos = generador.getListaPosiblesPuntos();
		for (int i = 0; i<pCantidad; i++) {
			try {
				Random aleatorio = new Random(System.currentTimeMillis());
				int indexPunto = aleatorio.nextInt(posiblesPuntos.size()-1);
				temp.add(posiblesPuntos.get(indexPunto));
				posiblesPuntos.remove(indexPunto);
				aleatorio.setSeed(aleatorio.nextLong());
				Thread.sleep(50);

			}catch(Exception e){
				e.printStackTrace();
			}
		};
		return temp;
	}
	
	public void sort(ArrayList<Punto> pLista) {
		
		int n = pLista.size();
		Punto temp;
		for (int i=0; i < n; i++) {
			for (int j=1; j<(n-i); j++) {
				if(pLista.get(j-1).getPosX() > pLista.get(j).getPosX()) {
					temp = pLista.get(j-1);
					pLista.set(j-1, pLista.get(j));
					pLista.set(j, temp);
				}
			}
		}
		
	}

	public ArrayList<Punto> getListaPuntos() {
		sort(listaPuntos);
		return listaPuntos;
	}
}
