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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameSegreteria extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSegreteria frame = new FrameSegreteria();
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
	public FrameSegreteria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				FrameRegistraUtente fs = new FrameRegistraUtente(); //apri il jFrame di Registrazione Utente
				fs.show(); //display frame di inserimento
				
				dispose();//chiudi il jFrame corrente dopo aver aperto il jFrame di Registrazione
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
