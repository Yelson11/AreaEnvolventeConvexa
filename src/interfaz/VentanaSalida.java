package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.CONSTANTES;
import aplicacion.Punto;

import javax.swing.JButton;
import javax.swing.JList;

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
		setBounds(0, 0, 520, 570);
		setBackground(new Color(200,0,180));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(361, 497, 89, 23);
		getContentPane().add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(361, 437, 89, 23);
		getContentPane().add(list);
		setVisible(true);
	}

	//Metodo que llama a todo cuando se inicia la ventana
	public void paint(Graphics g)
	{
		pintarNumeros(g);
		pintarSemiejes(g);
		//pintarPuntos(puntos, g);
	}
	
	public void drawCircle(Graphics g, int x, int y, int radius) {
		int diameter = radius * 2;
		g.setColor(Color.RED);
		g.fillOval(x - radius, y - radius, diameter, diameter); 
	}
	 
	public void pintarPuntos(ArrayList<Punto> pPuntos, Graphics g) {
		for (int i = 0; i < pPuntos.size(); i++) {
			drawCircle(g, pPuntos.get(i).getPosX() * ESCALA + ACOMODO_EN_X + 1, pPuntos.get(i).getPosY()  * ESCALA + ACOMODO_EN_Y, 2);
		}
	}
	
	public void pintarSemiejes(Graphics g) {
		//Pinta las rectas
		g.drawLine(ACOMODO_EN_X-4, ACOMODO_EN_Y, ACOMODO_EN_X-4, 450);
		g.drawLine(ACOMODO_EN_X-4, 450, 450, 450);
		
		//Pinta los sectores (de 10 en 10)
		for (int i = 0; i < 10; i++) {
			g.drawLine(ACOMODO_EN_X - 8, i * ACOMODO_EN_Y, ACOMODO_EN_X-4, i * ACOMODO_EN_Y);
		}
		for (int i = 1; i < 10; i++) {
			g.drawLine(i * ACOMODO_EN_X-4, 450 , i * ACOMODO_EN_X-4, 454);
		}
	}
	
	public void pintarNumeros(Graphics g) {
		Dimension d = this.getPreferredSize();
		int fontSize = 10;
		g.setFont(new Font("Arial", Font.PLAIN, fontSize));
		for (int i = 0; i < 10; i++) {
			g.drawString(i*10 + "", ACOMODO_EN_X - 12, i * ACOMODO_EN_Y);
		}
		for (int i = 1; i < 10; i++) {
			g.drawLine(i * ACOMODO_EN_X-4, 450 , i * ACOMODO_EN_X-4, 454);
		}
		g.drawString("12345678900", 100, 200);
	}
}
