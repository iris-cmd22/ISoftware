package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogSegreteria extends JDialog {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogSegreteria dialog = new DialogSegreteria();
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
	public DialogSegreteria() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lbl_titoloSegreteria = new JLabel("SEGRETERIA");
		lbl_titoloSegreteria.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titoloSegreteria.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lbl_titoloSegreteria, BorderLayout.NORTH);
		
		JButton btn_RegistraUtente = new JButton("Registra Utente");
		btn_RegistraUtente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DialogRegistraUtente fs = new DialogRegistraUtente(); //apri il jFrame di Registrazione Utente
				fs.show(); //display dialog di inserimento
				
				dispose();//chiudi il jdialog corrente dopo aver aperto il jdialog di Registrazione
			}
		});
		btn_RegistraUtente.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_RegistraUtente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn_RegistraUtente, BorderLayout.WEST);
		
		JButton btn_InserisciClasse = new JButton("Inserisci Classe");
		btn_InserisciClasse.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btn_InserisciClasse, BorderLayout.EAST);
	}

}
