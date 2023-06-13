package boundary;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class DialogVisualizzaVoti extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_username;
	private JTextField textOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogVisualizzaVoti dialog = new DialogVisualizzaVoti();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogVisualizzaVoti() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 0, 139));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Visualizza Voti");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(10, 10, 138, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			textField_username = new JTextField();
			textField_username.setBounds(98, 77, 96, 19);
			contentPanel.add(textField_username);
			textField_username.setColumns(10);
		}
		{
			JLabel lbl_username = new JLabel("Username");
			lbl_username.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbl_username.setForeground(new Color(255, 255, 255));
			lbl_username.setBounds(10, 78, 150, 13);
			contentPanel.add(lbl_username);
		}
		{
			JButton btn_Check = new JButton("Check");
			btn_Check.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String username = textField_username.getText();
					
					int i = Controller.CercaUsername(username, "Genitore");
					
					if(i==1) {
						//se ho trovato l'username						
						ArrayList<String> voti = new ArrayList<String>();
						voti = Controller.visualizzaVoti(username);
						
						JOptionPane.showMessageDialog(btn_Check, voti.toString(), "Voti", JOptionPane.INFORMATION_MESSAGE);
						
					}else {
						textOut.setText("Username non trovato");
					}
				}
			});
			btn_Check.setFont(new Font("Tahoma", Font.BOLD, 12));
			btn_Check.setForeground(new Color(0, 0, 0));
			btn_Check.setBounds(341, 222, 85, 21);
			contentPanel.add(btn_Check);
		}
		{
			textOut = new JTextField();
			textOut.setForeground(new Color(255, 255, 255));
			textOut.setBackground(new Color(0, 0, 139));
			textOut.setHorizontalAlignment(SwingConstants.CENTER);
			textOut.setBounds(10, 224, 321, 19);
			contentPanel.add(textOut);
			textOut.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
