package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogSegreteria extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogSegreteria dialog = new DialogSegreteria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogSegreteria() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 139));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lbl_Segreteria = new JLabel("SEGRETERIA");
			lbl_Segreteria.setForeground(new Color(255, 255, 255));
			lbl_Segreteria.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_Segreteria.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			contentPanel.add(lbl_Segreteria, BorderLayout.NORTH);
		}
		{
			JButton btn_RegistraUtente = new JButton("REGISTRA UTENTE");
			btn_RegistraUtente.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					DialogRegistraUtente dr = new DialogRegistraUtente();
					dr.show();
					
					dispose();
				}
			});
			btn_RegistraUtente.setBackground(new Color(255, 255, 255));
			btn_RegistraUtente.setFont(new Font("Tahoma", Font.BOLD, 13));
			
			contentPanel.add(btn_RegistraUtente, BorderLayout.WEST);
		}
		{
			JButton btn_InserisciClasse = new JButton("INSERISCI CLASSE");
			btn_InserisciClasse.setFont(new Font("Tahoma", Font.BOLD, 13));
			contentPanel.add(btn_InserisciClasse, BorderLayout.EAST);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
