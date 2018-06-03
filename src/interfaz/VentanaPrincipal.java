package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class VentanaPrincipal extends JFrame {
	
	private int cantidadPuntos;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 165);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Seleccione la cantidad de puntos que desea generar:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		label.setBounds(35, 25, 298, 31);
		contentPane.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(327, 31, 54, 20);
		for (int i = 1; i <= 100; i++) {
			comboBox.addItem(i);
		}
		contentPane.add(comboBox);
		
		JButton button = new JButton("ACEPTAR");
		button.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		button.setBounds(172, 69, 89, 23);
		contentPane.add(button);
	}
	
	public int getCantidadPuntos() {
		return cantidadPuntos;
	}

}
