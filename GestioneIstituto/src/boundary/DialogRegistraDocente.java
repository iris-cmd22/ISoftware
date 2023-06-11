package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import control.Controller;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.sound.midi.SysexMessage;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JSpinner;

public class DialogRegistraDocente extends JDialog {

	private JPanel contentPane;
	private JTextField textField_Nome;
	private JTextField textField_Cognome;
	private JTextField textField_codiceFiscale;
	private JTextField textField_Email;
	private JTextField textField_NumeroCellulare;
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JTextField textField_ComuneResidenza;
	private JTextField textOut;
	private JTextField text_materie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogRegistraUtente dialog = new DialogRegistraUtente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DialogRegistraDocente() {
		
		ArrayList<Integer> materie = new ArrayList<Integer>();
		
		setBounds(100, 100, 613, 447);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RegistraDocente = new JLabel("Registra Docente");
		lbl_RegistraDocente.setForeground(new Color(255, 255, 255));
		lbl_RegistraDocente.setBackground(new Color(255, 255, 255));
		lbl_RegistraDocente.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		lbl_RegistraDocente.setBounds(10, 10, 165, 19);
		contentPane.add(lbl_RegistraDocente);
		
		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setForeground(new Color(255, 255, 255));
		lbl_nome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_nome.setBounds(10, 59, 45, 13);
		contentPane.add(lbl_nome);
		
		textField_Nome = new JTextField();
		textField_Nome.setEditable(false);
		textField_Nome.setBounds(167, 57, 116, 19);
		contentPane.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		textField_Cognome = new JTextField();
		textField_Cognome.setEditable(false);
		textField_Cognome.setBounds(167, 98, 116, 19);
		contentPane.add(textField_Cognome);
		textField_Cognome.setColumns(10);
		
		textField_codiceFiscale = new JTextField();
		textField_codiceFiscale.setEditable(false);
		textField_codiceFiscale.setBounds(167, 188, 116, 19);
		contentPane.add(textField_codiceFiscale);
		textField_codiceFiscale.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setEditable(false);
		textField_Email.setBounds(167, 267, 116, 19);
		contentPane.add(textField_Email);
		textField_Email.setColumns(10);
		
		textField_NumeroCellulare = new JTextField();
		textField_NumeroCellulare.setEditable(false);
		textField_NumeroCellulare.setBounds(167, 303, 116, 19);
		contentPane.add(textField_NumeroCellulare);
		textField_NumeroCellulare.setColumns(10);
		
		textField_Username = new JTextField();
		textField_Username.setEditable(false);
		textField_Username.setBounds(493, 57, 96, 19);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setEditable(false);
		textField_Password.setBounds(493, 98, 96, 19);
		contentPane.add(textField_Password);
		textField_Password.setColumns(10);
		
		textField_ComuneResidenza = new JTextField();
		textField_ComuneResidenza.setEditable(false);
		textField_ComuneResidenza.setBounds(167, 231, 116, 19);
		contentPane.add(textField_ComuneResidenza);
		textField_ComuneResidenza.setColumns(10);
		
		text_materie = new JTextField();
		text_materie.setBounds(493, 145, 96, 19);
		contentPane.add(text_materie);
		text_materie.setColumns(10);
		
		textOut = new JTextField();
		textOut.setForeground(new Color(255, 255, 255));
		textOut.setBackground(new Color(0, 0, 128));
		textOut.setBounds(174, 370, 109, 30);
		contentPane.add(textOut);
		textOut.setColumns(10);
		
		JLabel lbl_cognome = new JLabel("Cognome");
		lbl_cognome.setForeground(new Color(255, 255, 255));
		lbl_cognome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_cognome.setBounds(10, 100, 74, 13);
		contentPane.add(lbl_cognome);
		
		JLabel lbl_dataNascita = new JLabel("Data di Nascita");
		lbl_dataNascita.setForeground(new Color(255, 255, 255));
		lbl_dataNascita.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_dataNascita.setBounds(10, 147, 109, 13);
		contentPane.add(lbl_dataNascita);
		
		JLabel lbl_codiceFiscale = new JLabel("Codice Fiscale");
		lbl_codiceFiscale.setForeground(new Color(255, 255, 255));
		lbl_codiceFiscale.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_codiceFiscale.setBounds(10, 190, 133, 13);
		contentPane.add(lbl_codiceFiscale);
		
		JLabel lbl_ComuneResidenza = new JLabel("Comune di Residenza");
		lbl_ComuneResidenza.setForeground(new Color(255, 255, 255));
		lbl_ComuneResidenza.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_ComuneResidenza.setBounds(10, 233, 133, 13);
		contentPane.add(lbl_ComuneResidenza);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setForeground(new Color(255, 255, 255));
		lbl_email.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_email.setBounds(10, 270, 46, 13);
		contentPane.add(lbl_email);
		
		JLabel lbl_numeroCellulare = new JLabel("Numero Cellulare");
		lbl_numeroCellulare.setForeground(new Color(255, 255, 255));
		lbl_numeroCellulare.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_numeroCellulare.setBounds(10, 306, 133, 13);
		contentPane.add(lbl_numeroCellulare);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setForeground(new Color(255, 255, 255));
		lbl_username.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_username.setBounds(348, 60, 79, 13);
		contentPane.add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setForeground(new Color(255, 255, 255));
		lbl_password.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_password.setBounds(348, 101, 79, 13);
		contentPane.add(lbl_password);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setBounds(167, 142, 116, 19);
		contentPane.add(dateChooser);
		
		JList list = new JList();
		list.setBounds(450, 60, 60, 0);
		contentPane.add(list);
		
		//Bottone INSERISCI
		JButton btn_Inserisci = new JButton("INSERISCI");
		btn_Inserisci.setEnabled(false);
		btn_Inserisci.setForeground(Color.RED);
		
		btn_Inserisci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int ret = -1;
		
				String nome = textField_Nome.getText();
				String cognome = textField_Cognome.getText();
				java.util.Date dataNascita =  dateChooser.getDate();
				String codiceFiscale = textField_codiceFiscale.getText();
				String email = textField_Email.getText();
				String numeroCellulare = textField_NumeroCellulare.getText();
				String username = textField_Username.getText();
				String password = textField_Password.getText();
				String comune = textField_ComuneResidenza.getText();
				
				ret = Controller.registraUtente("Docente",nome,cognome,(Date) dataNascita,codiceFiscale,comune ,email,
						numeroCellulare,username,password,materie, " ", 0);
				
				materie.clear();
				
				System.out.println(ret);
				
				if(ret!=-1) {
					
					String conferma = "Il Docente " + nome + " " + cognome + " è stato registrato correttamente";
					
					JOptionPane.showConfirmDialog(null, conferma, "Conferma", JOptionPane.OK_CANCEL_OPTION);
					
				}else {
					
					JOptionPane.showConfirmDialog(null, "Errore inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_Inserisci.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn_Inserisci.setBounds(450, 373, 139, 21);
		contentPane.add(btn_Inserisci);
		
		//Bottotone Check Username
		JButton btn_checkUsername = new JButton("Check Username");
		btn_checkUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Verifichiamo che l'username inserito non sia già utilizzato
				
				String username = textField_Username.getText();
				
				int i = Controller.CercaUsername(username,"Docente");
				
				if(i==1) {
					//se ho trovato l'username
					textOut.setText("Username non disponibile");
					
				}else {
					btn_Inserisci.setEnabled(true);
					textOut.setText("Username disponibile");
				}
				
			}
		});
		btn_checkUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_checkUsername.setBounds(10, 370, 150, 30);
		contentPane.add(btn_checkUsername);
		
		
		
		JLabel lbl_materie = new JLabel("Materie");
		lbl_materie.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_materie.setForeground(Color.WHITE);
		lbl_materie.setBounds(348, 148, 60, 13);
		contentPane.add(lbl_materie);
		
		JButton btn_selezionaMateria = new JButton("Seleziona Materia");
		btn_selezionaMateria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = text_materie.getText();
				try {
                    int number = Integer.parseInt(input);

                    // Aggiungi il numero all'ArrayList
                    materie.add(number);
                   
                    System.out.println("Id inserito: " + number);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Inserisci un numero valido!", "Errore", JOptionPane.ERROR_MESSAGE);
                }
				
			}
		});
		btn_selezionaMateria.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_selezionaMateria.setBounds(450, 230, 139, 21);
		contentPane.add(btn_selezionaMateria);
		
		JButton btn_ListaMaterie = new JButton("Lista Materie");
		btn_ListaMaterie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//mostra a video la lista delle materie
				ArrayList<String> materie = new ArrayList<String>();
				
				materie = Controller.visualizzamaterie();
				
				JOptionPane.showMessageDialog(btn_selezionaMateria, materie.toString(), "Lista Materie", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn_ListaMaterie.setFont(new Font("Tahoma", Font.BOLD, 10));
		btn_ListaMaterie.setBounds(348, 187, 101, 21);
		contentPane.add(btn_ListaMaterie);
		
		
		
	}
}
