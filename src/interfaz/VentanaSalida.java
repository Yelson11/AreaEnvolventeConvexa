package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VentanaSalida extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		VentanaSalida ventana=new VentanaSalida();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public VentanaSalida() {
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		setBounds(0, 0, 407, 371);
		setBackground(new Color(200,0,180));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(183, 298, 89, 23);
		getContentPane().add(btnNewButton);
		setVisible(true);
	}
	 public void paint(Graphics g)
	    {
		 g.drawLine(50,50,200,50);
		 g.drawLine(50,50,50,200);
		 g.drawLine(200,50,200,200);
		 g.drawLine(50,200,200,200);
	    }

}
