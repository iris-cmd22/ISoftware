package boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_FrameSegreteria = new JButton("Segreteria");
		btn_FrameSegreteria.setBounds(10, 156, 120, 25);
		btn_FrameSegreteria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DialogSegreteria fs = new DialogSegreteria(); //apri il jFrame Segreteria
				fs.show(); //display frame segreteria
				
				dispose();//chiudi il jFrame corrente dopo aver aperto il jFrame Segreteria
				
			}
		});
		btn_FrameSegreteria.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_FrameSegreteria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn_FrameSegreteria);
		
		JButton btn_Genitore = new JButton("Genitore");
		btn_Genitore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DialogGenitore fd = new DialogGenitore();
				fd.show();
				
				dispose();
				
				
			}
		});
		btn_Genitore.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Genitore.setBounds(306, 160, 120, 21);
		contentPane.add(btn_Genitore);
		
		
		
		
		JButton btn_DialogDocente = new JButton("Docente");
		btn_DialogDocente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DialogDocente fd = new DialogDocente(); //apri il jDialog Docente
				fd.show(); //display dialog docente
				
				dispose();//chiudi il jFrame corrente dopo aver aperto il jDialog Docente
			}
		});
		btn_DialogDocente.setBounds(10, 206, 120, 25);
		btn_DialogDocente.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btn_DialogDocente);
		
		
		
		
		JButton btn_Alunno = new JButton("Alunno");
		btn_Alunno.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_Alunno.setBounds(306, 210, 120, 21);
		contentPane.add(btn_Alunno);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\39388\\Downloads\\MicrosoftTeams-image.png"));
		lblNewLabel.setBounds(85, 10, 286, 95);
		contentPane.add(lblNewLabel);
	}
}
