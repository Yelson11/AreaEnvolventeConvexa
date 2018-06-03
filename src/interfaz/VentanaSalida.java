package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.CONSTANTES;
import aplicacion.Punto;

import javax.swing.JButton;

public class VentanaSalida extends JFrame implements CONSTANTES{

	ArrayList<Punto> puntos;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//VentanaSalida ventana = new VentanaSalida();
        //ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSalida frame = new VentanaSalida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public VentanaSalida(ArrayList<Punto> pPuntos) {
		puntos = pPuntos;
		setBounds(0, 0, 407, 371);
		setBackground(new Color(200,0,180));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(183, 298, 89, 23);
		getContentPane().add(btnNewButton);
		setVisible(true);
	}

	//Metodo que llama a todo cuando se inicia la ventana
	public void paint(Graphics g)
	{
		pintarPuntos(puntos, g);
	}
	
	public void drawCircle(Graphics g, int x, int y, int radius) {
		int diameter = radius * 2;
		g.setColor(Color.RED);
		g.fillOval(x - radius, y - radius, diameter, diameter); 
	}
	 
	public void pintarPuntos(ArrayList<Punto> pPuntos, Graphics g) {
		for (int i = 0; i < pPuntos.size(); i++) {
			drawCircle(g, pPuntos.get(i).getPosX() * ESCALA + ACOMODO_EN_X, pPuntos.get(i).getPosY()  * ESCALA + ACOMODO_EN_Y, 2);
		}
	}
}
