package boundary;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DialogRegistraUtente extends JDialog {

	private JPanel contentPane;
	private JTextField textField_ruolo;
	private JTextField textField_Nome;
	private JTextField textField_Cognome;
	private JTextField textField_dataNascita;
	private JTextField textField_codiceFiscale;
	private JTextField textField_Email;
	private JTextField textField_NumeroCellulare;
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JTextField textField_ComuneResidenza;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogRegistraUtente dialog = new DialogRegistraUtente();
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
	public DialogRegistraUtente() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RegistraUtente = new JLabel("Registra Utente");
		lbl_RegistraUtente.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_RegistraUtente.setBounds(10, 10, 106, 19);
		contentPane.add(lbl_RegistraUtente);
		
		JLabel lbl_ruolo = new JLabel("Ruolo");
		lbl_ruolo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_ruolo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ruolo.setBounds(20, 44, 45, 13);
		contentPane.add(lbl_ruolo);
		
		textField_ruolo = new JTextField();
		textField_ruolo.setBounds(111, 39, 96, 19);
		contentPane.add(textField_ruolo);
		textField_ruolo.setColumns(10);
		
		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_nome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nome.setBounds(20, 80, 45, 13);
		contentPane.add(lbl_nome);
		
		textField_Nome = new JTextField();
		textField_Nome.setEditable(false);
		textField_Nome.setBounds(111, 75, 96, 19);
		contentPane.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		textField_Cognome = new JTextField();
		textField_Cognome.setEditable(false);
		textField_Cognome.setBounds(111, 104, 96, 19);
		contentPane.add(textField_Cognome);
		textField_Cognome.setColumns(10);
		
		textField_dataNascita = new JTextField();
		textField_dataNascita.setEditable(false);
		textField_dataNascita.setBounds(111, 133, 96, 19);
		contentPane.add(textField_dataNascita);
		textField_dataNascita.setColumns(10);
		
		textField_codiceFiscale = new JTextField();
		textField_codiceFiscale.setEditable(false);
		textField_codiceFiscale.setBounds(111, 162, 96, 19);
		contentPane.add(textField_codiceFiscale);
		textField_codiceFiscale.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setEditable(false);
		textField_Email.setBounds(330, 75, 96, 19);
		contentPane.add(textField_Email);
		textField_Email.setColumns(10);
		
		textField_NumeroCellulare = new JTextField();
		textField_NumeroCellulare.setEditable(false);
		textField_NumeroCellulare.setBounds(330, 104, 96, 19);
		contentPane.add(textField_NumeroCellulare);
		textField_NumeroCellulare.setColumns(10);
		
		textField_Username = new JTextField();
		textField_Username.setEditable(false);
		textField_Username.setBounds(330, 133, 96, 19);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setEditable(false);
		textField_Password.setBounds(330, 162, 96, 19);
		contentPane.add(textField_Password);
		textField_Password.setColumns(10);
		
		textField_ComuneResidenza = new JTextField();
		textField_ComuneResidenza.setEditable(false);
		textField_ComuneResidenza.setBounds(111, 193, 96, 19);
		contentPane.add(textField_ComuneResidenza);
		textField_ComuneResidenza.setColumns(10);
		
		JLabel lbl_cognome = new JLabel("Cognome");
		lbl_cognome.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_cognome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_cognome.setBounds(10, 107, 60, 13);
		contentPane.add(lbl_cognome);
		
		JLabel lbl_dataNascita = new JLabel("Data di Nascita");
		lbl_dataNascita.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_dataNascita.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_dataNascita.setBounds(10, 138, 79, 13);
		contentPane.add(lbl_dataNascita);
		
		JLabel lbl_codiceFiscale = new JLabel("Codice Fiscale");
		lbl_codiceFiscale.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_codiceFiscale.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_codiceFiscale.setBounds(10, 167, 70, 13);
		contentPane.add(lbl_codiceFiscale);
		
		JLabel lbl_ComuneResidenza = new JLabel("Comune di Residenza");
		lbl_ComuneResidenza.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_ComuneResidenza.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_ComuneResidenza.setBounds(0, 198, 101, 13);
		contentPane.add(lbl_ComuneResidenza);
		
		JLabel lbl_email = new JLabel("Email");
		lbl_email.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_email.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_email.setBounds(275, 78, 45, 13);
		contentPane.add(lbl_email);
		
		JLabel lbl_numeroCellulare = new JLabel("Numero Cellulare");
		lbl_numeroCellulare.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_numeroCellulare.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_numeroCellulare.setBounds(229, 107, 91, 13);
		contentPane.add(lbl_numeroCellulare);
		
		JLabel lbl_username = new JLabel("Username");
		lbl_username.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_username.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_username.setBounds(264, 136, 63, 13);
		contentPane.add(lbl_username);
		
		JLabel lbl_password = new JLabel("Password");
		lbl_password.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbl_password.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_password.setBounds(275, 165, 45, 13);
		contentPane.add(lbl_password);
	}
}
