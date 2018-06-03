package aplicacion;

import java.util.ArrayList;

public class GeneradorPuntos {
	private ArrayList<Punto> listaPosiblesPuntos;
	
	public GeneradorPuntos() {
		listaPosiblesPuntos = generarPosiblesPuntos();
	}
	
	public ArrayList<Punto> generarPosiblesPuntos(){
		ArrayList<Punto> listaPuntos = new ArrayList<>();	
		for (int i = 0; i <= 80; i++) {
			for(int j = 0; j<= 80; j++) {
				Punto nuevo = new Punto(i,j);
				listaPuntos.add(nuevo);
			}
		}
		return listaPuntos;
	}

	public ArrayList<Punto> getListaPosiblesPuntos() {
		return listaPosiblesPuntos;
	}
	
}
