package boundary;



import javax.swing.JDialog;
import java.sql.Date;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogAggiungiVoto extends JDialog {

	private JPanel contentPane;
	private JTextField textField_matricola;
	private JTextField textField_materia;
	
	private static int idval = 1; // variabile statica per l'ID valutazioni progressivo
	private JTextField textOut_materia;
	private JTextField textOut_matricola;
	private JTextField textOut_data;


	

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
		setBounds(100, 100, 575, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_AggiungiVoto = new JLabel("Aggiungi Voto");
		lbl_AggiungiVoto.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_AggiungiVoto.setBounds(10, 10, 106, 19);
		contentPane.add(lbl_AggiungiVoto);
		
		JLabel lbl_matricola = new JLabel("Matricola");
		lbl_matricola.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_matricola.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_matricola.setBounds(25, 123, 60, 13);
		contentPane.add(lbl_matricola);
		
		textField_matricola = new JTextField();
		textField_matricola.setBounds(111, 119, 96, 19);
		contentPane.add(textField_matricola);
		textField_matricola.setColumns(10);
		
		
		JLabel lbl_data = new JLabel("Data");
		lbl_data.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_data.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_data.setBounds(25, 176, 60, 13);
		contentPane.add(lbl_data);
		
		JLabel lbl_voto = new JLabel("Voto");
		lbl_voto.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_voto.setBounds(39, 218, 48, 14);
		contentPane.add(lbl_voto);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(111, 169, 96, 20);
		contentPane.add(dateChooser);
		
	
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		spinner.setBounds(111, 215, 96, 20);
		contentPane.add(spinner);
		
		JLabel lbl_materia = new JLabel("Materia");
		lbl_materia.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_materia.setBounds(37, 70, 48, 14);
		contentPane.add(lbl_materia);
		
		textField_materia = new JTextField();
		textField_materia.setBounds(111, 67, 96, 20);
		contentPane.add(textField_materia);
		textField_materia.setColumns(10);
		
		JButton btnAggiungiVoto = new JButton("Aggiungi");
		btnAggiungiVoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ret=-1;
				
				int idvalutazioni = idval++;
				
				String matricola = textField_matricola.getText();
				String materia = textField_materia.getText();
				java.util.Date data = dateChooser.getDate();
				int voto = (int) spinner.getValue();
				
				ret=Controller.aggiungiVoto(idvalutazioni, Integer.parseInt(matricola),Integer.parseInt(materia),(Date) data, voto);
				
				if(ret!=-1) {
					
					JOptionPane.showMessageDialog(btnAggiungiVoto, "Testo inserito correttamente", "Plain Text", JOptionPane.PLAIN_MESSAGE);


				}else {
					
					JOptionPane.showMessageDialog(btnAggiungiVoto, "Inserimennto non andato a buon fine", "Error", JOptionPane.ERROR_MESSAGE);

				}
				
				
				
				
				
				
				
			}
		});
		btnAggiungiVoto.setBounds(464, 286, 89, 23);
		contentPane.add(btnAggiungiVoto);
		
		JButton btnCheckMateria = new JButton("Check Materia");
		btnCheckMateria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String materia = textField_materia.getText();
				
				boolean i = Controller.esisteMateria(Integer.parseInt(materia));
				
				if(i==true) {
					
					//se ho trovato la materia
					textField_matricola.setEditable(true);
					
					
					textOut_materia.setText("Materia Trovata");
				
				}else {
					
					textOut_materia.setText("Materia non trovata");
				}
			}
		});
		
		btnCheckMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckMateria.setBounds(217, 66, 123, 23);
		contentPane.add(btnCheckMateria);
		
		JButton btnCheckMatricola = new JButton("Check Matricola");
		btnCheckMatricola.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String matricola = textField_matricola.getText();
				
				boolean i = Controller.esisteStudente(Integer.parseInt(matricola));
				
				if(i==true) {
					
					//se ho trovato lo studente
					
					
					
					textOut_materia.setText("Studente Trovato");
				
				}else {
					
					textOut_materia.setText("Studente non trovato");
				}
			}
		});
		
		
		
		btnCheckMatricola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCheckMatricola.setBounds(217, 118, 123, 23);
		contentPane.add(btnCheckMatricola);
		
		JButton btnCheckData = new JButton("Check Data");
		btnCheckData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				java.util.Date data = dateChooser.getDate();
				
				boolean i=Controller.isDataValida((Date)data);
				if(i==true) {
					//se la data è valida
					textOut_data.setText("DataValida");
				}
				else {
					textOut_data.setText("Data non valida");
				}
				
				
				
			}
		});
		btnCheckData.setBounds(217, 171, 123, 23);
		contentPane.add(btnCheckData);
		
		textOut_materia = new JTextField();
		textOut_materia.setBounds(386, 67, 112, 20);
		contentPane.add(textOut_materia);
		textOut_materia.setColumns(10);
		
		textOut_matricola = new JTextField();
		textOut_matricola.setBounds(386, 119, 112, 20);
		contentPane.add(textOut_matricola);
		textOut_matricola.setColumns(10);
		
		textOut_data = new JTextField();
		textOut_data.setBounds(386, 172, 112, 20);
		contentPane.add(textOut_data);
		textOut_data.setColumns(10);

		
	}
}
