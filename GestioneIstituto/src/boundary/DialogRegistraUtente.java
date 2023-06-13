package boundary;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogRegistraUtente extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
	public DialogRegistraUtente() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_RegistraUtente = new JLabel("Registra Utente");
		lbl_RegistraUtente.setBounds(5, 5, 142, 59);
		lbl_RegistraUtente.setForeground(new Color(255, 255, 255));
		lbl_RegistraUtente.setBackground(new Color(255, 255, 255));
		lbl_RegistraUtente.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 14));
		contentPane.add(lbl_RegistraUtente);
		
		JLabel lbl_ruolo = new JLabel("Seleziona Ruolo");
		lbl_ruolo.setBounds(10, 105, 127, 49);
		lbl_ruolo.setForeground(new Color(255, 255, 255));
		lbl_ruolo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_ruolo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lbl_ruolo);
		
		JLabel label_selezionaRuolo = new JLabel("");
		label_selezionaRuolo.setBounds(5, 89, 142, 84);
		contentPane.add(label_selezionaRuolo);
		
		JButton btn_enter = new JButton("Enter");
		
		btn_enter.setEnabled(false);
		btn_enter.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_enter.setBounds(341, 232, 85, 21);
		contentPane.add(btn_enter);
		
		JComboBox cmb_Ruolo = new JComboBox();
		cmb_Ruolo.setFont(new Font("Tahoma", Font.BOLD, 12));
		cmb_Ruolo.setBounds(157, 107, 142, 49);
		cmb_Ruolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmb_Ruolo.getSelectedItem().equals("Docente") || cmb_Ruolo.getSelectedItem().equals("Studente") || cmb_Ruolo.getSelectedItem().equals("Genitore") ) {
					
					btn_enter.setEnabled(true);
				}
			}
		});
		cmb_Ruolo.setModel(new DefaultComboBoxModel(new String[] {"Docente", "Studente", "Genitore"}));
		contentPane.add(cmb_Ruolo);
		
		btn_enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(cmb_Ruolo.getSelectedItem().equals("Docente")) {
					DialogRegistraDocente dr = new DialogRegistraDocente();
					dr.show();
					dispose();
					
				}else if(cmb_Ruolo.getSelectedItem().equals("Studente")) {
					DialogRegistraStudente dr = new DialogRegistraStudente();
					dr.show();
					dispose();
					
				}else if(cmb_Ruolo.getSelectedItem().equals("Genitore")) {
					DialogRegistraGenitore dr = new DialogRegistraGenitore();
					dr.show();
					dispose();
				
				}
			}
		});
		
		
	}
}