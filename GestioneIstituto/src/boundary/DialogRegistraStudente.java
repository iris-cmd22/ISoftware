package boundary;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import control.Controller;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DialogRegistraStudente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private JTextField textField_Classe;
	private JTextField textOut_classe;

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
	public DialogRegistraStudente() {
		
		setBounds(100, 100, 613, 447);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RegistraDocente = new JLabel("Registra Studente");
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
		textField_Nome.setBounds(167, 57, 116, 19);
		contentPane.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		textField_Cognome = new JTextField();
		textField_Cognome.setBounds(167, 98, 116, 19);
		contentPane.add(textField_Cognome);
		textField_Cognome.setColumns(10);
		
		textField_codiceFiscale = new JTextField();
		textField_codiceFiscale.setBounds(167, 188, 116, 19);
		contentPane.add(textField_codiceFiscale);
		textField_codiceFiscale.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(167, 267, 116, 19);
		contentPane.add(textField_Email);
		textField_Email.setColumns(10);
		
		textField_NumeroCellulare = new JTextField();
		textField_NumeroCellulare.setBounds(167, 303, 116, 19);
		contentPane.add(textField_NumeroCellulare);
		textField_NumeroCellulare.setColumns(10);
		
		textField_Username = new JTextField();
		textField_Username.setBounds(493, 57, 96, 19);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setBounds(493, 98, 96, 19);
		contentPane.add(textField_Password);
		textField_Password.setColumns(10);
		
		textField_ComuneResidenza = new JTextField();
		textField_ComuneResidenza.setBounds(167, 231, 116, 19);
		contentPane.add(textField_ComuneResidenza);
		textField_ComuneResidenza.setColumns(10);
		
		textOut = new JTextField();
		textOut.setForeground(new Color(255, 255, 255));
		textOut.setBackground(new Color(0, 0, 128));
		textOut.setBounds(174, 370, 109, 30);
		contentPane.add(textOut);
		textOut.setColumns(10);
		
		textOut_classe = new JTextField();
		textOut_classe.setBackground(new Color(0, 0, 139));
		textOut_classe.setForeground(new Color(255, 255, 255));
		textOut_classe.setBounds(480, 231, 109, 19);
		contentPane.add(textOut_classe);
		textOut_classe.setColumns(10);
		
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
		dateChooser.setBounds(167, 142, 116, 19);
		contentPane.add(dateChooser);
		
		JLabel lbl_classe = new JLabel("Classe");
		lbl_classe.setForeground(new Color(255, 255, 255));
		lbl_classe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_classe.setBounds(348, 148, 45, 13);
		contentPane.add(lbl_classe);
		
		textField_Classe = new JTextField();
		textField_Classe.setBounds(493, 145, 96, 19);
		contentPane.add(textField_Classe);
		textField_Classe.setColumns(10);
		
		JButton btn_listaClassi = new JButton("Lista Classi"); //Bottone per visualizzare la lista delle classi
		btn_listaClassi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //al click del mouse viene richiamata la funzione visualizza classi
				//mostra lista classi
				ArrayList<String> classi = new ArrayList<String>();
				
				classi = Controller.visualizzaclassi();
				
				JOptionPane.showMessageDialog(btn_listaClassi, classi.toString(), "Lista Classi", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btn_listaClassi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_listaClassi.setBounds(348, 187, 96, 21);
		contentPane.add(btn_listaClassi);
		
		//Bottone INSERISCI
		JButton btn_Inserisci = new JButton("INSERISCI");
		btn_Inserisci.setEnabled(false);
		btn_Inserisci.setForeground(Color.RED);
		
		JButton btn_checkClasse = new JButton("Check Classe"); //Bottone per verificare l'esistenza della classe inserita
		btn_checkClasse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { //al click del mouse viene richiamata la funzione di controllo classe
				
				String classe = textField_Classe.getText();
				
				boolean ret = false;
				
				ret = Controller.controlloclasse(Integer.parseInt(classe));
				
				if(ret==true) { //Se la classe esiste
					
					btn_Inserisci.setEnabled(true); //viene abilitato il bottone di Inserimento
					textOut_classe.setText("classse esistente");
					
				}else {
					
					textOut_classe.setText("classe non esistente");
				}
				
			}
		});
		btn_checkClasse.setEnabled(false);
		btn_checkClasse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_checkClasse.setBounds(480, 187, 109, 21);
		contentPane.add(btn_checkClasse);
		
		
		
		btn_Inserisci.addMouseListener(new MouseAdapter() { //Bottone di inserimento dati dello Studente
			@Override
			public void mouseClicked(MouseEvent e) { //al click del mouse viene richiamata la funzione Registra Utente
				
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
				ArrayList<Integer> materie = null;
				String classe = textField_Classe.getText();
				
				ret = Controller.registraUtente("Studente",nome,cognome,new java.sql.Date(dataNascita.getTime()) ,codiceFiscale,comune ,email,
						numeroCellulare,username,password,materie, 0, Integer.parseInt(classe));
				
				System.out.println(ret);
				
				if(ret!=-1) { //se l'inserimento è andato a buon fine
					
					String conferma = "Lo Studente " + nome + " " + cognome + " è stato registrato correttamente"; 
					
					JOptionPane.showConfirmDialog(null, conferma, "Conferma", JOptionPane.OK_CANCEL_OPTION);
					
				}else {
					
					JOptionPane.showConfirmDialog(null, "Errore inserimento", "Errore", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_Inserisci.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btn_Inserisci.setBounds(450, 373, 139, 21);
		contentPane.add(btn_Inserisci);
		
		
		JButton btn_checkUsername = new JButton("Check Username"); //Bottone per la verifica dell'username
		btn_checkUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Verifichiamo che l'username inserito non sia già utilizzato
				
				String username = textField_Username.getText();
				
				int i = Controller.CercaUsername(username,"Studente");
				
				if(i==1) {
					//se ho trovato l'username
					textOut.setText("Username non disponibile");
					
				}else {
					btn_checkClasse.setEnabled(true);
					textOut.setText("Username disponibile");
				}
				
			}
		});
		btn_checkUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_checkUsername.setBounds(10, 370, 150, 30);
		contentPane.add(btn_checkUsername);
		
	}
}
