package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.List;

public class FrameAggiungiVoto extends JFrame {

	private JPanel contentPane;
	private JTextField textField_classe;
	private JTextField textField_cognome;
	private JTextField textField_nome;
	private JTextField textField_materia;
	private JTextField textField_voto;
	private JTextField textField_data;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAggiungiVoto frame = new FrameAggiungiVoto();
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
	public FrameAggiungiVoto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_AggiungiVoto = new JLabel("Aggiungi Voto");
		lbl_AggiungiVoto.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_AggiungiVoto.setBounds(10, 10, 106, 19);
		contentPane.add(lbl_AggiungiVoto);
		
		JLabel lbl_materia = new JLabel("Materia");
		lbl_materia.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_materia.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_materia.setBounds(20, 44, 45, 13);
		contentPane.add(lbl_materia);
		
		textField_classe = new JTextField();
		textField_classe.setBounds(111, 39, 96, 19);
		contentPane.add(textField_classe);
		textField_classe.setColumns(10);
		
		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setBounds(20, 80, 45, 13);
		contentPane.add(lbl_nome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(111, 75, 96, 19);
		contentPane.add(textField_nome);
		textField_nome.setColumns(10);
		
		textField_cognome = new JTextField();
		textField_cognome.setBounds(111, 104, 96, 19);
		contentPane.add(textField_cognome);
		textField_cognome.setColumns(10);
				

		
		JLabel lbl_cognome = new JLabel("Cognome");
		lbl_cognome.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_cognome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cognome.setBounds(10, 108, 60, 13);
		contentPane.add(lbl_cognome);
		
		
		JLabel lbl_data = new JLabel("Data");
		lbl_data.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_data.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_data.setBounds(10, 138, 60, 13);
		contentPane.add(lbl_data);
		
		JLabel lbl_voto = new JLabel("Voto");
		lbl_voto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_voto.setBounds(32, 178, 48, 14);
		contentPane.add(lbl_voto);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(111, 134, 96, 20);
		contentPane.add(dateChooser);
		
	
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(111, 175, 96, 20);
		contentPane.add(spinner);
		
		
		
		
		
		
	
		
	
		
		
	}
}