package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import aplicacion.CONSTANTES;
import aplicacion.Punto;
import aplicacion.CalculadorArea;
import aplicacion.Controlador;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaSalida extends JFrame implements CONSTANTES{

	ArrayList<Punto> puntos;
	private JPanel contentPane;
	private JTable table;

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
		setTitle("Area de Envolvente Convexa");
		setBounds(0, 0, 520, 570);
		setBackground(Color.WHITE);
		//setBackground(new Color(200,0,180));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				JComboBox<String> comboBox = new JComboBox();
				comboBox.setBounds(364, 459, 86, 20);
				comboBox.addItem("Puntos");
				for (int i = 0; i < puntos.size(); i++) {
					String n = "(" + puntos.get(i).getPosX() + "," + puntos.get(i).getPosY() + ")";
					comboBox.addItem(n);
				}
				getContentPane().add(comboBox);
				comboBox.show();
			}
		});
		btnNewButton.setBounds(361, 497, 89, 23);
		getContentPane().add(btnNewButton);

		
	}

	//Metodo que llama a todo cuando se inicia la ventana
	public void paint(Graphics g)
	{
		Controlador controlador = Controlador.getInstance();
		pintarNumeros(g);
		pintarSemiejes(g);
		pintarPuntos(puntos, g);
		pintarPoligono(controlador.ladosDelPoligono(), g);
	}
	
	public void drawCircle(Graphics g, int x, int y, int radius) {
		int diameter = radius * 2;
		g.setColor(Color.RED);
		g.fillOval(x - radius, y - radius, diameter, diameter); 
	}
	 
	public void pintarPuntos(ArrayList<Punto> pPuntos, Graphics g) {
		for (int i = 0; i < pPuntos.size(); i++) {			
			drawCircle(g, pPuntos.get(i).getPosX() * ESCALA + ACOMODO_EN_X - 1, 400 - pPuntos.get(i).getPosY()  * ESCALA + ACOMODO_EN_Y, 2);
		}
	}
	
	public void pintarSemiejes(Graphics g) {
		//Pinta las rectas
		g.drawLine(ACOMODO_EN_X-4, ACOMODO_EN_Y, ACOMODO_EN_X-4, 454);
		g.drawLine(ACOMODO_EN_X-4, 450, 448, 450);
		
		//Pinta los sectores (de 10 en 10)
		for (int i = 0; i < 10; i++) {
			g.drawLine(ACOMODO_EN_X - 8, i * ACOMODO_EN_Y, ACOMODO_EN_X-4, i * ACOMODO_EN_Y);
		}
		for (int i = 2; i < 10; i++) {
			g.drawLine(i * ACOMODO_EN_X-2, 450 , i * ACOMODO_EN_X-2, 454);
		}
	}
	
	public void pintarNumeros(Graphics g) {
		int fontSize = 10;
		g.setFont(new Font("Arial", Font.PLAIN, fontSize));
		for (int i = 1; i < 10; i++) {
			g.drawString((90-i*10) + "", ACOMODO_EN_X - 23, i * ACOMODO_EN_Y +5);
		}
		for (int i = 0; i < 10; i++) {
			g.drawString((i*10)-10 + "", i * ACOMODO_EN_X - 7, ACOMODO_EN_Y + 418);
		}
	}
	
	public void pintarPoligono(Vector<Punto> pPuntos, Graphics g) {
		for (int i=0; i < pPuntos.size()-1; i++) {
			g.drawLine(pPuntos.get(i).getPosX(),pPuntos.get(i).getPosX() , pPuntos.get(i+1).getPosX(), pPuntos.get(i+1).getPosY());
		}
	}
}
