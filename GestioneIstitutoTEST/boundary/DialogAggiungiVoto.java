package boundary;



import javax.swing.JDialog;
//import java.sql.Date;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import control.Controller;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DialogAggiungiVoto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_matricola;
	private JTextField textField_materia;
	private JTextField textOut_materia;
	private JTextField textOut_matricola;
	private JTextField textOut_data;
	private JTextField textField_docente;
	private JTextField textOut_docente;
	


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogAggiungiVoto dialog = new DialogAggiungiVoto();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogAggiungiVoto() {
		//setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 738, 355);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_AggiungiVoto = new JLabel("Aggiungi Voto");
		lbl_AggiungiVoto.setForeground(new Color(255, 255, 255));
		lbl_AggiungiVoto.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lbl_AggiungiVoto.setBounds(10, 10, 197, 19);
		contentPane.add(lbl_AggiungiVoto);
		
		JLabel lbl_matricola = new JLabel("Matricola");
		lbl_matricola.setForeground(new Color(255, 255, 255));
		lbl_matricola.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_matricola.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_matricola.setBounds(25, 144, 60, 13);
		contentPane.add(lbl_matricola);
		
		textField_matricola = new JTextField();
		textField_matricola.setEditable(false);
		textField_matricola.setBounds(111, 140, 145, 19);
		contentPane.add(textField_matricola);
		textField_matricola.setColumns(10);
		
		
		JLabel lbl_data = new JLabel("Data");
		lbl_data.setForeground(new Color(255, 255, 255));
		lbl_data.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_data.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_data.setBounds(25, 198, 60, 13);
		contentPane.add(lbl_data);
		
		JLabel lbl_voto = new JLabel("Voto");
		lbl_voto.setForeground(new Color(255, 255, 255));
		lbl_voto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_voto.setBounds(37, 238, 48, 14);
		contentPane.add(lbl_voto);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setEnabled(false);
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(111, 191, 145, 20);
		contentPane.add(dateChooser);
		
	
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setModel(new SpinnerNumberModel(Float.valueOf(1), Float.valueOf(1), Float.valueOf(10), Float.valueOf(1)));
		spinner.setBounds(111, 235, 145, 20);
		contentPane.add(spinner);
		
		JLabel lbl_materia = new JLabel("Materia");
		lbl_materia.setForeground(new Color(255, 255, 255));
		lbl_materia.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_materia.setBounds(37, 91, 48, 14);
		contentPane.add(lbl_materia);
		
		textField_materia = new JTextField();
		textField_materia.setEditable(false);
		textField_materia.setBounds(111, 88, 145, 20);
		contentPane.add(textField_materia);
		textField_materia.setColumns(10);
		
		JButton btnAggiungiVoto = new JButton("AGGIUNGI");
		btnAggiungiVoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAggiungiVoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAggiungiVoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ret=-1;
			
				
				String matricola = textField_matricola.getText();
				String materia = textField_materia.getText();
				String docente = textField_docente.getText();
				java.util.Date data = dateChooser.getDate();
				float voto = (float) spinner.getValue();
				
			
				ret = Controller.aggiungiVoto(docente, Integer.parseInt(matricola), Integer.parseInt(materia), new java.sql.Date(data.getTime()), voto);

				
				if(ret!=-1) {
					
					JOptionPane.showMessageDialog(btnAggiungiVoto, "Voto inserito correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);


				}else {
					JOptionPane.showMessageDialog(btnAggiungiVoto, "Inserimento non andato a buon fine", "Error", JOptionPane.ERROR_MESSAGE);
				}
				

				
				
			}
		});
		btnAggiungiVoto.setBounds(396, 264, 112, 23);
		contentPane.add(btnAggiungiVoto);
		
		
		
		
		textField_docente = new JTextField();
		textField_docente.setBounds(111, 50, 145, 20);
		contentPane.add(textField_docente);
		textField_docente.setColumns(10);
		
		JButton btnCHECK_DOCENTE = new JButton("Check Docente");
		btnCHECK_DOCENTE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String docente=textField_docente.getText();
				boolean i= Controller.controllodocente(docente);
				
				if(i==true) {
					textField_materia.setEditable(true);
					textOut_docente.setText("OK!");
				}else {
					textOut_docente.setText("Docente non trovato");
				}
				
			}
		});
		btnCHECK_DOCENTE.setBounds(404, 49, 119, 23);
		contentPane.add(btnCHECK_DOCENTE);
		
		
		
		
		
		JButton btnCHECK_MATERIA = new JButton("Check Materia");
		btnCHECK_MATERIA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String materia = textField_materia.getText();
				String docente = textField_docente.getText();
				
			
				boolean i = Controller.controllomateria_insegnata(Integer.parseInt(materia), docente);
				
				if(i==true) {
					textField_matricola.setEditable(true);
					textOut_materia.setText("OK!");
				}else {
					textOut_materia.setText("Materia non trovata");
					
					
				}
			}
		});
		btnCHECK_MATERIA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCHECK_MATERIA.setBounds(404, 87, 119, 23);
		contentPane.add(btnCHECK_MATERIA);
		
		
		
		JButton btnCHECK_MATRICOLA = new JButton("Check Matricola");
		btnCHECK_MATRICOLA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String matricola = textField_matricola.getText();
				String materia = textField_materia.getText();
		
			boolean i = Controller.controllostudenteInClasse(Integer.parseInt(matricola),Integer.parseInt(materia) );
				
				if(i==true) {
					dateChooser.setEnabled(true);
					textOut_matricola.setText("OK!");
				}else {
					textOut_matricola.setText("Matricola non trovata");
				}
				
				
			}
		});
		btnCHECK_MATRICOLA.setBounds(404, 139, 119, 23);
		contentPane.add(btnCHECK_MATRICOLA);
		
		JButton btnCHECK_DATA = new JButton("Check Data");
			btnCHECK_DATA.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        java.util.Date data = dateChooser.getDate();
		        java.sql.Date data2 = new java.sql.Date(data.getTime());


		        boolean i = Controller.controllodata(data2);
		        if (i == true) {
		            //se la data è valida
		            spinner.setEnabled(i);
		            textOut_data.setText("OK!");
		        } else {
		            textOut_data.setText("Data non valida");
		        }
		    }
		});

	
		
		
		btnCHECK_DATA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCHECK_DATA.setBounds(404, 193, 119, 23);
		contentPane.add(btnCHECK_DATA);
		
		textOut_materia = new JTextField();
		textOut_materia.setHorizontalAlignment(SwingConstants.CENTER);
		textOut_materia.setForeground(new Color(255, 255, 255));
		textOut_materia.setBackground(new Color(0, 0, 128));
		textOut_materia.setEditable(false);
		textOut_materia.setBounds(533, 88, 147, 20);
		contentPane.add(textOut_materia);
		textOut_materia.setColumns(10);
		
		textOut_matricola = new JTextField();
		textOut_matricola.setHorizontalAlignment(SwingConstants.CENTER);
		textOut_matricola.setForeground(new Color(255, 255, 255));
		textOut_matricola.setBackground(new Color(0, 0, 128));
		textOut_matricola.setEditable(false);
		textOut_matricola.setBounds(533, 140, 147, 20);
		contentPane.add(textOut_matricola);
		textOut_matricola.setColumns(10);
		
		textOut_data = new JTextField();
		textOut_data.setHorizontalAlignment(SwingConstants.CENTER);
		textOut_data.setForeground(new Color(255, 255, 255));
		textOut_data.setBackground(new Color(0, 0, 128));
		textOut_data.setEditable(false);
		textOut_data.setBounds(533, 194, 147, 20);
		contentPane.add(textOut_data);
		textOut_data.setColumns(10);
		
		JLabel lbl_docente = new JLabel("Docente");
		lbl_docente.setForeground(Color.WHITE);
		lbl_docente.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_docente.setBounds(37, 53, 48, 14);
		contentPane.add(lbl_docente);
		
	
		
		textOut_docente = new JTextField();
		textOut_docente.setHorizontalAlignment(SwingConstants.CENTER);
		textOut_docente.setForeground(Color.WHITE);
		textOut_docente.setEditable(false);
		textOut_docente.setColumns(10);
		textOut_docente.setBackground(new Color(0, 0, 128));
		textOut_docente.setBounds(533, 50, 147, 20);
		contentPane.add(textOut_docente);
		
		
		
		
		JButton btn_ListaMaterie = new JButton("Lista Materie");
		btn_ListaMaterie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_ListaMaterie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//mostra a video la lista delle materie
				ArrayList<String> materie = new ArrayList<String>();
				
			materie = Controller.visualizzamateriePerDocente(textField_docente.getText());
				
				JOptionPane.showMessageDialog(btnCHECK_MATERIA, materie.toString(), "Lista Materie", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn_ListaMaterie.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_ListaMaterie.setBounds(266, 88, 128, 22);
		contentPane.add(btn_ListaMaterie);
		
		JButton btn_listaMatricole = new JButton("Lista Matricole");
		btn_listaMatricole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//mostra lista Matricole
				ArrayList<String> studenti = new ArrayList<String>();
				String materia= textField_materia.getText();
				
				studenti = Controller.visualizzastudentiPerMateria(Integer.parseInt(materia));
				
				JOptionPane.showMessageDialog(btn_listaMatricole, studenti.toString(), "Lista Matricole", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		btn_listaMatricole.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_listaMatricole.setForeground(Color.BLACK);
		btn_listaMatricole.setBounds(266, 140, 128, 19);
		contentPane.add(btn_listaMatricole);
		
		

	}
}