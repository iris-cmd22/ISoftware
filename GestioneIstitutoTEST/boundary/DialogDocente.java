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
import java.awt.Color;

public class DialogDocente extends JDialog {

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
					DialogDocente dialog = new DialogDocente();
					dialog.setVisible(true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogDocente() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_titoloDocente = new JLabel("DOCENTE");
		lbl_titoloDocente.setBounds(5, 5, 426, 20);
		lbl_titoloDocente.setForeground(new Color(255, 255, 255));
		lbl_titoloDocente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titoloDocente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lbl_titoloDocente);
		
		JButton btn_AggiungiVoto = new JButton("AGGIUNGI VOTO");
		btn_AggiungiVoto.setBounds(115, 86, 199, 89);
		btn_AggiungiVoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DialogAggiungiVoto dv = new DialogAggiungiVoto(); //apri il jDialog di Aggiungi Voto
				dv.show(); //display frame di inserimento
				
				dispose();//chiudi il jFrame corrente dopo aver aperto il jDialog di Aggiungi voto
			}
		});
		btn_AggiungiVoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_AggiungiVoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn_AggiungiVoto);
	}

}