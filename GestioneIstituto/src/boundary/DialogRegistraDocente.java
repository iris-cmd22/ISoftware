package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogRegistraDocente extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRegistraDocente dialog = new DialogRegistraDocente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogRegistraDocente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 139));
		contentPanel.setForeground(new Color(0, 0, 139));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(71, 70, 145, 21);
		contentPanel.add(comboBox);
		
		JButton btn_insMaterie = new JButton("INSERISCI");
		btn_insMaterie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btn_insMaterie.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_insMaterie.setBounds(285, 70, 107, 21);
		contentPanel.add(btn_insMaterie);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(71, 142, 145, 21);
		contentPanel.add(comboBox_1);
		
		JButton btn_insClassi = new JButton("INSERISCI");
		btn_insClassi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_insClassi.setBounds(285, 142, 107, 21);
		contentPanel.add(btn_insClassi);
		
		JLabel lbl_materie = new JLabel("Materie");
		lbl_materie.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_materie.setForeground(new Color(255, 255, 255));
		lbl_materie.setBounds(10, 74, 73, 13);
		contentPanel.add(lbl_materie);
		
		JLabel lbl_classi = new JLabel("Classi");
		lbl_classi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_classi.setForeground(new Color(255, 255, 255));
		lbl_classi.setBounds(10, 146, 73, 13);
		contentPanel.add(lbl_classi);
		
		JLabel lbl_titolo = new JLabel("Seleziona Materie e Classi:");
		lbl_titolo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl_titolo.setForeground(new Color(255, 255, 255));
		lbl_titolo.setBounds(10, 10, 218, 13);
		contentPanel.add(lbl_titolo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
