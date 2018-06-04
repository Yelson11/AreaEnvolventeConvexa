package aplicacion;

import java.util.ArrayList;
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
	
	private Controlador() {
		calculador = new CalculadorArea();
		generador = new GeneradorPuntos();
		listaPuntos = new ArrayList<>();
	}
	
	public static Controlador getInstance() {
		if(controlador == null) {
			return new Controlador();
		}
		else {
			return controlador;
		}
	}
	//Genera los puntos aleatoriamente
	public void generarPuntos(int pCantidad) {
		ArrayList<Punto> posiblesPuntos = generador.getListaPosiblesPuntos();
		for (int i = 0; i<pCantidad; i++) {
			try {
				Random aleatorio = new Random(System.currentTimeMillis());
				int indexPunto = aleatorio.nextInt(posiblesPuntos.size()-1);
				listaPuntos.add(posiblesPuntos.get(indexPunto));
				posiblesPuntos.remove(indexPunto);
				aleatorio.setSeed(aleatorio.nextLong());
				Thread.sleep(50);

			}catch(Exception e){
				e.printStackTrace();
			}
		};
	}

	public ArrayList<Punto> getListaPuntos() {
		return listaPuntos;
	}
	
	public Vector<Punto> ladosDelPoligono(){
		Vector<Punto> vector;
		ArrayList<Punto> array = generador.getListaPosiblesPuntos();
		vector = calculador.ConvertirHull(array, array.size());
		return vector;
	}
}
