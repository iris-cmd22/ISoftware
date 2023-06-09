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

public class FrameDocente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDocente frame = new FrameDocente();
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
	public FrameDocente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lbl_titoloDocente = new JLabel("DOCENTE");
		lbl_titoloDocente.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titoloDocente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		contentPane.add(lbl_titoloDocente, BorderLayout.NORTH);
		
		JButton btn_AggiungiVoto = new JButton("Aggiungi Voto");
		btn_AggiungiVoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameAggiungiVoto fv = new FrameAggiungiVoto(); //apri il jFrame di Aggiungi Voto
				fv.show(); //display frame di inserimento
				
				dispose();//chiudi il jFrame corrente dopo aver aperto il jFrame di Aggiungi voto
			}
		});
		btn_AggiungiVoto.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_AggiungiVoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn_AggiungiVoto, BorderLayout.WEST);
		
		JButton btn_InserisciClasse = new JButton("Aggiungi Attività");
		btn_InserisciClasse.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(btn_InserisciClasse, BorderLayout.EAST);
	}

}